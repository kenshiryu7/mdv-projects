package com.lpuente.java_w2;

import java.util.ArrayList;
import java.util.HashMap;

import com.lpuente.pack1.FormingStuff;
import com.lpuente.pack2.InterfacCLASS;
import com.lpuente.pack2.LiquidConv;
import com.lpuente.pack2.J2Product;


import android.os.Bundle;
import android.app.Activity;
//import android.util.Log;		//removed my logs, may use later
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	
//As always many comments. Will keep some of the code from the videos as reference
	
	
	 RadioGroup fishTankOpts;
	 ArrayList<J2Product> fishtanks;
	 TextView result;
	 
	 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        LinearLayout mainlinlay = new LinearLayout(this);
        LayoutParams linParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mainlinlay.setLayoutParams(linParam);
        mainlinlay.setOrientation(LinearLayout.VERTICAL);
        
        
        TextView tview = new TextView(this);
        tview.setText("Type in number of Gallons with a decimal to view total conversion of quarts, pints, cups, and ounces" + "\r\n");
        
        TextView bottomMessage = new TextView(this);
        bottomMessage.setText("If number comes back a negative. That is the amount needed for the tank.");
        
     //calling linlay from pack1 package FormingStuff class passing in arguments
        LinearLayout entBox = FormingStuff.entryButton(this, "Ex. 54.67", "Tank dif", "Convert");
        
     //finding edit text and button ids from FormingStuff class
        //EditText entertext = (EditText) entBox.findViewById(1);
        Button textbutt = (Button) entBox.findViewById(2);
        
        Button secTextButt = (Button) entBox.findViewById(3);
        
     //Adding button listener for button from FormingStuff class by calling the variable = id 
        textbutt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int selRadioButtId = fishTankOpts.getCheckedRadioButtonId();
				RadioButton selectedR = (RadioButton) fishTankOpts.findViewById(selRadioButtId);
				
				String radioText = (String) selectedR.getText();
				
			//looping through radio to identify radio button / text	
				
				double gallonAmount = 0;
				
				
				for(int i = 0; i < fishtanks.size(); i ++)
				{
					if(radioText.compareTo(fishtanks.get(i).getName())==0)
					{
						gallonAmount = fishtanks.get(i).getPrice();
					}
				}
				
			//getting edit text from button tag 
				EditText textnexttobutton = (EditText) v.getTag(); 
				
				
				
			//setting what user types in edit text as a string variable
				//String test = textnexttobutton.getText().toString();
				
			//both work
				//Log.i("BUTTON ClICKED", textnexttobutton.getText().toString());
				//Log.i("SAME BUTTON CLICKED", test);
				
			//calling out double to shorten out hashMap log
				double hashShorten = Double.parseDouble(textnexttobutton.getText().toString());
				
				double rtrn = hashShorten - gallonAmount;
				
			//HashMap from Data class
				HashMap<LiquidConv, Integer> returndata = LiquidConv.getData(rtrn);
				
				
				//good stuff to keep
				/*
				Log.i("BUTTON CLICKED",
						"Dollar: " + returndata.get(Data.DOLLAR) + "\r\n" +
						"Quarter: " + returndata.get(Data.QUARTER) + "\r\n" +
						"Dime: " + returndata.get(Data.DIME) + "\r\n" +
						"Nickel: " + returndata.get(Data.NICKEL) + "\r\n" +
						"Penny: " + returndata.get(Data.PENNY) 
						);
						*/
				
				
				result.setText(
						"Gallon: " + returndata.get(LiquidConv.GALLON) + "\r\n" +
						"Quart: " + returndata.get(LiquidConv.QUART) + "\r\n" +
						"Pint: " + returndata.get(LiquidConv.PINT) + "\r\n" +
						"Cup: " + returndata.get(LiquidConv.CUP) + "\r\n" +
						"Ounce: " + returndata.get(LiquidConv.OUNCE) 
						);
			}
		});
        
        
        
        
        
        
        
    //Setting listener for second button
        secTextButt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			//getting edit text from button tag 
				EditText textnexttobutton = (EditText) v.getTag(); 
				
			//calling out double to shorten out hashMap log
				double hashShorten = Double.parseDouble(textnexttobutton.getText().toString());
				
			//HashMap from Data class
				HashMap<LiquidConv, Integer> returndata = LiquidConv.getData(hashShorten);
				
				
				result.setText(
						"Gallon: " + returndata.get(LiquidConv.GALLON) + "\r\n" +
						"Quart: " + returndata.get(LiquidConv.QUART) + "\r\n" +
						"Pint: " + returndata.get(LiquidConv.PINT) + "\r\n" +
						"Cup: " + returndata.get(LiquidConv.CUP) + "\r\n" +
						"Ounce: " + returndata.get(LiquidConv.OUNCE) + "\r\n"
						);
			}
		});
        
        
      //define new array list for j2Product interface /InterfaceCLASS / make sure class and interface are imported
        fishtanks = new ArrayList<J2Product>();
        fishtanks.add(new InterfacCLASS("Shark Tank", 100000));
        fishtanks.add(new InterfacCLASS("Marlins St. Fish Tank", 5000));
        fishtanks.add(new InterfacCLASS("Restauraunt Tank", 3500));
        fishtanks.add(new InterfacCLASS("Salt W. Tank", 1500));
        fishtanks.add(new InterfacCLASS("Fish Bowl", 5));
        fishtanks.add(new InterfacCLASS("None", 0));
        
        //defining the array with the length of the fishtanks array with size(). String[fishtanks.size()]
        String[] tankNames = new String[fishtanks.size()];
        
        //looping through fishtanks with size() instead of length
        for (int i = 0; i<fishtanks.size(); i ++)
        {
        	//getting the names of the fishtanks from the for loop
        	tankNames[i] = fishtanks.get(i).getName();
        }
        
        fishTankOpts = FormingStuff.getfishtanks(this, tankNames);
        
       
        
        
 //////////////////////////////////// Adding to the linear layout of main activity //////////////////////   
        
        mainlinlay.addView(tview);
        
     //add mainlinlay
        mainlinlay.addView(entBox);
        
        mainlinlay.addView(fishTankOpts);
        
        
        result = new TextView(this);
        mainlinlay.addView(result);
        
        mainlinlay.addView(bottomMessage);
     
      //setting content view / display on device
        setContentView(mainlinlay);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
