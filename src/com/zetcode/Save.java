package com.zetcode;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Save {
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    Data data = new Data();
//    InputStreamReader in = new InputStreamReader(System.in);


    int cntPlayer= 0;
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    Save(Data data){
        this.data = data;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void saveEnemyLocation(){
       /* for(data.setE)
        c = data.getX(data.getIndex());
        try {
            fout = new FileWriter("/res/txt/enemyLocation.txt");
            while(())
        }
        catch(IOException e){

        }*/
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void savePlayerLocation() {
        InputStreamReader in = new InputStreamReader(System.in);

        FileWriter playerLocationX = null;
        FileWriter playerLocationY = null;

        int cntdots = 0;
        ArrayList<String> playerX = new ArrayList<String>();
        ArrayList<String> playerY = new ArrayList<String>();
        for (data.setIndex(0); data.getIndex() < data.getDots(); data.setIndex(data.getIndex() + 1)) {
            playerX.add(Integer.toString(data.getX()));
            playerX.add(" ");
        }

        try {
            playerLocationX = new FileWriter("res/txt/playerLocation.txt", false);

            for (int i = 0; i < playerX.size(); ++i) {
                playerLocationX.write(playerX.get(i));
                cntdots++;
            }
            playerLocationX.write("\r\n");

//            in.close();
            playerLocationX.close();
        }
        catch (IOException e) {
            System.out.println("입출력 오류");
        }

        for(data.setIndex(0);data.getIndex() < data.getDots();data.setIndex(data.getIndex() +1 )){
            playerY.add(Integer.toString(data.getY()));
            playerY.add(" ");
        }

        try{
            playerLocationY = new FileWriter("res/txt/playerLocation.txt", true);
            for (int i = 0; i < playerY.size(); ++i)
                playerLocationY.write(playerY.get(i));
            playerLocationY.write("\r\n");
            playerLocationY.write(cntdots+";");

            in.close();
            playerLocationY.close();
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }


    }

    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void saveItemLocation(){
        InputStreamReader in = new InputStreamReader(System.in);

        FileWriter itemX = null;
        FileWriter itemY = null;

        try{
            itemX = new FileWriter("res/txt/itemLocation.txt",false);
            itemX.write(Integer.toString(data.getItem_x()));
            itemX.write("\r\n");

            itemX.close();
        }
        catch (IOException e){
            System.out.println("입출력 오류");
        }

        try{
            itemY = new FileWriter("res/txt/itemLocation.txt",true);
            itemY.write(Integer.toString(data.getItem_y()));
            itemY.write(";");
            itemY.write("\r\n");

            in.close();
            itemY.close();
        }
        catch (IOException e){
            System.out.println("입출력 오류");
        }


    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void saveAssignmentLocation() {
        InputStreamReader in = new InputStreamReader(System.in);

        FileWriter assignX = null;
        FileWriter assignY = null;

        try {
            assignX = new FileWriter("res/txt/assignmentLocation.txt", false);
            assignX.write(Integer.toString(data.getItem_x()));
            assignX.write("\r\n");

            assignX.close();
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }

        try {
            assignY = new FileWriter("res/txt/assignmentLocation.txt", true);
            assignY.write(Integer.toString(data.getItem_y()));
            assignY.write(";");
            assignY.write("\r\n");

            in.close();
            assignY.close();
        }
        catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void saveScore(){
        InputStreamReader in = new InputStreamReader(System.in);

        FileWriter score = null;

        try{
            score = new FileWriter("res/txt/score.txt", true);
            score.write(Integer.toString(data.getScore()));
            score.write(";");
            score.write("\r\n");
        }
        catch (IOException e){
        System.out.println("입출력 오류");
        }
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void saveStage() {
        InputStreamReader in = new InputStreamReader(System.in);
    }
}
//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//