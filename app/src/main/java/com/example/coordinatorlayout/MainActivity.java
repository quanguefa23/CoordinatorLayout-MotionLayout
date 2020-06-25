package com.example.coordinatorlayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coordinatorlayout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fabAndSnackbar.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, FabAndSnackbarActivity.class)));

        binding.floatingToolbar.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, FloatingToolbarActivity.class)));

        binding.collapsingToolbar.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, CollapsingToolbarActivity.class)));

        binding.clwithml.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, ClWithMlActivity.class)));

        binding.admotion.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, AdvancedMotionActivity.class)));
    }
}