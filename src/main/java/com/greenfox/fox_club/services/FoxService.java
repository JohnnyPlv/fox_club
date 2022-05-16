package com.greenfox.fox_club.services;

import com.greenfox.fox_club.models.Food;
import com.greenfox.fox_club.models.Fox;
import com.greenfox.fox_club.models.Drink;
import com.greenfox.fox_club.models.Trick;

import java.util.List;

public interface FoxService {

    public void setName(String name);

    public void addFox(String name);

    public List<Fox> getFoxes();

    public List<Food> getFoodTypes ();

    public List<Drink> getDrinkTypes();

    public List<Trick> getListOfTricks();

    public boolean checkTricks(String name, String trick);

    public boolean checkFox(String name);

    public Fox getActiveFox(String name);

    public boolean isMrGreen();
}
