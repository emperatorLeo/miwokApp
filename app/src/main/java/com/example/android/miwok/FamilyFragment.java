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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    private AudioManager audioManager;
    private MediaPlayer media;

    private AudioManager.OnAudioFocusChangeListener callback = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                Toast.makeText(getContext(),"trasient",Toast.LENGTH_LONG);
              //  media.stop();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                Toast.makeText(getContext(),"focus gain",Toast.LENGTH_LONG);
                media.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
                Toast.makeText(getContext(),"focus lost",Toast.LENGTH_LONG);
            }


        }
    };

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);

        audioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> arrayFamily= new ArrayList<Word>();
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

        WordAdapter itemsAdapter = new WordAdapter(getActivity(),arrayFamily,R.color.category_family);

        ListView listView = (ListView)rootView.findViewById(R.id.Word_list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView adapterView,View view,int position ,long l){
                releaseMediaPlayer();
                Word word = arrayFamily.get(position);

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
