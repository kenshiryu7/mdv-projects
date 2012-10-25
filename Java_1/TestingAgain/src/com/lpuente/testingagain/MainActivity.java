package com.lpuente.testingagain;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      //Creating a layout, instantiating and applying width and height params.
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
      //creating text view / instantiating
        TextView tv = new TextView(this);
        tv.setText("Just an example text view.");
        
      //adding text view to the layout
        ll.addView(tv);
        
      //Edit text class/instantiate  
        EditText et = new EditText(this);
        et.setHint("User type here");	//adds text within text line /dissapears as user types
        ll.addView(et);
      
      //edit text button
        Button  ebutt = new Button(this);
        ebutt.setHint("Button 1");		//set text within button. Instruction
        ll.addView(ebutt); //adding button to the Layout
        
      //adding layout to the content view
        setContentView(ll);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
