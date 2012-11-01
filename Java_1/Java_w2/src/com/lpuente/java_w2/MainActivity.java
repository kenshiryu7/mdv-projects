package com.lpuente.java_w2;

import com.lpuente.pack1.FormingStuff;

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
				
				Log.i("BUTTON ClICKED", textnexttobutton.getText().toString());
				Log.i("SAME BUTTON CLICKED", test);
				
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
