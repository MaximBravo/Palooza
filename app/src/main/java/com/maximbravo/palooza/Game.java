package com.maximbravo.palooza;

import android.text.Layout;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by Maxim Bravo on 1/23/2017.
 */

public class Game {
    public static final String TAG = "EBTurn";

    public String data = "";
    public int turnCounter;

    public Game() {
    }

    public Game(String currentPlayerID, String nextPlayerId){

    }

    public void setGameplayUI(){

    }
    // This is the byte array we will write out to the TBMP API.
    public byte[] persist() {
        JSONObject retVal = new JSONObject();

        try {
            retVal.put("data", data);
            retVal.put("turnCounter", turnCounter);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String st = retVal.toString();

        Log.d(TAG, "==== PERSISTING\n" + st);

        return st.getBytes(Charset.forName("UTF-8"));
    }

    // Creates a new instance of SkeletonTurn.
    static public Game unpersist(byte[] byteArray) {

        if (byteArray == null) {
            Log.d(TAG, "Empty array---possible bug.");
            return new Game();
        }

        String st = null;
        try {
            st = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }

        Log.d(TAG, "====UNPERSIST \n" + st);

        Game retVal = new Game();

        try {
            JSONObject obj = new JSONObject(st);

            if (obj.has("data")) {
                retVal.data = obj.getString("data");
            }
            if (obj.has("turnCounter")) {
                retVal.turnCounter = obj.getInt("turnCounter");
            }


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return retVal;
    }
}
