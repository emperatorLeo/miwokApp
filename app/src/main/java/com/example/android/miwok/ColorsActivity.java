package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> arrayColors= new ArrayList<Word>();
        arrayColors.add(new Word("red","wetetti"));
        arrayColors.add(new Word("green","chokokki"));
        arrayColors.add(new Word("brown","ṭakaakki"));
        arrayColors.add(new Word("gray","ṭopoppi"));
        arrayColors.add(new Word("black","kululli"));
        arrayColors.add(new Word("white","kelelli"));
        arrayColors.add(new Word("dusty yellow","ṭopiisә"));
        arrayColors.add(new Word("mustard yellow","chiwiiṭә"));
        
        WordAdapter itemsAdapter = new WordAdapter(this,arrayColors);

        ListView listView = (ListView) findViewById(R.id.ListColors);
        listView.setAdapter(itemsAdapter);
    }
}
