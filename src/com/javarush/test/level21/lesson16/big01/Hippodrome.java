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

    public static void main(String[] args) throws InterruptedException {
        game=new Hippodrome();

        Horse firstHorse=new Horse("firstHorse",3,0);
        Horse secondHorse=new Horse("secondHorse",3,0);
        Horse thirdHorse=new Horse("thirdHorse",3,0);

        //game.horses=new ArrayList<Horse>();

        game.getHorses().add(firstHorse);
        game.getHorses().add(secondHorse);
        game.getHorses().add(thirdHorse);

        game.run();
        game.printWinner();
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
        for (Horse itr: getHorses()){
            itr.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        double temp=getHorses().get(0).getDistance();
        Horse horse=getHorses().get(0);
        for (int i = 1; i < getHorses().size(); i++) {
            if (temp<getHorses().get(i).getDistance()){
                temp=getHorses().get(i).getDistance();
                horse=getHorses().get(i);
            }
        }
        return horse;
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}
