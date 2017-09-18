package me.cmlt.tankbattle.Control;

import java.util.Random;

import me.cmlt.tankbattle.Main.Main;
import me.cmlt.tankbattle.Model.Init;
import me.cmlt.tankbattle.View.GameFrame;
import me.cmlt.tankbattle.View.GamePanel;

public class ItemRun implements Runnable{
	
	Main  myMain;
	Random random =new Random();
	public ItemRun(Main mymain){
		this.myMain = mymain;
		
	}

	public void run() {
		
		while(true){
			
			
			//生成道具线程  6代表血包吃了加满血，满血吃奖励一条生命,7为星星吃后能打铁，,8为暂停敌方坦克
			if (!Init.isPause) {
				int ItemTemp = random.nextInt(10);//根据此随机数判断出现的道具
				
				int[][] map = GamePanel.getMap();
				int mapX=random.nextInt(30);//X Y 定义二维数组地图随机出现道具的地方
				int mapY=random.nextInt(40);
				switch (ItemTemp) {
				case 6:						

					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map[i].length; j++) {

							if (map[mapX][mapY]==0) {  //在没障碍物的地方生成道具
								map[mapX][mapY]=6;
							}
						}
					}
				case 7:

					for (int i = 0; i < map.length; i++) {

						for (int j = 0; j < map[i].length; j++) {

							if (map[mapX][mapY]==0) {  
								map[mapX][mapY]=7;
							}
						}
					}
				case  8:
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map[i].length; j++) {
							if (map[mapX][mapY]==0) {
								map[mapX][mapY]=8;
							}
						}
					}
					
					
					
					
					
					break;

				default:
					break;
				}
			}
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		
		
	}

}
