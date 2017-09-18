package me.cmlt.tankbattle.View;



import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;










import javax.swing.JFrame;




import javax.swing.JOptionPane;

import me.cmlt.tankbattle.Main.Main;
import me.cmlt.tankbattle.Model.Music;


public class GameFrame extends JFrame{
	
	private GamePanel panel;
	private GamePanelRight panelRight;
	private GameJmenuBar menuBar;
	private Main main1;
	private Music music;
    
	

	public GameFrame(Main mymain) {
		this.main1=mymain;
		
		this.setTitle("坦克大战");
		menuBar = new GameJmenuBar(this);
		this.add(menuBar,BorderLayout.NORTH);

		panel = new GamePanel();
		panelRight = new GamePanelRight(this);
	    music = new Music();
	    music.playStartMusic();
	    
	 
	     

		this.add(panel);
		this.add(panelRight,BorderLayout.EAST);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
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

   
	public Music getMusic() {
		return music;
	}


	public void setMusic(Music music) {
		this.music = music;
	}


	public GamePanelRight getPanelRight() {
		return panelRight;
	}


	public void setPanelRight(GamePanelRight panelRight) {
		this.panelRight = panelRight;
	}


	public Main getMain1() {
		return main1;
	}


	public void setMain1(Main main1) {
		this.main1 = main1;
	}


	public GamePanel getPanel() {
		return panel;
	}


	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}
	

	
    
}
