package com.farooqkhan.learnersland;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.farooqkhan.learnersland.Fragments.ftab1;
import com.farooqkhan.learnersland.Fragments.ftab2;
import com.farooqkhan.learnersland.Fragments.ftab3;

public class PageAdapter extends FragmentPagerAdapter {

    int tabCount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new ftab1();
            case 1: return new ftab3();
            case 2: return new ftab2();

            default:return  null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
