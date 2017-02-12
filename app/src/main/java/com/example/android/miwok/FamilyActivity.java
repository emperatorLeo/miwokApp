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
        arrayFamily.add(new Word("father","әpә"));
        arrayFamily.add(new Word("mother","әṭa"));
        arrayFamily.add(new Word("son","angsi"));
        arrayFamily.add(new Word("daughter","tune"));
        arrayFamily.add(new Word("older brother","taachi"));
        arrayFamily.add(new Word("younger brother","chalitti"));
        arrayFamily.add(new Word("older sister","teṭe"));
        arrayFamily.add(new Word("younger sister","kolliti"));
        arrayFamily.add(new Word("grandmother","ama"));
        arrayFamily.add(new Word("grandfather","paapa"));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayFamily);

        ListView listView = (ListView) findViewById(R.id.ListFamily);
        listView.setAdapter(itemsAdapter);
    }
}
