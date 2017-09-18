package me.cmlt.tankbattle.View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import me.cmlt.tankbattle.Main.Main;


public class StartPanel extends JPanel {
	StartFrame startFrame;
	JButton bStart;
	JButton bExit;
	
	public StartPanel(final StartFrame startFrame){
		this.startFrame = startFrame;
		this.setPreferredSize(new Dimension(400, 400));
		bStart = new JButton("��ʼ��Ϸ");
		bExit = new JButton("�˳���Ϸ");
		this.add(bStart);
		this.add(bExit);
		//���ÿ�ʼ��ť����������Ϸ
		bStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startFrame.dispose();
				new Main();
				
				
			}
		});
		
		//�����˳���ť�����˳�
		bExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
		
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(new ImageIcon("images/bgimg.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
