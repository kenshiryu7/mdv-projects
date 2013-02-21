package com.lpuente.project_3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class AudioVideo extends Activity{
	
	//Global Vars audio
		String playButtonText;
		MediaPlayer mP;
		Button playButt;
		
		//Glob. Vars for video
		String vidText;
		VideoView vw;
		
		
		private final String TAG = "AudioVideo Activity";
		
		//seen this done various times. I'll just go with it
		Context _this;
		
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.audiovideo_lay);
		
		 //im sure theres a better way around the audio issues when changing from port to land. but locking it is ok for now
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        //Setting Context
        _this = this;	
		
		
		
		 //Setting Media Player song
        mP = MediaPlayer.create(AudioVideo.this, R.raw.mxpx);
        
        
        //Setting play button
        
        playButt = (Button) findViewById(R.id.playB);
        
        //beginning with Play for the button text setting before onClickListener
        playButtonText = " Play ";
        
        
        
        
        //Start and Pause using the same button. As well as changing the text as user interacts
        
        playButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//using conditional to start or pause song
				
				if(playButtonText.equals(" Play "))
				{
					//starts song
					mP.start();
					
					//text will change to "Pause"
					playButtonText = "Pause";
					//setting text
					playButt.setText(playButtonText);
				}
				else
				{
					//same idea here as above except in reverse and pausing the mP. easy to do this since there are
					//only two options of play and pause
					mP.pause();
					playButtonText = " Play ";
					playButt.setText(playButtonText);
				}
				
			}
		});
        
        //set the play button text to the String to determine whether text is Play or Pause
        playButt.setText(playButtonText);
        
       
		////////////////Code for Video//////////////Similar to audio above////////////////
        
        Button vidButt = (Button) findViewById(R.id.playVid);
        
        //video button listener
        vw = (VideoView) findViewById(R.id.vidview);
        
        vidButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				//Set to play the video
				
				//vw = (VideoView) findViewById(R.id.vidview);
				
				
				//using a URI for video path for raw folder/file path
				
				String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.doing_time;
				
				//collecting path then parsing string to uri
				vw.setVideoURI(Uri.parse(uriPath));
				
				//setting media controller to context _this
				vw.setMediaController(new MediaController(_this));
				
				
				//starting video
				vw.start();
				
			}
		});
}




@Override
public boolean onCreateOptionsMenu(Menu menu){
	getMenuInflater().inflate(R.menu.main_menu, menu);
	return true;
}


@Override
public boolean onOptionsItemSelected(MenuItem item)
{
	switch(item.getItemId())
	{
	case R.id.item1:
		Log.i(TAG, "item 1 CLICKED");
		
		Intent audioInt = new Intent(AudioVideo.this, AudioVideo.class);
		startActivity(audioInt);
		
		
		return true;
	case R.id.item2:
		Log.i(TAG, "item 2 CLICKED");
		
		Intent gpsInt = new Intent(AudioVideo.this, GPS.class);
		startActivity(gpsInt);
		
		
		return true;
	case R.id.item3:
		Log.i(TAG, "item 3 CLICKED");
		
		Intent acellInt = new Intent(AudioVideo.this, Acellerom.class);
		startActivity(acellInt);
		
		
		return true;
	case R.id.item4:
		Log.i(TAG, "item 4 CLICKED");
		
		Intent ointent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com/design/patterns/actionbar.html"));
		
		startActivity(ointent1);
		
		return true;
	case R.id.item5:
		Log.i(TAG, "item 5 CLICKED");
		
		Intent ointent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fullsail.com"));
		
		startActivity(ointent2);
		
		return true;
	case R.id.item6:
		Log.i(TAG, "item 6 CLICKED");
		
		Intent ointent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.com"));
		
		startActivity(ointent3);
		
		return true;
	case R.id.item7:
		Log.i(TAG, "item 7 CLICKED");
		
		Intent ointent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
		
		startActivity(ointent4);
		
		return true;
		
		
		default: return super.onOptionsItemSelected(item);
	}
}
}
