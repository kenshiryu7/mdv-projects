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

public class Dev_Info extends Activity {

	private final String TAG = "Dev_Info Activity";
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.dev_info_lay);
	        
	  
	      //once again locking the screen in portrait. Eh, makes things a bit
	        //easier to see and sort through.
	          
	          setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	          
	          
	          //button
	          Button webButt = (Button) findViewById(R.id.web);
	          
	          webButt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent web_site = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aspca.org/pet-care/ask-the-expert/ask-the-expert-poison-control/people-foods.aspx"));
					
					startActivity(web_site);
					
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
					
					Intent mainInt = new Intent(Dev_Info.this, Main.class);
					startActivity(mainInt);
					
					
					return true;
					
				//intent to Map
				case R.id.item2:
					Log.i(TAG, "item 2 CLICKED");
					
					Intent mapInt = new Intent(Dev_Info.this, Map_Class.class);
					startActivity(mapInt);
					
					return true;
					
				//intent to Videos
				case R.id.item3:
					Log.i(TAG, "item 3 CLICKED");
					
					Intent vidInt = new Intent(Dev_Info.this, Videos.class);
					startActivity(vidInt);
					
					
					return true;
					
				//intent to dev info
				case R.id.item4:
					Log.i(TAG, "item 4 CLICKED");
					
					//Intent devInt = new Intent(Dev_Info.this, Dev_Info.class);
					//startActivity(devInt);
					
					return true;
				case R.id.item5:
					Log.i(TAG, "item 5 CLICKED");
					
					Intent mapIn = new Intent(Dev_Info.this, LegalNotices.class);
					
					startActivity(mapIn);
					
					return true;
				case R.id.item6:
					Log.i(TAG, "item 6 CLICKED");
					
					
					
					return true;
				case R.id.item7:
					Log.i(TAG, "item 7 CLICKED");
					
					
					
					return true;
					
					default: return super.onOptionsItemSelected(item);
				}
			}
		 
}