package com.maximbravo.palooza;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Maxim Bravo on 1/30/2017.
 */

public class TemporaryGame implements View.OnClickListener {
    public static Pieces pieces;
    private ArrayList<Integer> selected;
    private View pView;
    private String currentPlayer;
    private String nextPlayer;
    private Board board;

    public TemporaryGame(View view) {
        selected = new ArrayList<>();
        pView = view;
        board = new Board(6, 6);
        pieces = new Pieces();
    }

    public String getMessage() {
        String result = "";
        try {
            JSONObject data = new JSONObject();
            data.put("currentPlayer", nextPlayer);
            data.put("nextPlayer", currentPlayer);
            JSONArray bData = board.toJsonArray();
            data.put("board", bData);
            result = data.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setData(String d) {
        JSONObject data = null;
        try {
            data = new JSONObject(d);

            if (data.has("currentPlayer")) {
                currentPlayer = data.getString("currentPlayer");
            }
            if (data.has("nextPlayer")) {
                nextPlayer = data.getString("nextPlayer");
            }
            if (data.has("board")) {
                board.fillBoardWithJson(data.getJSONArray("board"));
                displayWarriors();
            } else {
                randomlySelectPlaces();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        TextView currentPlayerName = (TextView) pView.findViewById(R.id.player_name);
        currentPlayerName.setText(currentPlayer);
        TextView opponentPlayerName = (TextView) pView.findViewById(R.id.opponent_name);
        opponentPlayerName.setText(nextPlayer);
    }

    public void randomlySelectPlaces() {
        Cell heavyDuty = new Cell(1, pieces.getHeavy(), pieces.getStandardWeaponPack());
        Cell smallBird = new Cell(2, pieces.getSmallBird(), pieces.getStandardWeaponPack());
        Cell bigBird = new Cell(3, pieces.getBigBird(), pieces.getStandardWeaponPack());
        Cell predator = new Cell(4, pieces.getPredator(), pieces.getStandardWeaponPack());
        Cell reptile = new Cell(5, pieces.getReptile(), pieces.getStandardWeaponPack());
        Cell rodent = new Cell(6, pieces.getRodent(), pieces.getStandardWeaponPack());
        board.setCellAt(1, heavyDuty);
        board.setCellAt(2, smallBird);
        board.setCellAt(3, bigBird);
        board.setCellAt(4, predator);
        board.setCellAt(5, reptile);
        board.setCellAt(6, rodent);

        board.setCellAt(31, heavyDuty);
        board.setCellAt(32, smallBird);
        board.setCellAt(33, bigBird);
        board.setCellAt(34, predator);
        board.setCellAt(35, reptile);
        board.setCellAt(36, rodent);
        displayWarriors();
    }

    public void displayWarriors() {
        for (int i = 1; i <= 36; i++) {
            Cell currentCell = board.getCellNumber(i);
            if (currentCell.hasWarrior()) {
                Warrior currentWarrior = currentCell.getWarrior();
                TextView currentTextView = (TextView) convertToViewFromId(i);
                currentTextView.setBackgroundResource(currentWarrior.getPictureFilePath());
            }
        }
    }

    public void setClickListeners() {
        //pView.findViewById(R.id.doneButton).setOnClickListener(this);
        pView.findViewById(R.id.board_1).setOnClickListener(this);
        pView.findViewById(R.id.board_2).setOnClickListener(this);
        pView.findViewById(R.id.board_3).setOnClickListener(this);
        pView.findViewById(R.id.board_4).setOnClickListener(this);
        pView.findViewById(R.id.board_5).setOnClickListener(this);
        pView.findViewById(R.id.board_6).setOnClickListener(this);
        pView.findViewById(R.id.board_7).setOnClickListener(this);
        pView.findViewById(R.id.board_8).setOnClickListener(this);
        pView.findViewById(R.id.board_9).setOnClickListener(this);
        pView.findViewById(R.id.board_10).setOnClickListener(this);
        pView.findViewById(R.id.board_11).setOnClickListener(this);
        pView.findViewById(R.id.board_12).setOnClickListener(this);
        pView.findViewById(R.id.board_13).setOnClickListener(this);
        pView.findViewById(R.id.board_14).setOnClickListener(this);
        pView.findViewById(R.id.board_15).setOnClickListener(this);
        pView.findViewById(R.id.board_16).setOnClickListener(this);
        pView.findViewById(R.id.board_17).setOnClickListener(this);
        pView.findViewById(R.id.board_18).setOnClickListener(this);
        pView.findViewById(R.id.board_19).setOnClickListener(this);
        pView.findViewById(R.id.board_20).setOnClickListener(this);
        pView.findViewById(R.id.board_21).setOnClickListener(this);
        pView.findViewById(R.id.board_22).setOnClickListener(this);
        pView.findViewById(R.id.board_23).setOnClickListener(this);
        pView.findViewById(R.id.board_24).setOnClickListener(this);
        pView.findViewById(R.id.board_25).setOnClickListener(this);
        pView.findViewById(R.id.board_26).setOnClickListener(this);
        pView.findViewById(R.id.board_27).setOnClickListener(this);
        pView.findViewById(R.id.board_28).setOnClickListener(this);
        pView.findViewById(R.id.board_29).setOnClickListener(this);
        pView.findViewById(R.id.board_30).setOnClickListener(this);
        pView.findViewById(R.id.board_31).setOnClickListener(this);
        pView.findViewById(R.id.board_32).setOnClickListener(this);
        pView.findViewById(R.id.board_33).setOnClickListener(this);
        pView.findViewById(R.id.board_34).setOnClickListener(this);
        pView.findViewById(R.id.board_35).setOnClickListener(this);
        pView.findViewById(R.id.board_36).setOnClickListener(this);
        pView.findViewById(R.id.shelf_1).setOnClickListener(this);
        pView.findViewById(R.id.shelf_2).setOnClickListener(this);
        pView.findViewById(R.id.shelf_3).setOnClickListener(this);
        pView.findViewById(R.id.shelf_4).setOnClickListener(this);
    }

    public void dealWith(int id) {
        if (selected.size() >= 2) {
            if (selected.size() == 2) {
                selected.add(2, id);
            } else {
                selected.set(2, id);
            }
        } else {
            if (selected.size() == 0) {
                selected.add(0, id);
            } else {
                selected.set(0, id);
            }
        }
    }

    public View convertToViewFromId(int id) {
        switch (id) {
            case 1:
                return pView.findViewById(R.id.board_1);

            case 2:
                return pView.findViewById(R.id.board_2);

            case 3:
                return pView.findViewById(R.id.board_3);

            case 4:
                return pView.findViewById(R.id.board_4);

            case 5:
                return pView.findViewById(R.id.board_5);

            case 6:
                return pView.findViewById(R.id.board_6);

            case 7:
                return pView.findViewById(R.id.board_7);

            case 8:
                return pView.findViewById(R.id.board_8);

            case 9:
                return pView.findViewById(R.id.board_9);

            case 10:
                return pView.findViewById(R.id.board_10);

            case 11:
                return pView.findViewById(R.id.board_11);

            case 12:
                return pView.findViewById(R.id.board_12);

            case 13:
                return pView.findViewById(R.id.board_13);

            case 14:
                return pView.findViewById(R.id.board_14);

            case 15:
                return pView.findViewById(R.id.board_15);

            case 16:
                return pView.findViewById(R.id.board_16);

            case 17:
                return pView.findViewById(R.id.board_17);

            case 18:
                return pView.findViewById(R.id.board_18);

            case 19:
                return pView.findViewById(R.id.board_19);

            case 20:
                return pView.findViewById(R.id.board_20);

            case 21:
                return pView.findViewById(R.id.board_21);

            case 22:
                return pView.findViewById(R.id.board_22);

            case 23:
                return pView.findViewById(R.id.board_23);

            case 24:
                return pView.findViewById(R.id.board_24);

            case 25:
                return pView.findViewById(R.id.board_25);

            case 26:
                return pView.findViewById(R.id.board_26);

            case 27:
                return pView.findViewById(R.id.board_27);

            case 28:
                return pView.findViewById(R.id.board_28);

            case 29:
                return pView.findViewById(R.id.board_29);

            case 30:
                return pView.findViewById(R.id.board_30);

            case 31:
                return pView.findViewById(R.id.board_31);

            case 32:
                return pView.findViewById(R.id.board_32);

            case 33:
                return pView.findViewById(R.id.board_33);

            case 34:
                return pView.findViewById(R.id.board_34);

            case 35:
                return pView.findViewById(R.id.board_35);

            case 36:
                return pView.findViewById(R.id.board_36);

        }
        return null;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
//            case R.id.doneButton:
//                FullscreenActivity f = new FullscreenActivity();
//                f.done("" + selected);
//                break;
            case R.id.shelf_1:
                if (selected.size() >= 2) {
                    selected.set(1, 1);
                } else {
                    selected.add(1, 1);
                }
                break;
            case R.id.shelf_2:
                if (selected.size() >= 2) {
                    selected.set(1, 2);
                } else {
                    selected.add(1, 2);
                }
                break;
            case R.id.shelf_3:
                if (selected.size() >= 2) {
                    selected.set(1, 3);
                } else {
                    selected.add(1, 3);
                }
                break;
            case R.id.shelf_4:
                if (selected.size() >= 2) {
                    selected.set(1, 4);
                } else {
                    selected.add(1, 4);
                }
                break;
            case R.id.board_1:
                dealWith(1);
                break;
            case R.id.board_2:
                dealWith(2);
                break;
            case R.id.board_3:
                dealWith(3);
                break;
            case R.id.board_4:
                dealWith(4);
                break;
            case R.id.board_5:
                dealWith(5);
                break;
            case R.id.board_6:
                dealWith(6);
                break;
            case R.id.board_7:
                dealWith(7);
                break;
            case R.id.board_8:
                dealWith(8);
                break;
            case R.id.board_9:
                dealWith(9);
                break;
            case R.id.board_10:
                dealWith(10);
                break;
            case R.id.board_11:
                dealWith(11);
                break;
            case R.id.board_12:
                dealWith(12);
                break;
            case R.id.board_13:
                dealWith(13);
                break;
            case R.id.board_14:
                dealWith(14);
                break;
            case R.id.board_15:
                dealWith(15);
                break;
            case R.id.board_16:
                dealWith(16);
                break;
            case R.id.board_17:
                dealWith(17);
                break;
            case R.id.board_18:
                dealWith(18);
                break;
            case R.id.board_19:
                dealWith(19);
                break;
            case R.id.board_20:
                dealWith(20);
                break;
            case R.id.board_21:
                dealWith(21);
                break;
            case R.id.board_22:
                dealWith(22);
                break;
            case R.id.board_23:
                dealWith(23);
                break;
            case R.id.board_24:
                dealWith(24);
                break;
            case R.id.board_25:
                dealWith(25);
                break;
            case R.id.board_26:
                dealWith(26);
                break;
            case R.id.board_27:
                dealWith(27);
                break;
            case R.id.board_28:
                dealWith(28);
                break;
            case R.id.board_29:
                dealWith(29);
                break;
            case R.id.board_30:
                dealWith(30);
                break;
            case R.id.board_31:
                dealWith(31);
                break;
            case R.id.board_32:
                dealWith(32);
                break;
            case R.id.board_33:
                dealWith(33);
                break;
            case R.id.board_34:
                dealWith(34);
                break;
            case R.id.board_35:
                dealWith(35);
                break;
            case R.id.board_36:
                dealWith(36);
                break;

        }
        TextView output = (TextView) pView.findViewById(R.id.game);
        output.setText("" + selected);
    }
}
