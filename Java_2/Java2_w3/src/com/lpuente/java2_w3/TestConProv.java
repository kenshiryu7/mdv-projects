package com.lpuente.java2_w3;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class TestConProv extends ContentProvider {

	//setting constants
	//string
	
	public static final String AUTHORITY = "content://com.lpuente.java2_w3.provider";
	
	//setting the uri from authority string
	public static final Uri CONTENT_URI = Uri.parse(AUTHORITY);
	
	
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		
		
		//SUCCESS!!
		return true;
	}
	
	
	@Override
	public String getType(Uri uri) {
		
	//conditional for uri type item or directory
		/*if( uri.getLastPathSegment() == null)
		{
			return "vnd.android.cursor.item/vnd.lpuente.java2_w3.status";
		}
		else
		{
			return "vnd.android.cursor.dir/vnd.lpuente.java2_w3.status";
		}*/
		
		
		
		return null;
	}
	
	
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
