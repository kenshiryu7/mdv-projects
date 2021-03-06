package com.lpuente.testingagain;

import android.os.Bundle;
import android.app.Activity;
//import android.util.Log; //not used. Using system..out.println();
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

//making the linearLayout object and linearlayout params ...defining classes
	LinearLayout linlay;
	LinearLayout.LayoutParams linParam;
	EditText edText;
	TextView result;
	TextView list;
	boolean badbool;
	String good = "It works!";
	String bad = "It doesn't work";
	
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
        //tview.setText("Just an example text view.");
        //keeping above as reference. Calling strings from value files / strings and integers. getString converts id to get the string value
          //tview.setText(getString(R.string.quarter)+", "+getString(R.string.dime)+", "+getString(R.string.nickel)+", "+getString(R.string.penny));
        
        tview.setText("Convert lbs to Kilos");
        
      //adding text view to the layout
        linlay.addView(tview);
        
      //Edit text class/instantiate  
        edText = new EditText(this);
        edText.setHint("User a number");	//adds text within text line /dissapears as user types
        //linlay.addView(edText); //adding to new layout
      
      //edit text button
        Button  ebutt = new Button(this);
        ebutt.setHint("to Kilos");		//set text within button. Instruction
        //linlay.addView(ebutt); //adding button to the Layout..commented out to add to new layout
        
       //Drug list button 
        Button drugButt = new Button(this);
        drugButt.setHint("Drug List");
        
       //add drug button event listener
        drugButt.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
			//array of drugs/strings	
				String[] drugs = {"Valium","Metaclopramide","Furisamide","Phenobarbital","Oxytetracylcine"};
				
			//looping through array	with function
				loopArray(drugs);
				
			}

		//function to loop array	
			private void loopArray(String[] drugs) {
				for (int i = 0; i < drugs.length; i++)
				{
					
				//must be append not setText to show full array	
					list.append((drugs[i] +"\n"));
				}
			}
		});
        
        
        //add ebutt button event listener
        ebutt.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
			//keeping as reference	
				//int quarter = getResources().getInteger(R.integer.quarter);
				//int dime = getResources().getInteger(R.integer.dime);
				//int nickel = getResources().getInteger(R.integer.nickel);
				//int penny = getResources().getInteger(R.integer.penny);
				
				int pound = getResources().getInteger(R.integer.kilos);
				
				int entry = Integer.parseInt(edText.getText().toString()); //collecting user input as integer convert to string by casting integer/ string
				
				//calling value of quarter,dime,nickel,penny and multiplying by users entry. keeping as reference
				//int numQ =(100/quarter)*entry;
				//int numD =(100/dime)*entry;
				//int numN =(100/nickel)*entry;
				//int numP =(100/penny)*entry;
				
				int numKilo = pound * entry ;
				
				//result.setText("Quarter: " + numQ + "\r\n" + 
								//"Dime: " + numD + "\r\n" +
								//"Nickel: " + numN + "\r\n" +
								//"Penny" + numP + "\r\n");
			
			//useless boolean variable. Hey it works!	
			   badbool = (entry > 0);
				
			//cheesy condition to log out. Must learn how to do conditions for strings/ints if not or if.	
				if(badbool)
				{
					//log to logCat usually used for Errors 
					//Log.i("GOOD", "IT CONVERTS SOMETHING");
					
					//log to logcat
					System.out.println(good);
				} else 
				{
					//Log.i("BAD but whatever", "WONT CONVERT 0");
					
					System.out.println(bad);
				}
				result.setText("Kilos: " + numKilo + "\n");
			}
		});
        
      
      
      //making layout for positioning of objects
        LinearLayout llay2 = new LinearLayout(this);
        llay2.setOrientation(LinearLayout.HORIZONTAL);  //setting layout horizontal
        linParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); //wrap content sets height as needed.
        llay2.setLayoutParams(linParam);
       
      //Adding edit text and edit button to the new layout  
        llay2.addView(edText); // edit text
        llay2.addView(ebutt);  // edit button
        llay2.addView(drugButt); //drug list button
        
      //Adding the new layout to the main
        linlay.addView(llay2);
        
        result = new TextView(this);
        list = new TextView(this);
        
        linlay.addView(result);
        linlay.addView(list);
        
      //adding Main layout to the content view
        setContentView(linlay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
