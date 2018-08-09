package com.neelk.outsidehacks2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

import static com.neelk.outsidehacks2018.getLargeHtmlString.setRandArtistAndTitle;

public class SelectGenre extends AppCompatActivity {

    private CheckBox danceCheckBox;
    private CheckBox classicalCheckBox;
    private CheckBox rapCheckBox;
    private CheckBox countryCheckBox;
    private CheckBox rockCheckBox;
    private CheckBox allCheckBox;
    private CheckBox rnbCheckBox;
    private Button next;
    private static ArrayList<String> selectedGenres  = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_genre);

        CheckBox danceCheckBox = findViewById(R.id.danceCheckBox);
        CheckBox rockCheckBox = findViewById(R.id.rockCheckBox);
        CheckBox classicalCheckBox = findViewById(R.id.classicalCheckBox);
        CheckBox rapCheckBox = findViewById(R.id.rapCheckBox);
        CheckBox countryCheckBox = findViewById(R.id.countryCheckBox);
        CheckBox rnb = findViewById(R.id.rnbCheckBox);
        CheckBox all = findViewById(R.id.allCheckBox);

        Button next = findViewById(R.id.nextBtn);


//                selectedGenres.add("Rap");
//                selectedGenres.add("Rock");
//                selectedGenres.add("Disco 2000s");
//                selectedGenres.add("Jazz");


        classicalCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedGenres.add("Classical");
            }
        });


        countryCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedGenres.add("Slow Country");
                selectedGenres.add("Fast Country");
                selectedGenres.add("Country");
            }
        });

        rapCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedGenres.add("Rap");
            }
        });

        rockCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedGenres.add("Rock");
                selectedGenres.add("Rock 1950s");
                selectedGenres.add("Rock 1960s");
                selectedGenres.add("Rock 1970s");
                selectedGenres.add("Rock 1980s");
                selectedGenres.add("Rock 1990s");
                selectedGenres.add("Rock 2000s");
                selectedGenres.add("Rock 2010s");
                selectedGenres.add("Slow Rock");
                selectedGenres.add("Fast Rock");


            }
        });

        danceCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedGenres.add("Dance");
                selectedGenres.add("Dance 1960s");
                selectedGenres.add("Dance 1970s");
                selectedGenres.add("Dance 1980s");
                selectedGenres.add("Dance 1990s");
                selectedGenres.add("Dance 2000s");
                selectedGenres.add("Dance 2010s");
                selectedGenres.add("Slow Dance");
                selectedGenres.add("Fast Dance");
            }
        });

        rnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedGenres.add("R&B 1980s");
                selectedGenres.add("R&B 1990s");
                selectedGenres.add("R&B 2000s");
                selectedGenres.add("Reggae");

            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    selectedGenres.add("R&B 1980s");
                    selectedGenres.add("R&B 1990s");
                    selectedGenres.add("R&B 2000s");
                    selectedGenres.add("Reggae");
                    selectedGenres.add("Dance");
                    selectedGenres.add("Dance 1960s");
                    selectedGenres.add("Dance 1970s");
                    selectedGenres.add("Dance 1980s");
                    selectedGenres.add("Dance 1990s");
                    selectedGenres.add("Dance 2000s");
                    selectedGenres.add("Dance 2010s");
                    selectedGenres.add("Slow Dance");
                    selectedGenres.add("Fast Dance");
                    selectedGenres.add("Rock");
                    selectedGenres.add("Rock 1950s");
                    selectedGenres.add("Rock 1960s");
                    selectedGenres.add("Rock 1970s");
                    selectedGenres.add("Rock 1980s");
                    selectedGenres.add("Rock 1990s");
                    selectedGenres.add("Rock 2000s");
                    selectedGenres.add("Rock 2010s");
                    selectedGenres.add("Slow Rock");
                    selectedGenres.add("Fast Rock");
                    selectedGenres.add("Rap");
                    selectedGenres.add("Slow Country");
                    selectedGenres.add("Fast Country");
                    selectedGenres.add("Country");
                    selectedGenres.add("Classical");


            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setRandArtistAndTitle();
                htmlParser.randSongBasedOnGenres(selectedGenres);
              //  System.out.println("CHECK HERE: " + selectedGenres.toString());
                startActivity(new Intent(SelectGenre.this, PlayMusic.class));
            }
        });

    }

    public static ArrayList<String> getSelectedGenres() {
        return selectedGenres;
    }

    public static void clearSelectedGenres(){
        selectedGenres.clear();
    }
}


