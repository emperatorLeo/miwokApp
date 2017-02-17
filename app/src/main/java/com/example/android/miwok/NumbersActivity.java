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
        arrayNombres.add(new Word("lutti","one",R.drawable.number_one,R.raw.number_one));
        arrayNombres.add(new Word("otiiko","two",R.drawable.number_two,R.raw.number_two));
        arrayNombres.add(new Word("tolookosu","three",R.drawable.number_three,R.raw.number_three));
        arrayNombres.add(new Word("oyyisa","four",R.drawable.number_four,R.raw.number_four));
        arrayNombres.add(new Word("massokka","five",R.drawable.number_five,R.raw.number_five));
        arrayNombres.add(new Word("temmokka","six",R.drawable.number_six,R.raw.number_six));
        arrayNombres.add(new Word("kenekaku","seven",R.drawable.number_seven,R.raw.number_seven));
        arrayNombres.add(new Word("kawinta","eight",R.drawable.number_eight,R.raw.number_eight));
        arrayNombres.add(new Word("wo'e","nine",R.drawable.number_nine,R.raw.number_nine));
        arrayNombres.add(new Word("na'aacha","ten",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayNombres,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.List);
        listView.setAdapter(itemsAdapter);
    }
}
