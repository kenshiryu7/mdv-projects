package com.lpuente.testingagain;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

//making the linearLayout obect and linearlayout params
	LinearLayout linlay;
	LinearLayout.LayoutParams linParam;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      //Creating a layout, instantiating and applying width and height params.
        linlay = new LinearLayout(this);
        linlay.setOrientation(LinearLayout.VERTICAL);
        linParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linlay.setLayoutParams(linParam);
        
      //creating text view / instantiating
        TextView tview = new TextView(this);
        tview.setText("Just an example text view.");
        
      //adding text view to the layout
        linlay.addView(tview);
        
      //Edit text class/instantiate  
        EditText edText = new EditText(this);
        edText.setHint("User type here");	//adds text within text line /dissapears as user types
        //linlay.addView(edText); //adding to new layout
      
      //edit text button
        Button  ebutt = new Button(this);
        ebutt.setHint("Button 1");		//set text within button. Instruction
        //linlay.addView(ebutt); //adding button to the Layout..commented out to add to new layout
      
      //making layout for positioning of objects
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.HORIZONTAL);  //setting layout horizontal
        form.setLayoutParams(linParam);
       
      //Adding edit text and edit button to the new layout  
        form.addView(edText); // edit text
        form.addView(ebutt);  // edit button
        
      //Adding the new layout to the main
        linlay.addView(form);
        
      //adding Main layout to the content view
        setContentView(linlay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
