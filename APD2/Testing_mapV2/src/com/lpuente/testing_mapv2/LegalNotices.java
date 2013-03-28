package com.lpuente.testing_mapv2;

import com.google.android.gms.common.GooglePlayServicesUtil;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class LegalNotices extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.legal_notices_lay);
		
		TextView text = (TextView) findViewById(R.id.text);
		text.setText(GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(this));
		
	}

	

}
