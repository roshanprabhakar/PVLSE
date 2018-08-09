package com.neelk.outsidehacks2018;

import android.os.StrictMode;
import android.util.JsonReader;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


import static com.neelk.outsidehacks2018.htmlParser.randArtist;
import static com.neelk.outsidehacks2018.htmlParser.randTitle;


public class GetVideoId {

    public static String videoID;

    public static void  setVideoID() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        StringBuilder builder = new StringBuilder();


        try {
            String combinedTitleArtist = randTitle + "+" + randArtist;
            combinedTitleArtist.replace(" ", "+");
            URL youTubeUrl = new URL("https://www.googleapis.com/youtube/v3/search?key=AIzaSyD2sfk5EB8GiIOYP5-pdAFyMdk8xv4aPhw&part=snippet&q=" + combinedTitleArtist);
//            URL youTubeUrl = new URL("https://www.googleapis.com/youtube/v3/search?key=AIzaSyD2sfk5EB8GiIOYP5-pdAFyMdk8xv4aPhw&part=snippet&q=" + randTitle + "+" + randArtist);
            HttpsURLConnection yConn = (HttpsURLConnection) youTubeUrl.openConnection();
            yConn.setRequestProperty("Accept", "application/json");
            if (yConn.getResponseCode() == 200) {
                InputStream responseBody = yConn.getInputStream();
                InputStreamReader responseBodyReader =
                        new InputStreamReader(responseBody, "UTF-8");
                try (BufferedReader in = new BufferedReader(responseBodyReader)) {
                    String line;
                    while ((line = in.readLine()) != null) {
                        builder.append(line); // + "\r\n"(no need, json has no line breaks!)
                    }
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("JSON: " + builder.toString());
                JSONObject response = new JSONObject(builder.toString());
                JSONArray results = (JSONArray) response.get("items");
                JSONObject item = results.getJSONObject(0);
                JSONObject id = (JSONObject) item.get("id");
                videoID = (String) id.get("videoId");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
       // System.out.println(videoID);
    }
}



//                JsonReader jsonReader = new JsonReader(responseBodyReader);
//                jsonReader.beginObject(); // Start processing the JSON object
//                while (jsonReader.hasNext()) { // Loop through all keys
//                    String key = jsonReader.nextName(); // Fetch the next key
//                    if (key.equals("items")) { // Check if desired key
//                        // Fetch the value as a String
//                        //String value = jsonReader.nextString();
//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
//                            String ikey = jsonReader.nextName(); // Fetch the next key
//                            if (ikey.equals("id")) { // Check if desired key
//                                String nkey = jsonReader.nextName(); // Fetch the next key
//                                if (nkey.equals("videoId")) { // Check if desired key
//                                    String value = jsonReader.nextString();
//                                    jsonReader.close();
//                                    yConn.disconnect();
//                                    return value;
//                                } else {
//                                    jsonReader.skipValue(); // Skip values of other keys
//                                }
//                            } else {
//                                jsonReader.skipValue(); // Skip values of other keys
//                            }
//                        }
//                        jsonReader.endArray();
//                    } else {
//                        jsonReader.skipValue(); // Skip values of other keys
//                    }
//                }
//                jsonReader.close();
//                yConn.disconnect();
//                return "nothing";
// }
// return "video id Error code " + yConn.getResponseCode();
