package com.example.david0926.sunrinmeal.Meal;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david0926.sunrinmeal.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter_Meal extends RecyclerView.Adapter<RecycleHolder_Meal>{

    private List<RecycleModel_Meal> items = new ArrayList<>();

    public List<RecycleModel_Meal> getItems() {
        return items;
    }

    public void add(RecycleModel_Meal data){
        items.add(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecycleHolder_Meal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_meal, parent, false);
        return new RecycleHolder_Meal(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleHolder_Meal holder, int position) {
        RecycleModel_Meal item = items.get(position);
        holder.date.setText(item.getDate());
        holder.day.setText(item.getDay());
        switch(item.getDay()){
            case "월":
                holder.day.setTextColor(Color.parseColor("#f48fb1"));
                break;
            case "화":
                holder.day.setTextColor(Color.parseColor("#ffab91"));
                break;
            case "수":
                holder.day.setTextColor(Color.parseColor("#a5d6a7"));
                break;
            case "목":
                holder.day.setTextColor(Color.parseColor("#81d4fa"));
                break;
            case "금":
                holder.day.setTextColor(Color.parseColor("#b39ddb"));
                break;
            default:
                holder.day.setTextColor(Color.parseColor("#000000"));
        }
        holder.menu.setText(item.getMenu());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
