package me.cmlt.tankbattle.Model;

import java.awt.Rectangle;
import java.util.Map;
import java.util.Vector;

import javax.rmi.CORBA.Util;
import javax.xml.transform.Templates;

import me.cmlt.tankbattle.View.GamePanel;

public class Missile implements Move,Collide{
	Music music = new Music();
	private int type;
	private int dir;//方向
	private int bx;//坐标
	private int by;
	private int spd;//速度
	private String model;//模型
	private boolean isEnemy;
	public Missile() {
		super();
	}



	public Missile(int type, int dir, int bx, int by, int spd, String model,
			boolean isEnemy) {
		super();
		this.type = type;
		this.dir = dir;
		this.bx = bx;
		this.by = by;
		this.spd = spd;
		this.model = model;
		this.isEnemy = isEnemy;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public int getBx() {
		return bx;
	}
	public void setBx(int bx) {
		this.bx = bx;
	}
	public int getBy() {
		return by;
	}
	public void setBy(int by) {
		this.by = by;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean isEnemy() {
		return isEnemy;
	}
	public void setEnemy(boolean isEnemy) {
		this.isEnemy = isEnemy;
	}
	@Override
	public void move() {
        switch (this.dir) {
		case Init.up:
			this.by-=this.spd;
			break;
		case Init.down:
			this.by+=this.spd;
			break;
		case Init.left:
			this.bx-=this.spd;
			break;
		case Init.right:
			this.bx+=this.spd;
			

		
		}

	
	}
	@Override
	public boolean turn(int dir) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	//子弹碰撞边界判断
	public boolean collideBorder() {
		// TODO Auto-generated method stub

		int x = this.bx;
		int y = this.by;
	
		
		
		if (x>800||x<0||y>600||y<0) {
			return true;
			
		}
		return false;
	
		
		
		
		
	}


    //子弹碰撞物体/坦克判断
	@Override
	public boolean collideObj(Game game) {
		//获取地图上子弹碰撞体积
		Rectangle bRectangle  = new Rectangle(this.bx, this.by, Init.b_width, Init.b_height);
//		System.out.println("当前子弹："+this.bx+":"+this.by);
		//我方子弹碰撞敌方坦克结果
		Vector<Tank> enTanks = game.getEnemyTanks();//获取敌方坦克集合
		
		
		for (int i=enTanks.size()-1; i >=0; i--) {
			Tank enTank = enTanks.get(i);
			//当子弹属性和坦克属性不同时，
			if (enTank.getType()!=(this.type) ) {
				Rectangle entankRectangle = new Rectangle(enTank.getX(), enTank.getY(), Init.TankWidth, Init.TankHeight);
				//判断我方子弹和敌方坦克碰撞体积是否相交（碰撞）的方法
				if (bRectangle.intersects(entankRectangle)) {
					     //打中一次掉血一次，生命值为0时，删除敌方坦克
					    enTank.setHp(enTank.getHp()-10);
						if (enTank.getHp()==0) {
							enTanks.remove(i);
							Init.destoryEnemyTanks++;
							Init.perdestoryEnemyTanks++;
							//根据击毁坦克的类型加分
							switch (enTank.getModel()) {
							case Init.ENEMY:
								Init.perScores+=10;
								Init.allScores+=10;
								break;
							case Init.ENEMY2:
								Init.perScores+=20;
								Init.allScores+=20;
								break;
							case Init.ENEMY3:
								Init.perScores+=30;
								Init.allScores+=30;
								break;

							
							}
							
						}
					
					return true;
				}
				
			}
		}
		
		//敌方子弹击中我方
		Tank myTank = game.getTank();//获取我方坦克
		//获取我方坦克碰撞体积
		Rectangle mytankRectangle = new Rectangle(myTank.getX(), myTank.getY(), Init.TankWidth, Init.TankHeight);
		if (myTank.getType()!=this.type) {
			 if (bRectangle.intersects(mytankRectangle)) {//我方受到攻击，
				 myTank.setHp(myTank.getHp()-10);
					
					if (myTank.getHp()==0) {//生命值为0时life-1，重新充满生命，我方坦克回到初始位置,初始化状态为不能打铁
						
						Init.myTanklife--;
						Init.isHitIron=false;
						myTank.setHp(Init.myHp);
						myTank.setX(Init.myTankInitX);
						myTank.setY(Init.myTankInitY);
						if (Init.myTanklife==0) {//当生命用完时，游戏失败
							Init.isFail=true;
							
							music.playOverMusic();
						}
						
					}
					return true;
				}
		}
	    
		//子弹和子弹的碰撞
		
		
		

		
	
		//判断子弹射击墙体
		int[][] map = GamePanel.getMap();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j]==1) {
					Rectangle wall = new Rectangle(j*20, i*20, 20, 20);
					if (bRectangle.intersects(wall)) {
						
						map[i][j]=0;
						return true;
						
						
					}
					
				}
				
				else if (map[i][j]==3 &&this.type==1&&Init.isHitIron==true) {//判断打铁条件
					Rectangle iron = new Rectangle(j*20, i*20, 20, 20);
					if (bRectangle.intersects(iron)) {
						//子弹打击铁
						map[i][j]=0;
						return true;
					}
				}
				else if (map[i][j]==3) {
					Rectangle iron = new Rectangle(j*20, i*20, 20, 20);
					if (bRectangle.intersects(iron)) {
						//子弹打击铁
						
						return true;
					}
					
				}
				
				else if (map[i][j]==5) {
					Rectangle home  = new Rectangle(j*20,i*20,40,40);
					//子弹打击老窝时，游戏失败
					if (bRectangle.intersects(home)) {
						map[i][j]=-1;
						Init.isFail=true;
						music.playOverMusic();
						return true;
					}
					
				}
				
			
			}
		}
		
	     
		
		
		
		
		
		
		return false;
	}


    	
	
	
	

}
