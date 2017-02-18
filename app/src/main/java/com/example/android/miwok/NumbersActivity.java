package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer media;
    private ArrayList<Word> arrayNombres ;
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

        arrayNombres= new ArrayList<Word>();
        arrayNombres.add(new Word("lutti","one",R.drawable.number_one,R.raw.number_one));
        arrayNombres.add(new Word("otiiko","two",R.drawable.number_two,R.raw.number_two));
        arrayNombres.add(new Word("tolookosu","three",R.drawable.number_three,R.raw.number_three));
        arrayNombres.add(new Word("oyyisa","four",R.drawable.number_four,R.raw.number_four));
        arrayNombres.add(new Word("massokka","five",R.drawable.number_five,R.raw.number_five));
        arrayNombres.add(new Word("temmokka","six",R.drawable.number_six,R.raw.number_six));
        arrayNombres.add(new Word("kenekaku","seven",R.drawable.number_seven,R.raw.number_seven));
        arrayNombres.add(new Word("kawinta","eight",R.drawable.number_eight,R.raw.number_eight));
        arrayNombres.add(new Word("wo'e","nine",R.drawable.number_nine,R.raw.number_nine));
        arrayNombres.add(new Word("na'aacha","ten",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter itemsAdapter= new WordAdapter(this,arrayNombres,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.Word_list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                Word word = arrayNombres.get(position);
                releaseMediaPlayer();
                media = MediaPlayer.create(NumbersActivity.this,word.getAudioResourceId());
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
