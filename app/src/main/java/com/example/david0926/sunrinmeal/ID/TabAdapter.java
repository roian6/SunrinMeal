package com.example.david0926.sunrinmeal.ID;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {


    private int num;

    public TabAdapter(FragmentManager fm, int num) {
        super(fm);
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                IdTab_1 tab1 = new IdTab_1();
                return tab1;

            case 1:
                IdTab_2 tab2 = new IdTab_2();
                return tab2;
            default: return null;

        }
    }

    @Override
    public int getCount() { //탭 개수 반환 함수
        return num;
    }
}
