package com.example.android.miwok;

/**
 * Created by emperator on 11/02/2017.
 */

public class Word {
    private String mMihokWord;
    private String mDefaultWord;

    Word (String mihokWord,String defaultWord){
         mMihokWord = mihokWord;
         mDefaultWord =defaultWord;
    }

    public String getMihokWord(){
        return mMihokWord;
    }

    public String getDefaultWord(){
        return mDefaultWord;
    }
}
