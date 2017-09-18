package me.cmlt.tankbattle.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import me.cmlt.tankbattle.Model.Init;
import me.cmlt.tankbattle.Model.Tank;

public class InformationPanel extends JPanel{
	
	private GamePanelRight penelRight;
	
	public InformationPanel( GamePanelRight  newPenelRight){
		this.setPreferredSize(new Dimension(200, 200));
//		this.setBackground(Color.blue);
		this.penelRight=newPenelRight;
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
         Vector<Tank> tanks = penelRight.getFrame().getPanel().getGame().getEnemyTanks();
     	g.drawImage(new ImageIcon("images/bgRight.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);//背景
     	g.drawImage(new ImageIcon("images/enemy1D.gif").getImage(), 25, 40, 30, 30,  this);
     	g.drawImage(new ImageIcon("images/enemy2D.gif").getImage(), 55, 40, 30, 30,  this);
     	g.drawImage(new ImageIcon("images/enemy3D.gif").getImage(), 85, 40, 30, 30,  this);
     	g.setFont(new Font("X", 3, 30));
     	g.drawString("X"+(Init.enemyCounts+tanks.size()), 120, 65);
     	g.setColor(Color.red);
     	g.drawImage(new ImageIcon("images/e_up.png").getImage(), 25, 100, 30, 30,  this); 
     	g.drawString("X"+(Init.myTanklife), 60, 125);
        
        
        
         
//		g.drawString("敌方剩余坦克数量"+(Init.enemyCounts+tanks.size()), 20, 40);
		
//		g.drawString("我方剩余坦克数量"+(Init.myTanklife), 20, 80);
    	

		repaint();
	}
}
