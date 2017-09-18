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
	private int dir;//����
	private int bx;//����
	private int by;
	private int spd;//�ٶ�
	private String model;//ģ��
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
	//�ӵ���ײ�߽��ж�
	public boolean collideBorder() {
		// TODO Auto-generated method stub

		int x = this.bx;
		int y = this.by;
	
		
		
		if (x>800||x<0||y>600||y<0) {
			return true;
			
		}
		return false;
	
		
		
		
		
	}


    //�ӵ���ײ����/̹���ж�
	@Override
	public boolean collideObj(Game game) {
		//��ȡ��ͼ���ӵ���ײ���
		Rectangle bRectangle  = new Rectangle(this.bx, this.by, Init.b_width, Init.b_height);
//		System.out.println("��ǰ�ӵ���"+this.bx+":"+this.by);
		//�ҷ��ӵ���ײ�з�̹�˽��
		Vector<Tank> enTanks = game.getEnemyTanks();//��ȡ�з�̹�˼���
		
		
		for (int i=enTanks.size()-1; i >=0; i--) {
			Tank enTank = enTanks.get(i);
			//���ӵ����Ժ�̹�����Բ�ͬʱ��
			if (enTank.getType()!=(this.type) ) {
				Rectangle entankRectangle = new Rectangle(enTank.getX(), enTank.getY(), Init.TankWidth, Init.TankHeight);
				//�ж��ҷ��ӵ��͵з�̹����ײ����Ƿ��ཻ����ײ���ķ���
				if (bRectangle.intersects(entankRectangle)) {
					     //����һ�ε�Ѫһ�Σ�����ֵΪ0ʱ��ɾ���з�̹��
					    enTank.setHp(enTank.getHp()-10);
						if (enTank.getHp()==0) {
							enTanks.remove(i);
							Init.destoryEnemyTanks++;
							Init.perdestoryEnemyTanks++;
							//���ݻ���̹�˵����ͼӷ�
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
		
		//�з��ӵ������ҷ�
		Tank myTank = game.getTank();//��ȡ�ҷ�̹��
		//��ȡ�ҷ�̹����ײ���
		Rectangle mytankRectangle = new Rectangle(myTank.getX(), myTank.getY(), Init.TankWidth, Init.TankHeight);
		if (myTank.getType()!=this.type) {
			 if (bRectangle.intersects(mytankRectangle)) {//�ҷ��ܵ�������
				 myTank.setHp(myTank.getHp()-10);
					
					if (myTank.getHp()==0) {//����ֵΪ0ʱlife-1�����³����������ҷ�̹�˻ص���ʼλ��,��ʼ��״̬Ϊ���ܴ���
						
						Init.myTanklife--;
						Init.isHitIron=false;
						myTank.setHp(Init.myHp);
						myTank.setX(Init.myTankInitX);
						myTank.setY(Init.myTankInitY);
						if (Init.myTanklife==0) {//����������ʱ����Ϸʧ��
							Init.isFail=true;
							
							music.playOverMusic();
						}
						
					}
					return true;
				}
		}
	    
		//�ӵ����ӵ�����ײ
		
		
		

		
	
		//�ж��ӵ����ǽ��
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
				
				else if (map[i][j]==3 &&this.type==1&&Init.isHitIron==true) {//�жϴ�������
					Rectangle iron = new Rectangle(j*20, i*20, 20, 20);
					if (bRectangle.intersects(iron)) {
						//�ӵ������
						map[i][j]=0;
						return true;
					}
				}
				else if (map[i][j]==3) {
					Rectangle iron = new Rectangle(j*20, i*20, 20, 20);
					if (bRectangle.intersects(iron)) {
						//�ӵ������
						
						return true;
					}
					
				}
				
				else if (map[i][j]==5) {
					Rectangle home  = new Rectangle(j*20,i*20,40,40);
					//�ӵ��������ʱ����Ϸʧ��
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
