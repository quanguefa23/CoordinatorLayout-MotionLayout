package com.example.coordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.coordinatorlayout.databinding.ActivityCollapsingToolbarBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CollapsingToolbarActivity extends AppCompatActivity {

    ActivityCollapsingToolbarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCollapsingToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.collapsingToolbar.setTitle("Collapsing Toolbar");
    }
}