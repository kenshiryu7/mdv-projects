package com.example.quickapp;



//import android.app.Activity;




import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class StaticListView extends ListActivity {

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //setContentView(R.layout.activity_main);	//before firstfrag
	        setContentView(R.layout.static_frag);
	        
	        //this was suggested to me but not using.
	        //String[] contactsArray = getResources().getStringArray(R.array.contacts);
	        
	      //setting list adapter (adapting data to display in listview) from contacts resource
	        setListAdapter(new ListAdapter(this, android.R.layout.simple_list_item_1, R.id.list_name, getResources().getStringArray(R.array.contacts)));
	        
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
			 TextView textV = (TextView) row.findViewById(R.id.list_name);		//full name for row
			 TextView pNum = (TextView) row.findViewById(R.id.phoneText);		//phone number for row

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
			 else if(items[position].equals("Thor"))
			 {
				 imageV.setImageResource(R.drawable.thor);
			 }
			 else if(items[position].equals("Hulk"))
			 {
				 imageV.setImageResource(R.drawable.the_hulk);
			 }

			 //logging items position
			 Log.d("Luis", items[position]);

			 //returning all data passed into "row"


			 return row;
		 }

	 }

	    protected void onListItemClick(ListView lv, View v, int position, long id)
	    {
	    	super.onListItemClick(lv, v, position, id);
	    	
	    	//String details = lv.getItemAtPosition(position).toString();
	    	
	    	//creating local variables. YES i realize this repeats but I just want this TO WORK!
	    	//ImageView imageV = (ImageView) findViewById(R.id.list_image);	//image 
			TextView textV = (TextView) lv.findViewById(R.id.list_name);		//full name 
			TextView pNum = (TextView) lv.findViewById(R.id.phoneText);		//phone number 
			
			
	    	
			//Creating intent to pass data/open new activity
	    	Intent exIntent = new Intent(StaticListView.this, DetailsView.class);
	    	
	    	exIntent.putExtra("fullname", textV.getText().toString());
	    	exIntent.putExtra("fullphone", pNum.getText().toString());
	    	
	    	//trying something for the image
	    			Uri imageUri = exIntent.getData();
	    			exIntent.setData(imageUri);
	    			
	    			
	    	//startActivity(exIntent);
	    	startActivity(exIntent);
	    	
	    	//logging position 
	    	Log.d("Position.Log",String.valueOf(position));
	    	Log.d("Item", String.valueOf(lv.getPositionForView(v)));
	    	
	    	
	    }


}
