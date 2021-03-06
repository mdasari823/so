/*
* ============LICENSE_START=======================================================
* ONAP : SO
* ================================================================================
* Copyright 2018 TechMahindra
*=================================================================================
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
* ============LICENSE_END=========================================================
*/
package org.openecomp.mso.bpmn.core.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkResourceTest {
	private NetworkResource nr = new NetworkResource();

	@Test
	public void testNetworkResource() {
		nr.setNetworkType("networkType");
		nr.setNetworkRole("networkRole");
		nr.setNetworkTechnology("networkTechnology");
		nr.setNetworkScope("networkScope");
		assertEquals(nr.getNetworkType(), "networkType");
		assertEquals(nr.getNetworkRole(), "networkRole");
		assertEquals(nr.getNetworkTechnology(), "networkTechnology");
		assertEquals(nr.getNetworkScope(), "networkScope");
		
	}

}
