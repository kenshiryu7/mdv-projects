package com.lpuente.project_2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	
	//Really enjoyed the video for media will use as example as well as example from
	//previous project using audio mp
	
	//Global Vars
	String playButtonText;
	MediaPlayer mP;
	Button playButt;
	
	//seen this done various times. I'll just go with it
	Context _this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_lay);
        
        //Setting Context
        _this = this;	
        
       
        //Setting Media Player song
        mP = MediaPlayer.create(Main.this, R.raw.mxpx);
        
        
        //Setting play button
        
        playButt = (Button) findViewById(R.id.playB);
        
        //beginning with Play for the button text setting before onClickListener
        playButtonText = "Play";
        
        
        
        
        //Start and Pause using the same button. As well as changing the text as user interacts
        
        playButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//using conditional to start or pause song
				
				if(playButtonText.equals("Play"))
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
					playButtonText = "Play";
					playButt.setText(playButtonText);
				}
				
			}
		});
        
        //set the play button text to the String to determine whether text is Play or Pause
        playButt.setText(playButtonText);
        
        
    }

    
    
    
    
    
 ////////////////////////////////////////////////////////   
    //Unused
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_lay, menu);
        return true;
    }
}
