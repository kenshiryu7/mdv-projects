package com.lpuente.canine_care;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesUtil;


public class LegalNotices extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.legal_notices_lay);
		
		TextView text = (TextView) findViewById(R.id.text);
		text.setText(GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(this));
		
	}

	

}