package com.lpuente.project_3;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;





public class Main extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_lay);
		
		
		
		Button toMain = (Button) findViewById(R.id.main_butt);
		
		toMain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent mainInt = new Intent(Main.this, TheMainStuff.class);
				
				startActivity(mainInt);
				
			}
		});
	}


}
