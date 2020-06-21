package com.example.coordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.coordinatorlayout.databinding.ActivityFabAndSnackbarBinding;
import com.google.android.material.snackbar.Snackbar;

public class FabAndSnackbarActivity extends AppCompatActivity {

    private ActivityFabAndSnackbarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFabAndSnackbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(view ->
                Snackbar.make(binding.mainContent, "This is the Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("close", v -> {
                            Toast.makeText(this, "Closed snackbar", Toast.LENGTH_SHORT).show();
                            finish();
                        })
                        .show());

    }
}