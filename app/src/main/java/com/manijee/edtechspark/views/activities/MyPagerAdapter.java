package com.manijee.edtechspark.views.activities;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.manijee.edtechspark.views.activities.ui.Dashboard.DashboardFragment;
import com.manijee.edtechspark.views.activities.ui.My_Courses.CourseFragment;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    ArrayList fragments=new ArrayList<Fragment>();

    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments.add(new DashboardFragment());

        fragments.add(new CourseFragment());


    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return (Fragment) fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
