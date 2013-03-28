package com.lpuente.testing_mapv2;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.Toast;

public class Main extends Activity implements LocationListener{

	private GoogleMap gMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//check google play status method
		if(isGooglePlay())
		{
			//sets content view if success
			setContentView(R.layout.main_lay);
			setupMap();
		}
		
		
	}
	
	
////////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		
		if(item.getItemId() == R.id.action_LegalNotices)
		{
			Intent i = new Intent(Main.this, LegalNotices.class);
			
			startActivity(i);
		}
		return super .onOptionsItemSelected(item);
	}
//////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
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

	////// all methods for location listener////////////////////////////////////////
	///////
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
