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
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;

import static android.content.Context.SENSOR_SERVICE;
import static android.support.constraint.Constraints.TAG;
import static com.neelk.outsidehacks2018.getLargeHtmlString.setRandArtistAndTitle;
import static com.neelk.outsidehacks2018.htmlParser.parseHTMLselectSONG;
import static com.neelk.outsidehacks2018.htmlParser.randArtist;
import static com.neelk.outsidehacks2018.htmlParser.randTitle;


public class HeartRateFragment extends Fragment {

    private Button heartRateGetStartedButton;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Bitmap mImageBitmap;
    private String mCurrentPhotoPath;
    private ImageView mImageView;
    private SensorManager sMgr;
    private static Sensor heartRateSensor;
    public static int BPM = 0;
    private Button playMusic;
    private static SensorManager sensorManager;
    private static Context context;

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
        final ConstraintLayout.LayoutParams lparams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        heartRateGetStartedButton = (Button) view.findViewById(R.id.measureHeartRateButton);
        playMusic = (Button) view.findViewById(R.id.playMusicButton);

        heartRateGetStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getHeartRate();
                // we are unable to use any of our heart rate sensor methods as the emulator does not actually have any hardware or sensors
                // so in order to demonstrate  the rest of our program's functionality we are simulating a heart rate
                // our heart rate methods are below, commented out so they dont affect the code
                  //  startActivity(new Intent(getActivity(), HeartRateMonitor.class));
               // simulateHeartRate(40, 80);
                //Toast.makeText(getActivity(), "Your heart rate is " + BPM + " bpm", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), getHeartRate.class));

            }

        });


        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (BPM == 0) {
                    Toast.makeText(getActivity(), "Please check your heart rate first and try again", Toast.LENGTH_SHORT).show();


                } else if (BPM < 40) {
                    BPM = 80;
                    setRandArtistAndTitle();
                    //Toast.makeText(getActivity(), randTitle + " by " + randArtist, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getActivity(), PlayMusic.class));



                }
                else if(BPM < 80){
                    BPM = BPM *2;
                    setRandArtistAndTitle();
                   // Toast.makeText(getActivity(), randTitle + " by " + randArtist, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getActivity(), PlayMusic.class));

                }
                else {
                    //Toast.makeText(getActivity(), randArtist + " " + randTitle, Toast.LENGTH_LONG).show();
                    //Toast.makeText(getActivity(), )

                           /* if (Math.random() < 0.25) {
                                Toast.makeText(getActivity(), "Hip Hop is Dead by Nas", Toast.LENGTH_LONG).show();
                            } else if (Math.random() < 0.50) {
                                Toast.makeText(getActivity(), "Cry by Faith Hill", Toast.LENGTH_LONG).show();
                            } else if (Math.random() < 0.75){
                                Toast.makeText(getActivity(), "I Just Wanna Live by Good Charlotte", Toast.LENGTH_LONG).show();
                            } else if (Math.random() < 0.99){
                                Toast.makeText(getActivity(), "Answer in the Sky by Elton John", Toast.LENGTH_LONG).show();
                            }
                            */

                    setRandArtistAndTitle();
                    startActivity(new Intent(getActivity(), PlayMusic.class));

                    // Toast.makeText(getActivity(), randTitle + " by " + randArtist, Toast.LENGTH_LONG).show();


                }


            }

        });
        return view;
        //return for oncreateView


    }

    public static void simulateHeartRate(int min, int max) {
        BPM = (min + (int) (Math.random() * ((max - min) + 1)));


    }


}