package com.lpuente.java1_w3;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MyFavorites extends LinearLayout{
	
	SearchData _findField;
	
	
	Button _add;
	Button _delete;
	Spinner _favsList;		//Spinner is a drop down in Android
	
	Context _context;		//trying to make good habits
	
//Creating array list to populate spinner
	ArrayList<String> _information = new ArrayList<String>();
	
	public MyFavorites(Context context)
	{
		super(context);
		_context = context;
		
		LayoutParams layParam;
		
	//default value of Array List for Spinner
		_information.add("Select your Favorite");
		
	//inst Spinner / Drop Down and settings, add Button, Delete Button and setting the buttons text
		_favsList = new Spinner(_context);
		layParam = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_favsList.setLayoutParams(layParam);
		
		
	//Adding array adapter to populate Spinner
		ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(_context, android.R.layout.simple_spinner_item, _information);
		spinAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		_favsList.setAdapter(spinAdapter);
		
	//event listener for spinner selections
		_favsList.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int pos, long id)
			{
				Log.i("SELECTED A FAVORITE", parent.getItemAtPosition(pos).toString());
				
				if(parent.getItemAtPosition(pos).toString() == "Six Flags")
				{
					Log.i("YES THIS IS SIX FLAGS", "STOOP");
					
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
				Log.i("SELECTED A FAVORITE", "NOOOOOOOO");
			}

			
		});
		
	//Call to private function to update spinner
		updateSpinner();
		
		
		_add = new Button(_context);
		_add.setText("+");
		
		
		_delete = new Button(_context);
		_delete.setText("-");
		
	//adding to this linear layout class - Spinner, Add, Delete
		this.addView(_favsList);
		this.addView(_add);
		this.addView(_delete);
		
		//setting to allow spinner and add / delete buttons to fill up width evenly
		layParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(layParam);
	}
	
	
//private function to add to spinner	
	private void updateSpinner()
	{
		_information.add("Six Flags");
		_information.add("Sea World");
		_information.add("Pet Smart");
		_information.add("Petco");
		//_information.add("Apples");
		//_information.add("Water-Melons");
		//_information.add("Plumbs");
		//_information.add("Strawberries");
		
	}

}
