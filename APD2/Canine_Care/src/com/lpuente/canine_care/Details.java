package com.lpuente.canine_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends Activity {

	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.details_lay);
	        
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
			}
		//onions
			else if(number == 1)
			{
				passedIMG.setImageResource(R.drawable.onions);
			}
		//grapes and raisons
			else if(number == 2)
			{
				passedIMG.setImageResource(R.drawable.grapes);
			}
		//coffee
			else if(number == 3)
			{
				passedIMG.setImageResource(R.drawable.coffee);
			}
		//macadamia nuts
			else if(number == 4)
			{
				passedIMG.setImageResource(R.drawable.mnuts);
			}
		//azalea plant
			else if(number == 5)
			{
				passedIMG.setImageResource(R.drawable.azalea);
			}
		//crocus plant
			else if(number == 6)
			{
				passedIMG.setImageResource(R.drawable.crocus);
			}
		//foxglove plant
			else if(number == 7)
			{
				passedIMG.setImageResource(R.drawable.foxglove);
			}
		//juniper plant
			else if(number == 8)
			{
				passedIMG.setImageResource(R.drawable.juniper);
			}
		//mistletoe plant
			else if(number == 9)
			{
				passedIMG.setImageResource(R.drawable.mistletoe);
			}
		//ethylene glycol
			else if(number == 10)
			{
				passedIMG.setImageResource(R.drawable.afreeze);
			}
		//rat poison
			else if(number == 11)
			{
				passedIMG.setImageResource(R.drawable.ratpoison);	
			}	
		//snail bait
			else if(number == 12)
			{
				passedIMG.setImageResource(R.drawable.snailbait);
			}
			
			
			
}
}