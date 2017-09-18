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
	
	//������Ϸ״̬
	public static boolean isFail = false;//�Ƿ�ʧ��
	public static boolean isWin = false;//�Ƿ�ʤ��
	public static int level =1;//�ؿ�
	public static int enemyCounts=17;//�з�̹�˴���
	public static int perdestoryEnemyTanks=0;//ÿ�ػ���̹����
	public static int destoryEnemyTanks=0;//�ܻ���̹����
	public static int perScores=0;//ÿ�ص÷�
	public static int allScores=0;//�ܵ÷�
	public static boolean isPause = false;//�Ƿ���ͣ
	public static boolean isHitIron = false;//�Ƿ��ܴ���
	public static boolean isTimer = false;//�Ƿ��ʱ��״̬��
	

	//��ʼ������ֵ
	public static final int up = 1;
	public static final int down = 2;
	public static final int left = 3;
	public static final int right = 4;
	//�̷߳����ʼ��
	public static boolean runU=false;
	public static boolean runD=false;
	public static boolean runL=false;
	public static boolean runR=false;

	
	
	
	
	//��ʼ������λ��
	public static final int homeX =380;
	public static final int homeY =560;
	public static final int homeLongSide=40;
	public static final String homePath  = "images/timg.png";
	
	//��ʼ���ҷ�̹�˳���λ�ú�Ѫ�����ٶ�
	
	public static int myTanklife = 3;
	public static final int myTankInitX = 200;
	public static final int myTankInitY = 550;
	public static int myHp = 30;
	public static final int myTankSpeed = 5;
	//��ʼ���з�̹�˳���λ��
	public static final int enemyTank1X = 0;
	public static final int enemyTank1Y = 0;
	public static final int enemyTank2X = 360;
	public static final int enemyTank2Y = 0;
	public static final int enemyTank3X = 760;
	public static final int enemyTank3Y = 0;

	
	//��ʼ���з�̹���ٶȺ�Ѫ��
	public static final int enemyTank1spd = 2;
	public static final int enemyTank2spd = 3;
	public static final int enemyTank3spd = 4;
	public static final int enemyTank1Hp = 10;
	public static final int enemyTank2Hp = 20;
	public static final int enemyTank3Hp = 30;
	
	
	
	//��ʼ��̹�˴�С
	
	public static final int TankWidth = 40;
	public static final int TankHeight = 40;
	
	
	//�ҷ�̹��ģ��
	public static final String MY = "my";
	//�з�̹��ģ��
	public static final String ENEMY = "enemy";
	public static final String ENEMY2 = "enemy2";
	public static final String ENEMY3 = "enemy3";
	
	//�ӵ�������
	public static final int b_spd = 10;
	public static final int b_width = 5;
	public static final int b_height = 5;
	//�ҷ�̹�˼���
	public static final Map<String, List<String>> Models = new HashMap<String, List<String>>();

	static{//����List����  ��������������ͼƬ���뼯���У��ٽ����ϴ���Map�����У��������� ����Ӧ��ͼƬ��
		List<String> my_tank = new ArrayList<String>();
		my_tank.add("images/e_up.png");
		my_tank.add("images/e_down.png");
		my_tank.add("images/e_left.png");
		my_tank.add("images/e_right.png");
		Models.put(MY, my_tank); 
	//�����ֵз�̹�˵�ͼƬ���������ҵ�˳�� ���δ��뼯���У��ٽ����ϴ���Map������
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
	//��Ϸ��ͼ��ʼ��
	public static Maps maps = new Maps();
	
	
	
	
//	��Ϸ���ݳ�ʼ��
	public static Game initGame(){
		Game game = new Game();
		Tank myTank = new Tank();
		
		myTank.setType(1);
		myTank.setDir(up);//��������
		myTank.setHp(myHp);//Ѫ��
		myTank.setModel(MY);//�ҵ�ģ�� Map��key��ֵ
		myTank.setX(myTankInitX);;//̹�˳�ʼλ��
		myTank.setY(myTankInitY);
		myTank.setSp(myTankSpeed);//�ҷ�̹���ٶ�
		myTank.setOnlyId(getID());
		game.setTank(myTank);//���ҵ�̹�˴���game��Ĺ���
		game.setEnemyTanks(getEnemyTanks());
		
		
		
	  
		
		
		
		
		
		return game;
	}
	
	
    //��ʼ�����з�̹��
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
	
	//����3���з�̹���������
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
		//�������λ�ö��������
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
	
	//����ΨһId
	private static Random random = new Random();
	private static String getID(){
		return UUID.randomUUID().toString();
	}
	
	
     
 

}

    


