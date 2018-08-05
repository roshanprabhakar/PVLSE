package com.neelk.outsidehacks2018;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

//import org.apache.http.client.methods.HttpGetHC4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;

import static android.content.Context.SENSOR_SERVICE;
import static android.support.constraint.Constraints.TAG;


public class HeartRateFragment extends Fragment {

    private Button heartRateGetStartedButton;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Bitmap mImageBitmap;
    private String mCurrentPhotoPath;
    private ImageView mImageView;
    private SensorManager sMgr;
    private static  Sensor heartRateSensor;
    public int heartRate = 0;
    private Button playMusic;

    public HeartRateFragment() {
        // Required empty public constructor
    }


    public static HeartRateFragment newInstance() {
        HeartRateFragment fragment = new HeartRateFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_heart_rate, container, false);

        final ConstraintLayout constraintLayout = view.findViewById(R.id.constraintLayout);
       final ConstraintLayout.LayoutParams lparams = new  ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        heartRateGetStartedButton = (Button) view.findViewById(R.id.measureHeartRateButton);
        playMusic = (Button) view.findViewById(R.id.playMusicButton);

        heartRateGetStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getHeartRate();
                // we are unable to use any of our heart rate sensor methods as the emulator does not actually have any hardware or sensors
                // so in order to demonstrate  the rest of our program's functionality we are simulating a heart rate
                // our heart rate methods are below, commented out so they dont affect the code

                    simulateHeartRate(80,150);
                Toast.makeText(getActivity(), "Your heart rate is " + heartRate + " bpm", Toast.LENGTH_SHORT).show();

            }

        });


        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(heartRate == 0){
                    Toast.makeText(getActivity(), "Please check your heart first and try again", Toast.LENGTH_SHORT).show();
                }
                else{



                        Thread thread = new Thread(new Runnable() {

                            @Override
                            public void run() {
                                try  {
                                    Document document;
                                    document = Jsoup.connect("http://www.cs.ubc.ca/~davet/music/bpm/" + heartRate +".html").get();

                                    int noOfrows = 0;
                                    Elements artist  = document.select(".music:contains(")
                                    System.out.println(noOfrows);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                        thread.start();


                    }


            }
        });

        return view;
    }
    public void simulateHeartRate(int min, int max)  {
        heartRate = (min + (int) (Math.random() * ((max - min) + 1)));
    }

    // heart rate sensor methods
    // unable to use because emulator does not actually have any hardware sensors
/*
    private  static  Double getHeartRate() {
        SensorManager sMgr = new SensorManager() {
            @Override
            public boolean registerListener(SensorEventListener listener, Sensor sensor, int samplingPeriodUs) {
                return super.registerListener(listener, sensor, samplingPeriodUs);
            }
        };
        heartRateSensor = SensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
        Double heartRate = Double.valueOf(heartRateSensor.toString());

        return heartRate;

    }




    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: ");
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_HEART_RATE:
                getHeartRate();


        }
    }*/

}

