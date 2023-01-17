package School_Interface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Data.Data_Combo;
import Listener.MyListener_Exit;

public class Interface_Intro extends JFrame {
	private int page = -1;

	public Interface_Intro() {
		// ������(�ڹ� ȭ��) ũ��
		Dimension frameSize = this.getSize();
		// ����� ũ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// (�����ȭ�� ���� - ������ȭ�� ����) / 2, (�����ȭ�� ���� - ������ȭ�� ����) / 2
		this.setLocation((screenSize.width - frameSize.width) / 2 - 200,
				(screenSize.height - frameSize.height) / 2 - 125);

		this.setTitle("�ڰ��� ����");
		this.setSize(400, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false); // â ũ�� ����Ұ�
		
		// �� ����
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("dog.png"));
		JLabel imgLabel = new JLabel(img);
		imgLabel.setBounds(17, 17, 150, 150);
		this.add(imgLabel);

		// ������ư
		JRadioButton[] radio = new JRadioButton[3];
		String[] text = { " �� �� ��", " ������", " ��  ��" };
		ButtonGroup group = new ButtonGroup();
		Font font = new Font("���� ���", Font.BOLD, 20);
		for (int i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(text[i]); // ������ư ���� �ϰ�
			group.add(radio[i]); // ��ư �׷쿡 �ְ�
			radio[i].setFont(font); // ��Ʈ����
			this.add(radio[i]);
			// ������ư �̺�Ʈó��
			radio[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (radio[0].isSelected()) {
						setpage(0);
					}
					else if (radio[1].isSelected()) {
						setpage(1);
					}
					else if (radio[2].isSelected()) {
						setpage(2);
					}
				}
			});
		}
		radio[0].setBounds(230, 27, 150, 30);
		radio[1].setBounds(230, 72, 150, 30);
		radio[2].setBounds(230, 117, 150, 30);

		// �Ϸ��ư
		JButton btnSave = new JButton("�� ��");
		btnSave.setBounds(80, 180, 100, 30);
		this.add(btnSave);

		// �����ư
		JButton btnExit = new JButton("�� ��");
		btnExit.setBounds(220, 180, 100, 30);
		this.add(btnExit);

		// �Ϸ��ư �̺�Ʈ ó��
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane msg = new JOptionPane();
				switch (getpage()) {
				case 0:
					Interface_Craftsman page1 = new Interface_Craftsman();
					dispose();
					break;
				case 1:
					Interface_IndustrialEngineer page2 = new Interface_IndustrialEngineer();
					dispose();
					break;
				case 2:
					dispose();
					Interface_Engineer page3 = new Interface_Engineer();
					break;
				default:
					JOptionPane.showMessageDialog(null, "���� ������ �����ϼ���");
					break;
				}
			}
		});

		// �����ư �̺�Ʈó��
		btnExit.addActionListener(new MyListener_Exit());
	}
	// ����
	public void setpage(int page) {
		this.page = page;
	}
	// ����
	public int getpage() {
		return this.page;
	}
}
