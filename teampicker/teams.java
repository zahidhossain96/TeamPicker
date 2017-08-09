package com.hossain.zahid.teampicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class teams extends AppCompatActivity {
    private ArrayAdapter adapter2;
    private ArrayAdapter adapter3;
    private ArrayList<String> a;
    private ArrayList<String> b;
    MainActivity mainActivity = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        //If there are uneven number of players
        if(mainActivity.getArrayList().size()%2 !=0){
            Toast.makeText(getBaseContext(), "Uneven number of players, odd number of players in each team.", Toast.LENGTH_LONG).show();
        }

        a = new ArrayList<String>();
        b = new ArrayList<String>();
        //Shuffle player orders to randomly split teams in half
        Collections.shuffle(mainActivity.getArrayList());
        Collections.shuffle(mainActivity.getArrayList());
        Collections.shuffle(mainActivity.getArrayList());
        Collections.shuffle(mainActivity.getArrayList());


        //Add first half of main array to team a
        for (int i = 0; i <mainActivity.getArrayList().size()/2; i++){
            a.add(mainActivity.getArrayList().get(i));
        }


        //add players not in team a to team b
        for (int i = mainActivity.getArrayList().size()/2; i >= mainActivity.getArrayList().size()/2 && i<  mainActivity.getArrayList().size(); i++){
            b.add(mainActivity.getArrayList().get(i));
        }


        //display teams on screen.
        ListView team1List = (ListView) findViewById(R.id.playerList);
        ListView team2List = (ListView) findViewById(R.id.playerList2);
        adapter2 = new ArrayAdapter<String>(teams.this, android.R.layout.simple_expandable_list_item_1, a);
        adapter3 = new ArrayAdapter<String>(teams.this, android.R.layout.simple_expandable_list_item_1, b);
        team1List.setAdapter(adapter2);
        team2List.setAdapter(adapter3);
    }

}
