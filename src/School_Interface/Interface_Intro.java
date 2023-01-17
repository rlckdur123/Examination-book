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
		// 프레임(자바 화면) 크기
		Dimension frameSize = this.getSize();
		// 모니터 크기
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
		this.setLocation((screenSize.width - frameSize.width) / 2 - 200,
				(screenSize.height - frameSize.height) / 2 - 125);

		this.setTitle("자격증 선택");
		this.setSize(400, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false); // 창 크기 변경불가
		
		// 개 사진
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("dog.png"));
		JLabel imgLabel = new JLabel(img);
		imgLabel.setBounds(17, 17, 150, 150);
		this.add(imgLabel);

		// 라디오버튼
		JRadioButton[] radio = new JRadioButton[3];
		String[] text = { " 기 능 사", " 산업기사", " 기  사" };
		ButtonGroup group = new ButtonGroup();
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		for (int i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(text[i]); // 라디오버튼 생성 하고
			group.add(radio[i]); // 버튼 그룹에 넣고
			radio[i].setFont(font); // 폰트설정
			this.add(radio[i]);
			// 라디오버튼 이벤트처리
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

		// 완료버튼
		JButton btnSave = new JButton("완 료");
		btnSave.setBounds(80, 180, 100, 30);
		this.add(btnSave);

		// 종료버튼
		JButton btnExit = new JButton("종 료");
		btnExit.setBounds(220, 180, 100, 30);
		this.add(btnExit);

		// 완료버튼 이벤트 처리
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
					JOptionPane.showMessageDialog(null, "시험 종목을 선택하세요");
					break;
				}
			}
		});

		// 종료버튼 이벤트처리
		btnExit.addActionListener(new MyListener_Exit());
	}
	// 세터
	public void setpage(int page) {
		this.page = page;
	}
	// 게터
	public int getpage() {
		return this.page;
	}
}
