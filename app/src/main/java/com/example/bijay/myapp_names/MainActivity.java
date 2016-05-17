package com.example.bijay.myapp_names;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ActSQLiteOpenHelper db;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    Button btn_Display;//OnClick Implementation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new ActSQLiteOpenHelper(this);
        db.getWritableDatabase();

        db.createName(new Name("Preetika", "Kaur"));
        db.createName(new Name("Abhinadan", "Chavate"));
        db.createName(new Name("Bijay", "Swain"));
        db.createName(new Name("Elson", "P"));
        db.createName(new Name("Vimal", "V"));
        db.createName(new Name("Shruti", "Agarwal"));
        db.createName(new Name("Kavya", "Ramya"));
        db.createName(new Name("Gitanjali", "G"));
        db.createName(new Name("BhanuShree", "P"));

        btn_Display = (Button) findViewById(R.id.btnDisplayNames);//OnClick Implementation

        btn_Display.setOnClickListener(new View.OnClickListener() { //OnClick Implementation
            @Override
            public void onClick(View v) {
                List<Name> list = db.getAllNames();

                ArrayAdapter<String> myAdapter;
                List<String> stringName = new ArrayList<>();
                ListView listView = (ListView) findViewById(R.id.lvNames);

                for (int i = 0; i < list.size(); i++) {
                    stringName.add(i, list.get(i).toString());
                }

                myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, stringName);
                listView.setAdapter(myAdapter);
            }
        });


    }

    /*public void Display(View v) {
        List<Name> list = db.getAllNames();

        ArrayAdapter<String> myAdapter;
        List<String> stringName = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.lvNames);

        for (int i = 0; i < list.size(); i++) {
            stringName.add(i, list.get(i).toString());
        }

        myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, stringName);
        listView.setAdapter(myAdapter);
    }*/
    //in the layout add OnClick of btnDisplayNames with Display method
}
