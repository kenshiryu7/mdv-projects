package com.example.quickapp;

import java.io.File;
import java.io.FileOutputStream;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	/*Trying to meet the requirements this week with content providers, services and etc. Had to remake this app.
	 * Lynda and some others had a good start for imlementing content provider for contacts. Went in that direction
	 * found a few examples on various parts and answers in stack overflow. took all day and night. Some of this is from
	 * Lynda and a listview tutorial, some is from stack overflow. Putting it all together and trying to get this to work
	 */
	
	//member variables
	
	//Simple cursor to map textviews and images. 
	SimpleCursorAdapter mAdapter;
	
	//mutable cursor/able to add/remove
	MatrixCursor mMatrixCursor;	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // The contacts from the contacts content provider is stored in this cursor
        mMatrixCursor = new MatrixCursor(new String[] { "_id","name","photo","details"} );
        
        // Adapter to set data in the listview
        mAdapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.list_layout,
                null,
                new String[] { "name","photo","details"},
                new int[] { R.id.tv_name,R.id.iv_photo,R.id.tv_details}, 0);
        
       
        
        // Getting reference to listview
        ListView lvMainId = (ListView) findViewById(R.id.main_list);
        
        // Setting the adapter to listview
        lvMainId.setAdapter(mAdapter);        
        
        // AsyncTask  to get/ load data to listview wth contacts/ with builit inner class
        ListViewLoader listLoader = new ListViewLoader();
        
        //Button for See Static List
        Button toStaticList = (Button) findViewById(R.id.see_list);
        
        toStaticList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				

				//using Testing view to bypass view not working / SelectedContacts
		    	Intent exIntent = new Intent(MainActivity.this, StaticListView.class);
		    	startActivity(exIntent);
				
			}
		});
        
        //Button for services view
        Button toService = (Button) findViewById(R.id.see_services);
        
        //listener for to Service.
        toService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent service = new Intent(MainActivity.this, Services.class);
		    	startActivity(service);
				
			}
		});
        
        // Starting the AsyncTask process using .execute(). Guess this is like startActivity.
        listLoader.execute();        
        
    }    
    
   ////////////
    //Inner class built for AsyncTask. Function that gets all the data in other words
   
    private class ListViewLoader extends AsyncTask<Void, Void, Cursor>{   	

		@Override
		protected Cursor doInBackground(Void... params) {
			Uri contactsUri = ContactsContract.Contacts.CONTENT_URI;
			
			// Querying the table ContactsContract.Contacts to retrieve all the contacts
			Cursor conCursor = getContentResolver().query(contactsUri, null, null, null, 
									ContactsContract.Contacts.DISPLAY_NAME + " ASC ");
			
			
			//moveToFirst is bool this is saying if the cursor is at the first row
			//while loop to go through the data. do While i remember is to use code block at least once
			if(conCursor.moveToFirst()){
				do{
					
					//getting the id of the specific row/column of contact
					long contactId = conCursor.getLong(conCursor.getColumnIndex("_ID"));
					
					
					Uri dataUri = ContactsContract.Data.CONTENT_URI;
					
					// Querying the table ContactsContract.Data to retrieve individual items like
					// home phone, mobile phone, work email etc corresponding to each contact 
					Cursor dataCursor = getContentResolver().query(dataUri, null, 
											ContactsContract.Data.CONTACT_ID + "=" + contactId, 
											null, null);
					
					//setting up strings in which data will be collected
					//these are collections the people app uses
					//will be able to retrieve saved data from that app to display here 
					String fullname="";
					String nickName="";
					String homePh="";
					String mobilePh="";
					String workPh="";
					
					//here is the idea that Josh mentioned in getting the photo info with Byte.
					//This content provider example/ from stack overflow/ used it
					//tested and it works.
					String imagePath="" + R.drawable.blank;
					byte[] imageByte=null;
					
					String homeEmail="";
					String workEmail="";
					String comName="";
					String title="";
					
					
					
					if(dataCursor.moveToFirst()){
						// Getting Display Name
						fullname = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME ));
						do{
												
							// Getting NickName
							if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Nickname.CONTENT_ITEM_TYPE))
								nickName = dataCursor.getString(dataCursor.getColumnIndex("data1"));
							
							// Getting Phone numbers
							if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)){
								switch(dataCursor.getInt(dataCursor.getColumnIndex("data2"))){
									case ContactsContract.CommonDataKinds.Phone.TYPE_HOME : 
										homePh = dataCursor.getString(dataCursor.getColumnIndex("data1"));
										break;
									case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE : 
										mobilePh = dataCursor.getString(dataCursor.getColumnIndex("data1"));
										break;
									case ContactsContract.CommonDataKinds.Phone.TYPE_WORK : 
										workPh = dataCursor.getString(dataCursor.getColumnIndex("data1"));
										break;	
								}
							}
							
							// Getting EMails
							if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE ) ) {									
								switch(dataCursor.getInt(dataCursor.getColumnIndex("data2"))){
									case ContactsContract.CommonDataKinds.Email.TYPE_HOME : 
										homeEmail = dataCursor.getString(dataCursor.getColumnIndex("data1"));
										break;
									case ContactsContract.CommonDataKinds.Email.TYPE_WORK : 
										workEmail = dataCursor.getString(dataCursor.getColumnIndex("data1"));
										break;										
								}
							}
							
							// Getting Organization details
							if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE)){
								comName = dataCursor.getString(dataCursor.getColumnIndex("data1"));
								title = dataCursor.getString(dataCursor.getColumnIndex("data4"));
							}
								
							// Getting Photo	
							if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE)){								
								imageByte = dataCursor.getBlob(dataCursor.getColumnIndex("data15"));
								
								if(imageByte != null) {							
									Bitmap bitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
									
									// Getting Caching directory 
				                    File cache = getBaseContext().getCacheDir();
	
				                    // Temporary file to store the contact image 
				                    //Example used /wpta_ and .png to start. I'LL BE HONEST. I UNDERSTAND the .png or .jpg. why the /wpta?
				                    //in case of jpg or png. May need a conditinal
				                    
				                    File tempImageFile1 = new File(cache.getPath() + "/wpta_"+contactId+".png");
				                    //File tempImageFile2 = new File(cache.getPath() + "/wpta_"+contactId+".jpg");
	
				                    // The FileOutputStream to the tempImageFile 1 & 2
				                    try {
										FileOutputStream filestream1 = new FileOutputStream(tempImageFile1);
										//FileOutputStream filestream2 = new FileOutputStream(tempImageFile2);
										
										// Writing the bitmap to the temp Image file
					                    bitmap.compress(Bitmap.CompressFormat.PNG,100, filestream1);
					                    //bitmap.compress(Bitmap.CompressFormat.JPEG,100, filestream2);
	
					                    // Flushing it all out. flush is used to clear but keeps stream open
					                    filestream1.flush();
					                    //filestream2.flush();
	
					                    //Closing the stream. CLoses stream AFTER Flushing. NECESSARY
					                    filestream1.close();
					                    //filestream2.close();
	
					                    //typical catch nothing fance here
									} catch (Exception e) {
										e.printStackTrace();
									}
	
				                    //Leaving just PNG format for now. Im sure theres a way to check
				                    //if either or. Right now I'll be happy if only a few work.
				                    imagePath = tempImageFile1.getPath();
				                   // imagePath = tempImageFile2.getParent();
								}
								
							}
							
						}while(dataCursor.moveToNext());					
						
						//constant of details variable
						String details = "";
						
						// Concatenating various data to single string
						//IF variable AND variables STring is empty then the constant "details" string equals
						//a concat of string and collected variables plus \n to allow for the next line to be below
						
						
						//All fields work when detials has += not just =. 
						if(homePh != null && !homePh.equals("") )
							details += "HomePhone : " + homePh + "\n";			//home number details
						if(mobilePh != null && !mobilePh.equals("") )
							details += "MobilePhone : " + mobilePh + "\n";		//mobile phone details
						if(workPh != null && !workPh.equals("") )
							details += "WorkPhone : " + workPh + "\n";			//work phone details
						if(nickName != null && !nickName.equals("") )
							details += "NickName : " + nickName + "\n";			//nick name details
						if(homeEmail != null && !homeEmail.equals("") )
							details += "HomeEmail : " + homeEmail + "\n";		//home email details
						if(workEmail != null && !workEmail.equals("") )
							details += "WorkEmail : " + workEmail + "\n";		//work email details
						if(comName != null && !comName.equals("") )
							details += "CompanyName : " + comName + "\n";		//company name details
						if(title != null && !title.equals("") )
							details += "Title : " + title + "\n";				//title details. Title within company
						
						// Adding ID,  fullname, imagePath and details result to cursor
						//kind of like adding to a ListAdapter
						mMatrixCursor.addRow(new Object[]{ Long.toString(contactId),fullname,imagePath,details});
					}
					
				}while(conCursor.moveToNext());
			}
			
			//returning the mutable constant declared in member variables
			return mMatrixCursor;
		}
    	
		@Override
		protected void onPostExecute(Cursor result) {			
			// Setting the cursor containing contacts to listview myAdapter.add(whatever your adding); Makes sense
			mAdapter.swapCursor(result);
		}		
    }

    //This menu seems to be coming up when opening a project. Doesn't really do anything at this time. Not using it is what i mean
    //From what ive seen in adding contact info to emulator/ it can be used well within an application
    //Should probably at least read up on this and get some ideas how to is this later. Will just leave blank instead of removing
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}