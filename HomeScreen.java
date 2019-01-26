package com.example.conne.scoutingapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class HomeScreen extends Activity {

    Button pitScouting;
    Button inMatch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_screen);

        pitScouting = (Button) findViewById(R.id.pitScouting);

        inMatch = (Button) findViewById(R.id.inMatch);



        pitScouting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startPitScouting = new Intent(HomeScreen.this, PitScouting.class);

                startActivity(startPitScouting);


            }
        });


        inMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startInMatch = new Intent(HomeScreen.this, InMatch.class);

                startActivity(startInMatch);


            }
        });
    }


}
