package com.example.akshay.classroom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by akshay on 8/9/17.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {


    public int semValue;
    public SectionsPagerAdapter(FragmentManager fragmentManager,int x) {

        super(fragmentManager);
        semValue=x;
    }



    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        BranchSelect f = new BranchSelect();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", semValue);
        f.setArguments(args);
        return f;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "name";
    }
}
