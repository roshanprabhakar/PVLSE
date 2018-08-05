package com.neelk.outsidehacks2018;

import android.os.AsyncTask;
import android.util.Base64;

import com.google.common.base.Charsets;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import java.util.Base64.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.util.EntityUtils;

import static android.net.wifi.WifiConfiguration.Status.strings;

public class spotifyRequest  {

    private static String url;
    private static String userID;
    private static String authUrl;




    protected Void doInBackground(Void... voids) {
        String clientID = "eb3d9445cd234aeb9476dd3dba30b027";
        String clientSecret = "ac4e6074379e4bfa934a41fea5661ce1";
        String auth = (clientID + ":" + clientSecret);
        String encodedAuth = "Basic " + java.util.Base64.getEncoder().encodeToString(auth.getBytes());
        String playlistId = "37i9dQZEVXbLRQDuF5jeBp";
        userID = "k._neel";
        url = "https://api.spotify.com/v1/users/" + userID + "/" + playlistId  + "/tracks";
        authUrl = "https://accounts.spotify.com/api/token";

        try {
            com.mashape.unirest.http.HttpResponse<JsonNode> authResponse = Unirest.post(authUrl)
                    .header("Authorization", auth)
                    .queryString("grant_type", "client_credentials")
                    .asJson();
            System.out.println(authResponse.getBody().toString());
        } catch (UnirestException e) {
            e.printStackTrace();
            System.out.println(e.getCause());
        }


        /*try {
            com.mashape.unirest.http.HttpResponse<JsonNode> spotifyResponse = Unirest.get(url)
                     .header("accept", "application/json")
                     .header("client_id", clientID)
                     .header("client_secret", clientSecret)
                   // .queryString("user_id", user)
                     .asJson();
            System.out.println(spotifyResponse.getBody().toString());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
       return  null;*/






       /* HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("application/json", "accept");
        httpGet.addHeader("client_id", clientID);
        httpGet.addHeader("client_secret", clientSecret);
        try {
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            Header encodingHeader = entity.getContentEncoding();

// you need to know the encoding to parse correctly
            Charset encoding = (encodingHeader == null) ? StandardCharsets.UTF_8 :
                    Charsets.toString(encodingHeader.getValue());

// use org.apache.http.util.EntityUtils to read json as string
            String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);

            JSONObject o = null;
            try {
                o = new JSONObject(json);
                System.out.println(o.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;*/
       return null;
    }
}

