package org.springframework.data.rest.tests.neo4j;import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableExperimentalNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Luanne Misquitta
 */
@ComponentScan(basePackages = "org.springframework.data.rest.tests.neo4j")
@Configuration
@EnableExperimentalNeo4jRepositories
@EnableTransactionManagement
public class NeoConfig {
	@Bean
	public SessionFactory sessionFactory() {
		return new SessionFactory("org.springframework.data.rest.tests.neo4j");
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}
}
