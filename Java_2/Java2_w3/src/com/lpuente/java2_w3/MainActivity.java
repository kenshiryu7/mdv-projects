package com.lpuente.java2_w3;





import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockListActivity;

//import org.w3c.dom.Text;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends SherlockListActivity implements FirstFrag.FirstInterface, AddFrag.AddInterface{
	
	//member variables
	
	ArrayList<String> mylist = new ArrayList<String>();
	
//string to adapter which should handle the data for listview
	ArrayAdapter<String> adapter;
	
	

	//may need to create string array to hold pieces within listview
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);	//before firstfrag
        setContentView(R.layout.firstfrag);
        
        //this was suggested to me but not using.
       String[] contactsArray = getResources().getStringArray(R.array.contacts);
       
       
       mylist = new ArrayList<String>();
       adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylist);
        
        //setting list adapter (adapting data to display in listview) from contacts resource
        //setListAdapter(new ListAdapter(this, android.R.layout.simple_list_item_1, R.id.list_name, getResources().getStringArray(R.array.contacts)));
        
        setListAdapter(adapter);
    }

    
    
    
    
  //method to collect data from AddView to place in the ListAdapter  
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    //ViewGroup variable. Not sure if this will work
    	ViewGroup parent = null;
    	
    //Instantiating Layout Inflater
    	LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	
    //Adding the View (the way Josh recommended)
    	LinearLayout added = (LinearLayout) inflater.inflate(R.layout.list_item, parent, false);
    	
    	
    //getting data from AddView
    	String fname = data.getExtras().getString("firstName");		//key for first name
    	String lastname = data.getExtras().getString("lastName");	//key for last name
    	
    	String phone1 = data.getExtras().getString("phoneNum");		// these are
    	String phone2 = data.getExtras().getString("phoneNum2");		// the keys for all
    	String phone3 = data.getExtras().getString("phoneNum3");		// 3 inputs to total the phone number
    	
    	
    	String nameComplete = fname + "  " + lastname;
    //will add data for image here later if there's time
    	//
    	//
    	//
    	
    //Text Views of the list_item view
    	TextView fullname = (TextView) added.findViewById(R.id.list_name);	//the text view for the full name
    	TextView phoneTotal =  (TextView) added.findViewById(R.id.phoneText);	//the text view for the complete phone number
    	
    //Setting the text views of the view
    	fullname.setText(fname + " " + lastname);
    	phoneTotal.setText("1" + "(" + phone1 + ")" + phone2 + "-" + phone3);
    	
    //adds the layout to the list adapter
    	//getListAdapter().add(added);
    		//or
    	//ListAdapter.getListAdapter.add(added);
    	
    	
    	//All this is being added to a new list adapter. Completely different from before. Wont load details view now.
    	//right now only passes from one edit Text.class first name
    	
    	mylist.add(nameComplete);
    	
    
    	adapter.notifyDataSetChanged();
    	//WHAT AM I DOING WRONG??
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
    	
    	String details = lv.getItemAtPosition(position).toString();
    	
    	//creating local variables. YES i realize this repeats but I just want this TO WORK!
    	//ImageView imageV = (ImageView) findViewById(R.id.list_image);	//image 
		TextView textV = (TextView) lv.findViewById(R.id.list_name);		//full name 
		TextView pNum = (TextView) lv.findViewById(R.id.phoneText);		//phone number 
		
		
    	
		//using Testing view to bypass view not working / SelectedContacts
    	Intent exIntent = new Intent(MainActivity.this, TestingView.class);
    	
    	exIntent.putExtra("fullname", textV.getText().toString());
    	//exIntent.putExtra("fullphone", pNum.getText().toString());
    	
    	//trying something for the image
    			Uri imageUri = exIntent.getData();
    			exIntent.setData(imageUri);
    			
    			
    	//startActivity(exIntent);
    	startActivity(exIntent);
    	
    	//logging position 
    	Log.d("Position.Log",String.valueOf(position));
    	Log.d("Item", String.valueOf(lv.getPositionForView(v)));
    	
    	
    }



  //Implementation from fragment

	@Override
	public void onAdd() {
		

		//Calling the intent to move into SecondView Activity
		 Intent exIntent = new Intent(MainActivity.this, AddView.class);
		 
		//method to start the activity when the button is pressed
			startActivityForResult(exIntent,0);
	}


	@Override
	public void onAddContact() {
		// TODO Auto-generated method stub
		finish();
	}
	
	
	/*
	public void finish()
	{
		//Building Edit Texts for first and last name
		 EditText etFirst = (EditText) findViewById(R.id.editName);
	     EditText etLast = (EditText) findViewById(R.id.editLast);
	        
	//Building Edit Texts for the 3 input fields to make a full phone number.
	     EditText etPhone = (EditText) findViewById(R.id.editPhone);
	     EditText etPhone2 = (EditText) findViewById(R.id.editPhone2);
	     EditText etPhone3 = (EditText) findViewById(R.id.editPhone3);
	     
	   //building intent 
		Intent data = new Intent();
		
		//adding the first and last name
		data.putExtra("firstName", etFirst.getText().toString());
		data.putExtra("lastName", etLast.getText().toString());
		
	//for the phone number. Using 3 edit text fields
		data.putExtra("phoneNum", etPhone.getText().toString());
		data.putExtra("phoneNum2", etPhone2.getText().toString());
		data.putExtra("phoneNum3", etPhone3.getText().toString());
		
		setResult(RESULT_OK, data);
		super.finish();
	}
   */
	
    
}
