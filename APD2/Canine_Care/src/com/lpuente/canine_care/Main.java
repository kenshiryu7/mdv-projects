package com.lpuente.canine_care;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends Activity {
	
	private final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_lay);
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
		case R.id.item1:
			
			Log.i(TAG, "item 1 CLICKED");
			
			
			
			
			return true;
		case R.id.item2:
			Log.i(TAG, "item 2 CLICKED");
			
			
			
			return true;
		case R.id.item3:
			Log.i(TAG, "item 3 CLICKED");
			
			
			
			
			return true;
		case R.id.item4:
			Log.i(TAG, "item 4 CLICKED");
			
			
			
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
