package me.cmlt.tankbattle.Model;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;





import me.cmlt.tankbattle.View.GamePanel;

import org.omg.CORBA.PUBLIC_MEMBER;


//̹����
public class Tank implements Move,Collide{
	
	//̹������
	private int type;
	//̹�˷���
	private int dir;
	//̹�˺�����
	private int X;
	//̹��������
	private int Y;
    //̹���ƶ��ٶ�
	private int sp;
	//̹������ֵ
	private int hp;
	//̹��ģ��
	private String model;
	//̹���ӵ�
	private Vector<Missile> bullets;
	//Ψһ̹�˱�ʶ
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

	//̹���ƶ�����

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
	//̹����ײ�߽��ж�
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
	
	

    //̹����ײ�ϰ����ж�
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
		
		
		Rectangle rectangle = new Rectangle(x, y, Init.TankWidth, Init.TankHeight);//��ǰ̹��
		Vector<Tank> entanks = game.getEnemyTanks();
		
	Tank myTank = game.getTank();
		Rectangle mytankRectangle = new Rectangle(myTank.getX(), myTank.getY(), Init.TankWidth, Init.TankHeight);//�ҷ�̹����ײ���
		for (int i = entanks.size()-1; i >=0; i--) {//���ڵз���ײ���bug������δ�ܽ����ȡ���з�̹��֮�䲻����ײ����
			Tank tankTemp = entanks.get(i);
			Rectangle etemp = new Rectangle(tankTemp.getX(), tankTemp.getY(), Init.TankWidth, Init.TankHeight);
			if (tankTemp.getType()!=(this.getType())) {  //�ҷ��з���ײ
				if (rectangle.intersects(etemp)) {
					return true;
				}
			}
		}

//		�з�̹����ײ�ҷ�
	
		if (myTank.getType()!=this.type) {
			if (rectangle.intersects(mytankRectangle)) {
				return true;
			}
		}
		
//�ҷ�̹����ײ�з�
		
		
	
		
		
//		̹��ײǽ�жϣ�������ͼ�������ϰ�����ײ���
		//1Ϊǽ 2Ϊˮ 3Ϊ�� 4Ϊ�� 5Ϊ����
		int[][] map = GamePanel.getMap();
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j]==1||map[i][j]==2||map[i][j]==3) {//�ж�̹�˲���ֱ�Ӵ������ϰ��� 1ǽ 2ˮ 3�� 5����
							Rectangle noCrossObj = new Rectangle(j*20, i*20, 20, 20);
							if (rectangle.intersects(noCrossObj)) {
								
								return true;
								}
							
							
								
							
								
							}
						else if (map[i][j]==5) {//���ܴ�������
							Rectangle noCrossHome = new Rectangle(j*20, i*20, 40, 40);
							if (rectangle.intersects(noCrossHome)) {
								return true;
							}
							
						}
						
						//��ʼ�ж��ҷ�̹�˳Ե��� 6ΪѪ��  7Ϊ���� 8Ϊ��ʱ��
						else if (map[i][j]==6) {
							Rectangle lifeItem = new  Rectangle(j*20, i*20,20,20);
							    //ֻ���ҷ��ܳ� 
							    if (this.type==1) {
							    	
							    	if (rectangle.intersects(lifeItem)) {
							    		//�ж�����ҷ�̹�˳Ե�ʱ��Ѫ�������Ѫ�����Ե�ʱΪ��Ѫ�����һ����
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
							//ֻ���ҷ��ܳ�
							    if (this.type==1) {
							    	if (rectangle.intersects(starItem)) {
							    	      Init.isHitIron=true;//�ܴ���
							    		map[i][j]=0;	
									}
								}
								
								
								
							
							
						}
						else if (map[i][j]==8) {
							Rectangle timer = new Rectangle(j*20, i*20, 20, 20);
							 if (this.type==1) {
							if (rectangle.intersects(timer)) {//�Զ�ʱ��
								map[i][j]=0;
								Init.isTimer=true;
								
								
								//��ͣ������ָ�
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
	
	
	//̹�˷����ӵ�
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
	
	//�жϳ���λ���Ƿ���̹�� 
	public  int isBorn(Game game){
		
		int x1 = this.X;
		int y1 = this.Y;
		
		
		
		
		
		Rectangle a = new Rectangle(Init.enemyTank1X, Init.enemyTank1Y, 40, 40);
		Rectangle b = new Rectangle(Init.enemyTank2X, Init.enemyTank2Y, 40, 40);
		Rectangle c = new Rectangle(Init.enemyTank3X, Init.enemyTank3Y, 40, 40);
		Rectangle rectangle1 = new Rectangle(x1, y1, Init.TankWidth, Init.TankHeight);
		//���ݳ���λ���Ƿ����ҷ�̹�˵������ѡ������ص㣬����ֵ1��2��3��0�ֱ����ͬ�ĵص�
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
	

      
	
	
	
	
	


