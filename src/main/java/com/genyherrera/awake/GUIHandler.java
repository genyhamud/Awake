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

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

/**
 * System core, create the GUI and dispatch the events from menu items
 * @author genyherrera
 * @version 1.0
 */
public class GUIHandler {
	
	private static final Logger log = Logger.getLogger(GUIHandler.class);
	
	//Declaration of variables
	private final SystemTray tray;
	private final TrayIcon trayIcon;
	private final PopupMenu popup;

	/**
	 * Constructor to initialize the variables
	 */
	public GUIHandler() {
		//Initialize variables
		tray = SystemTray.getSystemTray();
		popup = new PopupMenu();
		trayIcon = getTrayIcon(getImage(Boolean.TRUE));
	}

	/**
	 * Create the GUI, run the dispatcher and handle the action events
	 */
	public void createAndShowGUI() {
		log.debug("Creating application GUI");
		//Check the SystemTray support
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported");
			return;
		}

		// Create a popup menu components
		final CheckboxMenuItem cb1 = new CheckboxMenuItem("Enable",true);
		final MenuItem aboutItem = new MenuItem("About");
		final MenuItem exitItem = new MenuItem("Exit");

		//Add components to PopupMenu
		popup.add(cb1);
		popup.addSeparator();
		popup.add(aboutItem);
		popup.add(exitItem);

		//Add PopupMenu to TrayIcon
		trayIcon.setPopupMenu(popup);

		try {
			//Add TrayIcon to SystemTray
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("Fail add the application on system tray bar.");
			return;
		}
		
		//Run the event dispatcher
		AwakeEventHandler.doEvent();

		//Listener for double-click on Awake icon
		trayIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log.debug("Double click on application icon");
				
				//Change state
				cb1.setState(!cb1.getState());
				
				//Set new image
				trayIcon.setImage(getImage(cb1.getState()));
				
				//Dispatch the right event
				if (cb1.getState()) {
					AwakeEventHandler.doEvent();
				} else {
					AwakeEventHandler.cancelEvent();
				}
			}
		});
		
		//Listener for status change Enable/Disable
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				log.debug("Status change");
				//Set new image
				trayIcon.setImage(getImage(cb1.getState()));
				
				//Dispatch the right event
				if (cb1.getState()) {
					AwakeEventHandler.doEvent();
				} else {
					AwakeEventHandler.cancelEvent();
				}
			}
		});

		//Listener for About menu item
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log.debug("Open about dialog");
				AboutDialog.createAndShowGUI();
			}
		});

		//Listener for Exit menu item
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log.debug("Exit action");
				//Dispatch the cancel event 
				AwakeEventHandler.cancelEvent();
				
				//Remove the application from Tray and close
				tray.remove(trayIcon);
				System.exit(0);
			}
		});
	}
	
	/**
	 * Return the TrayIcon with the image and set application properties 
	 * @param image
	 * @return TrayIcon
	 */
	private TrayIcon getTrayIcon(Image image) {
		int trayIconWidth = new TrayIcon(image).getSize().width;
		return new TrayIcon(image.getScaledInstance(trayIconWidth, -1, Image.SCALE_SMOOTH),"Awaken",popup);
	}

	/**
	 * Return the image relative to status Enable/Disable
	 * @param status
	 * @return Image
	 */
	private Image getImage(Boolean status) {
		if (status == Boolean.TRUE) {
			return new ImageIcon(this.getClass().getClassLoader().getResource("img/enable.png")).getImage();
		}
			return new ImageIcon(this.getClass().getClassLoader().getResource("img/disable.png")).getImage();
	}
}
