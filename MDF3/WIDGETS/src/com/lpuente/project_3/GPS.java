package com.lpuente.project_3;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
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
import android.widget.Toast;

public class GPS extends Activity{
	
	//var for tab 2 GPS class
		GPSclass gps;
		
		private final String TAG = "GPS Activity";
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gps_lay);
		
		
		
		 //im sure theres a better way around the audio issues when changing from port to land. but locking it is ok for now
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
 
        
        
        
        
        
        //setting notify button
        Button notifyB = (Button) findViewById(R.id.notifyB);
        
        //notify listener
        notifyB.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			   
				
				//get reference notification manager
				NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				
				//using built in icon for notification
				Notification note = new Notification(android.R.drawable.stat_notify_more, 
						"Last minute notification", System.currentTimeMillis());
				Context context = GPS.this;
				
				//title of notification String
				CharSequence title = "You've been Notified!!!";
				
				//Contents/message of that notification.
				CharSequence details = "Go ahead, keep doing what you're doing";
				
				Intent intent = new Intent(context, Main.class);
				
				PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
				
				note.setLatestEventInfo(context, title, details, pending);
				
				nm.notify(0, note);
				
				
			}
		});
        
        //setting location button
        Button showLocation = (Button) findViewById(R.id.locationB);
        
        //"Where I'm At" listener
        showLocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//class object for gps class
				gps = new GPSclass(GPS.this);
				
				
				//Checking if GPS is on
				if(gps.canGetLocation())
				{
					double latitude = gps.getLatitude();
					double longitude = gps.getLongitude();
					
					//displaying results in a toast
					Toast.makeText(getApplicationContext(), 
							"I am somewhere very close to: \n Lat: " + latitude +
							"\n Long: " + longitude, Toast.LENGTH_LONG).show();
				}
				else
				{
					//allow user to view alert to give option to turn gps on if it is off
					gps.showSetting();
				}
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
		
		Intent audioInt = new Intent(GPS.this, AudioVideo.class);
		startActivity(audioInt);
		
		
		return true;
	case R.id.item2:
		Log.i(TAG, "item 2 CLICKED");
		
		Intent gpsInt = new Intent(GPS.this, GPS.class);
		startActivity(gpsInt);
		
		
		return true;
	case R.id.item3:
		Log.i(TAG, "item 3 CLICKED");
		
		Intent acellInt = new Intent(GPS.this, Acellerom.class);
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
