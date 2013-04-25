package com.lpuente.canine_care;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service{

	//Globale var for the song
	MediaPlayer song;
	
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	//method used to START SERVICE
		@Override
		public int onStartCommand(Intent intent, int flags, int startId)
		{
			
			song = MediaPlayer.create(this, R.raw.music);
			song.start();
			
			//service will continue until told to stop
			return START_STICKY;
		}

		//Method to DESTROY the method
		@Override
		public void onDestroy()
		{
			super.onDestroy();
			
			
			//stop the song
			song.release();
		}
}
