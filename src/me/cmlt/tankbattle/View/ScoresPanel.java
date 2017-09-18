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
    	g.drawString("当前关卡:"+(Init.level), 10, 20);
    	g.setColor(Color.black);
    	g.drawString("本关击毁坦克："+Init.perdestoryEnemyTanks, 10, 60);
    	g.drawString("该关得分："+(Init.perScores), 10, 90);
    	g.drawString("总共击毁坦克："+(Init.destoryEnemyTanks), 10, 130);
    	g.drawString("总共得分："+(Init.allScores), 10, 150);
    	g.setFont(new Font("xx", 2, 20));
    	g.setColor(Color.red);
    	if (Init.isWin) {
    		g.drawString("恭喜您通关了！", 10, 180);
		}
    	
    	if (Init.isFail) {
    		g.drawString("很遗憾游戏失败！", 10, 180);
		}
    	g.drawRect(0, 0, 200, 200);
    	
    	repaint();
    	
    }
}
