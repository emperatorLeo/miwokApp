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


public class NumbersFragment extends Fragment {

    private AudioManager audioManager;
    private MediaPlayer media;

   private AudioManager.OnAudioFocusChangeListener callback = new AudioManager.OnAudioFocusChangeListener(){

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                Toast.makeText(getContext(),"trasient",Toast.LENGTH_LONG);
               media.stop();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                Toast.makeText(getContext(),"focus gain",Toast.LENGTH_LONG);
                media.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
                Toast.makeText(getContext(),"focus lost",Toast.LENGTH_LONG);
            }


        }
    };

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };



    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> arrayNombres= new ArrayList<Word>();
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

        WordAdapter itemsAdapter= new WordAdapter(getActivity(),arrayNombres,R.color.category_numbers);

        ListView listView = (ListView)rootView.findViewById(R.id.Word_list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView adapterView,View view,int position ,long l){
                releaseMediaPlayer();
                Word word = arrayNombres.get(position);

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

