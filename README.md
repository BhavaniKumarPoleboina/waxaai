# JobGraph – Skill-Based Job Recommendation System

## 📌 Overview

JobGraph is a skill-based job recommendation system that helps candidates discover suitable job opportunities based on their skills.

The application represents candidates, jobs, skills, and courses as nodes in a Neo4j graph database. Relationships between these entities are used to identify suitable jobs, calculate skill matches, identify skill gaps, and recommend learning courses.

The application is built using:

- Angular for the frontend
- Spring Boot and Java for the backend
- Neo4j for the graph database
- Official Neo4j Java Driver for database communication

---
# Why a graph database?
JobGraph uses Neo4j because the application is highly relationship-oriented. A candidate can have multiple skills, a job can require multiple skills, and courses can be associated with skills. Neo4j allows these relationships to be represented directly and makes multi-hop traversal such as Candidate → Skill → Job easier to query using Cypher.

# 🎯 Problem Statement

Candidates often search for jobs manually without knowing which jobs best match their current skills.

It is also difficult for candidates to identify:

- Which jobs are suitable for their skills
- Which skills they are missing
- Which skills are required for a particular job
- Which courses can help them improve their skill set

JobGraph addresses this problem by using a graph-based model to connect candidates, skills, jobs, and courses.

---

# 🎯 Objectives

The main objectives of JobGraph are:

- Recommend suitable jobs based on candidate skills.
- Represent candidate-job-skill relationships using Neo4j.
- Identify skills required by jobs.
- Identify missing skills in a candidate profile.
- Calculate basic job-skill matching.
- Recommend courses for missing skills.
- Provide a simple web interface for exploring the graph-based recommendation system.

---

# 🏗️ System Architecture

```text
                  Angular Frontend
                         |
                         | HTTP / REST API
                         ↓
                  Spring Boot Backend
                         |
                         | Official Neo4j Driver
                         ↓
                  Neo4j Graph Database
                         |
          +--------------+--------------+
          |              |              |
      Candidate         Job           Skill
          |              |              |
          +--------------+--------------+
                         |
                       Course


# Screenshots
<img width="1817" height="785" alt="Dashboard" src="https://github.com/user-attachments/assets/228d53c7-84c3-4186-b9c2-2bcaa57d4faa" />



