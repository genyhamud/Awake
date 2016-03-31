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
package org.genyherrera.awake;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * Event to be dispatch relative to status
 * @author genyherrera
 * @version 1.0
 */
public class AwakeEventHandler {
	
	private static final Logger log = Logger.getLogger(AwakeEventHandler.class);
	
	// Interval to dispatch a new event
	private static final int TIMEOUT = 60000;
	private static Timer timer;

	// Start the event
	public static void doEvent() {
		log.debug("Initializing event");
		timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				mouseEvent();
			}
		};
		timer.schedule(timerTask, 0, TIMEOUT);
	}
	
	// Cancel the event
	public static void cancelEvent() {
		log.debug("Cancel event");
		timer.cancel();
		System.gc();
	}

	// Mouse event
	private static void mouseEvent() {
		try{
			Robot robot = new Robot();
			robot.mousePress(MouseEvent.NOBUTTON);
			robot.mouseRelease(MouseEvent.NOBUTTON);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
