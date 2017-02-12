package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> arrayPhrases= new ArrayList<Word>();
        arrayPhrases.add(new Word("Where are you going?","minto wuksus"));
        arrayPhrases.add(new Word("What is your name?","tinnә oyaase'nә"));
        arrayPhrases.add(new Word("My name is...","oyaaset..."));
        arrayPhrases.add(new Word("How are you feeling?","michәksәs?"));
        arrayPhrases.add(new Word("I’m feeling good.","kuchi achit"));
        arrayPhrases.add(new Word("Are you coming?","әәnәs'aa?"));
        arrayPhrases.add(new Word("Yes, I’m coming.","hәә’ әәnәm"));
        arrayPhrases.add(new Word("I’m coming.","әәnәm"));
        arrayPhrases.add(new Word("Let’s go","yoowutis"));
        arrayPhrases.add(new Word("Come here.","әnni'nem"));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayPhrases);

        ListView listView = (ListView) findViewById(R.id.ListPhrases);
        listView.setAdapter(itemsAdapter);
    }
}
