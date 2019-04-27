package com.example.david0926.sunrinmeal.ID;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.david0926.sunrinmeal.ID.IdScanActivity;
import com.example.david0926.sunrinmeal.R;

public class IdTab_1 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_idtab1, container, false);
        LinearLayout btn = v.findViewById(R.id.btn_idcardscan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), IdScanActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
