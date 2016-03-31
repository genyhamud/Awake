/**
 * Copyright (C) 2016 Geny Isam Hamud Herrera (geny.herrera@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.genyherrera.awake;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.genyherrera.awake.Awake;

/**
 * Test class
 * @author genyherrera
 * @version 1.0
 */
public class AwakeTest {
	
	private static final Logger log = Logger.getLogger(AwakeTest.class);
	
	@Test
	public void simpleTestExecutor() {
		log.debug("Initialize test");
		Awake.main(null);
	}

}
