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
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {
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

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);
        audioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> arrayPhrases = new ArrayList<Word>();
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

        WordAdapter itemsAdapter = new WordAdapter(getActivity(),arrayPhrases,R.color.category_phrases);

        ListView listView = (ListView)rootView.findViewById(R.id.Word_list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = arrayPhrases.get(position);
                releaseMediaPlayer();
                media = MediaPlayer.create(getActivity(),word.getAudioResourceId());
                media.start();
                media.setOnCompletionListener(onCompletionListener);
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
