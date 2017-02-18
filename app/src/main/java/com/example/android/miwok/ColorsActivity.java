package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer media;
    private ArrayList<Word> arrayColors;
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

        arrayColors= new ArrayList<Word>();
        arrayColors.add(new Word("wetetti","red",R.drawable.color_red,R.raw.color_red));
        arrayColors.add(new Word("chokokki","green",R.drawable.color_green,R.raw.color_green));
        arrayColors.add(new Word("ṭakaakki","brown",R.drawable.color_brown,R.raw.color_brown));
        arrayColors.add(new Word("ṭopoppi","gray",R.drawable.color_gray,R.raw.color_gray));
        arrayColors.add(new Word("kululli","black",R.drawable.color_black,R.raw.color_black));
        arrayColors.add(new Word("kelelli","white",R.drawable.color_white,R.raw.color_white));
        arrayColors.add(new Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        arrayColors.add(new Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this,arrayColors,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.Word_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
                  public void onItemClick(AdapterView adapterView,View view,int position ,long l){
                Word word = arrayColors.get(position);
                releaseMediaPlayer();
                media = MediaPlayer.create(ColorsActivity.this,word.getAudioResourceId());
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
    protected void onStop() {
        super.onStop();
        Log.e("onStop method","it's stopped");
        releaseMediaPlayer();
    }
}
