package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import Data.Data_Combo;
import Data.Data_Page0;
import Data.Data_Page1;
import Data.Data_Page2;

public class MyListener_Combo implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		Data_Combo data = new Data_Combo();
		Data_Page0 data0 = new Data_Page0();
		Data_Page1 data1 = new Data_Page1();
		Data_Page2 data2 = new Data_Page2();
		
		JComboBox cb = (JComboBox) e.getSource();
		
		String license = null;
		
		int index = cb.getSelectedIndex();
		data.setIndex(index);
		
		if(Data_Combo.getPage_num() == 0) {
			license = data0.getLicense()[data.getIndex()];
			data.setText(license);
			System.out.println(data.getText());
		}
		else if(Data_Combo.getPage_num() == 1) {
			license = data1.getLicense()[data.getIndex()];
			data.setText(license);
			System.out.println(data.getText());
		}
		else {
			license = data2.getLicense()[data.getIndex()];
			data.setText(license);
			System.out.println(data.getText());
		}
		
	}
}
