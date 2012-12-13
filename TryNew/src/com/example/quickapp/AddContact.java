package com.example.quickapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;

import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddContact extends Activity {

	//member variables
	EditText firstName;
	EditText lastName;
	EditText phoneNum;
	
	//will try this later if anything
	ImageView image;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_contact);
		
			
	
	
	 Button toAdd = (Button) findViewById(R.id.submit_contact);
	 toAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(SaveContact())
				{
					Toast.makeText(getBaseContext(), "Contact Was Saved!!!", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(getBaseContext(), "Unable to Save Contact", Toast.LENGTH_LONG).show();
				}
			}
		});
	
	 
	}
	boolean SaveContact()
	 {
		firstName = (EditText) findViewById(R.id.first_name);
		lastName = (EditText) findViewById(R.id.last_name);
		phoneNum = (EditText) findViewById(R.id.phone_number);
		
		 String firstN = firstName.getText().toString();
		 String lastN = lastName.getText().toString();
		 String phone = phoneNum.getText().toString();
		 
		 
		 //New Contact
		 String fullName = firstN + lastN;
		 
		 //getting an array list
		 ArrayList<ContentProviderOperation> contentArray = new ArrayList<ContentProviderOperation>();
		 
		 int rawContactInsertIndex = contentArray.size();
		 
		 //this is one line
		 contentArray.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
				 .withValue(RawContacts.ACCOUNT_TYPE, null)
		 		 .withValue(RawContacts.ACCOUNT_NAME, null)
		 		 .build());
		 
		 //Getting the name details
		 contentArray.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
				 .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, rawContactInsertIndex)
				 .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
				 .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, fullName) //full name
				 .withValue(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME, lastN)		//last name. not sure if needed
				 .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, firstN)		//first name, not sure if needed
				 .build());
		 
		 //getting the phone number details//using only mobile
		 contentArray.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
				 .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, rawContactInsertIndex)
				 .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
				 .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, phone)    //phone number
				 .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
				 .build());
		 
		 
		 //This is something I need to look deeper into understanding
		 
		 Uri newContactUri = null;
		 try
		 {
			 ContentProviderResult[] res = getContentResolver().applyBatch(ContactsContract.AUTHORITY, contentArray);
			 if (res != null && res [0] != null)
			 {
				 newContactUri = res[0].uri;
				 Log.d("Testing", "Added contact:" + newContactUri);
			 }
			 else
			 
				 Log.d("Testing", "Could Not Add Contact! Crap!");
			 
		 }
		 catch(RemoteException e)
		 {
			 Log.e("ERROR", "ERROR ADDING CONTACT 1");
			 newContactUri = null;
		 }
		 catch(OperationApplicationException e)
		 {
			 Log.e("Testing", "ERROR ADDING CONTACT 2");
			 newContactUri = null;
		 }
		 
		 Log.d("Testing" , "ADDED TO SYSTEM CONTACTS");
		 
		 
		 //if Error/ null
		 if(newContactUri == null)
		 {
			 Log.e("Testing", "ERROR CREATING CONTACT");
			 return false;
		 }
		 return true;
	 }
}
