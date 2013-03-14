package com.lpuente.canine_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Map_Class extends Activity {

	private final String TAG = "Map Activity";
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.map_lay);
	        
	        
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
				
				Intent mainInt = new Intent(Map_Class.this, Main.class);
				startActivity(mainInt);
				
				
				return true;
				
			//intent to Map
			case R.id.item2:
				Log.i(TAG, "item 2 CLICKED");
				
				//Intent mapInt = new Intent(Map_Class.this, Map_Class.class);
				//startActivity(mapInt);
				
				return true;
				
			//intent to Videos
			case R.id.item3:
				Log.i(TAG, "item 3 CLICKED");
				
				Intent vidInt = new Intent(Map_Class.this, Videos.class);
				startActivity(vidInt);
				
				
				return true;
				
			//intent to dev info
			case R.id.item4:
				Log.i(TAG, "item 4 CLICKED");
				
				Intent devInt = new Intent(Map_Class.this, Dev_Info.class);
				startActivity(devInt);
				
				return true;
			case R.id.item5:
				Log.i(TAG, "item 5 CLICKED");
				
				
				
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