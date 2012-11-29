package com.lpuente.java2_w1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.firstfrag);			//setting first frag xml. commenting out first just in case for later.
        
        
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
    }

    
    //where did this come from? Not sure why this was automatically added.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
