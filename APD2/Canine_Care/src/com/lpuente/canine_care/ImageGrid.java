package com.lpuente.canine_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ImageGrid extends Activity {
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);
 
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        
       
        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));
        
        
        //onclick an item in the gridView
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
 
                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImage.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }

        });
        
        
    }
  
}
