package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
     private MediaPlayer media;
     private ArrayList<Word> arrayPhrases;
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

        arrayPhrases= new ArrayList<Word>();
        arrayPhrases.add(new Word("minto wuksus","Where are you going?",R.raw.phrase_where_are_you_going));
        arrayPhrases.add(new Word("tinnә oyaase'nә","What is your name?",R.raw.phrase_what_is_your_name));
        arrayPhrases.add(new Word("oyaaset...","My name is...",R.raw.phrase_my_name_is));
        arrayPhrases.add(new Word("michәksәs?","How are you feeling?",R.raw.phrase_how_are_you_feeling));
        arrayPhrases.add(new Word("kuchi achit","I’m feeling good.",R.raw.phrase_im_feeling_good));
        arrayPhrases.add(new Word("әәnәs'aa?","Are you coming?",R.raw.phrase_are_you_coming));
        arrayPhrases.add(new Word("hәә’ әәnәm","Yes, I’m coming.",R.raw.phrase_yes_im_coming));
        arrayPhrases.add(new Word("әәnәm","I’m coming.",R.raw.phrase_im_coming));
        arrayPhrases.add(new Word("yoowutis","Let’s go",R.raw.phrase_lets_go));
        arrayPhrases.add(new Word("әnni'nem","Come here.",R.raw.phrase_come_here));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayPhrases,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.Word_list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = arrayPhrases.get(position);
                releaseMediaPlayer();
                media = MediaPlayer.create(PhrasesActivity.this,word.getAudioResourceId());
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
