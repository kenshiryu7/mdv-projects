package com.lpuente.java2_w3;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class AddView extends Activity implements AddFrag.AddInterface{

	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.addfrag);			//setting addfrag.xml. 
	   
	    }

	    
	 //where did this come from? Not sure why this was automatically added.
	 //Erased this code and for some reason when using PHONE_CALL it takes you straight to the keypad instead of dialing the typed number.
	 //not sure why it does this so i left it in.
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_main, menu);
	        return true;
	    }


		@Override
		public void onAddContact() {
			// TODO Auto-generated method stub
			
			finish();
			
		}
		
		public void finish()
		{
			//Building Edit Texts for first and last name
			 EditText etFirst = (EditText) findViewById(R.id.editName);
		     EditText etLast = (EditText) findViewById(R.id.editLast);
		        
		//Building Edit Texts for the 3 input fields to make a full phone number.
		     EditText etPhone = (EditText) findViewById(R.id.editPhone);
		     EditText etPhone2 = (EditText) findViewById(R.id.editPhone2);
		     EditText etPhone3 = (EditText) findViewById(R.id.editPhone3);
		     
		   //building intent 
			Intent data = new Intent();
			
			//adding the first and last name
			data.putExtra("firstName", etFirst.getText().toString());
			data.putExtra("lastName", etLast.getText().toString());
			
		//for the phone number. Using 3 edit text fields
			data.putExtra("phoneNum", etPhone.getText().toString());
			data.putExtra("phoneNum2", etPhone2.getText().toString());
			data.putExtra("phoneNum3", etPhone3.getText().toString());
			
			setResult(RESULT_OK, data);
			super.finish();
		}
}
