package com.maximbravo.palooza;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Maxim Bravo on 2/12/2017.
 */

public class Cell {
    private boolean hasWarrior = false;
    private int id;
    private static final int SHELF_SIZE = 4;
    private Warrior warrior;
    ArrayList<Weapon> pool;
    private Weapon[] shelfWeapons;
    private Weapon[] weapons;
    public Cell(int id){
        this.id = id;
    }
    public Cell(int id, Warrior warrior, Weapon[] weapons){
        this.id = id;
        hasWarrior = true;
        this.warrior = warrior;
        this.weapons = weapons;
        shelfWeapons = generateShelfWeapons();
    }

    public void setHasWarrior(boolean t){
        hasWarrior = t;
    }
    public void setWeapons(String w){
        String[] weapo = w.split(",");
        Weapon[] weaponsToBe = new Weapon[6];
        Pieces p = new Pieces();
        for(int i = 0; i < weapo.length; i++){
            String wp = weapo[i];
            weaponsToBe[i] = p.getWeaponWithName(wp);
        }
        weapons = weaponsToBe;
        shelfWeapons = generateShelfWeapons();
    }
    public void setWarrior(Warrior war){
        warrior = war;
    }
    public void setWarriorHealth(int health){
        warrior.setHealth(health);
    }
    public boolean hasWarrior(){
        return hasWarrior;
    }
    public int getCellId(){
        return id;
    }
    public Weapon[] getShelfWeapons(){
        return shelfWeapons;
    }
    public Weapon[] getWeapons(){
        return weapons;
    }
    public Warrior getWarrior(){
        return warrior;
    }
    public void setCellId(int newId){
        id = newId;
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
}
