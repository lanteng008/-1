package me.cmlt.tankbattle.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;





















import org.omg.CORBA.PUBLIC_MEMBER;

import me.cmlt.tankbattle.Model.Game;
import me.cmlt.tankbattle.Model.Init;
import me.cmlt.tankbattle.Model.Maps;
import me.cmlt.tankbattle.Model.Missile;
import me.cmlt.tankbattle.Model.Music;
import me.cmlt.tankbattle.Model.Tank;




public class GamePanel extends JPanel{
	
	Game game;
	static Maps maps = new Maps();
	public static int[][] map = new Maps().getMap1();
	
	public GamePanel(){
		this.setPreferredSize(new Dimension(800, 600));
        game = Init.initGame();
        this.setBackground(Color.black);
      
        
     
   
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//绘制辅助线
//		for(int i = 0; i <= 60; i ++){
//			g.drawLine(0, i * 20, 800, i * 20);
//		}
		//绘制辅助线
//		for(int i = 0; i <= 80; i ++){
//			g.drawLine(i * 20, 0,  i *20, 600);
//		}
		//绘制我方坦克+我方血条
		Tank tank = game.getTank();
		String tankPath =   Init.Models.get(tank.getModel()).get(tank.getDir()-1);
		//根据血量百分百画血条
        Graphics2D g2=(Graphics2D) g;  
        Rectangle2D r=new Rectangle2D.Double(tank.getX(),tank.getY()-10, Init.TankWidth*((double)tank.getHp()/Init.myHp), 5);  
        g2.setColor(Color.red);
        g2.fill(r);
		
		g.drawImage(new ImageIcon(tankPath).getImage(),
				tank.getX(), tank.getY(), Init.TankWidth, Init.TankHeight, this);
		
		
		
		//绘制敌方坦克+敌方血条
		Vector<Tank> tanks = game.getEnemyTanks();
		if (tanks!=null &&tanks.size()>0) {
			for (int i = 0; i < tanks.size(); i++) {
				
				Tank tankE = tanks.get(i);
				//根据敌方血量百分比绘制血条  通过敌方不同的速度来判断敌方初始血量的多少，
				 if (tankE.getSp()==Init.enemyTank1spd) {
		        	 Rectangle2D e1=new Rectangle2D.Double(tankE.getX(),tankE.getY()-10, Init.TankWidth*((double)tankE.getHp()/Init.enemyTank1Hp), 5);
						g2.setColor(Color.red);
						g2.fill(e1);
				}else if (tankE.getSp()==Init.enemyTank2spd) {
		        	 Rectangle2D e1=new Rectangle2D.Double(tankE.getX(),tankE.getY()-10, Init.TankWidth*((double)tankE.getHp()/Init.enemyTank2Hp), 5);
						g2.setColor(Color.red);
						g2.fill(e1);
				}
				else if (tankE.getSp()==Init.enemyTank3spd) {
		        	 Rectangle2D e1=new Rectangle2D.Double(tankE.getX(),tankE.getY()-10, Init.TankWidth*((double)tankE.getHp()/Init.enemyTank3Hp), 5);
						g2.setColor(Color.red);
						g2.fill(e1);
				}
					
		
				
				
				String enTankPath = Init.Models.get(tankE.getModel()).get(tankE.getDir()-1);
				g.drawImage( new ImageIcon(enTankPath).getImage(), tankE.getX(), tankE.getY(), 
						Init.TankWidth, Init.TankHeight,  this);
			}
		}
		//绘制地图 
		//1为墙 2为水 3为铁 4为草 5为基地 6为血包 7为星星
        
         for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j]==1) {
					g.drawImage(new ImageIcon("images/1.png").getImage(), j*20, i*20, 20, 20, this);
					
				}
				if (map[i][j]==2) {
					g.drawImage(new ImageIcon("images/2.png").getImage(), j*20, i*20, 20, 20, this);
					
				}
				if (map[i][j]==3) {
					g.drawImage(new ImageIcon("images/3.gif").getImage(), j*20, i*20, 20, 20, this);
					
				}
				if (map[i][j]==4) {
					g.drawImage(new ImageIcon("images/4.png").getImage(), j*20, i*20, 20, 20, this);
					
				}
				if (map[i][j]==5) {
					g.drawImage(new ImageIcon("images/home.png").getImage(), j*20, i*20, 40, 40, this);
					
				}
				if (map[i][j]==-1) {
					g.drawImage(new ImageIcon("images/destory.gif").getImage(), j*20, i*20, 40, 40, this);
					
				}
				
				if (map[i][j]==6) {
					g.drawImage(new ImageIcon("images/Life.png").getImage(), j*20, i*20, 20, 20,  this);
				}
				if (map[i][j]==7) {
					g.drawImage(new ImageIcon("images/star.gif").getImage(), j*20, i*20, 20, 20,  this);
				}
				if (map[i][j]==8) {
					g.drawImage(new ImageIcon("images/timer.gif").getImage(), j*20, i*20, 20, 20,  this);
				}
		        
			}
			
		}
         
		
	
		//绘制我方子弹
		Vector<Missile> bullets =game.getTank().getBullets();
		if (bullets!=null) {
			
			for (int i = 0; i <bullets.size(); i++) {
				Missile b =bullets.get(i);
				g.drawImage(new ImageIcon("images/tankmissile.gif").getImage(), 
						b.getBx(), b.getBy(), Init.b_width, Init.b_height,  this);
				
			}
			
		}
	
		//绘制敌方子弹
		if (tanks!=null &&tanks.size()>0) {
			for (int i = 0; i < tanks.size(); i++) {
				Vector<Missile> enemyButtles = tanks.get(i).getBullets();
				if (enemyButtles!=null) {
					for (int j = 0; j < enemyButtles.size(); j++) {
						Missile b = enemyButtles.get(j);
						g.drawImage(new ImageIcon("images/enemymissile.gif").getImage(),
								b.getBx(), b.getBy(), Init.b_width,Init.b_height,this);
					}
				}
				
			}
			
		}
		
		
		//绘制胜利
		if (Init.isWin) {
			Init.isPause=true;//顺便暂停
			g.drawImage(new ImageIcon("images/win.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(),  this);
		}
		//绘制失败
             if (Init.isFail) {
			Init.isPause=true;//顺便暂停
			g.drawImage(new ImageIcon("images/fail.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(),  this);
		}
             
             
		
		
		
		}

	public static Maps getMaps() {
		return maps;
	}

	public static void setMaps(Maps maps) {
		GamePanel.maps = maps;
	}



	public static int[][] getMap() {
		return map;
	}

	public static void setMap(int[][] map) {
		GamePanel.map = map;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}











	
	
}
