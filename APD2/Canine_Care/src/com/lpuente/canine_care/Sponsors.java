package com.lpuente.canine_care;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Sponsors extends Activity{

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sponsor_lay);
        
        //Stopping the service/music when opening this activity
        stopService(new Intent(getBaseContext(), MusicService.class));
        
        
      //hills science diet sponsor/ad  
        ImageButton sponsor1 = (ImageButton) findViewById(R.id.sponsor1);
        
        sponsor1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent hills = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hillspet.com/science-diet-dog-food.html"));
				
				startActivity(hills);
				
				//notification shows when clicked
				notifyStuff();
			}
		});
        
        //Petco sponsor/ad
        ImageButton sponsor2 = (ImageButton) findViewById(R.id.sponsor2);
        
        sponsor2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent petco = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.petco.com"));
				
				startActivity(petco);
				
				//notification shows when clicked
				notifyStuff();
			}
		});
        
        
        //Cosequin Sponsor/ad
        ImageButton sponsor3 = (ImageButton) findViewById(R.id.sponsor3);
        
        sponsor3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent coq = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nutramaxlabs.com/index.php/dog/dog-joint-bone-health/cosequin-dog-product-selector"));
				
				startActivity(coq);
				
				//notification shows when clicked
				notifyStuff();
			}
		});
        
        
        //Sentinal Sponsor/ad
        ImageButton sponsor4 = (ImageButton) findViewById(R.id.sponsor4);
        
        sponsor4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent sentinal = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sentinelpet.com"));
				
				startActivity(sentinal);
				
				//notification shows when clicked
				notifyStuff();
			}
		});
        
        
        //Royal Canin Sponsor/ad
        ImageButton sponsor5 = (ImageButton) findViewById(R.id.sponsor5);
        
        sponsor5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent rc = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.royalcanin.us"));
				
				startActivity(rc);
				
				//notification shows when clicked
				notifyStuff();
			}
		});
	}
	
	
	public void notifyStuff(){
		
		//Intent noteInt = new Intent();
		Intent noteInt = new Intent(Sponsors.this, Sponsors.class);
		
		PendingIntent pInt = PendingIntent.getActivity(this, 0, noteInt, 0);
		
		//setting all the notification stuff
		@SuppressWarnings("deprecation")
		
		Notification note = new Notification.Builder(this)
		.setTicker("Canine Care ")
		.setContentTitle("Canine Care Sponsors")
		.setContentText("Check back for more Deals!")
		.setSmallIcon(R.drawable.l_icon)
		.setContentIntent(pInt).getNotification();
		
		//cancels notifcation after viewing once
		note.flags = Notification.FLAG_AUTO_CANCEL;
		
		NotificationManager noteMan = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		//first argument is app idd for notification, second is notification var
		noteMan.notify(0, note);
		
	}
	
	
	
}