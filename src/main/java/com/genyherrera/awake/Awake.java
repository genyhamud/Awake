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

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

/**
 * Main class to create the GUI and keep the machine awake
 * @author genyherrera
 * @version 1.0
 */
public class Awake {

	private static final Logger log = Logger.getLogger(Awake.class);
	
	/**
	 * Set the LookAndFeel and run the application to keep the machine awake
	 * @param args
	 */
	public static void main(String[] args) {
		/* Use an appropriate LookAndFeel, OS default */
		log.debug("Initialize application");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		//Schedule a job for the event-dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUIHandler().createAndShowGUI();
			}
		});
	}
}
