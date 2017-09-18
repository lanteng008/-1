package me.cmlt.tankbattle.Main;

import me.cmlt.tankbattle.Control.BulletRun;
import me.cmlt.tankbattle.Control.ItemRun;
import me.cmlt.tankbattle.Control.TankRun;
import me.cmlt.tankbattle.Control.KeyAction;
import me.cmlt.tankbattle.Model.Missile;
import me.cmlt.tankbattle.Model.Tank;
import me.cmlt.tankbattle.View.GameFrame;

public class Main {
	
	
   private GameFrame frame;
   private KeyAction keyAction;//键盘监听
   private BulletRun bulletRun;//子弹线程
   private TankRun tankRun;//坦克线程
   private ItemRun itemRun;//道具线程
   
   public Main(){
			
		frame = new GameFrame(this);
	    keyAction  = new KeyAction(this);
	    frame.addKeyListener(keyAction);
	    
	   bulletRun = new BulletRun(this);
	   tankRun = new TankRun(this);
	   itemRun = new ItemRun(this);
	   Thread t1=new Thread(bulletRun);
	    t1.start();//启动子弹线程
	   Thread t2 =new Thread(tankRun);
	    t2.start();//启动坦克线程
	    Thread t3 = new Thread(itemRun);
	    t3.start();//启动道具线程
	   
		
		
	}
	
	

//	public static void main(String[] args) {
//		
//		
//		new Main();
//		
//	}

	public GameFrame getFrame() {
		return frame;
	}

	public void setFrame(GameFrame frame) {
		this.frame = frame;
	}

	public KeyAction getKeyAction() {
		return keyAction;
	}

	public void setKeyAction(KeyAction keyAction) {
		this.keyAction = keyAction;
	}

}
