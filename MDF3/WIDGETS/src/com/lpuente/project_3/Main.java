package com.lpuente.project_3;


import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;





public class Main extends Activity implements OnClickListener{

	final String URI = "http://yahoo.com";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_lay);
		
		
		//button and listener for the switching activities
		Button toMain = (Button) findViewById(R.id.main_butt);
		
		toMain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent mainInt = new Intent(Main.this, TheMainStuff.class);
				
				startActivity(mainInt);
				
			}
		});
		
		
		//button for widget stuff. Nothing now. just to have if anything
		Button widgeButt = (Button) findViewById(R.id.w_butt);
	
		widgeButt.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//trying out this widget stuff....again
		
		Bundle extras = getIntent().getExtras();
		
		if(extras != null)
		{
			//widget id by int
			int widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
			
			//varify valid widget id
			if(widgetId != AppWidgetManager.INVALID_APPWIDGET_ID)
			{
				//do something special here
				
				
				
			}
			//really cheap stuff here
			String test = "it works kinda"; 
			
			//widget view
			RemoteViews rv = new RemoteViews(Main.this.getPackageName(), R.layout.widget_layout);
			
			rv.setTextViewText(R.id.update_text, test);
			
			//button in widget
			Intent buttInt = new Intent(Intent.ACTION_VIEW, Uri.parse(URI));
			
			PendingIntent pi = PendingIntent.getActivity(this,0/*requestCode*/, buttInt, 0 /*flags*/);
			
			rv.setOnClickPendingIntent(R.id.w_butt, pi);
			
			AppWidgetManager.getInstance(this).updateAppWidget(widgetId, rv);
			
			Intent resultV = new Intent();
			resultV.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
			
			setResult(RESULT_OK, resultV);
			
			finish();
		}
	}


}
