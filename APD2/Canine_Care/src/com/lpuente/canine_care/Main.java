package com.lpuente.canine_care;

//import java.util.List;



import android.os.Bundle;

//import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class Main extends ListActivity {
	
	private final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_lay);
        
        //Stopping the service/music when opening this activity
        stopService(new Intent(getBaseContext(), MusicService.class));
      
       //setting list adapter for list view with array adapter of items. toxins.xml in values
       //array of strings 
        //MyAdapter is an adapter made with an inner class below
        
        setListAdapter(new MyAdapter(this, android.R.layout.simple_list_item_1, R.id.list_name, 
        		getResources().getStringArray(R.array.toxins)));
        
       
    }

    
/////////////////////////////////////////////////////////////////////////////////////////////////////////    
  //inner adapter class used above for listview
    private class MyAdapter extends ArrayAdapter<String>{
    
    
		public MyAdapter(Context context, int resource, int textViewResourceId,
				String[] strings) {
    		super(context, resource, textViewResourceId, strings);
			// TODO Auto-generated constructor stub
		}
	
		//called for every row to display correct image
		@Override
		public View getView(int position, View convertView, ViewGroup parent){
			
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			//single row
			View row = inflater.inflate(R.layout.list_item, parent, false);
			
			//string array
			String[] items = getResources().getStringArray(R.array.toxins);
			
			//refs to images view and text view
			ImageView  img = (ImageView) row.findViewById(R.id.list_image);
			TextView toxName = (TextView) row.findViewById(R.id.list_name);
			
			//setting text of list
			toxName.setText(items[position]);
			
			//IF statements for images 
			//by clicking item with equal String name
			
			if(items[position].equals("Chocolate"))
			{
				img.setImageResource(R.drawable.choco);
			}
			else if(items[position].equals("Onions"))
			{
				img.setImageResource(R.drawable.onions);
			}
			else if(items[position].equals("Grapes and Raisons"))
			{
				img.setImageResource(R.drawable.grapes);
			}
			else if(items[position].equals("Coffee"))
			{
				img.setImageResource(R.drawable.coffee);
			}
			else if(items[position].equals("Macadamia Nuts"))
			{
				img.setImageResource(R.drawable.mnuts);
			}
			else if(items[position].equals("Azalea Plant"))
			{
				img.setImageResource(R.drawable.azalea);
			}
			else if(items[position].equals("Crocus Plant"))
			{
				img.setImageResource(R.drawable.crocus);
			}
			else if(items[position].equals("Foxglove Plant"))
			{
				img.setImageResource(R.drawable.foxglove);
			}
			else if(items[position].equals("Juniper Plant"))
			{
				img.setImageResource(R.drawable.juniper);
			}
			else if(items[position].equals("Mistletoe Plant"))
			{
				img.setImageResource(R.drawable.mistletoe);
			}
			else if(items[position].equals("Ethylene Glycol"))
			{
				img.setImageResource(R.drawable.afreeze);
			}
			else if(items[position].equals("Rat Poison"))
			{
				img.setImageResource(R.drawable.ratpoison);
			}
			else if(items[position].equals("Snail Bait"))
			{
				img.setImageResource(R.drawable.snailbait);
			}
			
			
			//returns list item variable from list_item.xml
			return row;
		}
		
    }
    
   
    //method for when item in the listview is clicked

    protected void onListItemClick(ListView lv, View v, int position, long id)
    {
    	super.onListItemClick(lv, v, position, id);
    	
    	
    	//String element = lv.getItemAtPosition(position).toString();
    	
    	//passing texts from list names collected in the listview. Must be with the View not the ListView.
    	//in other words. v NOT lv.
		TextView tnames = (TextView) v.findViewById(R.id.list_name);		//toxic name 
		
		
		//trying images stuff. Need help
		//ImageView  imgs = (ImageView) v.findViewById(R.id.list_image);
		
		
		
    	
		//to Details. Intent
    	Intent detInt = new Intent(Main.this, Details.class);
    	
    	//passing text of list
    	detInt.putExtra("elements", tnames.getText().toString()); //same as below. Leaving both just in case
    	//detInt.putExtra("elements", element);
    
    	detInt.putExtra("int", position);
    			
    			
    	//startActivity(exIntent);
    	startActivity(detInt);
    	
    	//logging position 
    	//Log.d("Position.Log",String.valueOf(position));
    	//Log.d("Item", String.valueOf(lv.getPositionForView(v)));
    	Log.d("TEST",String.valueOf(position));
    	
    }

    
    
    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    


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
			
			//Intent mainInt = new Intent(Main.this, Main.class);
			//startActivity(mainInt);
			
			return true;
			
		//intent to Map
		case R.id.item2:
			Log.i(TAG, "item 2 CLICKED");
			
			Intent mapInt = new Intent(Main.this, Map_Class.class);
			startActivity(mapInt);
			
			return true;
			
		//intent to Videos
		case R.id.item3:
			Log.i(TAG, "item 3 CLICKED");
			
			Intent vidInt = new Intent(Main.this, Videos.class);
			startActivity(vidInt);
			
			
			return true;
			
		//intent to dev info first Splash screen
		case R.id.item4:
			Log.i(TAG, "item 4 CLICKED");
			
			Intent devInt = new Intent(Main.this, Dev_Splash.class);
			startActivity(devInt);
			
			return true;
			
			//map legal notices
		case R.id.item5:
			Log.i(TAG, "item 5 CLICKED");
			
			Intent mapIn = new Intent(Main.this, LegalNotices.class);
			
			startActivity(mapIn);
			
			return true;
			
		case R.id.item6:
			Log.i(TAG, "item 6 CLICKED");
			
			Intent sponsor = new Intent(Main.this, Sponsors.class);
			
			startActivity(sponsor);
			
			return true;
			
		case R.id.item7:
			Log.i(TAG, "item 7 CLICKED");
			
			Intent tSearch = new Intent(Main.this, TwitterSearch.class);
			
			startActivity(tSearch);
			
			return true;
			
			default: return super.onOptionsItemSelected(item);
		}
	}
	
	
	
	
	
	
	
    
}
