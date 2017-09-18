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
			
			
			//���ɵ����߳�  6����Ѫ�����˼���Ѫ����Ѫ�Խ���һ������,7Ϊ���ǳԺ��ܴ�����,8Ϊ��ͣ�з�̹��
			if (!Init.isPause) {
				int ItemTemp = random.nextInt(10);//���ݴ�������жϳ��ֵĵ���
				
				int[][] map = GamePanel.getMap();
				int mapX=random.nextInt(30);//X Y �����ά�����ͼ������ֵ��ߵĵط�
				int mapY=random.nextInt(40);
				switch (ItemTemp) {
				case 6:						

					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map[i].length; j++) {

							if (map[mapX][mapY]==0) {  //��û�ϰ���ĵط����ɵ���
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
