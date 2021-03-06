package com.example.part2_openweb;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class OpenMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_main_lay);
        
        //Buttons to send to web sites
        
        Button yahooButt = (Button) findViewById(R.id.button1);
        Button googButt = (Button) findViewById(R.id.button2);
        Button fsButt = (Button) findViewById(R.id.button3);
        
        
        
        //yahoo button. To Yahoo
        yahooButt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.com"));
				
				startActivity(intent);
			}
        	
        });
        
        
        //google button. To Google
        googButt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
				
				startActivity(intent);
			}
        	
        });
        
        // Full Sail Button. To Full Sail
        fsButt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fullsail.edu"));
				
				startActivity(intent);
			}
        	
        });
    }

   
    
   
    
    
    //Not used
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.open_main_lay, menu);
        return true;
    }
}
