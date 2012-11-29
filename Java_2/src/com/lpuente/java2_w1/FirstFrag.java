package com.lpuente.java2_w1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class FirstFrag extends Fragment {



	 @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		
		//relating to the main.xml which is a relative layout. hopefully no issues.
		RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.activity_main, container, false);
		
		return view;
	}

}


