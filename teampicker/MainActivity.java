package com.hossain.zahid.teampicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> getArrayList() {
        return arrayList;
    }

    static ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    public MainActivity(){
        getArrayList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialisation
        final EditText insertName = (EditText) findViewById(R.id.addText);
        Button addButton = (Button) findViewById(R.id.addButton);
        Button generateBtn = (Button) findViewById(R.id.generateBtn);
        final ListView playerList = (ListView) findViewById(R.id.playerList);
        arrayList = new ArrayList<String>();

        //add players
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getPlayer = insertName.getText().toString();

                //if nothing is entered, tell the user to enter something
                if (getPlayer == null || getPlayer.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Add a player please, you forgot to add players name", Toast.LENGTH_LONG).show();

                }
                //there are less than 22 players, allow user to add
                else if (arrayList.size() < 22) {
                    arrayList.add(getPlayer);
                    adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, arrayList);
                    playerList.setAdapter(adapter);
                    ((EditText) findViewById(R.id.addText)).setText(" ");
                }
                //If there are too many players, tell user that it exceeds 11 a side games.
                else {
                    Toast.makeText(getBaseContext(), "Can't add anymore players, it exceeds 11 a side play", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Generate team
        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If there are no players in the list, don't allow user to continue.
                if (arrayList.size() == 0) {
                    Toast.makeText(getBaseContext(), "Add a minimum of 8 players first", Toast.LENGTH_LONG).show();
                }
                //if there aren't enough players for a 5 a side, don't allow user to continue
                else if (arrayList.size() < 10) {
                    Toast.makeText(getBaseContext(), "You need a minimum of 10 players before generating teams", Toast.LENGTH_LONG).show();
                    Toast.makeText(getBaseContext(), "10 players will make it 5 a side game", Toast.LENGTH_LONG).show();
                }
                //Continue if conditions required are met.
                else{
//                    Collections.shuffle(arrayList);
                    Intent intent = new Intent(MainActivity.this, teams.class);
                    startActivity(intent);
                }


            }
        });
    }
}

// new code underneath





