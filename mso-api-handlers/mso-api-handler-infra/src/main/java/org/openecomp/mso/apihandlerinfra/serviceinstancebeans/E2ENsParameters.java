/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2017 Huawei Technologies Co., Ltd. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

package org.openecomp.mso.apihandlerinfra.serviceinstancebeans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({ "additionalParamForNs", "additionalProperties" })
public class E2ENsParameters {

	@JsonProperty("locationConstraints")
	private List<E2ELocationConstraint> locationConstraints = null;
	@JsonProperty("additionalParamForNs")
	private E2EAdditionalParamForNs additionalParamForNs;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	public List<E2ELocationConstraint> getLocationConstraints() {
		return locationConstraints;
	}

	public void setLocationConstraints(
			List<E2ELocationConstraint> locationConstraints) {
		this.locationConstraints = locationConstraints;
	}

	public E2EAdditionalParamForNs getAdditionalParamForNs() {
		return additionalParamForNs;
	}

	public void setAdditionalParamForNs(
			E2EAdditionalParamForNs additionalParamForNs) {
		this.additionalParamForNs = additionalParamForNs;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

}