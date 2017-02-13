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
        arrayFamily.add(new Word("father","әpә",R.drawable.family_father));
        arrayFamily.add(new Word("mother","әṭa",R.drawable.family_mother));
        arrayFamily.add(new Word("son","angsi",R.drawable.family_son));
        arrayFamily.add(new Word("daughter","tune",R.drawable.family_daughter));
        arrayFamily.add(new Word("older brother","taachi",R.drawable.family_older_brother));
        arrayFamily.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother));
        arrayFamily.add(new Word("older sister","teṭe",R.drawable.family_older_sister));
        arrayFamily.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister));
        arrayFamily.add(new Word("grandmother","ama",R.drawable.family_grandmother));
        arrayFamily.add(new Word("grandfather","paapa",R.drawable.family_grandfather));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayFamily);

        ListView listView = (ListView) findViewById(R.id.ListFamily);
        listView.setAdapter(itemsAdapter);
    }
}
