package com.lpuente.java2_w1;





import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondFrag extends Fragment {

	//building the interface to implement in activity (SecondView)
private SecondInterface secondlistener;
	
	public interface SecondInterface
	{
		public void onMakeCall();
	}
	
	
	 @Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreateView(inflater, container, savedInstanceState);
			
			//relating to the main.xml which is a relative layout. hopefully no issues.
			RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.secondview, container, false);
			
			
			
			
			
	//Decided to leave this alone. I thought this would be as simple as my first fragment but the data was not being collected into
			

			TextView test = (TextView) getActivity().findViewById(R.id.full_name);
			//creating the button
			final Button callButt = (Button)view.findViewById(R.id.callnum);
			
			String phone1 = getActivity().getIntent().getExtras().getString("phoneNum");
			String phone2 = getActivity().getIntent().getExtras().getString("phoneNum2");
			String phone3 = getActivity().getIntent().getExtras().getString("phoneNum3");
			
			 callButt.setText("1" + "(" + phone1 + ")" + phone2 + "-" + phone3);
			
			//setting first and last name in one text view
			test.setText(getActivity().getIntent().getExtras().getString("firstName") + " " + getActivity().getIntent().getExtras().getString("lastName"));
			
			callButt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					secondlistener.onMakeCall();
				}
			});
			
			return view;	
	 }
	 
	 @Override
		public void onAttach(Activity activity)
		{
			super.onAttach(activity);
			
			try{
				secondlistener = (SecondInterface) activity;
			}
			catch(ClassCastException e)
			{
				throw new ClassCastException(activity.toString() + "must implement FirstInterface");
			}
		}
 }
		
