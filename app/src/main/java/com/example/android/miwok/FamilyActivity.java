package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> arrayFamily= new ArrayList<Word>();
        arrayFamily.add(new Word("әpә","father",R.drawable.family_father,R.raw.family_father));
        arrayFamily.add(new Word("әṭa","mother",R.drawable.family_mother,R.raw.family_mother));
        arrayFamily.add(new Word("angsi","son",R.drawable.family_son,R.raw.family_son ));
        arrayFamily.add(new Word("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        arrayFamily.add(new Word("taachi","older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        arrayFamily.add(new Word("chalitti","younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        arrayFamily.add(new Word("teṭe","older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        arrayFamily.add(new Word("kolliti","younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        arrayFamily.add(new Word("ama","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        arrayFamily.add(new Word("paapa","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayFamily,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.ListFamily);
        listView.setAdapter(itemsAdapter);
    }
}
