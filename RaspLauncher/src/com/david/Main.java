package com.david;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LauncherWindowDesign window = new LauncherWindowDesign();
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					window.frame.setUndecorated(true);
					window.frame.setVisible(true);
					System.out.println("Läuft");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
