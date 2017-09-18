package me.cmlt.tankbattle.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import me.cmlt.tankbattle.Model.Init;

public class ScoresPanel extends JPanel{
	
	private GamePanelRight penleRight;
	public ScoresPanel(GamePanelRight gamePanelRight){
		
		this.setPreferredSize(new Dimension(200, 200));
//		this.setBackground(Color.pink);
		this.penleRight=gamePanelRight;
		
		
	}
     
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.setFont(new Font("xx", 1, 20));
    	g.setColor(Color.red);
    	g.drawString("��ǰ�ؿ�:"+(Init.level), 10, 20);
    	g.setColor(Color.black);
    	g.drawString("���ػ���̹�ˣ�"+Init.perdestoryEnemyTanks, 10, 60);
    	g.drawString("�ùص÷֣�"+(Init.perScores), 10, 90);
    	g.drawString("�ܹ�����̹�ˣ�"+(Init.destoryEnemyTanks), 10, 130);
    	g.drawString("�ܹ��÷֣�"+(Init.allScores), 10, 150);
    	g.setFont(new Font("xx", 2, 20));
    	g.setColor(Color.red);
    	if (Init.isWin) {
    		g.drawString("��ϲ��ͨ���ˣ�", 10, 180);
		}
    	
    	if (Init.isFail) {
    		g.drawString("���ź���Ϸʧ�ܣ�", 10, 180);
		}
    	g.drawRect(0, 0, 200, 200);
    	
    	repaint();
    	
    }
}
