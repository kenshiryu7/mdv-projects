package com.lpuente.canine_care;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.model.LatLng;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Map_Class extends Activity implements LocationListener{

	private final String TAG = "Map Activity";
	
	//google map
	private GoogleMap gMap;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//check google play status method
		if(isGooglePlay())
		{
			//sets content view if success
			setContentView(R.layout.map_lay);
			setupMap();
		}
		
		
}
	

	//checking for google play
		private boolean isGooglePlay(){
			
			int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
			
			if(status == ConnectionResult.SUCCESS)
			{
				return true;
			}
			else
			{
				//sends alert and link to download google play services
				((Dialog) GooglePlayServicesUtil.getErrorDialog(status, this, 10)).show();
				
				//toast version
				//Toast.makeText(this, "Google Play is not available", Toast.LENGTH_LONG).show();
			}
			return (false);
		}
		
		
		private void setupMap(){
			
			if(gMap == null)
			{
				//getting map fragment by id. map
				gMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
				
				//if there is a map
				if(gMap != null)
				{
					//add code to initialize the map
					//setup for my location
					gMap.setMyLocationEnabled(true);
					
					LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
					
					String provider = lm.getBestProvider(new Criteria(), true);
					
					if(provider == null)
					{
						onProviderDisabled(provider);
					}
					
					Location loc = lm.getLastKnownLocation(provider);
					if(loc != null)
					{
						onLocationChanged(loc);
					}
					
					gMap.setOnMapLongClickListener(onLongClickMapSettings());
				}
			}
		}
		
		private OnMapLongClickListener onLongClickMapSettings() {
			
			
			
			return new OnMapLongClickListener(){
				
				@Override
				public void onMapLongClick(LatLng arg0){
					//long clicked log. works
					Log.i(arg0.toString(), "USER LONG CLICKED");
				}
			};
		}
	        


	   
	 //Menu / Action Bar Stuff
		@Override
		public boolean onCreateOptionsMenu(Menu menu){
			getMenuInflater().inflate(R.menu.main_menu, menu);
			return true;
		}
		
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item)
		{
			
			//Add intents to each case statement to switch activity.
			
			switch(item.getItemId())
			{
			
			//intent to List View
			case R.id.item1:
				Log.i(TAG, "item 1 CLICKED");
				
				Intent mainInt = new Intent(Map_Class.this, Main.class);
				startActivity(mainInt);
				
				
				return true;
				
			//intent to Map
			case R.id.item2:
				Log.i(TAG, "item 2 CLICKED");
				
				//Intent mapInt = new Intent(Map_Class.this, Map_Class.class);
				//startActivity(mapInt);
				
				return true;
				
			//intent to Videos
			case R.id.item3:
				Log.i(TAG, "item 3 CLICKED");
				
				Intent vidInt = new Intent(Map_Class.this, Videos.class);
				startActivity(vidInt);
				
				
				return true;
				
			//intent to dev info
			case R.id.item4:
				Log.i(TAG, "item 4 CLICKED");
				
				Intent devInt = new Intent(Map_Class.this, Dev_Info.class);
				startActivity(devInt);
				
				return true;
			case R.id.item5:
				Log.i(TAG, "item 5 CLICKED");
				
				
				
				return true;
			case R.id.item6:
				Log.i(TAG, "item 6 CLICKED");
				
				
				
				return true;
			case R.id.item7:
				Log.i(TAG, "item 7 CLICKED");
				
				
				
				return true;
				
				default: return super.onOptionsItemSelected(item);
			}
		}

		
		
		
		
		
		//location listener methods

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			
			//getting lat long
			LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
			
			//moving to location on map
			gMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
			//zoom to current location. int is to level of zoom
			gMap.animateCamera(CameraUpdateFactory.zoomTo(12));
			
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
		
}