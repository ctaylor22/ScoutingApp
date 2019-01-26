package com.example.conne.scoutingapp;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InMatch extends AppCompatActivity {

    public int counterValue = 0;

    TextView counterText;

    Spinner spinner;
    Spinner spinner2;

    Button saveButton;
    Button home;
    Button plus;
    Button minus;


    RadioGroup baselineCrossedRG;
    RadioButton baselineCrossedRB;

    RadioGroup gearPlacedRG;
    RadioButton gearPlacedRB;

    RadioGroup allianceColorRG;
    RadioButton allianceColorRB;

    EditText teamNumberInput;
    EditText matchNumberInput;
    EditText scoutersNameInput;
    EditText totalMatchPoints;

    RadioGroup defenseRG;
    RadioButton defenseRB;

    RadioGroup defense;
    RadioButton againstDefenseRB;

    RadioGroup climbRG;
    RadioButton climbRB;

    RadioGroup breakdownRG;
    RadioButton breakdownRB;

    /*EditText changeInKpaInputB;
    EditText baselineCrossedInput;
    EditText gearPlacedInput;
    EditText defenseInput;
    EditText againstDefenseInput;
    EditText gearsDeliveredInput;
    EditText climbInput;
    EditText breakdownInput;
    EditText userCommentaryInput;
*/

    String newLine = "\n";
    String comma = ", ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_match);


        //Toolbar inMatchToolbar = (Toolbar) findViewById(R.id)




        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.oneTo100, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        spinner2.setAdapter(adapter);

        home = (Button) findViewById(R.id.home);
        minus = (Button) findViewById(R.id.minus);
        plus = (Button) findViewById(R.id.plus);

        defense = (RadioGroup) findViewById(R.id.againstDefenseRG);
        defenseRG = (RadioGroup) findViewById(R.id.defenseRG);
        baselineCrossedRG = (RadioGroup) findViewById(R.id.baseLinedCrossedRG);
        gearPlacedRG = (RadioGroup) findViewById(R.id.gearPlacedRG);
        climbRG = (RadioGroup) findViewById(R.id.climbRG);
        breakdownRG = (RadioGroup) findViewById(R.id.breakdownRG);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);




        totalMatchPoints = (EditText) findViewById(R.id.totalMatchPoints);
        scoutersNameInput = (EditText) findViewById(R.id.scoutersNameInput);
        matchNumberInput = (EditText) findViewById(R.id.matchNumberInput);
        teamNumberInput = (EditText) findViewById (R.id.teamNumberInput);
        /*changeInKpaInputB = (EditText) findViewById(R.id.changeInKpaInputB);
        baselineCrossedInput = (EditText) findViewById(R.id.baselineCrossedInput);
        gearPlacedInput = (EditText) findViewById(R.id.gearPlacedInput);
        defenseInput = (EditText) findViewById(R.id.defenseInput);
        againstDefenseInput = (EditText) findViewById(R.id.againstDefenseInput);
        gearsDeliveredInput = (EditText) findViewById(R.id.gearsDeliveredInput);
        climbInput = (EditText) findViewById(R.id.climbInput);
        breakdownInput = (EditText) findViewById(R.id.breakdownInput);
        userCommentaryInput = (EditText) findViewById(R.id.userCommentaryInput);*/





        counterText = (TextView)findViewById(R.id.counterText);

        saveButton = (Button) findViewById(R.id.saveButton);




        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue++;
                counterText.setText(String.valueOf(counterValue));

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue--;
                counterText.setText(String.valueOf(counterValue));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startHome = new Intent(InMatch.this, HomeScreen.class);

                startActivity(startHome);

            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                        RadioGroup defense = (RadioGroup) findViewById(R.id.againstDefenseRG);
                        againstDefenseRB = (RadioButton) findViewById(defense.getCheckedRadioButtonId());

                        RadioGroup baselineCrossedRG = (RadioGroup)findViewById(R.id.baseLinedCrossedRG);
                        baselineCrossedRB = (RadioButton)findViewById(baselineCrossedRG.getCheckedRadioButtonId());


                        RadioGroup gearPlacedRG = (RadioGroup) findViewById(R.id.gearPlacedRG);
                        gearPlacedRB = (RadioButton) findViewById(gearPlacedRG.getCheckedRadioButtonId());

                        RadioGroup defenseRG = (RadioGroup) findViewById(R.id.defenseRG);
                        defenseRB = (RadioButton) findViewById(defenseRG.getCheckedRadioButtonId());

                        RadioGroup climbRG = (RadioGroup) findViewById(R.id.climbRG);
                        climbRB = (RadioButton) findViewById(climbRG.getCheckedRadioButtonId());

                        RadioGroup breakdownRG = (RadioGroup) findViewById(R.id.breakdownRG);
                        breakdownRB = (RadioButton) findViewById(breakdownRG.getCheckedRadioButtonId());

                        RadioGroup allianceColorRG = (RadioGroup) findViewById(R.id.allianceColorRG);
                        allianceColorRB = (RadioButton) findViewById(allianceColorRG.getCheckedRadioButtonId());

                        Spinner spinner=(Spinner) findViewById(R.id.spinner);
                        String spinner1 = spinner.getSelectedItem().toString();


                        String changeInKpaA = spinner1;

                        Spinner spinner2=(Spinner) findViewById(R.id.spinner2);
                        String spinner3 = spinner2.getSelectedItem().toString();

                        String changeInKpaB = spinner3;





                File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "ScoutingApp");

                if (!folder.exists()) {

                    folder.mkdir();

                }

                File fosFolder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/ScoutingApp", "InGameInfo");


                if (!fosFolder.exists()) {


                    fosFolder.mkdir();

                }


                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/ScoutingApp/InGameInfo", "Scouting_InGame_Data.csv");




                int totalMatchPointsCheck = Integer.parseInt(totalMatchPoints.getText().toString());


                if (totalMatchPointsCheck < 500) {

                    try {




                        FileOutputStream fos = new FileOutputStream(file, true);

                        fos.write(newLine.getBytes());

                        fos.write(scoutersNameInput.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(matchNumberInput.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(teamNumberInput.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(changeInKpaA.getBytes());

                        fos.write(comma.getBytes());

                        fos.write(baselineCrossedRB.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(gearPlacedRB.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(changeInKpaB.getBytes());

                        fos.write(comma.getBytes());

                        fos.write(defenseRB.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(againstDefenseRB.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(counterText.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(climbRB.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(breakdownRB.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(allianceColorRB.getText().toString().getBytes());

                        fos.write(comma.getBytes());

                        fos.write(totalMatchPoints.getText().toString().getBytes());


                        teamNumberInput.setText("");
                        baselineCrossedRG.clearCheck();
                        gearPlacedRG.clearCheck();
                        defenseRG.clearCheck();
                        defense.clearCheck();
                        counterValue = 0;
                        counterText.setText("0");
                        climbRG.clearCheck();
                        breakdownRG.clearCheck();
                        totalMatchPoints.setText("");
                        int matchNumber = Integer.parseInt(matchNumberInput.getText().toString());
                        matchNumber++;
                        matchNumberInput.setText(Integer.toString(matchNumber));
                        spinner.setSelection(0);
                        spinner2.setSelection(0);








                        fos.close();

                        Toast saved = Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT);
                        saved.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }




                }else {

                    Toast failed = Toast.makeText(getApplicationContext(), "Total Match Points Excede Limit", Toast.LENGTH_LONG);

                    failed.show();



                }









            }
        });










    }

}
