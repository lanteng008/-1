package me.cmlt.tankbattle.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;
import javax.swing.plaf.RootPaneUI;

import me.cmlt.tankbattle.Main.Main;
import me.cmlt.tankbattle.Model.Init;
import me.cmlt.tankbattle.Model.Maps;

public class GameJmenuBar extends JMenuBar{
	
	GameFrame frame;
	
	public GameJmenuBar(GameFrame gameFrame){
		this.frame = gameFrame;
		
		   //主菜单栏添加
		    JMenu game = new JMenu("游戏");
			JMenu help = new JMenu("帮助");
			JMenu choce = new JMenu("选择关卡");
			
			this.add(game);
			this.add(choce);
			this.add(help);
			
			//游戏菜单添加  Item
			JMenuItem reStart = new JMenuItem("重新开始");
			JMenuItem exit = new JMenuItem("退出游戏");
			
			game.add(reStart);
		    game.add(exit);
		    
			
			//帮助菜单添加Item
			JMenuItem gameText = new JMenuItem("游戏说明");
			help.add(gameText);
			
			
			//选择关卡添加Item
			JMenuItem choce2 = new JMenuItem("第二关");
			JMenuItem choce3 = new JMenuItem("第三关");
			JMenuItem choce4 = new JMenuItem("第四关");
		    
		    choce.add(choce2);
		    choce.add(choce3);
		    choce.add(choce4);
		    

//开始添加事件
		    
			//添加重新开始Item功能
		    reStart.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					
					   GamePanel.map=new Maps().getMap1();
					   Init.level=1;
					   Init.isPause=false;
					   Init.isFail=false;
					   Init.isWin=false;
					   Init.perdestoryEnemyTanks=0;
					   Init.destoryEnemyTanks=0;
					   Init.perScores=0;
					   Init.allScores=0;
					   Init.enemyCounts=17;
					   Init.myTanklife=3;
					  frame.getPanel().setGame(Init.initGame());
				}
			});
			
		    //添加退出游戏Item功能
		    exit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
		    
		    //添加游戏说明Item功能
		    gameText.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					String message = "欢迎来到坦克大战\n"
							+ "基本操作方式 在右侧面板，被炮弹击中生命值-10\n"
							+ "我方生命值为30，初始共有三辆坦克\n"
							+ "游戏内有三种敌方坦克-白色，绿色，黄色\n"
							+ "白色坦克速度为2，生命值为10，得分为10\n"
							+ "绿色色坦克速度为3，生命值为20，得分为20\n"
							+ "黄色坦克速度为4，生命值为30，得分为30\n"
							+ "游戏一共有四关，每关击败敌方20俩坦克即可过关\n"
							+ "当我方坦克生命消耗完，或我方基地被攻破时游戏失败\n"
							+ "游戏地图中会随机出现道具增强我方能力，帮助您过关\n"
							+ "血包吃了回满血，若满血时吃到，奖励一辆坦克\n"
							+ "星星吃了后加强子弹，可以打掉铁块\n"
							+ "最后祝您游戏愉快";
					JOptionPane.showMessageDialog(null, message);
					
				}
			});
			
			
			//添加选择关卡Item功能
			//选择第二关
		    choce2.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					   GamePanel.map=new Maps().getMap2();
					   Init.level=2;
					   Init.isPause=false;
					   Init.isFail=false;
					   Init.isWin=false;
					   Init.perdestoryEnemyTanks=0;
					   Init.destoryEnemyTanks=0;
					   Init.perScores=0;
					   Init.allScores=0;
					   Init.enemyCounts=17;
					   Init.myTanklife=3;
					  frame.getPanel().setGame(Init.initGame());
					
				}
			});
		    
		    //选择第三关
		    choce3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					   GamePanel.map=new Maps().getMap3();
					   Init.level=3;
					   Init.isPause=false;
					   Init.isFail=false;
					   Init.isWin=false;
					   Init.perdestoryEnemyTanks=0;
					   Init.destoryEnemyTanks=0;
					   Init.perScores=0;
					   Init.allScores=0;
					   Init.enemyCounts=17;
					   Init.myTanklife=3;
					  frame.getPanel().setGame(Init.initGame());
					
				}
			});
		    
		    //选择第四关
		    choce4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					   GamePanel.map=new Maps().getMap4();
					   Init.level=4;
					   Init.isPause=false;
					   Init.isFail=false;
					   Init.isWin=false;
					   Init.perdestoryEnemyTanks=0;
					   Init.destoryEnemyTanks=0;
					   Init.perScores=0;
					   Init.allScores=0;
					   Init.enemyCounts=17;
					   Init.myTanklife=3;
					  frame.getPanel().setGame(Init.initGame());
					
				}
			});
		
			
	 }

}
