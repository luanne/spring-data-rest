package org.springframework.data.rest.tests.neo4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.util.Assert;

/**
 * @author Luanne Misquitta
 */
@NodeEntity
public class Customer extends AbstractEntity {

	private String firstName, lastName;

	private String emailAddress;
	@Relationship(type = "ADDRESS")
	private Set<Address> addresses = new HashSet<Address>();

	public Customer(String firstName, String lastName, String emailAddress) {

		Assert.hasText(firstName);
		Assert.hasText(lastName);
		Assert.hasText(emailAddress);

		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	protected Customer() {

	}

	public void add(Address address) {
		this.addresses.add(address);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(addresses);
	}

	public boolean hasAddress(Address address) {
		return addresses.contains(address);
	}

	@Override
	public String toString() {
		return String.format("%s %s <%s>", firstName, lastName, emailAddress);
	}
}
