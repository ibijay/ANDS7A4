package com.example.bijay.myapp_names;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ActSQLiteOpenHelper db = new ActSQLiteOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.onUpgrade(db.getWritableDatabase(), 1, 2);
        db.createName(new Name("Preetika", "Kaur"));
        db.createName(new Name("Abhinadan", "Chavate"));
        db.createName(new Name("Bijay", "Swain"));
        db.createName(new Name("Elson", "P"));
        db.createName(new Name("Vimal", "V"));
        db.createName(new Name("Shruti", "Agarwal"));
        db.createName(new Name("Kavya", "Ramya"));
        db.createName(new Name("Gitanjali", "G"));
        db.createName(new Name("BhanuShree", "P"));
   }

    public void display(View v) {

        List<Name> list = db.getAllNames();

        ArrayAdapter<String> myAdapter;
        List<String> stringName = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.lvNames);

        for (int i = 0; i<list.size();i++){
            stringName.add(i, list.get(i).toString());
        }

        myAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,stringName);
        listView.setAdapter(myAdapter);

        finish();
    }
}