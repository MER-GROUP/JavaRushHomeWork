package com.javarush.test.level25.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by M.E.R.lin on 18.12.2015.
 */
public class Space {
    private int width;
    private int height;
    private SpaceShip ship;
    private ArrayList<Ufo> ufos;
    private ArrayList<Rocket> rockets;
    private ArrayList<Bomb> bombs;
    public static Space game;

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public SpaceShip getShip() {
        return ship;
    }
    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }
    public ArrayList<Ufo> getUfos() {
        return ufos;
    }
    public ArrayList<Rocket> getRockets() {
        return rockets;
    }
    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
        this.ship=new SpaceShip(200,300,5);
        this.ufos=new ArrayList<>();
        this.rockets=new ArrayList<>();
        this.bombs=new ArrayList<>();
    }

    public void run(){
        //
    }

    public void draw(){
        //
    }

    public void sleep(int ms){
        //
    }

    //main
    public static void main(String[] args) {
        //
    }
}
