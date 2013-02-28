package com.lpuente.project4;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;

import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled")
public class Main extends Activity {

	//global variables just in case
	WebView myWV;
	EditText message;
	Button collectInputButt;
	
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_lay);
        
        
      //once again locking the screen in portrait. Eh, makes things a bit
      //easier to see and sort through.
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
      //web view id
        
        myWV = (WebView) findViewById(R.id.webView);
       
        
      
      //adding java script interface class
        
        //final MyJavaScriptInterface myJSI = new MyJavaScriptInterface(this);
       // myWV.addJavascriptInterface(myJSI, "AndroidFunction");
        
        //same as stuff above
        myWV.addJavascriptInterface(new MyJavaScriptInterface(this), "Android");
        
        WebSettings webSettings = myWV.getSettings();
        webSettings.setJavaScriptEnabled(true);
        
       
      //web view loads url from asset html
        
        myWV.loadUrl("file:///android_asset/index.html");
       
        
     
      //Edit text stuff
        
        message = (EditText) findViewById(R.id.message);
        
        
     
      //The Main Button Stuff
        
        collectInputButt = (Button) findViewById(R.id.button1);
        collectInputButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Log.d("ET", "ET-BUTT CLICKED");
				
				//going to try to send typed input to web view and have the 
				//text viewed in the web view with a button to go to the web site

				
				if(message.getText().toString().equals(""))
				{
					Log.d("NONE", "NOTHING WAS TYPED");
					
					//alert
					AlertDialog.Builder emptyET = new AlertDialog.Builder(Main.this);
			    	
			    	//alert stuff
			    	emptyET.setTitle("Oops!!!");
			    	emptyET.setMessage("You forgot to type something in dummy!");
			    	emptyET.setPositiveButton("OK", null); //null is for the listener
			    	emptyET.show(); 
				}
				else
				{
					String messageSent = message.getText().toString(); //getting input from Edit text
					myWV.loadUrl("javascript:callFromActivity(\"" + messageSent + "\")");
					
					//puts the edit text back to default after pressing button
					message.setText("");
					
					//dismissing keyboard after pressing button with text
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(message.getWindowToken(), 0);
				}
			}
		});
        
    }

    
    //creating the java script interface inner class
    
    public class MyJavaScriptInterface{Context _context;
    	
    	MyJavaScriptInterface(Context c){
    		_context = c;
    	}
    	
    	//will try a toast first
    	@JavascriptInterface
    	public void showToast(String toast){
    		
    		Toast.makeText(_context, toast, Toast.LENGTH_LONG).show();
    		Log.d("JS", "TOAST CLICKED");
    	}
    	
    	
    	//now a simple alert 
    	//Will change these as i go. Probably to call intents. Something simple first
    	@JavascriptInterface
    	public void openDialog(){
    	
    		Log.d("ALERT", "ALERT CLICKED");
    		
    	AlertDialog.Builder myDialog = new AlertDialog.Builder(Main.this);
    	
    	//alert stuff
    	myDialog.setTitle("This is the Title");
    	myDialog.setMessage("This is the Message");
    	myDialog.setPositiveButton("Positive", null); //null is for the listener
    	myDialog.show(); 
    	}
    	
    	
    }

    
    
    
    
    
    
    //may use this later for action bar purposes.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
