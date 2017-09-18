package me.cmlt.tankbattle.Model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Music {
	//”Œœ∑ø™ º“Ù¿÷
	AudioClip startMusic;
	File startMusicUrl=new File("Music/start.wav");

	//ø™ª“Ù¿÷
	AudioClip fireMusic;
	File fireMusicUrl=new File("Music/fire.wav");
	
	//ª˜ªŸ“Ù¿÷
	AudioClip blastMusic;
	File blastMusicUrl=new File("Music/blast.wav");
	
	//”Œœ∑ ß∞‹“Ù¿÷
	AudioClip overMusic;
	File overMusicUrl=new File("Music/over.wav");
	
	//”Œœ∑ §¿˚“Ù¿÷
	AudioClip winMusic;
	File winMusicUrl=new File("Music/win.wav");
	
	//ÃÌº”“Ù¿÷
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
