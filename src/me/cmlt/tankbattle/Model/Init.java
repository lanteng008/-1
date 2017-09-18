package me.cmlt.tankbattle.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;

import javax.xml.transform.Templates;





public  class Init {
	
	//设置游戏状态
	public static boolean isFail = false;//是否失败
	public static boolean isWin = false;//是否胜利
	public static int level =1;//关卡
	public static int enemyCounts=17;//敌方坦克储备
	public static int perdestoryEnemyTanks=0;//每关击毁坦克数
	public static int destoryEnemyTanks=0;//总击毁坦克数
	public static int perScores=0;//每关得分
	public static int allScores=0;//总得分
	public static boolean isPause = false;//是否暂停
	public static boolean isHitIron = false;//是否能打铁
	public static boolean isTimer = false;//是否计时器状态。
	

	//初始化方向值
	public static final int up = 1;
	public static final int down = 2;
	public static final int left = 3;
	public static final int right = 4;
	//线程方向初始化
	public static boolean runU=false;
	public static boolean runD=false;
	public static boolean runL=false;
	public static boolean runR=false;

	
	
	
	
	//初始化老窝位置
	public static final int homeX =380;
	public static final int homeY =560;
	public static final int homeLongSide=40;
	public static final String homePath  = "images/timg.png";
	
	//初始化我方坦克出生位置和血量和速度
	
	public static int myTanklife = 3;
	public static final int myTankInitX = 200;
	public static final int myTankInitY = 550;
	public static int myHp = 30;
	public static final int myTankSpeed = 5;
	//初始化敌方坦克出生位置
	public static final int enemyTank1X = 0;
	public static final int enemyTank1Y = 0;
	public static final int enemyTank2X = 360;
	public static final int enemyTank2Y = 0;
	public static final int enemyTank3X = 760;
	public static final int enemyTank3Y = 0;

	
	//初始化敌方坦克速度和血量
	public static final int enemyTank1spd = 2;
	public static final int enemyTank2spd = 3;
	public static final int enemyTank3spd = 4;
	public static final int enemyTank1Hp = 10;
	public static final int enemyTank2Hp = 20;
	public static final int enemyTank3Hp = 30;
	
	
	
	//初始化坦克大小
	
	public static final int TankWidth = 40;
	public static final int TankHeight = 40;
	
	
	//我方坦克模型
	public static final String MY = "my";
	//敌方坦克模型
	public static final String ENEMY = "enemy";
	public static final String ENEMY2 = "enemy2";
	public static final String ENEMY3 = "enemy3";
	
	//子弹的属性
	public static final int b_spd = 10;
	public static final int b_width = 5;
	public static final int b_height = 5;
	//我方坦克集合
	public static final Map<String, List<String>> Models = new HashMap<String, List<String>>();

	static{//创建List集合  将上下左右四张图片存入集合中，再将集合存入Map集合中（上下左右 各对应的图片）
		List<String> my_tank = new ArrayList<String>();
		my_tank.add("images/e_up.png");
		my_tank.add("images/e_down.png");
		my_tank.add("images/e_left.png");
		my_tank.add("images/e_right.png");
		Models.put(MY, my_tank); 
	//将三种敌方坦克的图片按上下左右的顺序 依次存入集合中，再将集合存入Map集合中
		List<String> en_tank = new ArrayList<String>();
		en_tank.add("images/enemy1U.gif");
		en_tank.add("images/enemy1D.gif");
		en_tank.add("images/enemy1L.gif");
		en_tank.add("images/enemy1R.gif");
        Models.put(ENEMY, en_tank);
        List<String> en_tank2 = new ArrayList<String>();
		en_tank2.add("images/enemy2U.gif");
		en_tank2.add("images/enemy2D.gif");
		en_tank2.add("images/enemy2L.gif");
		en_tank2.add("images/enemy2R.gif");
		Models.put(ENEMY2, en_tank2);
        List<String> en_tank3 = new ArrayList<String>();
		en_tank3.add("images/enemy3U.gif");
		en_tank3.add("images/enemy3D.gif");
		en_tank3.add("images/enemy3L.gif");
		en_tank3.add("images/enemy3R.gif");
		Models.put(ENEMY3, en_tank3);

		
		
		
		

		}
	//游戏地图初始话
	public static Maps maps = new Maps();
	
	
	
	
//	游戏数据初始化
	public static Game initGame(){
		Game game = new Game();
		Tank myTank = new Tank();
		
		myTank.setType(1);
		myTank.setDir(up);//方向向上
		myTank.setHp(myHp);//血量
		myTank.setModel(MY);//我的模型 Map中key的值
		myTank.setX(myTankInitX);;//坦克初始位置
		myTank.setY(myTankInitY);
		myTank.setSp(myTankSpeed);//我方坦克速度
		myTank.setOnlyId(getID());
		game.setTank(myTank);//将我的坦克传入game类的构造
		game.setEnemyTanks(getEnemyTanks());
		
		
		
	  
		
		
		
		
		
		return game;
	}
	
	
    //初始三个敌方坦克
	public static Vector<Tank> getEnemyTanks(){
		Vector<Tank> tanks = new Vector<Tank>();
		Tank tank1 = new Tank();
		tank1.setType(2);
		tank1.setDir(down);
		tank1.setHp(enemyTank1Hp);
		tank1.setX(enemyTank1X);
		tank1.setY(enemyTank1Y);
		tank1.setSp(enemyTank1spd);
		tank1.setModel(ENEMY);
		tank1.setOnlyId(getID());
		
		tanks.add(tank1);
		
		Tank tank2 = new Tank();
		tank2.setType(2);
		tank2.setDir(down);
		tank2.setHp(enemyTank2Hp);
		tank2.setX(enemyTank2X);
		tank2.setY(enemyTank2Y);
		tank2.setSp(enemyTank2spd);
		tank2.setModel(ENEMY2);
		tank2.setOnlyId(getID());
		tanks.add(tank2);
		
		Tank tank3 = new Tank();
		tank3.setType(2);
		tank3.setDir(down);
		tank3.setHp(enemyTank3Hp);
		tank3.setX(enemyTank3X);
		tank3.setY(enemyTank3Y);
		tank3.setSp(enemyTank3spd);
		tank3.setModel(ENEMY3);
		tank3.setOnlyId(getID());
		tanks.add(tank3);	
	
		
		
		return tanks;
	}
	
