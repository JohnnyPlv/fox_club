package com.greenfox.fox_club.services;


import com.greenfox.fox_club.models.Food;
import com.greenfox.fox_club.models.Fox;
import com.greenfox.fox_club.models.Drink;
import com.greenfox.fox_club.models.Trick;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryFoxService implements FoxService {

    private final List<Fox> foxes;
    private final List<Food> listOfFood;
    private final List<Drink> listOfDrink;
    private final List<Trick> listOfTricks;


    public InMemoryFoxService() {
        this.foxes = new ArrayList<>();
        this.listOfFood = new ArrayList<>();
        listOfFood.add(new Food("pizza"));
        listOfFood.add(new Food("popcorn"));
        listOfFood.add(new Food("burito"));
        listOfFood.add(new Food("taco"));
        this.listOfDrink = new ArrayList<>();
        listOfDrink.add(new Drink("CocaCola"));
        listOfDrink.add(new Drink("Pepsi"));
        this.listOfTricks = new ArrayList<>();
        listOfTricks.add(new Trick("write Java"));
        listOfTricks.add(new Trick("write JavaScript"));
        listOfTricks.add(new Trick("write Python"));
        listOfTricks.add(new Trick("write C++"));

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void addFox(String name) {
        foxes.add(new Fox(name,"dirt","toilet water"));
    }

    @Override
    public List<Fox> getFoxes() {
        return foxes;
    }

    @Override
    public List<Food> getFoodTypes() {
        return listOfFood;
    }

    @Override
    public List<Drink> getDrinkTypes() {
        return listOfDrink;
    }

    @Override
    public List<Trick> getListOfTricks() {
        return listOfTricks;
    }

    @Override
    public boolean checkTricks(String name, String trick) {

        return getActiveFox(name).getTricks().stream().anyMatch(t -> t.equals(trick));

//        for (String s : getActiveFox(name).getTricks()) {
//            if (s.equals(trick)) {
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public boolean checkFox(String name) {
        for (Fox f : foxes) {
            if (f.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Fox getActiveFox(String name) {
        return foxes.stream().filter(fox -> fox.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public boolean isMrGreen() {
        for (Fox f : foxes) {
            if (f.getName().equals("Mr.Green")) {
                return true;
            }
        }
        return false;
    }
}
