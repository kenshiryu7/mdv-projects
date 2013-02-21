package com.lpuente.project_3;

import java.util.Random;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import android.widget.Toast;

public class DumbWidget extends AppWidgetProvider{

	//method to update widget. Rough estimate 
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		
		//Updating
		
		//In this case a Random. This is good to test updates and changes
		Random ran = new Random();
		
		//how many numbers can the random choose from.
		int ranInt = ran.nextInt(100);
		
		//converting the random int to string 
		String ranString = String.valueOf(ranInt);
		
		//getting value/number of ids
		final int widgIds = appWidgetIds.length;
		
		//using a loop to go through the array of ids
		
		for(int i = 0; i < widgIds; i++){
			
			//app widget ids
			int awids = appWidgetIds[i];
			
			//remote views for calling the widget layout 
			RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			
			//setting the textview of the layout calling the id of the TV and setting that to the String above
			//this case it is ranString which uses the random number
			rv.setTextViewText(R.id.tv_update, ranString);
			
			//informs the app widget of the update
			appWidgetManager.updateAppWidget(awids, rv);
		}
	}
	
	
	
	
	//method to delete widget
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
		
		//creating toast when widget is deleted
		Toast.makeText(context, "You've been dumped!", Toast.LENGTH_LONG).show();
	}

	

}
