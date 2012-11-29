package com.lpuente.java2_w1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.Menu;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements FirstFrag.FirstInterface {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.firstfrag);			//setting first frag xml. commenting out first just in case for later.
   
        
 /*       
        //creating button using reference from xml id
        Button subButt = (Button)findViewById(R.id.button1);
        final EditText etFirst = (EditText) findViewById(R.id.editName);
        final EditText etLast = (EditText) findViewById(R.id.editLast);
        final EditText etPhone = (EditText) findViewById(R.id.editPhone);
        
        
        //on click listener for button
        
        subButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent exIntent = new Intent(MainActivity.this, SecondView.class);
				
				//adding data to the intent with put extra AND Naming the KEY HERE!!!!!
				exIntent.putExtra("firstName", etFirst.getText().toString());
				exIntent.putExtra("lastName", etLast.getText().toString());
				exIntent.putExtra("phoneNum", etPhone.getText().toString());
				
				//method to start the activity when the button is pressed
				startActivity(exIntent);
				
				
			}
		});
		
		//comment out before i completely remove
 */
    }

    
    //where did this come from? Not sure why this was automatically added.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


    
    
  //FORM FRAGMENT METHODS HERE. MAY HAVE MORE LATER  
    
	@Override
	public void onSubmit() {
		// TODO Auto-generated method stub
		 EditText etFirst = (EditText) findViewById(R.id.editName);
	     EditText etLast = (EditText) findViewById(R.id.editLast);
	        
	     EditText etPhone = (EditText) findViewById(R.id.editPhone);
	     EditText etPhone2 = (EditText) findViewById(R.id.editPhone2);
	     EditText etPhone3 = (EditText) findViewById(R.id.editPhone3);
	     
	    
	     
		Intent exIntent = new Intent(MainActivity.this, SecondView.class);
		
	   
	     
		//adding data to the intent with put extra AND Naming the KEY HERE!!!!!
		
		//adding the first and last name
		exIntent.putExtra("firstName", etFirst.getText().toString());
		exIntent.putExtra("lastName", etLast.getText().toString());
		
		//for the phone number. Using 3 edit text fields
		exIntent.putExtra("phoneNum", etPhone.getText().toString());
		exIntent.putExtra("phoneNum2", etPhone2.getText().toString());
		exIntent.putExtra("phoneNum3", etPhone3.getText().toString());
		
	//method to start the activity when the button is pressed
		startActivity(exIntent);
	}
}
