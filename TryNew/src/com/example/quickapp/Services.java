package com.example.quickapp;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Services extends Activity {

	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);	//before firstfrag
        setContentView(R.layout.service);
        
        
        //start button
        Button start = (Button) findViewById(R.id.start); 
        
        //start listener
        start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startService(new Intent(getBaseContext(), CrappService.class));
				
			}
		});
        
        
        
        //stop button
        Button stop = (Button) findViewById(R.id.stop); 
        
        //stop listner
        stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				stopService(new Intent(getBaseContext(), CrappService.class));
			}
		});
	}
}
