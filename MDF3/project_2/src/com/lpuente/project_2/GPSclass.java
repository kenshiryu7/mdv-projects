package com.lpuente.project_2;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class GPSclass extends Service implements LocationListener{

	private final Context _context;
	
	//GSP status bool
	boolean isGPSon = false;
	
	//Network status bool
	boolean isNetworkOn = false;
	
	//location get bool
	boolean canGetLoc = false;
	
	//location, long and lat. Works with double
	Location location;
	double latitude;
	double longitude;
	
	//Minimum distance for update change. In meters
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 5;
	
	//Minimum time for updates milliseconds. Using multiplication helps see the minutes easier
	//this case 1 minute
	private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;
	
	//Location manager
	protected LocationManager locationManager;
	
	public GPSclass(Context context) {
		this._context = context;
		getLocation();
	}
	
	
	public Location getLocation(){
		
		try
		{
			//loc man object/instant...
			locationManager = (LocationManager) _context.getSystemService(LOCATION_SERVICE);
			
			//GPS status
			isGPSon = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
			
			//Network status
			isNetworkOn =  locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
			
			//condition to see if GPS is provided/ON
			if(!isGPSon && !isNetworkOn)
			{
				//no provider enabled
			}
			else
			{
				this.canGetLoc = true;
				
				//network prov. location
				if(isNetworkOn)
				{
					locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 
							MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
					
					//Log out
					Log.d("Network", "Network");
					
					if(locationManager != null)
					{
						location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						
						//condition to get lat and long if not null
						if(location != null)
						{
							latitude = location.getLatitude();
							longitude = location.getLongitude();
						}
					}
				}
				
				//So if and when the GPS is enabled. similar to above
				if(isGPSon)
				{
					if(location == null)
					{
						locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES,
								MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
						
						//Log out
						Log.d("GPS Enabled", "GPS Enabled");
						
						if(locationManager !=null)
						{
							location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							
							//getting lat and long for gps
							if(location != null)
							{
								latitude = location.getLatitude();
								longitude = location.getLongitude();
							}
						}
					}
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return location;
	}
	
//methods created for stopping Gps, getting lat and long, getting location
	
	//stop gps
	public void stopGPS(){
		if(locationManager != null)
		{
			locationManager.removeUpdates(GPSclass.this);
		}
	}
	
	//getting lat
	public double getLatitude(){
		if(location != null)
		{
			latitude = location.getLatitude();
		}
		return latitude;
	}
	
	//getting long
	public double getLongitude(){
		if(location != null)
		{
			longitude = location.getLongitude();
		}
		return longitude;
	}
	
	//gps enabled
	public boolean canGetLocation(){
		return this.canGetLoc;
	}
	
	//Thought this was cool. Allowing an alert to pop up that will lead you to make changes in settings if needed
	
	public void showSetting(){
		AlertDialog.Builder alert = new AlertDialog.Builder(_context);
		
		//title
		alert.setTitle("GPS settings");
		
		//message
		alert.setMessage("GPS is not on. Go to settings Menu?");
		
		//when pressing settings button
		alert.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				//sending you to the settings menu by intent
				Intent intent =  new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				_context.startActivity(intent);
			}
		});
		
		//pressing the cancel button
		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				//canceling the alert box
				dialog.cancel();
			}
		});
		
		//show alert
		alert.show();
	}
	
	
//methods for location listener//	
	
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
