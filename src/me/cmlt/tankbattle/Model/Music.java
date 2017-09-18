package me.cmlt.tankbattle.Model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Music {
	//��Ϸ��ʼ����
	AudioClip startMusic;
	File startMusicUrl=new File("Music/start.wav");

	//��������
	AudioClip fireMusic;
	File fireMusicUrl=new File("Music/fire.wav");
	
	//��������
	AudioClip blastMusic;
	File blastMusicUrl=new File("Music/blast.wav");
	
	//��Ϸʧ������
	AudioClip overMusic;
	File overMusicUrl=new File("Music/over.wav");
	
	//��Ϸʤ������
	AudioClip winMusic;
	File winMusicUrl=new File("Music/win.wav");
	
	//�������
	AudioClip addMusic;
	File addMusicUrl=new File("Music/add.wav");
	
	public Music(){
		
		try {
			startMusic=Applet.newAudioClip(startMusicUrl.toURL());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			
			fireMusic=Applet.newAudioClip(fireMusicUrl.toURL());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
          try {
			
			blastMusic=Applet.newAudioClip(blastMusicUrl.toURL());
		} catch (Exception e) {
			// TODO: handle exception
		}
          
          try {
  			
  			overMusic=Applet.newAudioClip(overMusicUrl.toURL());
  		} catch (Exception e) {
  			// TODO: handle exception
  		}
          
          try {
    			
    			winMusic=Applet.newAudioClip(winMusicUrl.toURL());
    		} catch (Exception e) {
    			// TODO: handle exception
    		}
          
          try {
  			
  			addMusic=Applet.newAudioClip(addMusicUrl.toURL());
  		} catch (Exception e) {
  			// TODO: handle exception
  		}
	}
	
	public void playStartMusic(){
		startMusic.play();
	}
	
	public void playFireMusic(){
		fireMusic.play();
	}
	public void playBlastMusic(){
		blastMusic.play();
	}
	public void playOverMusic(){
		overMusic.play();
	}
	public void playWinMusic(){
		winMusic.play();
	}
	public void playAddMusic(){
		addMusic.play();
	}
	
}
