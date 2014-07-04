package android.my_first_app;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{

	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle TravisLoveBacon) {
		// TODO Auto-generated method stub
		super.onCreate(TravisLoveBacon);
		setContentView(R.layout.boston);
		ourSong = MediaPlayer.create(Splash.this, R.raw.music);
		ourSong.start();
		//the framework of a Thread
		Thread timer = new Thread(){
			public void run() {
				//start a new activity via intent
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					Intent openStartingPoint = new Intent("android.my_first_app.MENU");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	
	
	
}
