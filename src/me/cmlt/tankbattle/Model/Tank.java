package me.cmlt.tankbattle.Model;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;





import me.cmlt.tankbattle.View.GamePanel;

import org.omg.CORBA.PUBLIC_MEMBER;


//坦克类
public class Tank implements Move,Collide{
	
	//坦克类型
	private int type;
	//坦克方向
	private int dir;
	//坦克横坐标
	private int X;
	//坦克纵坐标
	private int Y;
    //坦克移动速度
	private int sp;
	//坦克生命值
	private int hp;
	//坦克模型
	private String model;
	//坦克子弹
	private Vector<Missile> bullets;
	//唯一坦克标识
	private String onlyId;
     
	public String getOnlyId() {
		return onlyId;
	}


	public void setOnlyId(String onlyId) {
		this.onlyId = onlyId;
	}


	public Tank(int type, int dir, int x, int y, int sp, int hp, String model,Vector<Missile> bullets) {
		super();
		this.type = type;
		this.dir = dir;
		X = x;
		Y = y;
		this.sp = sp;
		this.hp = hp;
		this.model = model;
	}
	
	
	public Tank() {
		super();
	}

	//坦克移动方法

	@Override
	public void move() {
		
		switch (this.dir) {
		case Init.up:
			this.Y-=this.sp;
			break;
		case Init.down:
			this.Y+=this.sp;
			break;
		case Init.left:
			this.X-=this.sp;
			break;
		case Init.right:
			this.X+=this.sp;
			break;

	
		}
		
	}
	@Override
	public boolean turn(int dir) {
		if (this.dir==dir) {
			return true;
		}
		this.dir = dir;
		return true;
		
		
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

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	@Override
	//坦克碰撞边界判断
	public boolean collideBorder() {
		int x = this.X;
		int y = this.Y;
		switch (this.dir) {
		case Init.up:
			y = this.Y-this.sp;
			break;
		case Init.down:
			y = this.Y+this.sp;
			break;
		case Init.left:
			x = this.X-this.sp;
			break;
		case Init.right:
			x = this.X+this.sp;
			break;
		}
		
		
		if (x>800-Init.TankWidth||x<0||y>600-Init.TankHeight||y<0) {
			return true;
			
		}
		return false;
	}
	
	

    //坦克碰撞障碍物判断
	@Override
	public boolean collideObj(Game game) {
		int x = this.X;
		int y = this.Y;
		
		switch (this.dir) {
		case Init.up:
			y = this.Y-this.sp;
			break;
		case Init.down:
			y = this.Y+this.sp;
			break;
		case Init.left:
			x = this.X-this.sp;
			break;
		case Init.right:
			x = this.X+this.sp;
			break;
		}		
		
		
		Rectangle rectangle = new Rectangle(x, y, Init.TankWidth, Init.TankHeight);//当前坦克
		Vector<Tank> entanks = game.getEnemyTanks();
		
	Tank myTank = game.getTank();
		Rectangle mytankRectangle = new Rectangle(myTank.getX(), myTank.getY(), Init.TankWidth, Init.TankHeight);//我方坦克碰撞体积
		for (int i = entanks.size()-1; i >=0; i--) {//由于敌方碰撞会出bug，短期未能解决，取消敌方坦克之间不能碰撞功能
			Tank tankTemp = entanks.get(i);
			Rectangle etemp = new Rectangle(tankTemp.getX(), tankTemp.getY(), Init.TankWidth, Init.TankHeight);
			if (tankTemp.getType()!=(this.getType())) {  //我方敌方碰撞
				if (rectangle.intersects(etemp)) {
					return true;
				}
			}
		}

//		敌方坦克碰撞我方
	
		if (myTank.getType()!=this.type) {
			if (rectangle.intersects(mytankRectangle)) {
				return true;
			}
		}
		
//我方坦克碰撞敌方
		
		
	
		
		
//		坦克撞墙判断，遍历地图，创建障碍物碰撞体积
		//1为墙 2为水 3为铁 4为草 5为基地
		int[][] map = GamePanel.getMap();
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j]==1||map[i][j]==2||map[i][j]==3) {//判断坦克不能直接穿过的障碍物 1墙 2水 3铁 5老窝
							Rectangle noCrossObj = new Rectangle(j*20, i*20, 20, 20);
							if (rectangle.intersects(noCrossObj)) {
								
								return true;
								}
							
							
								
							
								
							}
						else if (map[i][j]==5) {//不能穿过老窝
							Rectangle noCrossHome = new Rectangle(j*20, i*20, 40, 40);
							if (rectangle.intersects(noCrossHome)) {
								return true;
							}
							
						}
						
