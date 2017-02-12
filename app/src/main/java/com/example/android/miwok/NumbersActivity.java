package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

      ArrayList<String> arrayNombres= new ArrayList<String>();
        arrayNombres.add("one");
        arrayNombres.add("two");
        arrayNombres.add("three");
        arrayNombres.add("four");
        arrayNombres.add("five");
        arrayNombres.add("six");
        arrayNombres.add("seven");
        arrayNombres.add("eight");
        arrayNombres.add("nine");
        arrayNombres.add("ten");

        int index;

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,R.layout.list_item,arrayNombres);

        ListView listView = (ListView) findViewById(R.id.List);

        listView.setAdapter(itemsAdapter);
    }
}
