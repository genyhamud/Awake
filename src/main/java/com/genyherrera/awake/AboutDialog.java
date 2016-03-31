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

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * About Dialog class
 * @author genyherrera
 * @version 1.0
 */
public class AboutDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	// Constructor
	public AboutDialog(JFrame frame, String title) {
		super(frame, title);
	}

	// Create and show the GUI
	public static void createAndShowGUI() {
        AboutDialog aboutDialog = new AboutDialog(new JFrame(),"Awake v1.0");
        aboutDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        aboutDialog.setIconImage(new ImageIcon("src/main/resources/img/enable.png").getImage());
        aboutDialog.pack();
        aboutDialog.setLocationRelativeTo(null);
        aboutDialog.setSize(new Dimension(250, 200));
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(new ImageIcon("src/main/resources/img/enable.png")));
        
        aboutDialog.add(panel);
        aboutDialog.setVisible(true);
    }
}

