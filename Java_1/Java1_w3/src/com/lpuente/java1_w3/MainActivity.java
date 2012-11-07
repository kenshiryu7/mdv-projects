package com.lpuente.java1_w3;

import java.net.URLEncoder;

import com.lpuente.pack_Lib.WebData;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	//Will follow videos for week 3 and may build on this file or week 2 file for turn in.
	
//global variable underscore naming. More traditional method. 
	
	Context _context;
	LinearLayout _appLo;
	SearchData _findField;
	DataDisplay _datas;
	MyFavorites _myfavs;
	Boolean _isConnected = false;

	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //setting global variables
        	_context = this;
        	_appLo = new LinearLayout(this);
        
//Calling Search Data class and context and setting to (this) or (_context) both work
        	_findField = new SearchData(this, "Look for something!", "Press to find");
        	
        	
        //Add Search data handler
        	//EditText searchTyped = _findField.getSearchData();
        //Also bringing the button in
        	Button searchButt = _findField.buttonPress();
        
        	
        //Search Butt on click listener / Method
        	searchButt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					//Log.i("Button Pressed ", _findField.getSearchData().getText().toString());
					getMyWebData(_findField.getSearchData().getText().toString());
					
				}
        	});
        	
        //DETECTING NETWORK CONNECTION FROM WEB DATA CLASS
        	//Calling connection status boolean from web data class
        	_isConnected = WebData.getConnectStatus(_context);
        	
        	//condition if connected (isConnected?)
        	if(_isConnected)
        	{
        		Log.i("NETWORK CONNECTION", WebData.getConnectType(_context));	//logging if connected and type from WebData class
        	}
        	
        	
//Adding data display layout
        	_datas = new DataDisplay(_context);
        	
//Adding My Favorites Class
        	_myfavs = new MyFavorites(_context);
        	
        //adding findField from Search Data class to the main activity layout
        //adding _datas from DataDisplay class to main
        //adding _myfavs for MyFavorites class to main
        	_appLo.addView(_findField);
        	_appLo.addView(_datas);
        	_appLo.addView(_myfavs);
        	    	
        //setting layout to vertical display for grid layout
        	_appLo.setOrientation(LinearLayout.VERTICAL);
        	
        //setting content view to the new linear layout global variable used.
        setContentView(_appLo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    //function to return web data from some API online (stocks in video example)
    private void getMyWebData(String symbol)
    {
   ////////HERES WHERE I PUT THE API URL AND ETC/////////////////////
    	
    	//will be testing stocks from video example. will change to something else later.
    	String baseURL = "http://query.yahooapis.com/v1/public/yql"; //yahoo api service
    	String carrierDataString = "select * from csv where url='http://download.finance.yahoo.com/d/quotes.csv?s" + symbol + "&f=sl1d1tc1ohgv&e=.csv' and columns='symbol,price,date,time,change,col1,high,low,col2'";
    			
    	String queryString;
    	
    	try{
    		queryString = URLEncoder.encode(carrierDataString, "UTF-8");
    	}
    	catch(Exception e)
    	{
    		Log.e("BAD URL","ENCODING PROBLEM");
    	}
    	
    	//Log.i("CLICK", symbol);
    }
}
