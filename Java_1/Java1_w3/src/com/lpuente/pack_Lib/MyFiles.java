package com.lpuente.pack_Lib;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	
	//Methods to read objects and strings
	
	@SuppressWarnings("resource")
	public static String readStrFile(Context context, String filename, Boolean saveLocation)
	{
		String content = "";
		
		try
		{
			File f;
			FileInputStream fin;		//brings files in to read
			
			if(saveLocation)
			{
				f = new File(context.getExternalFilesDir(null), filename);
				fin = new FileInputStream(f);	//added suppressed warning
			}
			else
			{
				f = new File(filename);
				fin = context.openFileInput(filename);
			}
					//brings bytes in over time
					BufferedInputStream bin = new BufferedInputStream(fin);
			
					byte [] contentBytes = new byte[1024];
					int bytesRead = 0;
			
					StringBuffer contentBuffer = new StringBuffer();
			
					while((bytesRead = bin.read(contentBytes)) != -1)
					{
						//pulls in bytes gradually
						content = new String(contentBytes, 0, bytesRead);
						contentBuffer.append(content);
					}
					content = contentBuffer.toString();
					fin.close();
		}
		catch(FileNotFoundException e)
		{
			Log.e("READ ERROR", "FILE NOT FOUND" + filename);
		}
		catch(IOException e)
		{
			Log.e("READ ERROR", "I.O ERROR");
		}
			return content;
			
	}
	
	@SuppressWarnings("resource")
	public static Object readObjFile(Context context, String filename, Boolean saveLocation)
	{
		Object content = new Object();
		
		try
		{
			File f;
			FileInputStream fin;		//brings files in to read
			
			if(saveLocation)
			{
				f = new File(context.getExternalFilesDir(null), filename);
				fin = new FileInputStream(f);	//added suppressed warning
			}
			else
			{
				f = new File(filename);
				fin = context.openFileInput(filename);
			}
			/*// not used. copied and kept for reference
			 * 
					//brings bytes in over time
					BufferedInputStream bin = new BufferedInputStream(fin);
			
					byte [] contentBytes = new byte[1024];
					int bytesRead = 0;
			
					StringBuffer contentBuffer = new StringBuffer();
			
					while((bytesRead = bin.read(contentBytes)) != -1)
					{
						//pulls in bytes gradually
						content = new String(contentBytes, 0, bytesRead);
						contentBuffer.append(content);
					}
					content = contentBuffer.toString();
					fin.close();
			*/
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			try
			{
				content = (Object) ois.readObject();
			}
			catch(ClassNotFoundException e)
			{
				Log.e("READ ERROR", "INVALID JAVA FILE");
			}
			//object function requires to close ois and fin
			ois.close();
			fin.close();
		}
		catch(FileNotFoundException e)
		{
			Log.e("READ ERROR", "FILE NOT FOUND" + filename);
			return null;
		}
		catch(IOException e)
		{
			Log.e("READ ERROR", "I.O ERROR");
			
		}
			return content;
			
	}
}

