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
        arrayNombres.add(new Word("one","lutti",R.drawable.number_one));
        arrayNombres.add(new Word("two","otiiko",R.drawable.number_two));
        arrayNombres.add(new Word("three","tolookosu",R.drawable.number_three));
        arrayNombres.add(new Word("four","oyyisa",R.drawable.number_four));
        arrayNombres.add(new Word("five","massokka",R.drawable.number_five));
        arrayNombres.add(new Word("six","temmokka",R.drawable.number_six));
        arrayNombres.add(new Word("seven","kenekaku",R.drawable.number_seven));
        arrayNombres.add(new Word("eight","kawinta",R.drawable.number_eight));
        arrayNombres.add(new Word("nine","wo'e",R.drawable.number_nine));
        arrayNombres.add(new Word("ten","na'aacha",R.drawable.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayNombres);

        ListView listView = (ListView) findViewById(R.id.List);
        listView.setAdapter(itemsAdapter);
    }
}
