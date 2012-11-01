package com.lpuente.java_w2;

import com.lpuente.pack1.FormingStuff;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     //calling linlay from pack1 package FormingStuff class
        LinearLayout entBox = FormingStuff.entryButton(this, "Type here", "button text butt1");
     
     //Creat main linlay
        LinearLayout mainlinlay = new LinearLayout(this);
     //add mainlinlay
        mainlinlay.addView(entBox);
        
     //setting content view / display on device
        setContentView(mainlinlay);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
