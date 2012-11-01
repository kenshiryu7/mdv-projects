package com.lpuente.java_w2;

import java.util.HashMap;

import com.lpuente.pack1.FormingStuff;
import com.lpuente.pack2.Data;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     //calling linlay from pack1 package FormingStuff class passing in arguments
        LinearLayout entBox = FormingStuff.entryButton(this, "Type here", "button text butt1");
        
     //finding edit text and button ids from FormingStuff class
        //EditText entertext = (EditText) entBox.findViewById(1);
        Button textbutt = (Button) entBox.findViewById(2);
        
     //Adding button listener for button from FormingStuff class by calling the variable = id 
        textbutt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			//getting edit text from button tag 
				EditText textnexttobutton = (EditText) v.getTag(); 
				
			//setting what user types in edit text as a string variable
				String test = textnexttobutton.getText().toString();
				
			//both work
				//Log.i("BUTTON ClICKED", textnexttobutton.getText().toString());
				//Log.i("SAME BUTTON CLICKED", test);
				
			//calling out double to shorten out hashMap log
				double hashShorten = Double.parseDouble(textnexttobutton.getText().toString());
			//HashMap from Data class
				HashMap<Data, Integer> returndata = Data.getData(hashShorten);
				
				/*
				Log.i("BUTTON CLICKED",
						"Dollar: " + returndata.get(Data.DOLLAR) + "\r\n" +
						"Quarter: " + returndata.get(Data.QUARTER) + "\r\n" +
						"Dime: " + returndata.get(Data.DIME) + "\r\n" +
						"Nickel: " + returndata.get(Data.NICKEL) + "\r\n" +
						"Penny: " + returndata.get(Data.PENNY) 
						);
						*/
				
				Log.i("BUTTON CLICKED",
						"Gallon: " + returndata.get(Data.GALLON) + "\r\n" +
						"Quart: " + returndata.get(Data.QUART) + "\r\n" +
						"Pint: " + returndata.get(Data.PINT) + "\r\n" +
						"Cup: " + returndata.get(Data.CUP) + "\r\n" +
						"Ounce: " + returndata.get(Data.OUNCE) 
						);
			}
		});
        
     //Creat main linlay
        LinearLayout mainlinlay = new LinearLayout(this);
     //add mainlinlay
        mainlinlay.addView(entBox);
        
     //setting content view / display on device
        setContentView(mainlinlay);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
