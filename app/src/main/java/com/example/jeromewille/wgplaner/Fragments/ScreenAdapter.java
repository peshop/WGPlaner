package com.example.jeromewille.wgplaner.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jeromewille on 05.12.2017.
 */

public class ScreenAdapter extends FragmentPagerAdapter {

    int numberofTabs;
    List<Class> types;
    List<Object> objects;


    public ScreenAdapter(FragmentManager fm, Class... params){
        super(fm);

        this.numberofTabs = params.length;

        types = new ArrayList<>();
        types.addAll(Arrays.asList(params));

        objects = new ArrayList<>();

        for (Class c :
                types) {
            try {
                objects.add(c.newInstance());
            }
            catch (Exception e){}
        }
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment)objects.get(position);
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public int getCount() {
        return numberofTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "TAB" + position;
    }
}