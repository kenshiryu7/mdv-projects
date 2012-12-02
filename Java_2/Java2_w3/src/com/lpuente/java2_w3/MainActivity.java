package com.lpuente.java2_w3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
//import android.app.Activity;
import android.app.ListActivity;
//import android.view.Menu;
import android.content.Context;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //setting list adapter (adapting data to display in listview) from contacts resource
        setListAdapter(new ListAdapter(this, android.R.layout.simple_list_item_1, R.id.list_text, getResources().getStringArray(R.array.contacts)));
        
    }

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
			
			//getting layout inflator system service
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			//getting inflated layout/ represnting a single row 
			View row = inflater.inflate(R.layout.list_item, parent, false);
			
			//getting resources for row from list item.xml layout. THIS IS STATIC
			String[] items = getResources().getStringArray(R.array.contacts);
			
			ImageView imageV = (ImageView) row.findViewById(R.id.list_image);	//image for row
			TextView textV = (TextView) row.findViewById(R.id.list_text);		//text for row
			
			//setting the correct text from the String xml with "position"
			textV.setText(items[position]);
			
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
   
    
}
