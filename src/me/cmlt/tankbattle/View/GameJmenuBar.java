package me.cmlt.tankbattle.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;
import javax.swing.plaf.RootPaneUI;

import me.cmlt.tankbattle.Main.Main;
import me.cmlt.tankbattle.Model.Init;
import me.cmlt.tankbattle.Model.Maps;

public class GameJmenuBar extends JMenuBar{
	
	GameFrame frame;
	
	public GameJmenuBar(GameFrame gameFrame){
		this.frame = gameFrame;
		
		   //���˵������
		    JMenu game = new JMenu("��Ϸ");
			JMenu help = new JMenu("����");
			JMenu choce = new JMenu("ѡ��ؿ�");
			
			this.add(game);
			this.add(choce);
			this.add(help);
			
			//��Ϸ�˵����  Item
			JMenuItem reStart = new JMenuItem("���¿�ʼ");
			JMenuItem exit = new JMenuItem("�˳���Ϸ");
			
			game.add(reStart);
		    game.add(exit);
		    
			
			//�����˵����Item
			JMenuItem gameText = new JMenuItem("��Ϸ˵��");
			help.add(gameText);
			
			
			//ѡ��ؿ����Item
			JMenuItem choce2 = new JMenuItem("�ڶ���");
			JMenuItem choce3 = new JMenuItem("������");
			JMenuItem choce4 = new JMenuItem("���Ĺ�");
		    
		    choce.add(choce2);
		    choce.add(choce3);
		    choce.add(choce4);
		    

//��ʼ����¼�
		    
			//������¿�ʼItem����
		    reStart.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					
					   GamePanel.map=new Maps().getMap1();
					   Init.level=1;
					   Init.isPause=false;
					   Init.isFail=false;
					   Init.isWin=false;
					   Init.perdestoryEnemyTanks=0;
					   Init.destoryEnemyTanks=0;
					   Init.perScores=0;
					   Init.allScores=0;
					   Init.enemyCounts=17;
					   Init.myTanklife=3;
					  frame.getPanel().setGame(Init.initGame());
				}
			});
			
		    //����˳���ϷItem����
		    exit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
		    
		    //�����Ϸ˵��Item����
		    gameText.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					String message = "��ӭ����̹�˴�ս\n"
							+ "����������ʽ ���Ҳ���壬���ڵ���������ֵ-10\n"
							+ "�ҷ�����ֵΪ30����ʼ��������̹��\n"
							+ "��Ϸ�������ֵз�̹��-��ɫ����ɫ����ɫ\n"
							+ "��ɫ̹���ٶ�Ϊ2������ֵΪ10���÷�Ϊ10\n"
							+ "��ɫɫ̹���ٶ�Ϊ3������ֵΪ20���÷�Ϊ20\n"
							+ "��ɫ̹���ٶ�Ϊ4������ֵΪ30���÷�Ϊ30\n"
							+ "��Ϸһ�����Ĺأ�ÿ�ػ��ܵз�20��̹�˼��ɹ���\n"
							+ "���ҷ�̹�����������꣬���ҷ����ر�����ʱ��Ϸʧ��\n"
							+ "��Ϸ��ͼ�л�������ֵ�����ǿ�ҷ�����������������\n"
							+ "Ѫ�����˻���Ѫ������Ѫʱ�Ե�������һ��̹��\n"
							+ "���ǳ��˺��ǿ�ӵ������Դ������\n"
							+ "���ף����Ϸ���";
					JOptionPane.showMessageDialog(null, message);
					
				}
			});
			
			
			//���ѡ��ؿ�Item����
			//ѡ��ڶ���
		    choce2.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					   GamePanel.map=new Maps().getMap2();
					   Init.level=2;
					   Init.isPause=false;
					   Init.isFail=false;
					   Init.isWin=false;
					   Init.perdestoryEnemyTanks=0;
					   Init.destoryEnemyTanks=0;
					   Init.perScores=0;
					   Init.allScores=0;
					   Init.enemyCounts=17;
					   Init.myTanklife=3;
					  frame.getPanel().setGame(Init.initGame());
					
				}
			});
		    
		    //ѡ�������
		    choce3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					   GamePanel.map=new Maps().getMap3();
					   Init.level=3;
					   Init.isPause=false;
					   Init.isFail=false;
					   Init.isWin=false;
					   Init.perdestoryEnemyTanks=0;
					   Init.destoryEnemyTanks=0;
					   Init.perScores=0;
					   Init.allScores=0;
					   Init.enemyCounts=17;
					   Init.myTanklife=3;
					  frame.getPanel().setGame(Init.initGame());
					
				}
			});
		    
		    //ѡ����Ĺ�
		    choce4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					   GamePanel.map=new Maps().getMap4();
					   Init.level=4;
					   Init.isPause=false;
					   Init.isFail=false;
					   Init.isWin=false;
					   Init.perdestoryEnemyTanks=0;
					   Init.destoryEnemyTanks=0;
					   Init.perScores=0;
					   Init.allScores=0;
					   Init.enemyCounts=17;
					   Init.myTanklife=3;
					  frame.getPanel().setGame(Init.initGame());
					
				}
			});
		
			
	 }

}
