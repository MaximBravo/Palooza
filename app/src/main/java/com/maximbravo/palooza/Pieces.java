package com.maximbravo.palooza;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Maxim Bravo on 2/9/2017.
 */

public class Pieces {
    private ArrayList<Warrior> allWarriors;
    private ArrayList<Warrior> heavys;
    private ArrayList<Warrior> bigBirds;
    private ArrayList<Warrior> smallBirds;
    private ArrayList<Warrior> predators;
    private ArrayList<Warrior> rodents;
    private ArrayList<Warrior> reptiles;

    private Warrior elephant;
    private Warrior eagle;
    private Warrior parrot;
    private Warrior tiger;
    private Warrior hedgehog;
    private Warrior snake;

    private Weapon[] standardWeaponPack;

    private Weapon bazooka;
    private Weapon shotgun;
    private Weapon shield;
    private Weapon sword;
    private Weapon grenade;

    public Pieces(){
        heavys = new ArrayList<>();
        bigBirds = new ArrayList<>();
        smallBirds = new ArrayList<>();
        predators = new ArrayList<>();
        rodents = new ArrayList<>();
        reptiles = new ArrayList<>();
        allWarriors = new ArrayList<>();
        bazooka = new Weapon("bazooka", 50, 0, 5, 1, 3, R.drawable.bazooka);
        shotgun = new Weapon("shotgun", 25, 0, 3, 2, 2, R.drawable.shotgun);
        shield = new Weapon( "shield",   0, 0, 0, 1, 0, R.drawable.shield);
        sword = new Weapon(  "sword",   75, 0, 5, 1, 1, R.drawable.sword);
        grenade = new Weapon("grenade", 25, 10,5, 1, 4, R.drawable.grenade);
        standardWeaponPack = new Weapon[]{bazooka, shotgun, shield, sword, grenade};


        elephant = new Warrior("elephant", 200, 1, R.drawable.elephant);
        eagle    = new Warrior( "eagle",    100, 4,  R.drawable.eagle);
        parrot   = new Warrior("parrot",  50,  4, R.drawable.parrot);
        tiger    = new Warrior("tiger",    150, 2, R.drawable.parrot);
        hedgehog = new Warrior("hedgehog",   100, 3, R.drawable.hedgehog);
        snake    = new Warrior("snake",     75,  4, R.drawable.snake);

        heavys.add(elephant);
        bigBirds.add(eagle);
        smallBirds.add(parrot);
        predators.add(tiger);
        rodents.add(hedgehog);
        reptiles.add(snake);

        allWarriors.add(elephant);
        allWarriors.add(eagle);
        allWarriors.add(parrot);
        allWarriors.add(tiger);
        allWarriors.add(hedgehog);
        allWarriors.add(snake);
    }

    public Weapon getWeaponWithName(String name){
        for(int i = 0; i < standardWeaponPack.length; i++){
            if(standardWeaponPack[i].getName().equals(name)){
                return standardWeaponPack[i];
            }
        }
        return bazooka;
    }
    public Weapon[] getStandardWeaponPack(){
        return standardWeaponPack;
    }
    public Warrior getWarriorWithName(String name){
        for(Warrior w : allWarriors){
            if(name.equals(w.getName())){
                return w;
            }
        }
        return null;
    }
    public Warrior getHeavy(){
        Random r = new Random();
        int index = r.nextInt(heavys.size());
        return heavys.get(index);

    }
    public Warrior getBigBird(){
        Random r = new Random();
        int index = r.nextInt(bigBirds.size());
        return bigBirds.get(index);
    }
    public Warrior getSmallBird(){
        Random r = new Random();
        int index = r.nextInt(smallBirds.size());
        return smallBirds.get(index);
    }
    public Warrior getPredator(){
        Random r = new Random();
        int index = r.nextInt(predators.size());
        return predators.get(index);
    }
    public Warrior getRodent(){
        Random r = new Random();
        int index = r.nextInt(rodents.size());
        return rodents.get(index);
    }
    public Warrior getReptile(){
        Random r = new Random();
        int index = r.nextInt(reptiles.size());
        return reptiles.get(index);
    }
}
