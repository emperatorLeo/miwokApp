package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by emperator on 21/02/2017.
 */

public class ColorsFragment extends Fragment {

    private AudioManager audioManager;
    private MediaPlayer media;

    private AudioManager.OnAudioFocusChangeListener callback = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                media.pause();
                media.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {

                media.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {

                releaseMediaPlayer();
            }


        }
    };

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public ColorsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);
        audioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> arrayColors = new ArrayList<Word>();
        arrayColors.add(new Word("wetetti","red",R.drawable.color_red,R.raw.color_red));
        arrayColors.add(new Word("chokokki","green",R.drawable.color_green,R.raw.color_green));
        arrayColors.add(new Word("ṭakaakki","brown",R.drawable.color_brown,R.raw.color_brown));
        arrayColors.add(new Word("ṭopoppi","gray",R.drawable.color_gray,R.raw.color_gray));
        arrayColors.add(new Word("kululli","black",R.drawable.color_black,R.raw.color_black));
        arrayColors.add(new Word("kelelli","white",R.drawable.color_white,R.raw.color_white));
        arrayColors.add(new Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        arrayColors.add(new Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(getActivity(),arrayColors,R.color.category_colors);

        ListView listView = (ListView)rootView.findViewById(R.id.Word_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView adapterView,View view,int position ,long l){
                releaseMediaPlayer();
                Word word = arrayColors.get(position);

                int requesting = audioManager.requestAudioFocus(callback,
                        AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(requesting == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    media = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    media.start();
                    media.setOnCompletionListener(onCompletionListener);
                }
            }
        });

      return rootView;
    }
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

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



}
