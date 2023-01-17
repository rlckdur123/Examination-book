package School_Interface;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import API_Serch.API_Serch;
import Data.Data_API;
import Data.Data_Combo;
import Data.Data_Page1;
import Listener.MyListener_CBT;
import Listener.MyListener_Combo;
import Listener.MyListener_Exit;

public class Interface_IndustrialEngineer extends JFrame {
	JPanel contentP, infoP;
	JScrollPane scroll;
	JTextArea Jtext;
	JLabel info = new JLabel();
	static JButton[] btn = new JButton[10];
	String title = "";

	public Interface_IndustrialEngineer() {
		Data_Page1 data = new Data_Page1();
		Data_Combo.setPage_num(1);

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2 - 500,
				(screenSize.height - frameSize.height) / 2 - 350);
		this.setTitle("산업기사 자격증");
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		setResizable(false);

		// 인터파크 로고
		ImageIcon img1 = new ImageIcon(getClass().getClassLoader().getResource("naver.png"));
		JLabel imgLabel = new JLabel(img1);
		imgLabel.setBounds(-5, 15, 400, 70);
		this.add(imgLabel);

		// 콬보박스
		JComboBox<String> combo = new JComboBox<String>(data.getLicense());
		combo.setBounds(570, 35, 300, 40);
		this.add(combo);

		// 선택버튼
		JButton btnSelect = new JButton("선 택");
		btnSelect.setBounds(880, 35, 100, 40);
		this.add(btnSelect);

		// 종류
		contentP = new JPanel();
		contentP.setPreferredSize(new Dimension(500, 2100));
		contentP.setLayout(new FlowLayout());

		scroll = new JScrollPane(contentP);
		scroll.setBounds(20, 80, 530, 570);
		this.add(scroll);

		// 내용
		infoP = new JPanel();
		infoP.setPreferredSize(new Dimension(400, 460));
		infoP.setBackground(Color.white);
		infoP.setLayout(null);

		JScrollPane info = new JScrollPane(infoP);
		info.setBounds(570, 80, 410, 470);
		this.add(info);

		// 텍스트용 프레임
		Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
		JLabel text1 = new JLabel("자격증 기출문제 사이트");
		text1.setFont(font1);
		text1.setBounds(570, 560, 200, 30);
		this.add(text1);

		Font font2 = new Font("맑은 고딕", Font.BOLD, 26);
		JLabel text2 = new JLabel("전자문제집 CBT");
		text2.setForeground(Color.blue);
		text2.setFont(font2);
		text2.setBounds(570, 590, 200, 40);
		this.add(text2);

		// CBT
		ImageIcon img2 = new ImageIcon(getClass().getClassLoader().getResource("CBT.png"));
		JButton btnCBT = new JButton(img2);
		btnCBT.setBounds(775, 555, 100, 100);
		this.add(btnCBT);

