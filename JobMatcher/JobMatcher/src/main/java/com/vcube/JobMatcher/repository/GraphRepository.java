package com.vcube.JobMatcher.repository;

import java.util.List;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Repository;

import com.vcube.JobMatcher.Model.Candidate;
import com.vcube.JobMatcher.Model.Course;
import com.vcube.JobMatcher.Model.Job;
import com.vcube.JobMatcher.Model.JobRecommendation;
import com.vcube.JobMatcher.Model.Skill;
import com.vcube.JobMatcher.Model.SkillGap;

@Repository
public class GraphRepository {

	private final Driver driver;

	public GraphRepository(Driver driver) {
		this.driver = driver;
	}

	// -----------------------------
	// CANDIDATES
	// -----------------------------

	public List<Candidate> getCandidates() {

		try (Session session = driver.session()) {

			return session.executeRead(tx -> {

				var result = tx.run("""
						MATCH (c:Candidate)
						RETURN c
						ORDER BY c.name
						""");

				return result.list(record -> {

					var node = record.get("c").asNode();

					return new Candidate(node.get("id").asLong(), node.get("name").asString(),
							node.get("email").asString(), node.get("experience").asInt(),
							node.get("location").asString());
				});
			});
		}
	}

	// -----------------------------
	// SINGLE CANDIDATE
	// -----------------------------

	public Candidate getCandidateById(Long id) {

		try (Session session = driver.session()) {

			return session.executeRead(tx -> {

				var result = tx.run("""
						MATCH (c:Candidate {id: $id})
						RETURN c
						""", org.neo4j.driver.Values.parameters("id", id));

				if (!result.hasNext()) {
					return null;
				}

				var node = result.single().get("c").asNode();

				return new Candidate(node.get("id").asLong(), node.get("name").asString(), node.get("email").asString(),
						node.get("experience").asInt(), node.get("location").asString());
			});
		}
	}

	// -----------------------------
	// CANDIDATE SKILLS
	// -----------------------------

	public List<Skill> getCandidateSkills(Long candidateId) {

		try (Session session = driver.session()) {

			return session.executeRead(tx -> {

				var result = tx.run("""
						MATCH (c:Candidate {id: $candidateId})
						      -[:HAS_SKILL]->
						      (s:Skill)
						RETURN s
						ORDER BY s.name
						""", org.neo4j.driver.Values.parameters("candidateId", candidateId));

				return result.list(record -> {

					var node = record.get("s").asNode();

					return new Skill(node.get("id").asLong(), node.get("name").asString(),
							node.get("category").asString());
				});
			});
		}
	}

	// -----------------------------
	// ALL SKILLS
	// -----------------------------

	public List<Skill> getSkills() {

		try (Session session = driver.session()) {

			return session.executeRead(tx -> {

				var result = tx.run("""
						MATCH (s:Skill)
						RETURN s
						ORDER BY s.name
						""");

				return result.list(record -> {

					var node = record.get("s").asNode();

					return new Skill(node.get("id").asLong(), node.get("name").asString(),
							node.get("category").asString());
				});
			});
		}
	}

	// -----------------------------
	// ALL JOBS
	// -----------------------------

	public List<Job> getJobs() {

		try (Session session = driver.session()) {

			return session.executeRead(tx -> {

				var result = tx.run("""
						MATCH (j:Job)
						RETURN j
						ORDER BY j.title
						""");

				return result.list(record -> {

					var node = record.get("j").asNode();

					return new Job(node.get("id").asLong(), node.get("title").asString(),
							node.get("location").asString(), node.get("experienceRequired").asInt(),
							node.get("salary").asLong(), node.get("jobType").asString());
				});
			});
		}
	}

	// -----------------------------
	// SINGLE JOB
	// -----------------------------

	public Job getJobById(Long id) {

		try (Session session = driver.session()) {

			return session.executeRead(tx -> {

				var result = tx.run("""
						MATCH (j:Job {id: $id})
						RETURN j
						""", org.neo4j.driver.Values.parameters("id", id));

				if (!result.hasNext()) {
					return null;
				}

				var node = result.single().get("j").asNode();

				return new Job(node.get("id").asLong(), node.get("title").asString(), node.get("location").asString(),
						node.get("experienceRequired").asInt(), node.get("salary").asLong(),
						node.get("jobType").asString());
			});
		}
	}

	// -----------------------------
	// JOB REQUIRED SKILLS
	// -----------------------------

