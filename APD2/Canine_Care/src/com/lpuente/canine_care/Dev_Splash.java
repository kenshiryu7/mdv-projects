package com.lpuente.canine_care;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Dev_Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_lay);
		
		//keep portrait
		 
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        startService(new Intent(getBaseContext(), MusicService.class));
		
		//making thread for Splash screen. Searched the internet for best way. Seems this isnt the best way yet the only solid
		//example I could find used threads so I will keep this until i find a better way
		
		//Thread sets up similar to method
		Thread logoTime = new Thread(){
			
			//run method for thread
			public void run(){
				
				//try catch for thread incase any other thread running
				try
				{
					sleep(1000 * 5); //multiply by 1000. Easier to see how many secs
					
					//intent to move to dev info
					Intent dev_intent = new Intent(Dev_Splash.this, Dev_Info.class);
					startActivity(dev_intent);
				}
				//in case of interrupted Thread
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					finish();  //finish running
				}
			}
		};
		//Starts
		logoTime.start();
		
	}

}
