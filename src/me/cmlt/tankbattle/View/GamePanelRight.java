package me.cmlt.tankbattle.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import me.cmlt.tankbattle.Main.Main;

public class GamePanelRight extends JPanel{
	
	
	
	private GameFrame frame;
	InformationPanel panelInfo;
	RulesPanel panelRules;
	ScoresPanel panelScores;
	public GamePanelRight(GameFrame newframe){
		this.setPreferredSize(new Dimension(200, 600));
		this.frame = newframe;
		panelInfo = new InformationPanel(this);
		panelRules = new RulesPanel();
		panelScores = new ScoresPanel(this);
		
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(panelInfo,BorderLayout.NORTH);
		this.add(panelRules,BorderLayout.CENTER);
		this.add(panelScores,BorderLayout.SOUTH);
		
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	
	}
	
	
	public GameFrame getFrame() {
		return frame;
	}
	public void setFrame(GameFrame frame) {
		this.frame = frame;
	}
}
