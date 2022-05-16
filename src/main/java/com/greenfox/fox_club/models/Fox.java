package com.greenfox.fox_club.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {

    private String name;
    private List<String> tricks;
    private String food;
    private String drink;

    public Fox(String name,String food, String drink) {
        this.food = food;
        this.drink = drink;
        this.name = name;
        this.tricks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public String getFood() {
        return food;
    }

    public String getDrink() {
        return drink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}
