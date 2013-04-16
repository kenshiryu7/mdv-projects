package com.lpuente.canine_care;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlaceJSONParser {
	
	//Receives JSON and returns a list
	
	public List<HashMap<String, String>> parse(JSONObject jObject){
		
		JSONArray jPlaces = null;
		
		try
		{
			//retrieves all elements in places array
			jPlaces = jObject.getJSONArray("results");
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		return getPlaces(jPlaces);
	}
	
	//getPlaces
	
	private List<HashMap<String, String>> getPlaces(JSONArray jPlaces){
		
		int placesCount = jPlaces.length();
		
		List<HashMap<String, String>> placesList = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> place = null;
		
		//parsing each place and adds to list with loops
		for(int i = 0; i<placesCount; i++)
		{
			try
			{
				//call getPlace with json obj to parse
				place = getPlace((JSONObject)jPlaces.get(i));
				placesList.add(place);
			}
			catch(JSONException e)
			{
				e.printStackTrace();
			}
		}
		return placesList;
	}
	
	//getPlace //parsing place json obj

	private HashMap<String, String> getPlace(JSONObject jPlace){
		
		HashMap<String, String> place = new HashMap<String, String>();
		
		String placeName = "-NA-";
		String vicinity = "-NA-";
		String latitude = "";
		String longitude = "";
		
		try
		{
			//getting place name if available
			if(!jPlace.isNull("name"))
			{
				placeName = jPlace.getString("name");
			}
			
			//getting vicinity if available
			if(!jPlace.isNull("vicinity"))
			{
				vicinity = jPlace.getString("vicinity");
			}
			
			latitude = jPlace.getJSONObject("geometry").getJSONObject("location").getString("lat");
			longitude = jPlace.getJSONObject("geometry").getJSONObject("location").getString("lng");
			
			place.put("place_name", placeName);
			place.put("vicinity", vicinity);
			place.put("lat", latitude);
			place.put("lng", longitude);
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		return place;
	}
}
