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
        arrayColors.add(new Word("red","wetetti",R.drawable.color_red));
        arrayColors.add(new Word("green","chokokki",R.drawable.color_green));
        arrayColors.add(new Word("brown","ṭakaakki",R.drawable.color_brown));
        arrayColors.add(new Word("gray","ṭopoppi",R.drawable.color_gray));
        arrayColors.add(new Word("black","kululli",R.drawable.color_black));
        arrayColors.add(new Word("white","kelelli",R.drawable.color_white));
        arrayColors.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow));
        arrayColors.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayColors);

        ListView listView = (ListView) findViewById(R.id.ListColors);
        listView.setAdapter(itemsAdapter);
    }
}
