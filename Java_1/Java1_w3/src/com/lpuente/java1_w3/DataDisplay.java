package com.lpuente.java1_w3;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;

public class DataDisplay extends GridLayout{
	
	
	//global variables Grid Layout is new and requires a change to version 14 in android manifest
	TextView _symbol;	//may not use some of these variables later
	TextView _priceData;
	TextView _timeData;
	TextView _highData;
	TextView _lowData;
	TextView _changes;
	TextView _open;
	TextView _close;
	TextView _volume;
	
	Context _context;
	
	public DataDisplay(Context context)
	{
		super(context);
		
		
		_context = context;
		
		//setting number of columns in grid layout
		this.setColumnCount(2);
		
		
	//setting text views within grid and setting text to each text field/ following video example	
		TextView symLab = new TextView(_context);
		symLab.setText("Symbol: ");
		_symbol    = new TextView(_context);
		
		
		TextView priceDLab = new TextView(_context);
		_priceData = new TextView(_context);
		priceDLab.setText("Current: ");
		
		
		TextView timeDLab = new TextView(_context);
		timeDLab.setText("Updated: ");
		_timeData = new TextView(_context);
		
		
		TextView highDLab = new TextView(_context);
		highDLab.setText("High: ");
		_highData = new TextView(_context);
		
		
		TextView lowDLab = new TextView(_context);
		lowDLab.setText("Low: ");
		_lowData  = new TextView(_context);
		
		
		TextView changeLab = new TextView(_context);
		changeLab.setText("Change: ");
		_changes   = new TextView(_context);
		
		
		TextView  openLab = new TextView(_context);
		openLab.setText("Open: ");
		_open     = new TextView(_context);
		
		
		TextView closeLab = new TextView(_context);
		closeLab.setText("Close: ");
		_close 	  = new TextView(_context);
		
		
		TextView volLab = new TextView(_context);
		volLab.setText("Volume: ");
		_volume   = new TextView(_context);
		
	
		//adding labels and content 
	
		this.addView(symLab);
		this.addView(_symbol);
		
		this.addView(priceDLab);
		this.addView(_priceData);
		
		this.addView(timeDLab);
		this.addView(_timeData);
		
		this.addView(highDLab);
		this.addView(_highData);
		
		this.addView(lowDLab);
		this.addView(_lowData);
		
		this.addView(changeLab);
		this.addView(_changes);
		
		this.addView(openLab);
		this.addView(_open);

		this.addView(closeLab);
		this.addView(_close);
		
		this.addView(volLab);
		this.addView(_volume);
	}

}