	//创建3俩敌方坦克随机补充
	public static Tank getEnemyTank(int x){
		Tank enTandAdd = new Tank();
		int r = x;
        Random random = new Random();
        int temp = random.nextInt(3);
        
		
		
		if (r==1 ) {
			enTandAdd.setType(2);
			enTandAdd.setDir(down);
			enTandAdd.setHp(enemyTank1Hp);
			enTandAdd.setX(enemyTank1X);
			enTandAdd.setY(enemyTank1Y);
			enTandAdd.setSp(enemyTank1spd);
			enTandAdd.setModel(ENEMY);
			enTandAdd.setOnlyId(getID());
		}
		if (r==2) {              
			enTandAdd.setType(2);
			enTandAdd.setDir(down);
			enTandAdd.setHp(enemyTank2Hp);
			enTandAdd.setX(enemyTank2X);
			enTandAdd.setY(enemyTank2Y);
			enTandAdd.setSp(enemyTank2spd);
			enTandAdd.setModel(ENEMY2);
			enTandAdd.setOnlyId(getID());
		}
		if (r==3) {
			enTandAdd.setType(2);
			enTandAdd.setDir(down);
			enTandAdd.setHp(enemyTank3Hp);
			enTandAdd.setX(enemyTank3X);
			enTandAdd.setY(enemyTank3Y);
			enTandAdd.setSp(enemyTank3spd);
			enTandAdd.setModel(ENEMY3);
			enTandAdd.setOnlyId(getID());		
		}if (r==4) {
			
		}
		//如果出生位置都随机出生
		if (r==0) {
			switch (temp) {
			case 0:
				enTandAdd.setType(2);
				enTandAdd.setDir(down);
				enTandAdd.setHp(enemyTank1Hp);
				enTandAdd.setX(enemyTank1X);
				enTandAdd.setY(enemyTank1Y);
				enTandAdd.setSp(enemyTank1spd);
				enTandAdd.setModel(ENEMY);
				enTandAdd.setOnlyId(getID());
				break;
			case 1:
				enTandAdd.setType(2);
				enTandAdd.setDir(down);
				enTandAdd.setHp(enemyTank2Hp);
				enTandAdd.setX(enemyTank2X);
				enTandAdd.setY(enemyTank2Y);
				enTandAdd.setSp(enemyTank2spd);
				enTandAdd.setModel(ENEMY2);
				enTandAdd.setOnlyId(getID());
				break;
			case 2:
				enTandAdd.setType(2);
				enTandAdd.setDir(down);
				enTandAdd.setHp(enemyTank3Hp);
				enTandAdd.setX(enemyTank3X);
				enTandAdd.setY(enemyTank3Y);
				enTandAdd.setSp(enemyTank3spd);
				enTandAdd.setModel(ENEMY3);
				enTandAdd.setOnlyId(getID());
				break;
			}
			
		}
		
		
		
		return enTandAdd;
	}
	
	//生成唯一Id
	private static Random random = new Random();
	private static String getID(){
		return UUID.randomUUID().toString();
	}
	
	
     
 

}

    


