package com.puenteluis;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     //button 1 view photo
        Button viewPhoto = (Button) findViewById(R.id.button1);
        
     //button 2 just in case.
        Button second = (Button) findViewById(R.id.button2);
        
        viewPhoto.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("SdCardPath")
			@Override
			public void onClick(View v) {
				
			//creating simple implicit intent
				Intent impIntent = new Intent();
				
			//intent action to view. In this case a photo
				impIntent.setAction(android.content.Intent.ACTION_VIEW);
				
				//accessing a specific file
				//accessing from sdcard directly. Not from folder within sdcard.
				//String test = Environment.getExternalStorageDirectory().getAbsolutePath() + "/thor.jpg";
				//File photofile1 = new File(test);
				
				//perhaps I'm missing something. When using the String above the camera app doesn't allow share or set.
				
				
				File photofile = new File("/sdcard/thor.jpg");    //this is deprecated to use sdcard
				
			//setting data and type of what is being viewed * at the end of image means any image component.
				impIntent.setDataAndType(Uri.fromFile(photofile), "images/*");
				
			//starting the activity when button pressed.
				startActivity(impIntent);
			}
		});
    }

    
//menu is auto/added lately. Not a big deal
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
