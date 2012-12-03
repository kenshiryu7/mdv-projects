package com.lpuente.java2_w1;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


//Adding implements NameOfFragment.NameofInterface and then implementing from fragment within this.

public class SecondView extends Activity implements SecondFrag.SecondInterface{

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondview);		//setting to secondfrag.xml
		
	//Getting id for TextView to display full name
		TextView fullName = (TextView) findViewById(R.id.full_name);
		
	//creating the button
		final Button callButt = (Button)findViewById(R.id.callnum);
		
	//Getting user's input for phone field in 3 edit texts
		String phone1 = getIntent().getExtras().getString("phoneNum");
		String phone2 = getIntent().getExtras().getString("phoneNum2");
		String phone3 = getIntent().getExtras().getString("phoneNum3");
		
	//Setting text to 3 typed numbers for full phone number plus ( ) and - for phone format
	//I understand there is a way to do this through a feature built in android. To complicated right now to get into
		callButt.setText("1" + "(" + phone1 + ")" + phone2 + "-" + phone3);
		
	//setting first and last name in one text view
		fullName.setText(getIntent().getExtras().getString("firstName") + " " + getIntent().getExtras().getString("lastName"));
		
	
	
	//listener for callButt button hopefully will work
		callButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			//Adding the typed in cell number to call. Must have tel: at beginning of string
			//Im sure there's a cleaner better way to do this
				String phoneNum = "tel:" + callButt.getText().toString();
				
			//Calling the ACTION_CALL to use the typed number for the phone. NEEDS PERMISSON CALL_PHONE IN MANIFEST
				Intent impIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNum));
				
			//Code to Start intent
				startActivity(impIntent);
			}
		});

		
		
// FROM SEcondFrag. FRAGMENT METHODS HERE. MAY HAVE MORE LATER  		

		// Attempted to add a second fragment for the implicit intent PHONE_CALL
		// Tried numerous ways including global variables and etc. 
		// Will leave this implement blank until HOPEFULLY can make use of it.
		// ok came back and tried something. Didnt work so now im just leaving things as they are.
	}

	@Override
	public void onMakeCall() {
		// TODO Auto-generated method stub
		
		//Getting id for TextView to display full name
				TextView fullName = (TextView) findViewById(R.id.full_name);
				
			//creating the button
				final Button callButt = (Button)findViewById(R.id.callnum);
				
			//Getting user's input for phone field in 3 edit texts
				String phone1 = getIntent().getExtras().getString("phoneNum");
				String phone2 = getIntent().getExtras().getString("phoneNum2");
				String phone3 = getIntent().getExtras().getString("phoneNum3");
				
			//Setting text to 3 typed numbers for full phone number plus ( ) and - for phone format
			//I understand there is a way to do this through a feature built in android. To complicated right now to get into
				callButt.setText("1" + "(" + phone1 + ")" + phone2 + "-" + phone3);
				
			//setting first and last name in one text view
				fullName.setText(getIntent().getExtras().getString("firstName") + " " + getIntent().getExtras().getString("lastName"));
				
			
			
			//listener for callButt button
				callButt.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
					//Adding the typed in cell number to call. Must have tel: at beginning of string
					//Im sure there's a cleaner better way to do this
						String phoneNum = "tel:" + callButt.getText().toString();
						
					//Calling the ACTION_CALL to use the typed number for the phone. NEEDS PERMISSON CALL_PHONE IN MANIFEST
						Intent impIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNum));
						
					//Code to Start intent
						startActivity(impIntent);
					}
				});

	}
	
}
	
	

