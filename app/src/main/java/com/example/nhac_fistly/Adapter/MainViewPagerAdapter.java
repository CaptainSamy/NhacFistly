package com.example.nhac_fistly.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayFagment = new ArrayList<>();
    private ArrayList<String> arrayTitle = new ArrayList<>();


    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayFagment.get(position);
    }

    @Override
    public int getCount() {
        return arrayFagment.size();
    }
    public void addFragment(Fragment fragment, String title ){
        arrayFagment.add(fragment);
        arrayTitle.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrayTitle.get(position);
    }
}
