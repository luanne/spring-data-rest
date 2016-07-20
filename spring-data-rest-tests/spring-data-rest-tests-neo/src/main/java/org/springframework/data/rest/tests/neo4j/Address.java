package org.springframework.data.rest.tests.neo4j;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author Luanne Misquitta
 */
@NodeEntity
public class Address extends AbstractEntity {

	private String street, city;
	private Country country;

	public Address(String street, String city, Country country) {

		this.street = street;
		this.city = city;
		this.country = country;
	}

	public Address() {

	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public Country getCountry() {
		return country;
	}
}