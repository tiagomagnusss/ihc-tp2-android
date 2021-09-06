package com.example.tp221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensorLight;
    private Sensor sensorTemp;
    private Sensor sensorLatLong;

    TextView lblLight;

    TextView lblTemp;

    TextView lblLat;
    TextView lblLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblLight = findViewById(R.id.lblLigth);
        lblTemp = findViewById(R.id.lblTemp);

        lblLat = findViewById(R.id.lblLat);
        lblLong = findViewById(R.id.lblLong);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensorLatLong = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if ( sensorLight != null )
        {
            sensorManager.registerListener(MainActivity.this, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);
        }

        if ( sensorTemp != null )
        {
            sensorManager.registerListener(MainActivity.this, sensorTemp, SensorManager.SENSOR_DELAY_NORMAL);
        }

        if ( sensorLatLong != null )
        {
            sensorManager.registerListener(MainActivity.this, sensorLatLong, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if ( sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT )
        {
            lblLight.setText( String.valueOf(sensorEvent.values[0]) );
        }
        else if ( sensorEvent.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE )
        {
            lblTemp.setText( String.valueOf(sensorEvent.values[0]) );
        }
        else if ( sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE )
        {
            lblLat.setText( String.valueOf(sensorEvent.values[0]) );
            lblLong.setText( String.valueOf(sensorEvent.values[1]) );
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // do nothing
    }
}