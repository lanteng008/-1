package me.cmlt.tankbattle.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import me.cmlt.tankbattle.Model.Init;

public class RulesPanel extends JPanel{
	public RulesPanel(){
		
		this.setPreferredSize(new Dimension(200, 200));
//		this.setBackground(Color.red);
	}

	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(new ImageIcon("images/bgRight2.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);//背景
		g.setFont(new Font("X", 3, 20));
		g.setColor(Color.red);
		g.drawString("游戏规则:", 10, 40);
		
		g.setColor(Color.black);
		g.setFont(new Font("X", 4, 15));
		g.drawString("上移:W", 20, 60);
		g.drawString("下移:S", 20, 80);
		g.drawString("左移:A", 20, 100);
		g.drawString("右移:D", 20, 120);
		g.drawString("开火:J", 20, 140);
		g.drawString("暂停:P", 20, 160);
		g.drawString("继续:R", 20, 180);
		g.setColor(Color.red);
		g.drawString("击毁坦克加分", 80, 60);
     	g.setFont(new Font("X", 3, 30));
     	g.drawImage(new ImageIcon("images/enemy1D.gif").getImage(), 90, 70, 30, 30,  this);
     	g.drawString("+"+10, 120, 90);
     	g.drawImage(new ImageIcon("images/enemy2D.gif").getImage(), 90, 100, 30, 30,  this);
     	g.drawString("+"+20, 120, 125);
     	g.drawImage(new ImageIcon("images/enemy3D.gif").getImage(), 85, 130, 30, 30,  this);
     	g.drawString("+"+30, 120, 160);

		
	}
}
