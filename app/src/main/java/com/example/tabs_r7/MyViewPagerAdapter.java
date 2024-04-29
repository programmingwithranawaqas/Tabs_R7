package com.example.tabs_r7;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new ChatFragment();
            case 1:
                return new UpdatesFragment();
            case 2:
                return new CommunityFragment();
            default:
                return new CallsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
