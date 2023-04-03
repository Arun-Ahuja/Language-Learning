package com.example.sindhilearning.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sindhilearning.fragments.AlphabetFrag;
import com.example.sindhilearning.fragments.ConsonentFrag;
import com.example.sindhilearning.fragments.RhymesFrag;
import com.example.sindhilearning.fragments.SentencesFrag;
import com.example.sindhilearning.fragments.WordsFrag;

/**
 * Created by aliraza on 05/12/2019.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {


    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new WordsFrag();
            case 1: return new AlphabetFrag();
            case 2:return  new ConsonentFrag();


        }
        return null;
    }

    @Override
    public int getCount() {

        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Words";
            case 1:
                return "Alphabets";
            case 2:
                return "Consonents";
            default:
                return null;
        }
    }
}



