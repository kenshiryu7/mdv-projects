package com.lpuente.canine_care;

import android.app.Activity;
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
			}
		});
        
        //Petco sponsor/ad
        ImageButton sponsor2 = (ImageButton) findViewById(R.id.sponsor2);
        
        sponsor2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent petco = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.petco.com"));
				
				startActivity(petco);
			}
		});
        
        
        //Cosequin Sponsor/ad
        ImageButton sponsor3 = (ImageButton) findViewById(R.id.sponsor3);
        
        sponsor3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent coq = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nutramaxlabs.com/index.php/dog/dog-joint-bone-health/cosequin-dog-product-selector"));
				
				startActivity(coq);
			}
		});
        
        
        //Sentinal Sponsor/ad
        ImageButton sponsor4 = (ImageButton) findViewById(R.id.sponsor4);
        
        sponsor4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent sentinal = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sentinelpet.com"));
				
				startActivity(sentinal);
			}
		});
        
        
        //Royal Canin Sponsor/ad
        ImageButton sponsor5 = (ImageButton) findViewById(R.id.sponsor5);
        
        sponsor5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent rc = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.royalcanin.us"));
				
				startActivity(rc);
			}
		});
	}
}