package org.springframework.data.rest.tests.neo4j;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author Luanne Misquitta
 */
@NodeEntity
public class Country extends AbstractEntity {

	String code;
	String name;

	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Country() {}
}

