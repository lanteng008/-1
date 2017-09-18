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
				Vector<Tank> Etanks = game.getEnemyTanks();//��ȡ�ط�̹�˼���
				
//				if (tanks==null ||tanks.size()==0) {
//					continue;
//				}
				//����Ļ��̹��С��3ֻʱ�Զ�����
				if (Etanks.size()<3) {  //��������̹��ʱ������
					if (Init.enemyCounts>0) {//��ʣ��̹��������ʱ��Ų���
						Etanks.add(Init.getEnemyTank(mymain.getFrame().getPanel().getGame().getTank().isBorn(game)));
						mymain.getFrame().getMusic().playBlastMusic();
						Init.enemyCounts--;
					}
					
					
				}
				 if (Etanks.size()==0 &&Init.level<5&&Init.enemyCounts==0 &&Init.enemyCounts==0) {//�����ڵз��������
					//��������
					
					 
					 
					 if (Init.level==4) {//������Ĺ�ʤ��
							Init.isWin=true;
							
					         continue;	
						}
					 Init.level++;//�ؿ�����

					 //ɾ���ҷ�������ӵ�
					 Vector<Missile> buttles = game.getTank().getBullets();
					 for (int i = 0; i < buttles.size(); i++) {
						   buttles.remove(i);
					}
					//���ó�ʼ�����з�̹��
					game.setEnemyTanks(Init.getEnemyTanks());
					//���õо�̹�˴���
					 Init.enemyCounts=17;
					 //���õ�ǰ�ؿ��÷�,��ǰ�ؿ�����̹������
					 Init.perScores=0;
					 Init.perdestoryEnemyTanks=0;
					 //����Map������ݵ�ǰ�ؿ��л���ͼ����
					 GamePanel.setMap(new Maps().changeMap());
					 Tank myTank = game.getTank();
					 myTank.setDir(Init.up);
					 myTank.setX(Init.myTankInitX);
					 myTank.setY(Init.myTankInitY);
					
					 
					 
					 
					}	
				 if (Init.isTimer!=true) {//����ʱ������ʱ����ͣ�з��ƶ��������ﵽ��ֹ�з��˶�Ч��
					
					 for (int i = 0; i <Etanks.size(); i++) {
						 Tank tank = Etanks.get(i);
						 
						 int temp  = random.nextInt(30);
						 if (temp==1&&!Init.isTimer) {
							 tank.turn(random.nextInt(4)+1);    //�з�̹�˷Ƕ�ʱ״̬���ת��
						 }else {
							 if (!tank.collideBorder()&&!tank.collideObj(game)&&!Init.isTimer ) {//�з�δ�����ϰ���Ƕ�ʱ״̬�ƶ�
								 tank.move();
							 }else if(!Init.isTimer){
								 int dir = random.nextInt(4)+1;   //�з�̹����ײת��
								 tank.setDir(dir);
								 
								 
							 }
						 }
						 
						 //�з��Ƕ�ʱ״̬��������ӵ�
						 int temp2 =random.nextInt(30);
						 if (temp2==2) {
							 tank.createMissile(true);
						 }
					 }
				}
			}
	        
			Game game = mymain.getFrame().getPanel().getGame();//��ͣʱ�ҷ�̹�˲���Ӱ�� 
			Tank runTank = game.getTank();//��ȡ�ҷ�̹��
				 //�ҷ�̹���ƶ��߳�
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
