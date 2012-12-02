package com.lpuente.java2_w3;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends ListActivity implements FirstFrag.FirstInterface{

	//may need to create string array to hold pieces within listview
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);	//before firstfrag
        setContentView(R.layout.activity_main);
        
        //setting list adapter (adapting data to display in listview) from contacts resource
        setListAdapter(new ListAdapter(this, android.R.layout.simple_list_item_1, R.id.list_name, getResources().getStringArray(R.array.contacts)));
        
    }

    protected void onListItemClick(ListView lv, View v, int position, long id)
    {
    	super.onListItemClick(lv, v, position, id);
    	
    	Intent exIntent = new Intent(MainActivity.this, AddView.class);
    	startActivity(exIntent);
    	/*
    	try {
			Class details = Class.forName("com.lpuente.java2_w3." + "SelectedContact");
			
			Intent selectedItem = new Intent(this, details);
			
			startActivity(selectedItem);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    }
    
//This menu onCreate was here from the beginning
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    //Creating Inner class. May rearrange this later into separate file. Just going with this for now
    private class ListAdapter extends ArrayAdapter<String> {

		public ListAdapter(Context context, int resource,
				int textViewResourceId, String[] strings) {
			super(context, resource, textViewResourceId, strings);
			// TODO Auto-generated constructor stub
		}
    	
	//This is called for every row in the list. Able to modify here.
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			//getting layout inflater system service
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			//getting inflated layout/ representing a single row 
			View row = inflater.inflate(R.layout.list_item, parent, false);
			
		//getting resources for row from list item.xml layout. THIS IS STATIC
			String[] items = getResources().getStringArray(R.array.contacts);
		//getting resources for phone numbers for the first 3 list items. THIS IS STATIC
			String[] phoneItems = getResources().getStringArray(R.array.phone_numbers);
			
			ImageView imageV = (ImageView) row.findViewById(R.id.list_image);	//image for row
			TextView textV = (TextView) row.findViewById(R.id.list_name);		//text for row
			TextView pNum = (TextView) row.findViewById(R.id.phoneText);
			
		//setting the correct text from the String xml with "position"
			textV.setText(items[position]);
		//setting the correct STATIC phone numbers from string array
			pNum.setText(phoneItems[position]);
			
			//using a conditional to place proper image by string name
			if(items[position].equals("Captain America"))
			{
				imageV.setImageResource(R.drawable.captain_america);
			}
			else if(items[position].equals("Iron Man"))
			{
				imageV.setImageResource(R.drawable.iron_man);
			}
			else if(items[position].equals("Spider-Man"))
			{
				imageV.setImageResource(R.drawable.spider_man);
			}
			
			//returning all data passed into "row"
			return row;
		}
    }

   


//Implementation from fragment

	@Override
	public void onAdd() {
		
		//Calling the intent to move into SecondView Activity
		 Intent exIntent = new Intent(MainActivity.this, AddView.class);
		 
		//method to start the activity when the button is pressed
			startActivity(exIntent);
	}
    
}
