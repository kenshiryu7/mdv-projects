package com.lpuente.pack_Lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.util.Log;

public class MyFiles {

	//class made to create methods to allow storage to the device's drive and read from the drive as well
	
	@SuppressWarnings("resource")
	public static Boolean storeString(Context context, String filename, String contents, Boolean saveLocation)
	{
		try
		{
			File f;
			FileOutputStream fos;
			
			//if saved to external location
			if(saveLocation)
			{
				f = new File(context.getExternalFilesDir(null), filename);
				fos = new FileOutputStream(f);
			}
			else //if saved to an internal location
			{
				fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
			}
			//write contents
			fos.write(contents.getBytes());
			
			//when finished writing bytes. close.
			fos.close();
		}
		catch(IOException e)
		{
			Log.e("WRITE ERROR", filename);
		}
		
		return true;
	}
	
	
	@SuppressWarnings("resource")
	public static Boolean storeObject(Context context, String filename, Object contents, Boolean saveLocation)
	{
		
		try
		{
			File f;
			FileOutputStream fos;
			ObjectOutputStream oos;
			
			//if saved to external location
			if(saveLocation)
			{
				f = new File(context.getExternalFilesDir(null), filename);
				fos = new FileOutputStream(f);
			}
			else //if saved to an internal location
			{
				fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
			}
			oos = new ObjectOutputStream(fos);
			
			//write contents
			oos.writeObject(contents);
			
			//same as closing fos / closing oos beforehand
			oos.close();
			
			//when finished writing bytes. close.
			fos.close();
		}
		catch(IOException e)
		{
			Log.e("WRITE ERROR", filename);
		}
		
		return true;
	}
}
