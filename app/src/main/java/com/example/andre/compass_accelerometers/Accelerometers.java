package com.example.andre.compass_accelerometers;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Accelerometers extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView textViewX, textViewY, textViewZ;
    private int black = -16777216;
    private int magneta = -65281;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometers);

        // Create Sensor Manager
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Create Accelerometer Sensor
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Reister Sensor Listener
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        // Set text views by id
        textViewX = (TextView) findViewById(R.id.sensor_x);
        textViewY = (TextView) findViewById(R.id.sensor_y);
        textViewZ = (TextView) findViewById(R.id.sensor_z);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not used
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        // Assigning sensor data to text views
        textViewX.setText("X: " + event.values[0]);
        textViewY.setText("Y: " + event.values[1]);
        textViewZ.setText("Z: " + event.values[2]);

        // Changing color depending on sensor value
        if(event.values[0] > 0){
            textViewX.setTextColor(magneta);
        }else{
            textViewX.setTextColor(black);
        }
        if(event.values[1] > 0){
            textViewY.setTextColor(magneta);
        }else{
            textViewY.setTextColor(black);
        }
        if(event.values[2] > 0){
            textViewZ.setTextColor(magneta);
        }else{
            textViewZ.setTextColor(black);
        }
    }
}
