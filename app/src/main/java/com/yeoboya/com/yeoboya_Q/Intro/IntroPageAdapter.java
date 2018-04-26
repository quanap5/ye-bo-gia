package com.yeoboya.com.yeoboya_Q.Intro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class IntroPageAdapter extends FragmentPagerAdapter {
    protected static final String[] CONTENT = {"intro_1", "intro_2", "intro_3", "intro_4"};
    private int mCount = CONTENT.length;

    public IntroPageAdapter(FragmentManager paramFragmentManager) {
        super(paramFragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return this.mCount;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int paramInt) {
        return IntroFragment.newInstance(paramInt, CONTENT[(paramInt % CONTENT.length)]);
    }

    public void setCount(int paramInt) {
        if ((paramInt > 0) && (paramInt <= 10)) {
            this.mCount = paramInt;
            notifyDataSetChanged();
        }
    }
}
