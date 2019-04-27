package com.example.david0926.sunrinmeal.Meal;

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
        holder.date.setText(item.getDate()+" ("+item.getDay()+")");
        holder.menu.setText(item.getMenu());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
