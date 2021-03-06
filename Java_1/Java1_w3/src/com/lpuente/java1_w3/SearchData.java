package com.lpuente.java1_w3;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ImageView;
import android.widget.LinearLayout;

public class SearchData extends LinearLayout {

	//creating and setting global variables with underscore naming.
	EditText _searchDataField;
	Button _searchButton;
	
	
	//ImageView image;
	
	//constructor created
	public SearchData(Context context, String hint, String buttonText)
	{
		super(context);
		
		//setting layout parameters object
		LayoutParams layParam;
			
	//create instance of global variables
		_searchDataField = new EditText(context);
		layParam = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_searchDataField.setLayoutParams(layParam);
		_searchDataField.setHint(hint);				//setting hint to String hint value passed in class call
		
		//image = (ImageView) findViewById(R.id.imageView1);
		//image.setBackgroundResource(R.drawable.dsign);
		
		_searchButton = new Button(context);
		
		_searchButton.setText(buttonText);			//setting button Text to String buttonText value passed in class call
		
		
	//adding instantiated variables to this LinearLayout class
		this.addView(_searchDataField);
		this.addView(_searchButton);
		//this.addView(image);
		
		layParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(layParam);
	}
	
	//setting functionality to edit text and button(s) to call in Main Activity Java file
	
	//Edit Text function
	public EditText getSearchData()
	{
		return _searchDataField;
	}
	
	//Button function
	public Button buttonPress()
	{
		return _searchButton;
		
	}
	
}
