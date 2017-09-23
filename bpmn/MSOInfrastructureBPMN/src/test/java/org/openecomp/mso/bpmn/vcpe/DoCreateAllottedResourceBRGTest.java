/*
 * © 2014 AT&T Intellectual Property. All rights reserved. Used under license from AT&T Intellectual Property.
 */
package org.openecomp.mso.bpmn.vcpe;

import static org.junit.Assert.assertEquals;
import static org.openecomp.mso.bpmn.mock.StubResponseAAI.MockGetServiceInstance;
import static org.openecomp.mso.bpmn.mock.StubResponseAAI.MockNodeQueryServiceInstanceById;
import static org.openecomp.mso.bpmn.mock.StubResponseAAI.MockPatchAllottedResource;
import static org.openecomp.mso.bpmn.mock.StubResponseAAI.MockPutAllottedResource;
import static org.openecomp.mso.bpmn.mock.StubResponseDatabase.mockUpdateRequestDB;
import static org.openecomp.mso.bpmn.mock.StubResponseSDNCAdapter.mockSDNCAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.camunda.bpm.engine.test.Deployment;
import org.junit.Assert;
import org.junit.Test;
import org.openecomp.mso.bpmn.common.BPMNUtil;
import org.openecomp.mso.bpmn.common.WorkflowTest;
import org.openecomp.mso.bpmn.mock.FileUtil;


public class DoCreateAllottedResourceBRGTest extends WorkflowTest {

	private final CallbackSet callbacks = new CallbackSet();

	public DoCreateAllottedResourceBRGTest() throws IOException {
		callbacks.put("assign", FileUtil.readResourceFile("__files/VCPE/VfModularity/SDNCTopologyAssignCallback.xml"));
		callbacks.put("create", FileUtil.readResourceFile("__files/VCPE/VfModularity/SDNCTopologyCreateCallback.xml"));
		callbacks.put("activate", FileUtil.readResourceFile("__files/VCPE/VfModularity/SDNCTopologyActivateCallback.xml"));
		callbacks.put("query", FileUtil.readResourceFile("__files/VCPE/DoCreateAllottedResourceBRG/SDNCTopologyQueryCallback.xml"));
	}
	
	@Test
	@Deployment(resources = {
			"subprocess/GenericGetService.bpmn", 
			"subprocess/SDNCAdapterV1.bpmn", 
			"subprocess/FalloutHandler.bpmn",
			"subprocess/DoCreateAllottedResourceBRG.bpmn",
			"subprocess/DoCreateAllottedResourceBRGRollback.bpmn"})
	public void testDoCreateAllottedResourceBRG_success() throws Exception{

		MockNodeQueryServiceInstanceById("MIS%252F1604%252F0026%252FSW_INTERNET", "GenericFlows/getSIUrlById.xml");
		MockGetServiceInstance("SDN-ETHERNET-INTERNET", "123456789", "MIS%252F1604%252F0026%252FSW_INTERNET", "GenericFlows/getServiceInstance.xml");
		MockNodeQueryServiceInstanceById("MIS%252F1604%252F0027%252FSW_INTERNET", "GenericFlows/getParentSIUrlById.xml");
		MockGetServiceInstance("SDN-ETHERNET-INTERNET", "123456789", "MIS%252F1604%252F0027%252FSW_INTERNET", "GenericFlows/getParentServiceInstance.xml");
		MockPutAllottedResource("SDN-ETHERNET-INTERNET", "123456789", "MIS%252F1604%252F0027%252FSW_INTERNET", "arId-1");
		MockPatchAllottedResource("SDN-ETHERNET-INTERNET", "123456789", "MIS%252F1604%252F0027%252FSW_INTERNET", "arId-1");
		mockSDNCAdapter(200);
		mockUpdateRequestDB(200, "Database/DBUpdateResponse.xml");

		String businessKey = UUID.randomUUID().toString();
		Map<String, Object> variables = new HashMap<>();
		setVariablesSuccess(variables, "testRequestId123");
		
		invokeSubProcess("DoCreateAllottedResourceBRG", businessKey, variables);
		
		injectSDNCCallbacks(callbacks, "assign");
		injectSDNCCallbacks(callbacks, "create");
		injectSDNCCallbacks(callbacks, "activate");
		injectSDNCCallbacks(callbacks, "query");

		waitForProcessEnd(businessKey, 10000);
		
		Assert.assertTrue(isProcessEnded(businessKey));
		String allotedResourceName = BPMNUtil.getVariable(processEngineRule, "DoCreateAllottedResourceBRG", "allotedResourceName");
		String workflowException = BPMNUtil.getVariable(processEngineRule, "DoCreateAllottedResourceBRG", "WorkflowException");
		assertEquals("namefromrequest", allotedResourceName);
		assertEquals(null, workflowException);
	}

	private void setVariablesSuccess(Map<String, Object> variables, String requestId) {
		// TODO: need all of these?
		variables.put("isDebugLogEnabled", "true");
		variables.put("failExists", "true");
		variables.put("disableRollback", "true");
		variables.put("msoRequestId", requestId);
		variables.put("mso-request-id", "requestId");
		variables.put("sourceNetworkId", "snId");
		variables.put("sourceNetworkRole", "snRole");
		variables.put("allottedResourceRole", "txc");
		variables.put("allottedResourceType", "BRG");
		variables.put("allottedResourceId", "arId-1");
		variables.put("vni", "BRG");
		variables.put("vgmuxBearerIP", "bearerip");
		variables.put("brgWanMacAddress", "wanmac");
		variables.put("junitSleepMs", "5");
		
		variables.put("serviceInstanceId", "MIS%252F1604%252F0026%252FSW_INTERNET");
		variables.put("parentServiceInstanceId","MIS%252F1604%252F0027%252FSW_INTERNET");
		variables.put("serviceChainServiceInstanceId", "scsiId");
		
		String arModelInfo = "{ "+ "\"modelType\": \"allotted-resource\"," +
				"\"modelInvariantUuid\": \"ff5256d2-5a33-55df-13ab-12abad84e7ff\"," +
				"\"modelUuid\": \"fe6478e5-ea33-3346-ac12-ab121484a3fe\"," +
				"\"modelName\": \"vSAMP12\"," +
				"\"modelVersion\": \"1.0\"," +
				"\"modelCustomizationUuid\": \"MODEL-ID-1234\"," +
				"}";
		variables.put("allottedResourceModelInfo", arModelInfo);
	}

}