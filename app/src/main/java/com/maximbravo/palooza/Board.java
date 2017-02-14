package com.maximbravo.palooza;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Maxim Bravo on 2/9/2017.
 */

public class Board {
    private Cell[] board;
    private int width;
    private int height;
    public Board(int w, int h){
        width = w;
        height = h;
        board = new Cell[width*height];
        fillInitialBoard();
    }

    public Cell getCellNumber(int id){
        return board[id-1];
    }
    public void setCellAt(int id, Cell cell){
        Cell nCell = cell;
        nCell.setCellId(id);
        board[id-1] = nCell;
    }
    /*
    board{
        cell{
            id:1
            hasWarrior:true

        }
    }
     */
    public void fillBoardWithJson(JSONArray bData){
        for(int i = 1; i <= bData.length(); i++){
            Cell newCell = new Cell(i);
            try {
                JSONObject cell = (JSONObject) bData.get(i-1);

                if(cell.has("hasWarrior")){
                    if(cell.getBoolean("hasWarrior")){
                        newCell.setHasWarrior(true);
                        if(cell.has("warriorName")) {
                            newCell.setWarrior(TemporaryGame.pieces.getWarriorWithName(cell.getString("warriorName")));
                        }
                        if(cell.has("warriorHealth")) {
                            newCell.setWarriorHealth(cell.getInt("warriorHealth"));
                        }
                        if(cell.has("weapons")){
                            newCell.setWeapons(cell.getString("weapons"));
                        }
//                    cell.put("weapons", currentCell.getWeapons());
//                    cell.put("shelfWeapons", currentCell.getShelfWeapons());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            board[i-1] = newCell;

        }
    }
    public JSONArray toJsonArray(){
        JSONArray result = new JSONArray();
        for(int i = 1; i <= board.length; i++){
            JSONObject cell = new JSONObject();
            Cell currentCell = board[i-1];
            try {

                boolean hasWar = currentCell.hasWarrior();
                cell.put("hasWarrior", hasWar);
                if(hasWar){
                    Warrior warrior = currentCell.getWarrior();
                    cell.put("warriorName", warrior.getName());
                    cell.put("warriorHealth", warrior.getHealth());
                    cell.put("weapons", currentCell.getWeapons());
//                    cell.put("shelfWeapons", currentCell.getShelfWeapons());
                }
                result.put(cell);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
    public void fillInitialBoard(){
        for(int i = 1; i <= width*height; i++){
            Cell empty = new Cell(i);
            board[i-1] = empty;
        }
    }

}
