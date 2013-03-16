package com.lpuente.canine_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends Activity {

	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.details_lay);
	        
	        //image view id
	        ImageView passedIMG = (ImageView) findViewById(R.id.det_img);
	      
	        
	        
	       
	        
	        //Text view details id
	        TextView passedText = (TextView) findViewById(R.id.det_text);
	        
	        
	      //setting first and last name in one text view
			passedText.setText(getIntent().getExtras().getString("elements"));
			//Log.d("TEST", String.valueOf(passedText));
			
			
			
			
}
}