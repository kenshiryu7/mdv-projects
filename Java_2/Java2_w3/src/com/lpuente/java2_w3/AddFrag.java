package com.lpuente.java2_w3;






import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class AddFrag extends Fragment {
	
	private AddInterface listener;
	
	
	//Building the interface to implement in AddView
		public interface AddInterface
		{
			public void onSubmit();
		}

	
	 @Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			super.onCreateView(inflater, container, savedInstanceState);
			
		//relating to the main.xml which is a relative layout. hopefully no issues.
			RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.addview, container, false);
			
			
			
		//creating button using reference from xml id
	     Button subButt = (Button) view.findViewById(R.id.sub_butt);
	        
	    //on click listener for button
	        subButt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
				     listener.onSubmit();
				    
				}
			});
	        return view;
		};
		
		@Override
		public void onAttach(Activity activity)
		{
			super.onAttach(activity);
			
			try{
				listener = (AddInterface) activity;
			}
			catch(ClassCastException e)
			{
				throw new ClassCastException(activity.toString() + "must implement FirstInterface");
			}
		}
}
