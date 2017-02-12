package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

      ArrayList<Word> arrayNombres= new ArrayList<Word>();
        arrayNombres.add(new Word("one","lutti"));
        arrayNombres.add(new Word("two","otiiko"));
        arrayNombres.add(new Word("three","tolookosu"));
        arrayNombres.add(new Word("four","oyyisa"));
        arrayNombres.add(new Word("five","massokka"));
        arrayNombres.add(new Word("six","temmokka"));
        arrayNombres.add(new Word("seven","kenekaku"));
        arrayNombres.add(new Word("eight","kawinta"));
        arrayNombres.add(new Word("nine","wo'e"));
        arrayNombres.add(new Word("ten","na'aacha"));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayNombres);

        ListView listView = (ListView) findViewById(R.id.List);
        listView.setAdapter(itemsAdapter);
    }
}
