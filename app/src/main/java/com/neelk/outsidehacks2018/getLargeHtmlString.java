package com.neelk.outsidehacks2018;

import android.os.AsyncTask;
import android.os.StrictMode;

import org.jsoup.Jsoup;

import java.io.IOException;

import static com.neelk.outsidehacks2018.HeartRateFragment.BPM;
import static com.neelk.outsidehacks2018.htmlParser.parseHTMLselectSONG;
import static com.neelk.outsidehacks2018.htmlParser.randSongBasedOnGenres;

public class getLargeHtmlString {



    public static void setRandArtistAndTitle(){

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);

        String url = "http://www.cs.ubc.ca/~davet/music/bpm/" + BPM + ".html";
        String scrapeHtmlBigLine = null;
        try {
            scrapeHtmlBigLine = Jsoup.connect(url).get().html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(url);
        //System.out.println(scrapeHtmlBigLine);
        parseHTMLselectSONG(scrapeHtmlBigLine);
        //System.out.println(scrapeHtmlBigLine);



    }



}

