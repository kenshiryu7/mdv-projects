package com.lpuente.java2_w1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondView extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondview);
		
		
		//instance for text view string from previous view is passing into
		
		TextView name = (TextView) findViewById(R.id.textView2);
		TextView last = (TextView) findViewById(R.id.textView3);
		
		//creating the button
		final Button callButt = (Button)findViewById(R.id.callnum);
		
		//string from phone num
		//String phoneNum;
		
		 callButt.setText(getIntent().getExtras().getString("phoneNum"));
		
		name.setText(getIntent().getExtras().getString("firstName"));
		last.setText(getIntent().getExtras().getString("lastName"));
		
		//listener for button
		callButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Adding the typed in cell number to call. Must have tel: at beginning of string
				//Im sure there's a cleaner better way to do this
				String phoneNum = "tel:" + callButt.getText().toString();
				
				//Calling the ACTION_CALL to use the typed number for the phone. NEEDS PERMISSON CALL_PHONE IN MANIFEST
				Intent impIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNum));
				
				
				startActivity(impIntent);
			}
		});
	}
	
	
}
