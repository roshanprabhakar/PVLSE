package com.neelk.outsidehacks2018;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

import static com.neelk.outsidehacks2018.HeartRateFragment.BPM;

public class getHeartRate extends AppCompatActivity implements SensorEventListener {

    private static SensorManager sensorManager;
    private static Sensor heartRateSensor;
    public static int measuredHeartRate =0;
    private int count = 0;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_heart_rate);

        System.out.println("In heartrate onCreate");

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        System.out.println("In heartrate onCreate " + sensorManager);
        heartRateSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
        System.out.println("In heartrate onCreate heartRateSensor " + heartRateSensor);
 //       sensorManager.registerListener(mSensorEventListener, heartRateSensor, SensorManager.SENSOR_DELAY_FASTEST);

        //getHeartRate mGetHeartRate = new getHeartRate();
       // mGetHeartRate.mSensorEventListener.onSensorChanged();
        back = findViewById(R.id.getHeartRateToHeartRateFragment);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getHeartRate.this, Home.class));

            }
        });


    }

//   SensorEventListener mSensorEventListener = new SensorEventListener() {

       @Override
        protected void onResume() {
            // Register a listener for the sensor.
            //getHeartRate.
           System.out.println("onResume");

           super.onResume();
            sensorManager.registerListener(this, heartRateSensor, SensorManager.SENSOR_DELAY_FASTEST);

       }

        @Override
       protected void onPause(){
            // Be sure to unregister the sensor when the activity pauses.
            //getHeartRate.
            super.onPause();
            System.out.println("onPause");
            sensorManager.unregisterListener((SensorEventListener) this);
        }

        @Override
        public void onSensorChanged(SensorEvent event){
            System.out.println("onSensorChanged");
            float heartBeatValueFloat = event.values[0];
            measuredHeartRate = Math.round(heartBeatValueFloat);
            count++;

            if(event.values[0] < 1){
              //  Toast.makeText(getHeartRate.this, count + " Keep finger on heart rate sensor", Toast.LENGTH_LONG).show();

                Snackbar.make(findViewById(R.id.constraintLayout), "Looking for Heart Rate...", Snackbar.LENGTH_INDEFINITE).show();
            }
           else{
                Toast.makeText(getHeartRate.this,"Success! Heart Rate is "  + measuredHeartRate + " BPM",Toast.LENGTH_SHORT).show();
                 BPM = measuredHeartRate;
                 startActivity(new Intent(getHeartRate.this, Home.class));


            }

        }

       @Override
       public void onAccuracyChanged(Sensor sensor, int i) {

       }

       public static int getMeasuredHeartRate(){
        return measuredHeartRate;
       }

//sensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
//heartRateSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
    //};

}


