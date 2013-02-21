package com.lpuente.project_3;

import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetConfigActivity extends AppWidgetProvider{
	
	
	
	
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		
		// Getting the ids
		ComponentName thisWidge = new ComponentName(context, WidgetConfigActivity.class);
		
		//ids int
		int[] allWidgeIds = appWidgetManager.getAppWidgetIds(thisWidge);
		
		for(int widgetId: allWidgeIds)
		{
			//going the random route again. just trying to get this to work
			int nums = (new Random().nextInt(100));
			
			////remote views for the widget to show. layout
			RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			
			//just in case logging stuff out
			Log.w("WiddgeEX", String.valueOf(nums));
			
			//setting the text in the widge
			rv.setTextViewText(R.id.update_text, String.valueOf(nums));
			
			//onclick listener
			Intent intent = new Intent(context, WidgetConfigActivity.class);
			
			intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
			
			//trying this pending intent thing that didnt work the first 2 times
			PendingIntent pendInt = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
			
			rv.setOnClickPendingIntent(R.id.update_text, pendInt);
			appWidgetManager.updateAppWidget(widgetId, rv);
		}
		
		
		
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

	
	
	

}
