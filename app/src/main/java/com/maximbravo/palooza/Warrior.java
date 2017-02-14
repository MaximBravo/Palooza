package com.maximbravo.palooza;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Maxim Bravo on 1/30/2017.
 */

public class Warrior {
    private String name;
    private int health;
    private boolean isEmpty;
    private int movability;
    private int pictureFilePath;
    //private String soundFilePath;
    public Warrior(String n, int h, int m, int resId){//}, String s){
        isEmpty = false;
        name = n;
        health = h;
        movability = m;

        pictureFilePath = resId;
        //soundFilePath = s;

    }

    public Warrior(){
        isEmpty = true;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int h){
        health = h;
    }
    public int getHealth() {
        return health;
    }

    public int getMovability() {
        return movability;
    }

    public int getPictureFilePath() {
        return pictureFilePath;
    }

//    public String getSoundFilePath() {
//        return soundFilePath;
//    }
}