						//开始判断我方坦克吃道具 6为血包  7为星星 8为定时器
						else if (map[i][j]==6) {
							Rectangle lifeItem = new  Rectangle(j*20, i*20,20,20);
							    //只有我方能吃 
							    if (this.type==1) {
							    	
							    	if (rectangle.intersects(lifeItem)) {
							    		//判断如果我方坦克吃到时残血，则加满血，若吃到时为满血，则加一条命
							    		map[i][j]=0;
							            if (this.getHp()<30) {
											this.setHp(30);
										}else if (this.getHp()==30) {
											Init.myTanklife++;
										}
											
									}
								}
								
								
								
							
							
						}
						else if (map[i][j]==7) {
							Rectangle starItem = new  Rectangle(j*20, i*20,20,20);
							//只有我方能吃
							    if (this.type==1) {
							    	if (rectangle.intersects(starItem)) {
							    	      Init.isHitIron=true;//能打铁
							    		map[i][j]=0;	
									}
								}
								
								
								
							
							
						}
						else if (map[i][j]==8) {
							Rectangle timer = new Rectangle(j*20, i*20, 20, 20);
							 if (this.type==1) {
							if (rectangle.intersects(timer)) {//吃定时器
								map[i][j]=0;
								Init.isTimer=true;
								
								
								//暂停后五秒恢复
								Timer timer2 = new Timer(true);
								timer2.schedule(new TimerTask() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										if (Init.isTimer==true) {
											Init.isTimer=false;
											this.cancel();
										}
									}
								}, 5000);
								
								
							}
							 }
						}
						
					
					}
				}
				
			
			
		
		
		return false;
	}
	
	
	//坦克发射子弹
	public void createMissile(boolean isEenmy){
		Missile bullet = new Missile();
	   bullet.setType(this.type);
	   bullet.setDir(dir);
	   bullet.setEnemy(isEenmy); 	
	   bullet.setSpd(Init.b_spd);
	   int x = this.X;
	   int y = this.Y;
	   
	   switch (this.dir) {
	case Init.up:
		x = this.X+18;
		break;
	case Init.down:
		x = this.X+18;
		y = this.Y+36;
		break;
	case Init.left:
		y = this.Y+18;
		break;
	case Init.right:
		y=this.Y+18;
		x=this.X+36;
	}
	  bullet.setBx(x);
	  bullet.setBy(y);
	   
	  if (this.bullets==null) {
		  bullets = new Vector<Missile>();
		
	}
	  bullets.add(bullet);
	  

	}
	
	//判断出生位置是否有坦克 
	public  int isBorn(Game game){
		
		int x1 = this.X;
		int y1 = this.Y;
		
		
		
		
		
		Rectangle a = new Rectangle(Init.enemyTank1X, Init.enemyTank1Y, 40, 40);
		Rectangle b = new Rectangle(Init.enemyTank2X, Init.enemyTank2Y, 40, 40);
		Rectangle c = new Rectangle(Init.enemyTank3X, Init.enemyTank3Y, 40, 40);
		Rectangle rectangle1 = new Rectangle(x1, y1, Init.TankWidth, Init.TankHeight);
		//根据出生位置是否有我方坦克的情况，选择出生地点，返回值1，2，3，0分别代表不同的地点
		if (b.intersects(rectangle1)||c.intersects(rectangle1)) {
			return 1;
		}else if (a.intersects(rectangle1)||c.intersects(rectangle1)) {
			return 2;
		}else if (a.intersects(rectangle1)||b.intersects(rectangle1)) {
			return 3;
		}else if (a.intersects(rectangle1)&&b.intersects(rectangle1)&&c.intersects(rectangle1)) {
			return 4;
			
		}	
		else return 0;
	}


	public Vector<Missile> getBullets() {
		return bullets;
	}


	public void setBullets(Vector<Missile> bullets) {
		this.bullets = bullets;
	}

	

   
	
	

		
		
		
	}
	

      
	
	
	
	
	


