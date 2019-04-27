package com.example.david0926.sunrinmeal;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david0926.sunrinmeal.ID.IdActivity;
import com.example.david0926.sunrinmeal.Meal.MealActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //커밋 테스트

    LinearLayout idcardmenu, mealmenu;
    String date[] = new String[3], day[] = new String[3], meal[] = new String[3];

    Document doc;
    Elements mealparse;

    TextView main_date, main_day, main_meal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);




        main_date = findViewById(R.id.txt_main_date);
        main_day = findViewById(R.id.txt_main_day);
        main_meal = findViewById(R.id.txt_main_meal);

        new AsyncTask(){

            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    doc = Jsoup.connect("http://sunrint.hs.kr/index.do").get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                mealparse = doc.select(".school_menu_info");

                String ans[] = mealparse.text().split(" ");
                int count=0;
                for(int i=0;i<3;i++){
                    date[i] = ans[count++];
                    day[i] = ans[++count];
                    meal[i] = ans[++count];
                    if(count<ans.length-1) {
                        if (ans[count + 1].contains("(")) meal[i] += " " + ans[++count];
                        if (ans[count + 1].contains(")")) meal[i] += " " + ans[++count];
                        count++;
                    }
                }
                main_date.setText(date[0]+" 오늘의 급식");
                main_day.setText(day[0]);
                main_meal.setText(meal[0]);
            }
        }.execute();

        idcardmenu = findViewById(R.id.btn_idcardmenu);
        idcardmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IdActivity.class);
                startActivity(intent);
            }
        });

        mealmenu = findViewById(R.id.btn_mealmore);
        mealmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(main_date.getText().equals("오늘의 급식"))){
                    Intent intent = new Intent(getApplicationContext(), MealActivity.class);
                    intent.putExtra("date1", date[0]);
                    intent.putExtra("date2", date[1]);
                    intent.putExtra("date3", date[2]);
                    intent.putExtra("day1", day[0]);
                    intent.putExtra("day2", day[1]);
                    intent.putExtra("day3", day[2]);
                    intent.putExtra("menu1", meal[0]);
                    intent.putExtra("menu2", meal[1]);
                    intent.putExtra("menu3", meal[2]);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_share, menu);
        inflater.inflate(R.menu.menu_more, menu);
        return true;
    }
}
