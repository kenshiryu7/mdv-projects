package com.lpuente.pack_Lib;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class WebData {


	//holder values / accessible outside of class
	
	static Boolean _connection = false;
	static String _connType = "Unavailable";
	
//function to call connection service and type function and return the connection type
	public static String getConnectType(Context context)
	{
		onlineInfo(context);	//connection service and type function
		return _connType;		//connection type value
	}

//Function to return Boolean. Is connected? In other words connection status
	public static Boolean getConnectStatus(Context context)
	{
		onlineInfo(context);	//connection service and type function
		return _connection;		//boolean value
	}
	
	
//function to allow if there is connection service and Type.
	private static void onlineInfo(Context context)
	{
		//connectivity manager object
		ConnectivityManager connMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		//Network info object / check to see if network is already active
		NetworkInfo  netInfo = connMan.getActiveNetworkInfo();
		
		//check to make sure network activity is not null. 
		if(netInfo != null)
		{
			//make sure if connected
			if(netInfo.isConnected())
			{
			//getting connection type by string "name"
				_connType = netInfo.getTypeName();
				_connection = true;
			}
			else
			{
				
				Log.e("UH-OH", "NO NETWORK DETECTED");
				
				//ATTEMPT TO PROMPT THE USER THAT THERE IS NO CONNECTION WITH ALERT DIALOG
				
				AlertDialog.Builder adBuilder = new AlertDialog.Builder(context); //creating alert dialog
				adBuilder.setTitle("No Network Detected.");			//Setting Title to alert dialog box
				adBuilder.setMessage("");							//setting a message. Leaving blank for this alert.
				
				adBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						//not sure if null is right here. 
						Toast.makeText(null, "You clicked Ok. Just testing!", Toast.LENGTH_SHORT).show();
					}
				});
			}
		}
	}
	
//getting response from a URL as a string
	public static String getURLResponse(URL url)
	{
		//String response set to empty 
		String response = "";
		
		//try catch statement to try and grab URL
		try{
			URLConnection urlConn = url.openConnection();	//opens connection to a server
			
			//Calling buffered input stream. May need a better explanation on this. 
			BufferedInputStream bin = new BufferedInputStream(urlConn.getInputStream());
			
			//why 1024 bytes?
			byte[] contentBytes = new byte[1024];
			
			//will loop through bytes
			int bytesRead = 0;
			
			//String buffer holds Data as comes in / new object
			StringBuffer responseBuffer = new StringBuffer();
			
			//while loop to count bytes read as they count up
			while((bytesRead = bin.read(contentBytes)) != -1)
			{
				//getting response placed in "response" string variable and appending it to response buffer which is a stringBuffer
				response = new String(contentBytes, 0, bytesRead);
				responseBuffer.append(response);
			}
			
			//returning response buffer and converting to string
			return responseBuffer.toString();
		} 
			catch(Exception e)
		{
				//logging out an error if running into problems
			Log.e("URL RESPONSE ERROR", "getURLResponse");
		}
		
		return response;
	}
	
}
