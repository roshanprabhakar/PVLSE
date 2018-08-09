package com.neelk.outsidehacks2018;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.neelk.outsidehacks2018.HeartRateFragment.BPM;


public class HomeFragment extends Fragment {

    private Fragment fragment;
    private FragmentTransaction ft;
    private TextView lastHeartRate;


    public HomeFragment() {


    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
         lastHeartRate  = view.findViewById(R.id.lastHeartBeatTextView);

        if(BPM != 0){
            lastHeartRate.setText("Last Measured BPM: " + BPM);
        }


                return view;
    }


}


