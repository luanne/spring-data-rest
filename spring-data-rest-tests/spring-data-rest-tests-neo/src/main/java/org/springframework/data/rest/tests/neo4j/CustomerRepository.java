package org.springframework.data.rest.tests.neo4j;import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author Luanne Misquitta
 */
public interface CustomerRepository extends Neo4jRepository<Customer> {
	Customer findByEmailAddress(String emailAddress);
}
