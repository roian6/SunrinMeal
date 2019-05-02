package com.example.david0926.sunrinmeal.Meal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.david0926.sunrinmeal.R;

public class RecycleHolder_Meal extends RecyclerView.ViewHolder{

    public TextView date, day, menu;

    RecycleHolder_Meal(View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.item_date);
        day = itemView.findViewById(R.id.item_day);
        menu = itemView.findViewById(R.id.item_meal);
    }
}
