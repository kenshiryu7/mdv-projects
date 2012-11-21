package com.lpuente.java2_w1;

import android.app.Activity;
import android.os.Bundle;
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
		
		
		
		name.setText(getIntent().getExtras().getString("firstName"));
		last.setText(getIntent().getExtras().getString("lastName"));
	}
	
	
}
