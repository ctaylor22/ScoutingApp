package com.example.conne.scoutingapp;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PitScouting extends AppCompatActivity {
    Button saveButton;
    Button home;

    //Tells What these variables are... Edit Text
    EditText teamNumberInput;
    EditText mainObjectiveInput;
    EditText driveTrainTypeInput;
    EditText shooterBotInput;
    EditText maxFuelInput;
    EditText fuelSecondInput;
    EditText gearTimeInput;
    EditText speedFeetSecondInput;
    EditText targetSystemInput;
    EditText comments;
    EditText plannedBallsShotInput;
    EditText plannedGearDeliveriesInput;


    String newLine = "\r";
    String comma = ",";


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_scouting);

        home = (Button) findViewById(R.id.home);
        saveButton = (Button) findViewById(R.id.saveButton);


        teamNumberInput = (EditText) findViewById(R.id.teamNumberInput);
        mainObjectiveInput = (EditText) findViewById(R.id.mainObjectiveInput);
        driveTrainTypeInput = (EditText) findViewById(R.id.driveTrainTypeInput);
        shooterBotInput = (EditText) findViewById(R.id.shooterBotInput);
        maxFuelInput = (EditText) findViewById(R.id.maxFuelInput);
        mainObjectiveInput = (EditText) findViewById(R.id.mainObjectiveInput);
        driveTrainTypeInput = (EditText) findViewById(R.id.driveTrainTypeInput);
        shooterBotInput = (EditText) findViewById(R.id.shooterBotInput);
        fuelSecondInput = (EditText) findViewById(R.id.fuelSecondInput);
        gearTimeInput = (EditText) findViewById(R.id.gearTimeInput);
        speedFeetSecondInput = (EditText) findViewById(R.id.speedFeetSecondInput);
        targetSystemInput = (EditText) findViewById(R.id.targetSystemInput);
        comments = (EditText) findViewById(R.id.Comments);
        plannedBallsShotInput = (EditText) findViewById(R.id.plannedBallsShotInput);
        plannedGearDeliveriesInput = (EditText) findViewById(R.id.plannedGearDeliveriesInput);

        //onClick... Send You to Home Screen
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startHome = new Intent(PitScouting.this, HomeScreen.class);

                startActivity(startHome);

            }
        });


        //OnClick... Saves All Data To Internal Storage
        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //Location Of Folder For Data
                File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "ScoutingApp");

                //means... If this folder doesnt exist make it
                if (!folder.exists()) {

                    folder.mkdir();

                }

                //Location for Pit Scouting Data
                File fosFolder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/ScoutingApp", "PitScouting");

                //means... If this folder doesnt exist make it
                if (!fosFolder.exists()) {

                    fosFolder.mkdir();


                }


                //Location of Data... And Choosing data type... ex. CSV, TXT, etc
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/ScoutingApp/PitScouting", "PS_UnForm.csv");

                try {

                    //Outputs Data to variable... file
                    FileOutputStream fos = new FileOutputStream(file, true);

                    fos.write(newLine.getBytes());
                    fos.write(teamNumberInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(mainObjectiveInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(driveTrainTypeInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(shooterBotInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(maxFuelInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(fuelSecondInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(gearTimeInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(speedFeetSecondInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(targetSystemInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(plannedBallsShotInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(plannedGearDeliveriesInput.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.write(comments.getText().toString().getBytes());
                    fos.write(comma.getBytes());
                    fos.close();

                    //Clears Text Fields
                    teamNumberInput.setText("");
                    mainObjectiveInput.setText("");
                    driveTrainTypeInput.setText("");
                    shooterBotInput.setText("");
                    maxFuelInput.setText("");
                    fuelSecondInput.setText("");
                    gearTimeInput.setText("");
                    speedFeetSecondInput.setText("");
                    targetSystemInput.setText("");
                    comments.setText("");
                    plannedBallsShotInput.setText("");
                    plannedGearDeliveriesInput.setText("");

                    //If it Saves correctly it Displays Message "Saved Succesfully"
                    Toast saved = Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT);
                    saved.show();
                } catch (IOException e) {
                    //catches errors
                    e.printStackTrace();

                }


            }


        });

    }
}





