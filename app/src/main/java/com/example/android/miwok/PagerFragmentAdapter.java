package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by emperator on 21/02/2017.
 */

public class PagerFragmentAdapter extends FragmentPagerAdapter {
    private String titles []= new String[]{"Numbers","Colors","Family","Phrases"};
    public PagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position ==0){
            return new NumbersFragment();
        }
        else if(position==1){
            return new ColorsFragment();
        }
        else if(position==2){
            return new FamilyFragment();
        }
        else if(position==3){
            return new PhrasesFragment();
        }

     return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }
}