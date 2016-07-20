/*
 * Copyright [yyyy] [name of copyright owner]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.rest.tests.neo4j;import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.tests.CommonWebTests;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Luanne Misquitta
 */
@ContextConfiguration(classes = NeoConfig.class)
public class Neo4jWebTests extends CommonWebTests {

	@Autowired TestDataPopulator populator;
	@Before
	@Override
	public void setUp() {
		this.populator.populate();
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.rest.webmvc.AbstractWebIntegrationTests#expectedRootLinkRels()
	 */
	@Override
	protected Iterable<String> expectedRootLinkRels() {
		return Arrays.asList("customers");
	}

	/**
	 * @see DATAREST-184
	 */
	@Test
	public void deletesCustomer() throws Exception {

		// Lookup customer
		Link customers = client.discoverUnique("customers");
		Link customerLink = assertHasContentLinkWithRel("self", client.request(customers));

		// Delete customer
		mvc.perform(delete(customerLink.getHref()));

		// Assert no customers anymore
		assertDoesNotHaveContentLinkWithRel("self", client.request(customers));
	}
}
