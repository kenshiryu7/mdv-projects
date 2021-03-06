package com.lpuente.proj_1;

import java.net.URL;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;


public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //trying simple window management feature
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.main_lay);
        
        //get intent method
        Intent getintent = getIntent();
        
        //getting data from intent
        Uri data = getintent.getData();
        
        URL url = null;
        
        //code to collect uri from button selected in previous fake app
        try
        {
        	url = new URL(data.getScheme(), data.getHost(), data.getPath());
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        //loading url into webview.
        WebView webview = (WebView) findViewById(R.id.webView1);
        
        webview.loadUrl(url.toString());
    }

    
    
    //Not used
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_lay, menu);
        return true;
    }
}
