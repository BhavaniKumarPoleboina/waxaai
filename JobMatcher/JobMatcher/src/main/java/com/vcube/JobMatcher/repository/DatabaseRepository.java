package com.vcube.JobMatcher.repository;



import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseRepository {

    private final Driver driver;

    public DatabaseRepository(Driver driver) {
        this.driver = driver;
    }

    public String testConnection() {

        try (Session session = driver.session()) {

            return session.executeRead(tx -> {

                var result = tx.run("RETURN 'CognoDB Connected Successfully' AS message");

                return result.single()
                        .get("message")
                        .asString();
            });
        }
    }
}