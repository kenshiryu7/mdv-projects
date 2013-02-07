package com.example.part2_openweb;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class OpenMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_main_lay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.open_main_lay, menu);
        return true;
    }
}
