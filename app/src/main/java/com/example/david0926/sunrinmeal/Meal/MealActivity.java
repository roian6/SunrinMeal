package com.example.david0926.sunrinmeal.Meal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.david0926.sunrinmeal.R;

public class MealActivity extends AppCompatActivity {

    RecyclerView rcv;
    RecycleAdapter_Meal rcvAdap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        Toolbar toolbar = findViewById(R.id.meal_toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setTitle("식단표");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rcv = findViewById(R.id.recycler_meal);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(lm);

        rcvAdap = new RecycleAdapter_Meal();
        rcv.setAdapter(rcvAdap);

        Intent getIntent = getIntent();

        RecycleModel_Meal model = new RecycleModel_Meal(
                getIntent.getStringExtra("date1"),
                getIntent.getStringExtra("day1"),
                getIntent.getStringExtra("menu1"));
        rcvAdap.add(model);
        rcvAdap.notifyDataSetChanged();

        model = new RecycleModel_Meal(
                getIntent.getStringExtra("date2"),
                getIntent.getStringExtra("day2"),
                getIntent.getStringExtra("menu2"));
        rcvAdap.add(model);
        rcvAdap.notifyDataSetChanged();

        model = new RecycleModel_Meal(
                getIntent.getStringExtra("date3"),
                getIntent.getStringExtra("day3"),
                getIntent.getStringExtra("menu3"));
        rcvAdap.add(model);
        rcvAdap.notifyDataSetChanged();


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
