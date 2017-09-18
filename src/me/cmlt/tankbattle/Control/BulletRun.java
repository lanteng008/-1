package me.cmlt.tankbattle.Control;

import java.util.Vector;

import me.cmlt.tankbattle.Main.Main;
import me.cmlt.tankbattle.Model.Game;
import me.cmlt.tankbattle.Model.Init;
import me.cmlt.tankbattle.Model.Missile;
import me.cmlt.tankbattle.Model.Tank;

public class BulletRun implements Runnable{

	private Main mymMain;
	
	
	public BulletRun(Main mymMain) {
		super();
		this.mymMain = mymMain;
	}


	@Override
	public void run() {
		while(true){
			Game game =mymMain.getFrame().getPanel().getGame();
			//敌方子弹移动线程
			Vector<Tank> tanks = game.getEnemyTanks();
			
			if(!Init.isPause){
			for (int i = 0; i < tanks.size(); i++) {
				Vector<Missile> buttles =tanks.get(i).getBullets();
				if (buttles==null) {
					continue;
				}
				
				for (int j = buttles.size()-1; j >=0; j--) {
					Missile b = buttles.get(j);
					if (!b.collideBorder()&&!b.collideObj(game)) {
						b.move();
					}
				    else {
				    	buttles.remove(j);
//						System.err.println("敌方子弹删除");
						
					}
					
				}
				
			}
			
			
			
			
			//我方子弹移动线程
			Vector<Missile> mybullet = game.getTank().getBullets();			
			if (mybullet!=null) {
				
				for (int j= mybullet.size()-1;j>=0;j--) {
				      Missile b = mybullet.get(j);
				      if (b!=null &&!b.collideBorder()&&!b.collideObj(game)) {
						b.move();
						
					}else {
//						System.out.println("子弹删除");
						mybullet.remove(j);
						
					}
				}
				
			}
			}
			mymMain.getFrame().getPanel().repaint();
		
			try {
				Thread.sleep(30);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			 
			
		}
	}
	

}
