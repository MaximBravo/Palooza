package com.maximbravo.palooza;

/**
 * Created by Maxim Bravo on 1/30/2017.
 */

public class Weapon {
    private String name;
    private int damage;
    private int splashDamage;
    private int variablility;
    private int ammo;
    private int range;
    private int picture;
    public Weapon(String n, int d, int sd, int v, int a, int r, int resId){//, String s){
        name = n;
        damage = d;
        splashDamage = sd;
        variablility = v;
        ammo = a;
        range = r;
        picture = resId;
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getVariablility(){
        return variablility;
    }
    public int getResId(){
        return picture;
    }
    public int getSplashDamage() {
        return splashDamage;
    }
//    public String getSoundFilePath() {
//        return soundFilePath;
//    }
}