	public List<Skill> getJobSkills(Long jobId) {

		try (Session session = driver.session()) {

			return session.executeRead(tx -> {

				var result = tx.run("""
						MATCH (j:Job {id: $jobId})
						      -[:REQUIRES]->
						      (s:Skill)
						RETURN s
						ORDER BY s.name
						""", org.neo4j.driver.Values.parameters("jobId", jobId));

				return result.list(record -> {

					var node = record.get("s").asNode();

					return new Skill(node.get("id").asLong(), node.get("name").asString(),
							node.get("category").asString());
				});
			});
		}
	}
	
	
	public List<JobRecommendation> getJobRecommendations(Long candidateId) {

	    try (Session session = driver.session()) {

	        return session.executeRead(tx -> {

	            var result = tx.run(
	                    """
	                    MATCH (c:Candidate {id: $candidateId})

	                    MATCH (j:Job)-[:REQUIRES]->(required:Skill)

	                    WITH c, j,
	                         collect(required.name) AS requiredSkills

	                    OPTIONAL MATCH (c)-[:HAS_SKILL]->(matched:Skill)
	                    WHERE matched.name IN requiredSkills

	                    WITH c, j, requiredSkills,
	                         collect(DISTINCT matched.name) AS matchedSkills

	                    WITH j,
	                         requiredSkills,
	                         matchedSkills,
	                         CASE
	                           WHEN size(requiredSkills) = 0 THEN 0
	                           ELSE round(
	                             100.0 * size(matchedSkills)
	                             / size(requiredSkills)
	                           )
	                         END AS percentage

	                    WITH j,
	                         requiredSkills,
	                         matchedSkills,
	                         percentage,
	                         [skill IN requiredSkills
	                          WHERE NOT skill IN matchedSkills]
	                         AS missingSkills

	                    RETURN
	                        j.id AS jobId,
	                        j.title AS jobTitle,
	                        j.location AS location,
	                        percentage,
	                        matchedSkills,
	                        missingSkills

	                    ORDER BY percentage DESC
	                    """,
	                    org.neo4j.driver.Values.parameters(
	                            "candidateId", candidateId
	                    )
	            );

	            return result.list(record -> {

	                return new JobRecommendation(
	                        record.get("jobId").asLong(),
	                        record.get("jobTitle").asString(),
	                        record.get("location").asString(),
	                        record.get("percentage").asInt(),
	                        record.get("matchedSkills")
	                                .asList(value -> value.asString()),
	                        record.get("missingSkills")
	                                .asList(value -> value.asString())
	                );
	            });
	        });
	    }
	}
	
	
	public List<SkillGap> getSkillGaps(Long candidateId) {

	    try (Session session = driver.session()) {

	        return session.executeRead(tx -> {

	            var result = tx.run(
	                    """
	                    MATCH (c:Candidate {id: $candidateId})

	                    MATCH (j:Job)-[:REQUIRES]->(required:Skill)

	                    WITH c, j,
	                         collect(required.name) AS requiredSkills

	                    OPTIONAL MATCH (c)-[:HAS_SKILL]->(candidateSkill:Skill)
	                    WHERE candidateSkill.name IN requiredSkills

	                    WITH j,
	                         requiredSkills,
	                         collect(DISTINCT candidateSkill.name)
	                         AS matchedSkills

	                    WITH j,
	                         requiredSkills,
	                         matchedSkills,
	                         [skill IN requiredSkills
	                          WHERE NOT skill IN matchedSkills]
	                         AS missingSkills

	                    RETURN
	                        j.id AS jobId,
	                        j.title AS jobTitle,
	                        matchedSkills,
	                        missingSkills
	                    """,
	                    org.neo4j.driver.Values.parameters(
	                            "candidateId", candidateId
	                    )
	            );

	            return result.list(record -> {

	                return new SkillGap(
	                        record.get("jobId").asLong(),
	                        record.get("jobTitle").asString(),
	                        record.get("matchedSkills")
	                                .asList(value -> value.asString()),
	                        record.get("missingSkills")
	                                .asList(value -> value.asString())
	                );
	            });
	        });
	    }
	}
	
	
	public List<Course> getCoursesForMissingSkills(Long candidateId) {

	    try (Session session = driver.session()) {

	        return session.executeRead(tx -> {

	            var result = tx.run(
	                    """
	                    MATCH (c:Candidate {id: $candidateId})
	                    MATCH (j:Job)-[:REQUIRES]->(required:Skill)

	                    WITH c, required

	                    OPTIONAL MATCH (c)-[:HAS_SKILL]->(candidateSkill:Skill)

	                    WITH required, candidateSkill

	                    WHERE candidateSkill IS NULL

	                    MATCH (required)-[:TAUGHT_BY]->(course:Course)

	                    RETURN DISTINCT course
	                    ORDER BY course.name
	                    """,
	                    org.neo4j.driver.Values.parameters(
	                            "candidateId", candidateId
	                    )
	            );

	            return result.list(record -> {

	                var node = record.get("course").asNode();

	                return new Course(
	                        node.get("id").asLong(),
	                        node.get("name").asString(),
	                        node.get("platform").asString(),
	                        node.get("url").asString()
	                );
	            });
	        });
	    }
	}
}