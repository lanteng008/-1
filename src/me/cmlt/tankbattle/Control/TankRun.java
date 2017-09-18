package me.cmlt.tankbattle.Control;

import java.util.Random;
import java.util.Vector;

import me.cmlt.tankbattle.Main.Main;
import me.cmlt.tankbattle.Model.Game;
import me.cmlt.tankbattle.Model.Init;
import me.cmlt.tankbattle.Model.Maps;
import me.cmlt.tankbattle.Model.Missile;
import me.cmlt.tankbattle.Model.Tank;
import me.cmlt.tankbattle.View.GamePanel;

public class TankRun implements Runnable{
	
	private Main mymain;
	private Random  random = new Random();
	
	

	public TankRun(Main mymain) {
		super();
		this.mymain = mymain;
	}



	@Override
	public void run() {
		
		while(true){
			
			if (mymain.getFrame().isVisible()) {
				
				Game game = mymain.getFrame().getPanel().getGame();
				Vector<Tank> Etanks = game.getEnemyTanks();//获取地方坦克集合
				
//				if (tanks==null ||tanks.size()==0) {
//					continue;
//				}
				//当屏幕上坦克小于3只时自动补充
				if (Etanks.size()<3) {  //出生点有坦克时不出生
					if (Init.enemyCounts>0) {//有剩余坦克数量的时候才补充
						Etanks.add(Init.getEnemyTank(mymain.getFrame().getPanel().getGame().getTank().isBorn(game)));
						mymain.getFrame().getMusic().playBlastMusic();
						Init.enemyCounts--;
					}
					
					
				}
				 if (Etanks.size()==0 &&Init.level<5&&Init.enemyCounts==0 &&Init.enemyCounts==0) {//集合内敌方打完过关
					//重置数据
					
					 
					 
					 if (Init.level==4) {//打过第四关胜利
							Init.isWin=true;
							
					         continue;	
						}
					 Init.level++;//关卡升级

					 //删除我方射出的子弹
					 Vector<Missile> buttles = game.getTank().getBullets();
					 for (int i = 0; i < buttles.size(); i++) {
						   buttles.remove(i);
					}
					//重置初始三辆敌方坦克
					game.setEnemyTanks(Init.getEnemyTanks());
					//重置敌军坦克储备
					 Init.enemyCounts=17;
					 //重置当前关卡得分,当前关卡击毁坦克数量
					 Init.perScores=0;
					 Init.perdestoryEnemyTanks=0;
					 //调用Map类里根据当前关卡切换地图方法
					 GamePanel.setMap(new Maps().changeMap());
					 Tank myTank = game.getTank();
					 myTank.setDir(Init.up);
					 myTank.setX(Init.myTankInitX);
					 myTank.setY(Init.myTankInitY);
					
					 
					 
					 
					}	
				 if (Init.isTimer!=true) {//当定时器被吃时，暂停敌方移动方法，达到禁止敌方运动效果
					
					 for (int i = 0; i <Etanks.size(); i++) {
						 Tank tank = Etanks.get(i);
						 
						 int temp  = random.nextInt(30);
						 if (temp==1&&!Init.isTimer) {
							 tank.turn(random.nextInt(4)+1);    //敌方坦克非定时状态随机转向
						 }else {
							 if (!tank.collideBorder()&&!tank.collideObj(game)&&!Init.isTimer ) {//敌方未碰到障碍物，非定时状态移动
								 tank.move();
							 }else if(!Init.isTimer){
								 int dir = random.nextInt(4)+1;   //敌方坦克碰撞转向
								 tank.setDir(dir);
								 
								 
							 }
						 }
						 
						 //敌方非定时状态随机发射子弹
						 int temp2 =random.nextInt(30);
						 if (temp2==2) {
							 tank.createMissile(true);
						 }
					 }
				}
			}
	        
			Game game = mymain.getFrame().getPanel().getGame();//暂停时我方坦克不被影响 
			Tank runTank = game.getTank();//获取我方坦克
				 //我方坦克移动线程
				 if (!runTank.collideBorder()&&!runTank.collideObj(game)) {
					 if (Init.runU) {
						runTank.move();
					}
					 else if (Init.runD) {
							runTank.move();
						}
					 else if (Init.runL) {
							runTank.move();
						}
					 else if (Init.runR) {
							runTank.move();
						}
					}
                 	 
		
				
				
				
			
				
		      
				
				
				
				mymain.getFrame().getPanel().repaint();
		
			
			try {
				Thread.sleep(25);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		}
		
		
		
	}



	public Main getMymain() {
		return mymain;
	}



	public void setMymain(Main mymain) {
		this.mymain = mymain;
	}



	public Random getRandom() {
		return random;
	}



	public void setRandom(Random random) {
		this.random = random;
	}
	

}
