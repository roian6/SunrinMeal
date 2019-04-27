package com.example.david0926.sunrinmeal.Meal;

public class RecycleModel_Meal {

    private String date, day, menu;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public RecycleModel_Meal(String date, String day, String menu){
        this.date = date;
        this.day = day;
        this.menu = menu;

    }
}
