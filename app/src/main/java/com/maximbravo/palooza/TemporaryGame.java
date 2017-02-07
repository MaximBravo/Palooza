package com.maximbravo.palooza;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Maxim Bravo on 1/30/2017.
 */

public class TemporaryGame implements View.OnClickListener {
    private ArrayList<Integer> selected;
    private View pView;
    public TemporaryGame(){
        selected = new ArrayList<>();
    }
    public String getMessage(){
        String result = "";
        for(int i = 0; i < selected.size(); i++){
            result += selected.get(i) + ", ";
        }
        return result;
    }
    public void setData(String data){

    }
    public void setClickListeners(View pView){
        this.pView = pView;
        //pView.findViewById(R.id.doneButton).setOnClickListener(this);
        pView.findViewById(R.id.board_1).setOnClickListener(this);
        pView.findViewById(R.id.board_2).setOnClickListener(this);
        pView.findViewById(R.id.board_3).setOnClickListener(this);
        pView.findViewById(R.id.board_4).setOnClickListener(this);
        pView.findViewById(R.id.board_5).setOnClickListener(this);
        pView. findViewById(R.id.board_6).setOnClickListener(this);
        pView.findViewById(R.id.board_7).setOnClickListener(this);
        pView.    findViewById(R.id.board_8).setOnClickListener(this);
        pView.    findViewById(R.id.board_9).setOnClickListener(this);
        pView. findViewById(R.id.board_10).setOnClickListener(this);
        pView. findViewById(R.id.board_11).setOnClickListener(this);
        pView.   findViewById(R.id.board_12).setOnClickListener(this);
        pView. findViewById(R.id.board_13).setOnClickListener(this);
        pView. findViewById(R.id.board_14).setOnClickListener(this);
        pView.  findViewById(R.id.board_15).setOnClickListener(this);
        pView.  findViewById(R.id.board_16).setOnClickListener(this);
        pView. findViewById(R.id.board_17).setOnClickListener(this);
        pView.  findViewById(R.id.board_18).setOnClickListener(this);
        pView.  findViewById(R.id.board_19).setOnClickListener(this);
        pView. findViewById(R.id.board_20).setOnClickListener(this);
        pView.  findViewById(R.id.board_21).setOnClickListener(this);
        pView.  findViewById(R.id.board_22).setOnClickListener(this);
        pView.  findViewById(R.id.board_23).setOnClickListener(this);
        pView.  findViewById(R.id.board_24).setOnClickListener(this);
        pView. findViewById(R.id.board_25).setOnClickListener(this);
        pView. findViewById(R.id.board_26).setOnClickListener(this);
        pView.  findViewById(R.id.board_27).setOnClickListener(this);
        pView.  findViewById(R.id.board_28).setOnClickListener(this);
        pView.findViewById(R.id.board_29).setOnClickListener(this);
        pView.findViewById(R.id.board_30).setOnClickListener(this);
        pView.findViewById(R.id.board_31).setOnClickListener(this);
        pView.findViewById(R.id.board_32).setOnClickListener(this);
        pView.findViewById(R.id.board_33).setOnClickListener(this);
        pView.findViewById(R.id.board_34).setOnClickListener(this);
        pView.findViewById(R.id.board_35).setOnClickListener(this);
        pView.findViewById(R.id.board_36).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
//            case R.id.doneButton:
//                FullscreenActivity f = new FullscreenActivity();
//                f.done("" + selected);
//                break;
            case R.id.board_1:
                selected.add(1);
                break;
            case R.id.board_2:
                selected.add(2);
                break;
            case R.id.board_3:
                selected.add(3);
                break;
            case R.id.board_4:
                selected.add(4);
                break;
            case R.id.board_5:
                selected.add(5);
                break;
            case R.id.board_6:
                selected.add(6);
                break;
            case R.id.board_7:
                selected.add(7);
                break;
            case R.id.board_8:
                selected.add(8);
                break;
            case R.id.board_9:
                selected.add(9);
                break;
            case R.id.board_10:
                selected.add(10);
                break;
            case R.id.board_11:
                selected.add(11);
                break;
            case R.id.board_12:
                selected.add(12);
                break;
            case R.id.board_13:
                selected.add(13);
                break;
            case R.id.board_14:
                selected.add(14);
                break;
            case R.id.board_15:
                selected.add(15);
                break;
            case R.id.board_16:
                selected.add(16);
                break;
            case R.id.board_17:
                selected.add(17);
                break;
            case R.id.board_18:
                selected.add(18);
                break;
            case R.id.board_19:
                selected.add(19);
                break;
            case R.id.board_20:
                selected.add(20);
                break;
            case R.id.board_21:
                selected.add(21);
                break;
            case R.id.board_22:
                selected.add(22);
                break;
            case R.id.board_23:
                selected.add(23);
                break;
            case R.id.board_24:
                selected.add(24);
                break;
            case R.id.board_25:
                selected.add(25);
                break;
            case R.id.board_26:
                selected.add(26);
                break;
            case R.id.board_27:
                selected.add(27);
                break;
            case R.id.board_28:
                selected.add(28);
                break;
            case R.id.board_29:
                selected.add(29);
                break;
            case R.id.board_30:
                selected.add(30);
                break;
            case R.id.board_31:
                selected.add(31);
                break;
            case R.id.board_32:
                selected.add(32);
                break;
            case R.id.board_33:
                selected.add(33);
                break;
            case R.id.board_34:
                selected.add(34);
                break;
            case R.id.board_35:
                selected.add(35);
                break;
            case R.id.board_36:
                selected.add(36);
                break;

        }
        TextView output = (TextView) pView.findViewById(R.id.game);
        output.setText(""+selected+" is selected");
    }
}
