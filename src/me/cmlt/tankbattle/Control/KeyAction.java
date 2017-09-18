package me.cmlt.tankbattle.Control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.rmi.CORBA.Util;

import me.cmlt.tankbattle.Main.Main;
import me.cmlt.tankbattle.Model.Game;
import me.cmlt.tankbattle.Model.Init;
import me.cmlt.tankbattle.Model.Tank;
import me.cmlt.tankbattle.View.GameFrame;
import me.cmlt.tankbattle.View.GamePanel;

public class KeyAction extends KeyAdapter{
	private Main mymain;
	public  KeyAction(Main mymain) {
		this.mymain=mymain;
	}
	
	
	
	//我方坦克按键控制方向
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		Tank tank = mymain.getFrame().getPanel().getGame().getTank();
		
		boolean isTurn = true;
		
		switch (e.getKeyCode()) {
		
	
		
		
		case KeyEvent.VK_W:
			if (!Init.isPause) {
				isTurn=tank.turn(Init.up);
				Init.runU=true;
				break;
			}

		case KeyEvent.VK_S:
			if (!Init.isPause) {
				isTurn=tank.turn(Init.down);
                Init.runD=true;
                break;
			}
			
		case KeyEvent.VK_A:
            if (!Init.isPause) {
			isTurn=tank.turn(Init.left);
            Init.runL=true;
            break;
	
			}
           
		case KeyEvent.VK_D:
            if (!Init.isPause) {
					isTurn=tank.turn(Init.right);
			Init.runR=true;
			break;
			}
	        		
			//暂停
		case KeyEvent.VK_P:
			
			Init.isPause = true;
			break;
			//继续
		case KeyEvent.VK_R:
			Init.isPause=false;
			break;

		
		
		}
		
		

	
	}
	

	
	
	
	
	
	  //创建子弹，和我方移动线程调整
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
		Tank tank = mymain.getFrame().getPanel().getGame().getTank();
		if(!Init.isPause){
		switch (e.getKeyCode()) {
		//放下J键创建子弹
		case KeyEvent.VK_J:
			
			tank.createMissile(false);
			mymain.getFrame().getMusic().playFireMusic();
			break;
		case KeyEvent.VK_W:
			Init.runU=false;
			break;
		
		case KeyEvent.VK_S:
		
			Init.runD=false;
			break;
			
		case KeyEvent.VK_A:
			
			Init.runL=false;
			break;
			
		case KeyEvent.VK_D:
		
			Init.runR=false;
			
			break;
			
			
		}
		
	}}
	
	
	
}


