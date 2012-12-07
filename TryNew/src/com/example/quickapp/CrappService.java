package com.example.quickapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class CrappService extends Service {

	MediaPlayer song;
	
	//auto generated on bind. Binds activity to service. Yippy
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//method used to START SERVICE
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		
		//Using a toast just to say the silly thing started
		Toast.makeText(this, "The Service Started!!! Yeah!!", Toast.LENGTH_LONG).show();
		
		song = MediaPlayer.create(this, R.raw.mxpx);
		song.start();
		
		//service will continue until told to stop
		return START_STICKY;
	}

	//Method to DESTROY the method
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		
		//using toast to say the service has been destroyed
		Toast.makeText(this, "The Service Has Been CRUSHED!!!", Toast.LENGTH_LONG).show();
		
		song.release();
	}
}
