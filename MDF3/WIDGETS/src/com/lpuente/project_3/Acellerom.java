package com.lpuente.project_3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Acellerom extends Activity implements SensorEventListener{
	
	//var tab 3
		Sensor accelerometer;
		SensorManager senseMan;
		TextView acceleration;
		
		private final String TAG = "Acellerom Activity";
		
		
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acellerom_lay);
		
		 //im sure theres a better way around the audio issues when changing from port to land. but locking it is ok for now
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		//sensor object
		senseMan = (SensorManager)getSystemService(SENSOR_SERVICE);

		//getting sensor type
		accelerometer = senseMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

		//registering the sensor manager
		senseMan.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

		//textview id
		acceleration = (TextView) findViewById(R.id.accellText);

	}


	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		
		//displaying values to X, Y, Z using values of the ais 0 being x y being 1 z being 2.
				acceleration.setText(" X: " +arg0.values[0] +
						"\n Y: " +arg0.values[1] +
						"\n Z: " +arg0.values[2]);
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
	{
	case R.id.item1:
		Log.i(TAG, "item 1 CLICKED");
		
		Intent audioInt = new Intent(Acellerom.this, AudioVideo.class);
		startActivity(audioInt);
		
		
		return true;
	case R.id.item2:
		Log.i(TAG, "item 2 CLICKED");
		
		Intent gpsInt = new Intent(Acellerom.this, GPS.class);
		startActivity(gpsInt);
		
		
		return true;
	case R.id.item3:
		Log.i(TAG, "item 3 CLICKED");
		
		Intent acellInt = new Intent(Acellerom.this, Acellerom.class);
		startActivity(acellInt);
		
		
		return true;
		
		default: return super.onOptionsItemSelected(item);
	}
}
}