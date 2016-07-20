package org.springframework.data.rest.tests.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Luanne Misquitta
 */
public class TestDataPopulator {
	@Autowired CustomerRepository repository;

	@Transactional
	public void populate() {

		if (repository.count() > 0) {
			return;
		}

		repository.save(new Customer("Oliver", "Gierke", "ogierke@gopivotal.com"));
	}
}