		// 메인으로 돌아가기
		JButton btnIntro = new JButton("돌아가기");
		btnIntro.setBounds(880, 555, 100, 50);
		this.add(btnIntro);
		btnIntro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Interface_Intro();
			}
		});

		// 종료
		JButton btnExit = new JButton("종 료");
		btnExit.setBounds(880, 605, 100, 50);
		this.add(btnExit);

		btnExit.addActionListener(new MyListener_Exit());
		btnCBT.addActionListener(new MyListener_CBT());
		combo.addActionListener(new MyListener_Combo());
		btnSelect.addActionListener(new MyListener_serchBtn());
	}

	// 선택버튼 리스너
	class MyListener_serchBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String text = null;
			Data_Combo combo = new Data_Combo();
			text = combo.getText();
			new API_Serch(text);

			Data_API data_API = new Data_API();
			ArrayList<Data_API> list = data_API.getList();
			Font font1 = new Font("맑은 고딕", Font.PLAIN, 20);
			Font font2 = new Font("맑은 고딕", Font.PLAIN, 15);
			Font font3 = new Font("맑은 고딕", Font.BOLD, 15);
			Color color = new Color(102, 102, 102);

			contentP.removeAll();
			contentP.revalidate();
			contentP.repaint();

			for (int i = 0; i < list.size(); i++) {
				JLabel content = new JLabel();
				content.setPreferredSize(new Dimension(500, 180));
				content.setLayout(null);
				content.setOpaque(true);
				contentP.add(content);

				// 이미지 추가
				try {
					URL url = new URL(list.get(i).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(0, 0, 140, 180);
					content.add(imgLabel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JLabel title = new JLabel(list.get(i).getTitle());
				title.setBounds(170, 30, 330, 50);
				title.setFont(font1);
				content.add(title);

				JLabel publisher = new JLabel(list.get(i).getPubdate());
				publisher.setBounds(170, 30, 330, 90);
				publisher.setFont(font2);
				publisher.setForeground(color);
				content.add(publisher);

				JLabel pubdate = new JLabel(list.get(i).getPublisher());
				pubdate.setBounds(170, 30, 330, 125);
				pubdate.setFont(font2);
				pubdate.setForeground(color);
				content.add(pubdate);

				JLabel discount = new JLabel("판매가 : " + list.get(i).getDiscount());
				discount.setBounds(170, 30, 330, 170);
				discount.setFont(font3);
				content.add(discount);

				btn[i] = new JButton();
				btn[i].setBounds(0, 0, 500, 180);
				btn[i].setBorderPainted(false);
				content.add(btn[i]);

				btn[i].addActionListener(new MyListener_content());
			}
			contentP.updateUI();
		}
	}

	class MyListener_content implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Data_API data_API = new Data_API();
			ArrayList<Data_API> list = data_API.getList();
			Font font1 = new Font("맑은 고딕", Font.PLAIN, 20);
			Font font2 = new Font("맑은 고딕", Font.PLAIN, 15);

			infoP.removeAll();
			infoP.revalidate();
			infoP.repaint();

			if (e.getSource() == btn[0]) {
				try {
					URL url = new URL(list.get(0).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(0).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(0).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(0).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}
				

			} else if (e.getSource() == btn[1]) {
				try {
					URL url = new URL(list.get(1).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(1).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(1).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(1).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}
				
			}else if (e.getSource() == btn[2]) {
				try {
					URL url = new URL(list.get(2).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(2).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(2).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(2).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}
				
			}else if (e.getSource() == btn[3]) {
				try {
					URL url = new URL(list.get(3).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(3).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(3).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(3).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}

			} else if (e.getSource() == btn[4]) {
				try {
					URL url = new URL(list.get(4).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(4).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(4).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(4).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}

			} else if (e.getSource() == btn[5]) {
				try {
					URL url = new URL(list.get(5).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(5).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(5).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(5).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}

			} else if (e.getSource() == btn[6]) {
				try {
					URL url = new URL(list.get(6).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(6).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(6).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(6).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}

			} else if (e.getSource() == btn[7]) {
				try {
					URL url = new URL(list.get(7).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(7).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(7).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(7).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}

			} else if (e.getSource() == btn[8]) {
				try {
					URL url = new URL(list.get(8).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(8).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(8).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(8).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}

			} else if (e.getSource() == btn[9]) {
				try {
					URL url = new URL(list.get(9).getImage());
					Image image = ImageIO.read(url);
					image = image.getScaledInstance(140, 200, Image.SCALE_SMOOTH);

					ImageIcon img = new ImageIcon(image);
					JLabel imgLabel = new JLabel(img);
					imgLabel.setBounds(240, 20, 140, 180);
					infoP.add(imgLabel);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Jtext = new JTextArea(list.get(9).getTitle());
				Jtext.setFont(font1);
				Jtext.setLineWrap(true);
				Jtext.setEditable(false);
				Jtext.setBounds(30, 30, 200, 80);
				infoP.add(Jtext);
				

				JTextArea description = new JTextArea(list.get(9).getDescription());
				description.setFont(font2);
				description.setLineWrap(true);
				description.setEditable(false);

				JScrollPane scroll = new JScrollPane(description);
				scroll.setBounds(30, 210, 340, 160);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scroll.setBorder(null);
				infoP.add(scroll);
				
				ImageIcon img3 = new ImageIcon(getClass().getClassLoader().getResource("vidio.png"));
				JButton vidio_btn = new JButton(img3);
				vidio_btn.setBounds(170, 130, 50, 50);
				infoP.add(vidio_btn);

				title = list.get(9).getTitle();
				System.out.println(title);
				
				Data_Page1 data = new Data_Page1();
				String[] data_title = data.getTitle();
				String[] content_a = data.getContnet();
				boolean flag = false;
				String content_b = "";
				
				for(int i = 0; i < data_title.length; i++) {
					if(title.contains(data_title[i]) == true) {
						flag = true;
						content_b = content_a[i];
					}
				}
				if(flag) {
					vidio_btn.setVisible(true);
					vidio_btn.addActionListener(new MyListener_vidioBtn());
					
					JTextArea content = new JTextArea(content_b);
					content.setBounds(30, 380, 340, 100);
					content.setForeground(Color.blue);
					infoP.add(content);
				}else {
					vidio_btn.setVisible(false);
				}

			}
		}
	}

	class MyListener_vidioBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Data_Page1 data = new Data_Page1();
			String[] data_title = data.getTitle();
			String[] data_title_url = data.getTitle_url();
			
			for(int i = 0; i < data_title.length; i++) {
				if(title.contains(data_title[i]) == true) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI(data_title_url[i]);
							desktop.browse(uri);
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
					
				}
			}
		}
	}
}
