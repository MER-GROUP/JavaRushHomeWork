package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by maxim on 05.09.2015.
 */
public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game=new Hippodrome();

        Horse firstHorse=new Horse("firstHorse",3,0);
        Horse secondHorse=new Horse("secondHorse",3,0);
        Horse thirdHorse=new Horse("thirdHorse",3,0);

        //game.horses=new ArrayList<Horse>();

        game.getHorses().add(firstHorse);
        game.getHorses().add(secondHorse);
        game.getHorses().add(thirdHorse);
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            this.move();
            this.print();
            Thread.sleep(500);
        }
    }

    public void move(){
        for (Horse itr: getHorses()){
            itr.move();
        }
    }

    public void print(){
        //
    }
}
