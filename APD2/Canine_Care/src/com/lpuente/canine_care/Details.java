package com.lpuente.canine_care;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends Activity {

	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.details_lay);
	        
	        //locking screen
	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	        
	        
	        //Text view ids
	        TextView symptoms = (TextView) findViewById(R.id.details);
	        TextView description = (TextView) findViewById(R.id.description);
	        
	      //string array
			String[] syms = getResources().getStringArray(R.array.symps);
			String[] dscr = getResources().getStringArray(R.array.descr);
			
	        
	        
	        
	        
	        
	        //image view id
	        ImageView passedIMG = (ImageView) findViewById(R.id.det_img);
	        
	        Intent i = getIntent();
	        int number = i.getIntExtra("int", -1);
	      
	        
	        
	       
	        
	        //Text view details id
	        TextView passedText = (TextView) findViewById(R.id.det_text);
	        
	        
	      //setting first and last name in one text view
			passedText.setText(getIntent().getExtras().getString("elements"));
			Log.d("TEST_DET", String.valueOf(number));
			
			
			//not the best solution. But it works
			//selecting
		//chocolate
			if(number == 0)
			{
				Log.d("Chocolate", "okeedokee");
				passedIMG.setImageResource(R.drawable.choco);
				
				symptoms.setText(syms[0]);
				description.setText(dscr[0]);
			}
		//onions
			else if(number == 1)
			{
				passedIMG.setImageResource(R.drawable.onions);
				symptoms.setText(syms[1]);
				description.setText(dscr[1]);
			}
		//grapes and raisons
			else if(number == 2)
			{
				passedIMG.setImageResource(R.drawable.grapes);
				symptoms.setText(syms[2]);
				description.setText(dscr[2]);
			}
		//coffee
			else if(number == 3)
			{
				passedIMG.setImageResource(R.drawable.coffee);
				symptoms.setText(syms[3]);
				description.setText(dscr[3]);
			}
		//macadamia nuts
			else if(number == 4)
			{
				passedIMG.setImageResource(R.drawable.mnuts);
				symptoms.setText(syms[4]);
				description.setText(dscr[4]);
			}
		//azalea plant
			else if(number == 5)
			{
				passedIMG.setImageResource(R.drawable.azalea);
				symptoms.setText(syms[5]);
				description.setText(dscr[5]);
			}
		//crocus plant
			else if(number == 6)
			{
				passedIMG.setImageResource(R.drawable.crocus);
				symptoms.setText(syms[6]);
				description.setText(dscr[6]);
			}
		//foxglove plant
			else if(number == 7)
			{
				passedIMG.setImageResource(R.drawable.foxglove);
				symptoms.setText(syms[7]);
				description.setText(dscr[7]);
			}
		//juniper plant
			else if(number == 8)
			{
				passedIMG.setImageResource(R.drawable.juniper);
				symptoms.setText(syms[8]);
				description.setText(dscr[8]);
			}
		//mistletoe plant
			else if(number == 9)
			{
				passedIMG.setImageResource(R.drawable.mistletoe);
				symptoms.setText(syms[9]);
				description.setText(dscr[9]);
			}
		//ethylene glycol
			else if(number == 10)
			{
				passedIMG.setImageResource(R.drawable.afreeze);
				symptoms.setText(syms[10]);
				description.setText(dscr[10]);
			}
		//rat poison
			else if(number == 11)
			{
				passedIMG.setImageResource(R.drawable.ratpoison);	
				symptoms.setText(syms[11]);
				description.setText(dscr[11]);
			}	
		//snail bait
			else if(number == 12)
			{
				passedIMG.setImageResource(R.drawable.snailbait);
				symptoms.setText(syms[12]);
				description.setText(dscr[12]);
			}
			
			
			
}
}