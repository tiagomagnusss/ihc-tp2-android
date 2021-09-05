package com.example.tp213;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    private static double DESIRED_VALUE = 6.90;

    TextView lblXaxis;
    TextView lblYaxis;
    TextView lblZaxis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        lblXaxis = findViewById(R.id.lblXaxis);
        lblYaxis = findViewById(R.id.lblYaxis);
        lblZaxis = findViewById(R.id.lblZaxis);

        if ( sensor != null )
        {
            sensorManager.registerListener(Activity1.this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if ( sensor.getType() == Sensor.TYPE_ACCELEROMETER )
        {
            lblXaxis.setText( String.valueOf( sensorEvent.values[0] ) );
            lblYaxis.setText( String.valueOf( sensorEvent.values[1] ) );
            lblZaxis.setText( String.valueOf( sensorEvent.values[2] ) );

            if ( sensorEvent.values[0]
                    + sensorEvent.values[1]
                    + sensorEvent.values[2] <= DESIRED_VALUE
            )
            {
                this.switchScreen();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // do nothing
    }

    private void switchScreen()
    {
        Intent intent = new Intent(Activity1.this, Activity2.class);
        startActivity(intent);
    }
}