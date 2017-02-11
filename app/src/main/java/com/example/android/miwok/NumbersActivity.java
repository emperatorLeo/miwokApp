package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    String tag = "nubersActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

      ArrayList<String> arrayNombres= new ArrayList<String>();
        arrayNombres.add("one");
        arrayNombres.add("two");
        arrayNombres.add("three");
        arrayNombres.add("four");
        arrayNombres.add("five");
        arrayNombres.add("six");
        arrayNombres.add("seven");
        arrayNombres.add("eight");
        arrayNombres.add("nine");
        arrayNombres.add("ten");

        Log.v(tag,"the word in position 1 is: "+arrayNombres.get(0));
        Log.v(tag,"the word in position 6 is: "+arrayNombres.get(5));
    }
}
