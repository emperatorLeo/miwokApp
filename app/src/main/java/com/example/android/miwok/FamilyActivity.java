package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer media;
    private ArrayList<Word> arrayFamily;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        arrayFamily= new ArrayList<Word>();
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

        ListView listView = (ListView) findViewById(R.id.Word_list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView adapterView, View view, int position , long l){
                Word word = arrayFamily.get(position);
                releaseMediaPlayer();
                media = MediaPlayer.create(FamilyActivity.this,word.getAudioResourceId());
                media.start();
                media.setOnCompletionListener(onCompletionListener);
            }
        });
    }
    //this method is useful to know when the variable media is empty or not , to configure
    //and to use just the same object instead create a bran new object
    public void releaseMediaPlayer() {

        // If the media player is not null, then it may be currently playing a sound.
        if (media != null) {
            Log.e("mensaje", "releaseMediaPlayer: the variable is not empty");
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            media.stop();
            media.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            media = null;
        }
        else{
            Log.e("mensaje", "releaseMediaPlayer: the variable is empty");
        }
    }
    @Override
    public void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }
}
