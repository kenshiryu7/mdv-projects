package com.example.quickapp;





import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;


public class DetailsFrag extends Fragment{
	
	
	
	 @Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreateView(inflater, container, savedInstanceState);
			
		//relating to the main.xml which is a relative layout. hopefully no issues.
			//changed to linear from before
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.details_view, container,false);
			
	
      				
     
	
			return view;
		 }
	 
	
}
