package com.example.coordinatorlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.coordinatorlayout.databinding.ActivityFloatingToolbarBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class FloatingToolbarActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 3;
    private FragmentStateAdapter pagerAdapter;
    private ActivityFloatingToolbarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarGradient(this);
        binding = ActivityFloatingToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        settingActionBar();

        // Instantiate a ViewPager2 and a PagerAdapter.
        pagerAdapter = new ListViewPagerAdapter(this);
        binding.pager.setAdapter(pagerAdapter);

        new TabLayoutMediator(binding.tabs, binding.pager,
                (tab, position) -> tab.setText("List Cheese " + (position + 1))
        ).attach();
    }

    public static void setStatusBarGradient(Activity activity) {
        Window window = activity.getWindow();
        Drawable background = activity.getResources().getDrawable(R.drawable.layout_gradient, null);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent, null));
        window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent, null));
        window.setBackgroundDrawable(background);
    }

    private void settingActionBar() {
        setSupportActionBar(binding.toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setTitle("Floating Toolbar");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * A simple pager adapter that represents 3 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private static class ListViewPagerAdapter extends FragmentStateAdapter {
        public ListViewPagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(final int position) {
            return new RecyclerViewFragment();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}