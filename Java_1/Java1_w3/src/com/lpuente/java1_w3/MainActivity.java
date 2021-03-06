package com.lpuente.java1_w3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import java.util.ArrayList;

import com.lpuente.pack1.FormingStuff;
import com.lpuente.pack2.InterfacCLASS;
import com.lpuente.pack2.LiquidConv;
import com.lpuente.pack2.J2Product;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

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
	
	TextView _result;
	
	RadioGroup fishTankOpts;
	ArrayList<J2Product> fishtanks;
	
	//testing this image view
	
	//ImageView image;

	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        	
        //setting global variables / instantiating
        	_context = this;
        	_appLo = new LinearLayout(this);
        	LayoutParams linParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            _appLo.setLayoutParams(linParam);
            _appLo.setOrientation(LinearLayout.VERTICAL);
            
        	_history = getHistory();
        	
        	
        	//image = (ImageView) findViewById(R.id.imageView1);
        	
        	//calling linlay from pack1 package FormingStuff class passing in arguments
            LinearLayout entBox = FormingStuff.entryButton(this, "Ex. 54.67", "Tank dif", " Convert ");
            
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
    				
    				
    				_result.setText(
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
    				
    				
    				_result.setText(
    						"Gallon: " + returndata.get(LiquidConv.GALLON) + "\r\n" +
    						"Quart: " + returndata.get(LiquidConv.QUART) + "\r\n" +
    						"Pint: " + returndata.get(LiquidConv.PINT) + "\r\n" +
    						"Cup: " + returndata.get(LiquidConv.CUP) + "\r\n" +
    						"Ounce: " + returndata.get(LiquidConv.OUNCE) 
    						);
    			}
    		});
            
            
          //define new array list for j2Product interface /InterfaceCLASS / make sure class and interface are imported
            fishtanks = new ArrayList<J2Product>();
            fishtanks.add(new InterfacCLASS("Shark Tank", 100000));
            //fishtanks.add(new InterfacCLASS("Marlins St. Fish Tank", 5000));
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
            
        	//logging out history which is not equal to getHistory() method
        	Log.i("HISTORY READ", _history.toString());
        
//Calling Search Data class and context and setting to (this) or (_context) both work
        	_findField = new SearchData(this, "Type Stock Symbol Here", "View Info");
        	
        	
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
     
        	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //adding findField from Search Data class to the main activity layout
        //adding _datas from DataDisplay class to main
        //adding _myfavs for MyFavorites class to main
        	_appLo.addView(_findField);
        	//_appLo.addView(_datas);
        	
        	_appLo.addView(entBox);
            
            _appLo.addView(fishTankOpts);
            
            _result = new TextView(this);
        	
            _appLo.addView(_result);
        	
        	_appLo.addView(_myfavs);
        	
        	
        	    	
        //setting layout to vertical display for grid layout
        	_appLo.setOrientation(LinearLayout.VERTICAL);
        	
        //setting content view to the new linear layout global variable used.
        setContentView(_appLo);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    			JSONObject jsonResults = jsonData.getJSONObject("query").getJSONObject("results").getJSONObject("row");
    			
    			if(jsonResults.getString("col1").compareTo("N/A") == 0)
    			{
    			//Toast is a pop-up box in android. What other edible objects will we learn?
    				Toast toasty = Toast.makeText(_context, "Invalid Symbol", Toast.LENGTH_SHORT);
    				toasty.show();
    			}
    			else
    			{
    			//Else Symbol is Valid...
    				Toast toasty = Toast.makeText(_context, "Valid Symbol " + jsonResults.getString("symbol"), Toast.LENGTH_SHORT);
    				toasty.show();
    				
    			//using the hashmap to store JSON object results converted to string ready to write to hard drive
    				_history.put(jsonResults.getString("symbol"), jsonResults.toString());
    				
    				//storing the object and string from MyFiles class to device hd
    				MyFiles.storeObject(_context, "history", _history, false);
    				MyFiles.storeString(_context, "temp", jsonResults.toString(), true);
    			}
    		}
    		catch(JSONException e)
    		{
    			Log.e("JSON", "JSON OBJECT EXCEPTION");
    		}
    		
    	}
    }
}


