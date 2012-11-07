package com.lpuente.java1_w3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.lpuente.pack_Lib.MyFiles;
import com.lpuente.pack_Lib.WebData;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
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
	HashMap<String, String> _history;

	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //setting global variables / instantiating
        	_context = this;
        	_appLo = new LinearLayout(this);
        	_history = getHistory();
        	
        	//logging out history which is not equal to getHistory() method
        	Log.i("HISTORY READ", _history.toString());
        
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
        	//_datas = new DataDisplay(_context);
        	
//Adding My Favorites Class
        	_myfavs = new MyFavorites(_context);
        	
        //adding findField from Search Data class to the main activity layout
        //adding _datas from DataDisplay class to main
        //adding _myfavs for MyFavorites class to main
        	_appLo.addView(_findField);
        	//_appLo.addView(_datas);
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
    	String carrierDataString = "select * from csv where url='http://download.finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=sl1d1t1c1ohgv&e=.csv' and columns='symbol,price,date,time,change,col1,high,low,col2'";
    			
    	String queryString;
    	
    	try{
    		queryString = URLEncoder.encode(carrierDataString, "UTF-8");
    	}
    	catch(Exception e)
    	{
    		Log.e("BAD URL","ENCODING PROBLEM");
    		queryString ="";
    	}
    	URL finalURL;
    	
    	try
    	{
    		finalURL = new URL(baseURL + "?q=" + queryString + "&format=json");
    		DataRequest dreq = new DataRequest();
    		dreq.execute(finalURL);
    	}
    	catch(MalformedURLException e)
    	{
    		Log.e("BAD URL", "MALFORMED URL");
    		finalURL = null;
    	}
    	//Log.i("CLICK", symbol);
    }
    
    //new method to pull out history from internal or external storage with MyFiles class
    @SuppressWarnings("unchecked")
	private HashMap<String,String> getHistory()
    {
    	//pulls stored file
    	Object  stored = MyFiles.readObjFile(_context, "history", false ); //internal
    	
    	HashMap<String,String> history;
    	
    	if(stored == null)
    	{
    		Log.i("HISTORY LOG", "NO HISTORY FILE FOUND");
    		
    		//another HAsh Map
    		history = new HashMap<String, String>();
    	}
    	else
    	{
    		history = (HashMap<String, String>) stored;
    	}
    	
    	return history;
    }
    
    //making a private class
    private class DataRequest extends AsyncTask<URL, Void, String>
    {
    	@Override
    	protected String doInBackground(URL...urls)
    	{
    		String response = "";
    		
    		for(URL url: urls)
    		{
    			response = WebData.getURLResponse(url);
    		}
    		return response;
    	}
    	//runs when do in background is done.
    	
    	@Override
    	protected  void onPostExecute(String result)
    	{
    		//logging out response in with String result
    		Log.i("URL RESPONSE", result);
    		
    		//Parsing to the data needed / desired
    		
    		
    		try
    		{
    			JSONObject jsonData = new JSONObject(result);
    		//drilling down to get stock data
    		//Was going to use google finance instead but apparently its been shut down. Im sure there's other sources out there but no time
    			JSONObject results = jsonData.getJSONObject("query").getJSONObject("results").getJSONObject("row");
    			
    			if(results.getString("col1").compareTo("N/A") == 0)
    			{
    			//Toast is a pop-up box in android. What other edible objects will we learn?
    				Toast toasty = Toast.makeText(_context, "Invalid Symbol", Toast.LENGTH_SHORT);
    				toasty.show();
    			}
    			else
    			{
    			//Else Symbol is Valid...
    				Toast toasty = Toast.makeText(_context, "Valid Symbol " + results.getString("symbol"), Toast.LENGTH_SHORT);
    				toasty.show();
    				
    			//using the hashmap to store JSON object results converted to string ready to write to hard drive
    				_history.put(results.getString("symbol"), results.toString());
    				
    				//storing the object and string from MyFiles class to device hd
    				MyFiles.storeObject(_context, "history", _history, false);
    				MyFiles.storeString(_context, "temp", results.toString(), true);
    			}
    		}
    		catch(JSONException e)
    		{
    			Log.e("JSON", "JSON OBJECT EXCEPTION");
    		}
    		
    	}
    }
}


