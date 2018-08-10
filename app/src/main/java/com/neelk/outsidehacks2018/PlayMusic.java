package com.neelk.outsidehacks2018;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static com.neelk.outsidehacks2018.getLargeHtmlString.setRandArtistAndTitle;
import static com.neelk.outsidehacks2018.htmlParser.randArtist;
import static com.neelk.outsidehacks2018.htmlParser.randSongBasedOnGenres;
import static com.neelk.outsidehacks2018.htmlParser.randTitle;

public class PlayMusic extends YouTubeBaseActivity {


    private TextView songNameTextView;
    private YouTubePlayerView youTubePlayerView;
    private String apiKey;
    private Button back;
    private Button nextSong;
    private String formattedSongInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        nextSong = findViewById(R.id.nextSongBtn);
        back = findViewById(R.id.backBtn);
        youTubePlayerView = findViewById(R.id.youtubePlayer);
        songNameTextView = (TextView) findViewById(R.id.musicTitleTextView);
       formattedSongInfo = randTitle + " by " + randArtist;
       formattedSongInfo.replaceAll("&amp", "and");
        songNameTextView.setText(formattedSongInfo);

        apiKey = "AIzaSyD2sfk5EB8GiIOYP5-pdAFyMdk8xv4aPhw";

       // mp.start();

        initYoutube();

       /* playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying){
                    mp.pause();
                    playPause.setText("Play");
                }
                else{
                    mp.start();
                    playPause.setText("Pause");
                }
                isPlaying = !isPlaying;
            }
        });
*/

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectGenre.clearSelectedGenres();
                startActivity(new Intent(PlayMusic.this, Home.class));
            }
        });

        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandArtistAndTitle();
                randSongBasedOnGenres(SelectGenre.getSelectedGenres());
                initYoutube();
                recreate();
            }
        });


    }

    @Override
    public void onDestroy() {

        super.onDestroy();


    }

    public void initYoutube(){

        GetVideoId.setVideoID();

        youTubePlayerView.initialize("YOUR API KEY",
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.

                        youTubePlayer.cueVideo(GetVideoId.videoID);
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {
                        Toast.makeText(PlayMusic.this, "Youtube Failed!", Toast.LENGTH_SHORT).show();

                    }
                });

    }


}
