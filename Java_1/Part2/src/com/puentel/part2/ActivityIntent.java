package com.puentel.part2;

import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

public class ActivityIntent extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//using same main view. will run this from outside application
		this.setContentView(R.layout.activity_main);
		
		Intent openIntent = this.getIntent();
		
		if(openIntent != null)
		{
			Uri uri = openIntent.getData();
			ImageView imageView = (ImageView)this.findViewById(R.id.imageView1);
			try {
				imageView.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), uri));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
}
