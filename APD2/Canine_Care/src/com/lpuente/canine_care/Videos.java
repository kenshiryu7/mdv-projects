package com.lpuente.canine_care;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Videos extends Activity{
	
	private final String TAG = "Videos Activity";
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	       
	        
	        setContentView(R.layout.videos_lay);
	        
	        //Stopping the service/music when opening this activity
	        stopService(new Intent(getBaseContext(), MusicService.class));
	        
	      //locking screen
	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	        
	        
	        //button ids
	        Button care = (Button) findViewById(R.id.button1);
	        Button pill = (Button) findViewById(R.id.button2);
	        Button flea = (Button) findViewById(R.id.button3);
	        Button sx = (Button) findViewById(R.id.button4);

	        
	        
	        care.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent care_youtube = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=vJKKFsyBRS4"));
					
					startActivity(care_youtube);
				}
			});
	        
	        pill.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent pill_youtube = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=oytYLAjo2_0"));
					
					startActivity(pill_youtube);
				}
			});
 
	        flea.setOnClickListener(new OnClickListener() {
		
	        	@Override
	        	public void onClick(View v) {
	        		// TODO Auto-generated method stub
			
	        		Intent flea_youtube = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=xsb_ajb9tto"));
					
					startActivity(flea_youtube);
	        	}
	        });
 
	        sx.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent sx_youtube = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=JNIgGvhrAY0"));
			
			startActivity(sx_youtube);
		}
	});
}

	   
	 //Menu / Action Bar Stuff
		@Override
		public boolean onCreateOptionsMenu(Menu menu){
			getMenuInflater().inflate(R.menu.main_menu, menu);
			return true;
		}
		
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item)
		{
			
			//Add intents to each case statement to switch activity.
			
			switch(item.getItemId())
			{
			
			//intent to List View
			case R.id.item1:
				Log.i(TAG, "item 1 CLICKED");
				
				Intent mainInt = new Intent(Videos.this, Main.class);
				startActivity(mainInt);
				
				
				return true;
				
			//intent to Map
			case R.id.item2:
				Log.i(TAG, "item 2 CLICKED");
				
				Intent mapInt = new Intent(Videos.this, Map_Class.class);
				startActivity(mapInt);
				
				return true;
				
			//intent to Videos
			case R.id.item3:
				Log.i(TAG, "item 3 CLICKED");
				
				//Intent vidInt = new Intent(Videos.this, Videos.class);
				//startActivity(vidInt);
				
				
				return true;
				
			//intent to dev info
			case R.id.item4:
				Log.i(TAG, "item 4 CLICKED");
				
				Intent devInt = new Intent(Videos.this, Dev_Splash.class);
				startActivity(devInt);
				
				return true;
			case R.id.item5:
				Log.i(TAG, "item 5 CLICKED");
				
				Intent mapIn = new Intent(Videos.this, LegalNotices.class);
				
				startActivity(mapIn);
				
				return true;
			case R.id.item6:
				Log.i(TAG, "item 6 CLICKED");
				
				Intent sponsor = new Intent(Videos.this, Sponsors.class);
				
				startActivity(sponsor);
				
				return true;
			case R.id.item7:
				Log.i(TAG, "item 7 CLICKED");
				
				
				
				return true;
				
				default: return super.onOptionsItemSelected(item);
			}
		}
	 
}