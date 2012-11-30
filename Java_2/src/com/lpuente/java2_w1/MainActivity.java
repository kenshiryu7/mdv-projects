package com.lpuente.java2_w1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;

//Implementing From FirstFrag and FirstInterface 

public class MainActivity extends Activity implements FirstFrag.FirstInterface {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstfrag);			//setting firstfrag.xml. 
   
    }

    
 //where did this come from? Not sure why this was automatically added.
 //Erased this code and for some reason when using PHONE_CALL it takes you straight to the keypad instead of dialing the typed number.
 //not sure why it does this so i left it in.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


    
    
  //FROM FirstFrag. FRAGMENT METHODS HERE. MAY HAVE MORE LATER  
    
	@Override
	public void onSubmit() {
		// TODO Auto-generated method stub
		
	//Building Edit Texts for first and last name
		 EditText etFirst = (EditText) findViewById(R.id.editName);
	     EditText etLast = (EditText) findViewById(R.id.editLast);
	        
	//Building Edit Texts for the 3 input fields to make a full phone number.
	     EditText etPhone = (EditText) findViewById(R.id.editPhone);
	     EditText etPhone2 = (EditText) findViewById(R.id.editPhone2);
	     EditText etPhone3 = (EditText) findViewById(R.id.editPhone3);
	     
	    
	//Calling the intent to move into SecondView Activity
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
