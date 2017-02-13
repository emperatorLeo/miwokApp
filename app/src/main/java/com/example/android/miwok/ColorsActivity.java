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
        arrayColors.add(new Word("wetetti","red",R.drawable.color_red));
        arrayColors.add(new Word("chokokki","green",R.drawable.color_green));
        arrayColors.add(new Word("ṭakaakki","brown",R.drawable.color_brown));
        arrayColors.add(new Word("ṭopoppi","gray",R.drawable.color_gray));
        arrayColors.add(new Word("kululli","black",R.drawable.color_black));
        arrayColors.add(new Word("kelelli","white",R.drawable.color_white));
        arrayColors.add(new Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow));
        arrayColors.add(new Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayColors);

        ListView listView = (ListView) findViewById(R.id.ListColors);
        listView.setAdapter(itemsAdapter);
    }
}
