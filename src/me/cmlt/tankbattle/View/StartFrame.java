package me.cmlt.tankbattle.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class StartFrame extends JFrame{
	
	StartPanel startPanel;
	
	public StartFrame(){
		this.setTitle("坦克大战");
		startPanel = new StartPanel(this);
		this.add(startPanel);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
		
//		退出确认
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				int opion = JOptionPane.showConfirmDialog(null, "真的要退出吗？");
				if (opion==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
				
				
				
			}
		});
		
	}

	public static void main(String[] args) {
		new StartFrame();
	}
}
