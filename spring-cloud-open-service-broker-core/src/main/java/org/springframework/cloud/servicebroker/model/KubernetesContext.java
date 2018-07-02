/*
 * Copyright 2002-2018 the original author or authors.
 *
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
 */

package org.springframework.cloud.servicebroker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

/**
 * Kubernetes specific contextual information under which the service instance is to be provisioned or updated.
 *
 * @author Scott Frederick
 */
public final class KubernetesContext extends Context {
	public static final String KUBERNETES_PLATFORM = "kubernetes";
	public static final String NAMESPACE_KEY = "namespace";

	KubernetesContext() {
	}

	KubernetesContext(String namespace) {
		setNamespace(namespace);
	}

	public String getNamespace() {
		return getStringProperty(NAMESPACE_KEY);
	}

	@JsonProperty
	@NotEmpty
	private void setNamespace(String namespace) {
		properties.put(NAMESPACE_KEY, namespace);
	}
}
