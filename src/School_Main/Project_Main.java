package School_Main;

import javax.swing.JFrame;
import javax.swing.UIManager;

import School_Interface.Interface_Engineer;
import School_Interface.Interface_Intro;

public class Project_Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
		}

		new Interface_Intro();
	}
}
