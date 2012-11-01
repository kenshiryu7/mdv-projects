package com.lpuente.pack1;


import android.content.Context;
//import android.view.ViewGroup.LayoutParams; doesn't work with new re-purpose layout for edbutt
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class FormingStuff {

	public static LinearLayout entryButton(Context cons, String hint, String buttonText)
	{
		LinearLayout linlay = new LinearLayout(cons);
		
	//creating content
		//(width, height)
		LayoutParams laypar = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
	
	//setting params to linear layout
		linlay.setLayoutParams(laypar);
		
		
	//Editable text view
		EditText edtext = new EditText(cons);
		
		
	//re-purpose layout params to have text full width of screen
		laypar = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
	//setting text hint (hint) passed in class. String hint
		edtext.setHint(hint);
	//setting new layout params
		edtext.setLayoutParams(laypar);
	//setting id for edit text /edtext  - int
		edtext.setId(1);
		
		
		
	//Button
		Button butt1 = new Button(cons);
	//setting button text (buttonText) passed in class. String buttonText
		butt1.setText(buttonText);
	//setting id for button / butt1 - int
		butt1.setId(2);
	//setting tag to button to edtext. The EditText field.
		butt1.setTag(edtext);
		
		
		
	//adding to linear layout
		linlay.addView(edtext);		//add edit text to linlay
		linlay.addView(butt1);		//add butt1 to linlay
		
		
		
		return linlay;
	}
	
}
