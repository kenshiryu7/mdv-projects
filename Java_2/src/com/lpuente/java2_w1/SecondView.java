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
		
		
		
		TextView test = (TextView) findViewById(R.id.test);
		
		//creating the button
		final Button callButt = (Button)findViewById(R.id.callnum);
		
		//string from phone num
		//String phoneNum;
		
		String phone1 = getIntent().getExtras().getString("phoneNum");
		String phone2 = getIntent().getExtras().getString("phoneNum2");
		String phone3 = getIntent().getExtras().getString("phoneNum3");
		
		 callButt.setText("1" + "(" + phone1 + ")" + phone2 + "-" + phone3);
		
		//setting first and last name in one text view
		test.setText(getIntent().getExtras().getString("firstName") + "  " + getIntent().getExtras().getString("lastName"));
		
		//listener for button
		callButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Adding the typed in cell number to call. Must have tel: at beginning of string
				//Im sure there's a cleaner better way to do this
				String phoneNum = "tel:" + "1" + callButt.getText().toString();
				
				//Calling the ACTION_CALL to use the typed number for the phone. NEEDS PERMISSON CALL_PHONE IN MANIFEST
				//Hope this counts as an implicit Intent
				Intent impIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNum));
				
				
				startActivity(impIntent);
			}
		});
	}
	
	
}
