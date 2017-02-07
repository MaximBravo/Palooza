package com.maximbravo.palooza;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Maxim Bravo on 1/30/2017.
 */

public class Warrior {
    private static final int SHELF_SIZE = 4;
    private String name;
    private int health;
    private int movability;
    private Weapon[] weapons;
    ArrayList<Weapon> pool;
    private Weapon[] shelfWeapons;
    private String pictureFilePath;
    private String soundFilePath;
    public Warrior(String n, int h, int m, Weapon[] w, String p, String s){
        name = n;
        health = h;
        movability = m;
        weapons = w;
        pictureFilePath = p;
        soundFilePath = s;
        shelfWeapons = generateShelfWeapons();
    }
    public void updateShelfWeaponsWithout(int index){
        shelfWeapons[index] = pool.get(0);
        pool.remove(0);
    }

    public Weapon[] generateShelfWeapons(){
        Weapon[] result = new Weapon[SHELF_SIZE];
        pool = randomized(toArrayList(weapons));
        for(int i = 0; i < SHELF_SIZE; i++){
            Weapon currentWeapon = pool.get(0);
            result[i] = currentWeapon;
            pool.remove(0);
        }
        return result;
    }

    public ArrayList<Weapon> randomized(ArrayList<Weapon> w){
        ArrayList<Weapon> randomized = new ArrayList<>();
        ArrayList<Integer> randomIndexes = new ArrayList<>();
        while(randomIndexes.size() != w.size()){
            Random rand = new Random();
            int randomNum = rand.nextInt(w.size());
            if(!randomIndexes.contains(randomNum)){
                randomized.add(w.get(randomNum));
                randomIndexes.add(randomNum);
            }
        }
        return randomized;
    }
    public ArrayList<Weapon> toArrayList(Weapon[] w){
        ArrayList<Weapon> result = new ArrayList<>();
        for(int i = 0; i < w.length; i++){
            result.add(w[i]);
        }
        return result;
    }
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMovability() {
        return movability;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public Weapon[] getShelfWeapons() {
        return shelfWeapons;
    }

    public String getPictureFilePath() {
        return pictureFilePath;
    }

    public String getSoundFilePath() {
        return soundFilePath;
    }
}
