package com.example.david0926.sunrinmeal.ID;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.david0926.sunrinmeal.R;

public class IdScanActivity extends AppCompatActivity {

    private WindowManager.LayoutParams params;
    private float bri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        Toolbar toolbar = findViewById(R.id.scan_toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setTitle("학생증 스캔하기");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toast.makeText(this, "인식을 위해 화면 밝기를 조정합니다", Toast.LENGTH_SHORT).show();

        params = getWindow().getAttributes();
        bri = params.screenBrightness;
        params.screenBrightness = 1f;
        getWindow().setAttributes(params);
//        try {
//            bri = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
//            Settings.System.putInt(getContentResolver(), "screen_brightness", 255);
//
//        } catch (Exception e) {
//
//        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onPause() {
        params.screenBrightness = bri;
        getWindow().setAttributes(params);
        super.onPause();
    }
}
