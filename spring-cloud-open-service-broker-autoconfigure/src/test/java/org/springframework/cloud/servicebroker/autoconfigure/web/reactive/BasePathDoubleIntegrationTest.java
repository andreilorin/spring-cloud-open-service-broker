/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.servicebroker.autoconfigure.web.reactive;

import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "spring.cloud.openservicebroker.base-path=/api/broker")
public class BasePathDoubleIntegrationTest extends AbstractBasePathWebApplicationIntegrationTest {

	@Test
	public void basePathFound() {
		assertFound("/api/broker", "null");
	}

	@Test
	public void basePathWithPlatformIdFound() {
		assertFound("/api/broker/123", "123");
	}

	@Test
	public void noBasePathNotFound() {
		assertNotFound("");
	}

	@Test
	public void noBasePathWithPlatformIdNotFound() {
		assertNotFound("/123");
	}

	@Test
	public void basePathWithAdditionalSegmentsNotFound() {
		assertNotFound("/api/broker/123/456");
	}
}
