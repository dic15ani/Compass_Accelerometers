package com.example.andre.compass_accelerometers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Compass button */
    public void compass(View view) {
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }

    public void accelerometers(View view) {
        Intent intent = new Intent(this, Accelerometers.class);
        startActivity(intent);
    }
}
