package com.example.quickapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsView extends Activity {

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);	//before firstfrag
        setContentView(R.layout.details_frag);
        
       
        //calling for the proper id's
        TextView name = (TextView) findViewById(R.id.full_name);
        final TextView phone = (TextView) findViewById(R.id.phone_digits);
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        Button callButt = (Button) findViewById(R.id.call_button);
        
        
        //setting full name and phone number text Views
        name.setText(getIntent().getExtras().getString("fullname"));
        phone.setText(getIntent().getExtras().getString("fullphone"));
        
        //setting image view
        Uri imageUri = getIntent().getData();
        image.setImageURI(imageUri);
        
      //listener for callButt button
      		callButt.setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View v) {
      				
      			//Adding the typed in cell number to call. Must have tel: at beginning of string
      			//Im sure there's a cleaner better way to do this
      				String phoneNum = "tel:" + phone.getText().toString();
      				
      			//Calling the ACTION_CALL to use the typed number for the phone. NEEDS PERMISSON CALL_PHONE IN MANIFEST
      				Intent impIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNum));
      				
      			//Code to Start intent
      				startActivity(impIntent);
      			}
      		});
	}
}
