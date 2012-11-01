package com.lpuente.java_w2;

import java.util.ArrayList;
import java.util.HashMap;

import com.lpuente.pack1.FormingStuff;
import com.lpuente.pack2.InterfacCLASS;
import com.lpuente.pack2.LiquidConv;
import com.lpuente.pack2.J2Product;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        TextView tview = new TextView(this);
        tview.setText("Type in number of Gallons with a decimal to view total conversion of quarts, pints, cups, and ounces" + "\r\n");
        
        
     //calling linlay from pack1 package FormingStuff class passing in arguments
        LinearLayout entBox = FormingStuff.entryButton(this, "Ex. 54.67", "View Total");
        
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
				HashMap<LiquidConv, Integer> returndata = LiquidConv.getData(hashShorten);
				
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
						"Gallon: " + returndata.get(LiquidConv.GALLON) + "\r\n" +
						"Quart: " + returndata.get(LiquidConv.QUART) + "\r\n" +
						"Pint: " + returndata.get(LiquidConv.PINT) + "\r\n" +
						"Cup: " + returndata.get(LiquidConv.CUP) + "\r\n" +
						"Ounce: " + returndata.get(LiquidConv.OUNCE) 
						);
			}
		});
        
      //define new array list for j2Product interface /InterfaceCLASS
        ArrayList<J2Product> fishtanks = new ArrayList<J2Product>();
        fishtanks.add(new InterfacCLASS("Shark Tank", 100000));
        fishtanks.add(new InterfacCLASS("Marlins Stadium Tank", 5000));
        fishtanks.add(new InterfacCLASS("Restauraunt Tank", 3500));
        fishtanks.add(new InterfacCLASS("Salt water Tank", 1500));
        fishtanks.add(new InterfacCLASS("Fish Bowl", 5));
        
        
     //Creat main linlay
        LinearLayout mainlinlay = new LinearLayout(this);
        LinearLayout.LayoutParams linParam;
        mainlinlay.setOrientation(LinearLayout.VERTICAL);
        linParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mainlinlay.setLayoutParams(linParam);
        
        mainlinlay.addView(tview);
        
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
