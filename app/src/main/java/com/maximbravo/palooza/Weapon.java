package com.maximbravo.palooza;

/**
 * Created by Maxim Bravo on 1/30/2017.
 */

public class Weapon {
    private String name;
    private int damage;
    private int splashDamage;
    private String soundFilePath;
    public Weapon(String n, int d, int sd, String s){
        name = n;
        damage = d;
        splashDamage = sd;
        soundFilePath = s;
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getSplashDamage() {
        return splashDamage;
    }
    public String getSoundFilePath() {
        return soundFilePath;
    }
}
