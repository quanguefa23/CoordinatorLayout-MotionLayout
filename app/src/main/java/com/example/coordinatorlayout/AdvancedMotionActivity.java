package com.example.coordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

public class AdvancedMotionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarGradient(this);
        setContentView(R.layout.activity_advanced_motion);
    }

    public static void setStatusBarGradient(Activity activity) {
        Window window = activity.getWindow();
        Drawable background = activity.getResources().getDrawable(R.drawable.layout_gradient, null);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent, null));
        window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent, null));
        window.setBackgroundDrawable(background);
    }
}