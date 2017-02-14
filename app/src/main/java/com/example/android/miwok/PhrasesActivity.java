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
        arrayPhrases.add(new Word("minto wuksus","Where are you going?"));
        arrayPhrases.add(new Word("tinnә oyaase'nә","What is your name?"));
        arrayPhrases.add(new Word("oyaaset...","My name is..."));
        arrayPhrases.add(new Word("michәksәs?","How are you feeling?"));
        arrayPhrases.add(new Word("kuchi achit","I’m feeling good."));
        arrayPhrases.add(new Word("әәnәs'aa?","Are you coming?"));
        arrayPhrases.add(new Word("hәә’ әәnәm","Yes, I’m coming."));
        arrayPhrases.add(new Word("әәnәm","I’m coming."));
        arrayPhrases.add(new Word("yoowutis","Let’s go"));
        arrayPhrases.add(new Word("әnni'nem","Come here."));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayPhrases,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.ListPhrases);
        listView.setAdapter(itemsAdapter);
    }
}
