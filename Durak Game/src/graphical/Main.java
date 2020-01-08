package graphical;

import javax.swing.JButton;   
import javax.swing.JFrame;

import graphical.MainFrame;

public class Main implements Runnable {
	
	MainFrame GUI = new MainFrame();
	
	public static void main(String args[]) {
		new Thread(new Main()).start();
	}
	@Override
	public void run() {
		while(true) {
			GUI.getIgnoreRepaint();
		}
	
}
}