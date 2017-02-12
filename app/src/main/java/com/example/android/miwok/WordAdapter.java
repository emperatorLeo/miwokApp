package com.example.android.miwok;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by emperator on 12/02/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> palabras){
        super(context,0,palabras);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View listView = convertView;

        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);

        TextView englishView = (TextView) listView.findViewById(R.id.english_word_view);
        englishView.setText(currentWord.getDefaultWord());

        TextView miHowkView = (TextView) listView.findViewById(R.id.miwok_word_view);
        miHowkView.setText(currentWord.getMihokWord());


        return listView;

    }
}
