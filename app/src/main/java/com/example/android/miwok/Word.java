package com.example.android.miwok;

/**
 * Created by emperator on 11/02/2017.
 */

public class Word {
    private String mMihokWord;
    private String mDefaultWord;
    private static final int  NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Word (String mihokWord,String defaultWord){
         mMihokWord = mihokWord;
         mDefaultWord =defaultWord;
    }

    public Word (String mihokWord,String defaultWord,int imageResource ){
        mMihokWord = mihokWord;
        mDefaultWord =defaultWord;
        mImageResourceId = imageResource;
    }

    public String getMihokWord(){
        return mMihokWord;
    }

    public String getDefaultWord(){
        return mDefaultWord;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage(){
       return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
