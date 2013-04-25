package com.lpuente.canine_care;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
//import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



//import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Map_Class extends FragmentActivity implements LocationListener{

	private final String TAG = "Map Activity";
	
	//google map
	GoogleMap gMap;
	
	//spinner 1
	Spinner mSprPlaceType;
	//spinner 2
	Spinner mapType;
	
	String[] mPlaceType = null;
	String[] mPlaceTypeName = null;
	
	String[] maps = null;
	
	double mLatitude = 0;
	double mLongitude = 0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_lay);
		
		  //Stopping the service/music when opening this activity
        stopService(new Intent(getBaseContext(), MusicService.class));
        
		//array of place types
		mPlaceType = getResources().getStringArray(R.array.place_type);
		
		//array of place type NAMES
		mPlaceTypeName = getResources().getStringArray(R.array.place_type_name);
		
		//Creating array adapter with place type names for spinner
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mPlaceTypeName);
		
		//Spinner Reference
		mSprPlaceType = (Spinner) findViewById(R.id.spr_place_type);
		
		//setting adapter for spinner
		mSprPlaceType.setAdapter(adapter);
		
		
		//Button id
		Button btnFind = (Button) findViewById(R.id.btn_find);
		
	//second spinner Map options stuff./////////////
		
		maps = getResources().getStringArray(R.array.map_opts);
		
		ArrayAdapter<String> adapter_map = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, maps);
		
		mapType = (Spinner) findViewById(R.id.map_views);
		
		mapType.setAdapter(adapter_map);
		//
	//button OK 
		Button okButt = (Button) findViewById(R.id.ok);
		
		okButt.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void onClick(View v) {
				int selectedPosition = mapType.getSelectedItemPosition();
				String type = maps[selectedPosition];
				
			//Normal Map
				if(type.equals("Normal"))
				{
					gMap.setMapType(gMap.MAP_TYPE_NORMAL);
					Log.i("PRESSED OK", "N");
				}
			//Satellite Map
				else if(type.equals("Satellite"))
				{
					gMap.setMapType(gMap.MAP_TYPE_SATELLITE);
					Log.i("PRESSED OK", "S");
				}
			//Hybrid Map
				else if(type.equals("Hybrid"))
				{
					gMap.setMapType(gMap.MAP_TYPE_HYBRID);
					Log.i("PRESSED OK", "H");
				}
			//Terrain Map
				else if(type.equals("Terrain"))
				{
					gMap.setMapType(gMap.MAP_TYPE_TERRAIN);
					Log.i("PRESSED OK", "T");
				}
			}
		});
		
		//Google play availability status
		int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
		
		//if Google services not available
		if(status != ConnectionResult.SUCCESS)
		{
			int requestCode = 10;
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
			dialog.show();
		}
		//google play services available
		else
		{
			//Reference to map fragment
			SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);	
			
			//getting google map
			gMap = fragment.getMap();
			
			//enabling my/user location in map
			gMap.setMyLocationEnabled(true);
			
			//getting location manager object
			LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
			
			//Criteria object to retrieve provider
			Criteria criteria = new Criteria();
			
			//Getting best provider
			String provider = locationManager.getBestProvider(criteria, true);
			
			//current location from GPS
			Location location = locationManager.getLastKnownLocation(provider);
			
			if(location != null)
			{
				onLocationChanged(location);
			}
			
			locationManager.requestLocationUpdates(provider, 2000, 0, this);
			
		//Listener for FIND button
			btnFind.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					int selectedPosition = mSprPlaceType.getSelectedItemPosition();
					String type = mPlaceType[selectedPosition];
					
					StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
					sb.append("location=" +mLatitude + "," + mLongitude);
					sb.append("&radius=5000");
					sb.append("&types=" + type);
					sb.append("&sensor=true");
					//sb.append("&key=AIzaSyA4N1omWJuTUGFqGyohHaS4cufNiOUyE4Y");
					sb.append("AIzaSyBMBp9zZn3k1bIzsNnv7iF-8XCUXKYddr4");

					
					//new non-ui thread/ downlaod json data
					PlacesTask tasks = new PlacesTask(); 
					
					//invokes doing in background method within place task
					tasks.execute(sb.toString());
					
					//logging to see which spinner item/type is selected and pressed "FIND"
					Log.i("PRESSED FIND", sb.toString());
				}
			});
			
		}
}
	

	//private method to get json from url
	private String downloadUrl(String strUrl) throws IOException{
		
		String data = "";
		InputStream iStream = null;
		HttpURLConnection urlConnection = null;
		
		try
		{
			URL url = new URL(strUrl);
			
			//http to communicate with url
			urlConnection = (HttpURLConnection) url.openConnection();
			
			//connect to url
			urlConnection.connect();
			
			//reading data from url
			iStream = urlConnection.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
			
			StringBuffer sb = new StringBuffer();
			
			String line = "";
			while((line = br.readLine()) != null)
			{
				sb.append(line);
			}
			
			data = sb.toString();
			
			br.close();
		}
		catch(Exception e)
		{
			Log.d("EXCEPTION WHILE DLing URL", e.toString());
		}
		finally
		{
			iStream.close();
			urlConnection.disconnect();
		}
		
		return data;
	}

	
	////////////
	//Inner CLASS to get GOOGLE PLACES STUFF/////////////////////////////
	
	private class PlacesTask extends AsyncTask<String, Integer, String>{
		
		String data = null;
		
		//invoked by execute() of this object
		@Override
		protected String doInBackground(String... url){
			try
			{
				data = downloadUrl(url[0]);
			}
			catch(Exception e)
			{
				Log.d("BACKGROUND TASK", e.toString());
			}
			return data;
		}
		
		//executes after the completeion of doinbackground
		@Override
		protected void onPostExecute(String result){
			ParserTask parserTask = new ParserTask();
			
			//Start parsing google places
			//do doinbacground method
			parserTask.execute(result);
		}
	}
	
	//another inner class to parse GOOGLE PLACES IN JSON format
	private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String,String>>>{
		
		JSONObject jObject;
		
		@Override
		protected List<HashMap<String, String>> doInBackground(String... jsonData){
			
			List<HashMap<String, String>> places = null;
			PlaceJSONParser placeJsonParser = new PlaceJSONParser();
			
			try
			{
				jObject = new JSONObject(jsonData[0]);
				
				//getting the parsed data as a list construct
				places = placeJsonParser.parse(jObject);
			}
			catch(Exception e)
			{
				Log.d("EXCEPTION", e.toString());
			}
			return places;
		}
		
		
		
		//EXECUTED AFTER the complete execution of do in background method
		@Override
		protected void onPostExecute(List<HashMap<String, String>> list){
			
			//clears all existing markers
			gMap.clear();
			
			for(int i = 0; i < list.size(); i++)
			{
				//creating a marker
				MarkerOptions markerOptions = new MarkerOptions();
				
				//getting a place from the places list
				HashMap<String, String> hmPlace = list.get(i);
				
				//getting latitude and longitude of the place
				double lat = Double.parseDouble(hmPlace.get("lat"));
				double lng = Double.parseDouble(hmPlace.get("lng"));
				
				//getting name and vicinity
				String name = hmPlace.get("place_name");
				String vicinity = hmPlace.get("vicinity");
				
				LatLng latLng = new LatLng(lat, lng);
				
				
				//setting position of the marker
				markerOptions.position(latLng);
				
				//setting the title for the marker
				//title to be displayed 
				markerOptions.title(name + " : " + vicinity);
				
				//placing a marker on the touched position
				gMap.addMarker(markerOptions);
				
				Log.i("MARKER NAMES", name + "...and..." +  vicinity);
				
			}
		}
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
				
				Intent devInt = new Intent(Map_Class.this, Dev_Splash.class);
				startActivity(devInt);
				
				return true;
			case R.id.item5:
				Log.i(TAG, "item 5 CLICKED");
				
				Intent mapIn = new Intent(Map_Class.this, LegalNotices.class);
				
				startActivity(mapIn);
				
				return true;
			case R.id.item6:
				Log.i(TAG, "item 6 CLICKED");
				
				Intent sponsor = new Intent(Map_Class.this, Sponsors.class);
				
				startActivity(sponsor);
				
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