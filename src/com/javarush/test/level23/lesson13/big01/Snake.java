package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by maxim on 24.09.2015.
 */
public class Snake {
    private ArrayList<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    public SnakeDirection getDirection() {
        return direction;
    }
    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Snake(int x,int y) {
        sections=new ArrayList<>();
        sections.add(new SnakeSection(x,y));
        isAlive=true;
    }

    public void move(){
        if (getDirection()==SnakeDirection.DOWN){
            int y=sections.get(0).getY();
            int x=sections.get(0).getX();
            y++;
            sections.add(0,new SnakeSection(x,y));
        }else if (getDirection()==SnakeDirection.UP){
            int y=sections.get(0).getY();
            int x=sections.get(0).getX();
            y--;
            sections.add(0,new SnakeSection(x,y));
        }else if (getDirection()==SnakeDirection.LEFT){
            int y=sections.get(0).getY();
            int x=sections.get(0).getX();
            x--;
            sections.add(0,new SnakeSection(x,y));
        }else {
            int y=sections.get(0).getY();
            int x=sections.get(0).getX();
            x++;
            sections.add(0,new SnakeSection(x,y));
        }

        if ((getSections().get(0).getY()<0 || getSections().get(0).getY()>=Room.game.getHeight()) ||
                (getSections().get(0).getX()<0 || getSections().get(0).getX()>=Room.game.getWidth())){
            isAlive=false;
        }
        if (isAlive()){
            for (int i = 1; i < getSections().size(); i++) {
                if (getSections().get(0).getY()==getSections().get(i).getY() &&
                        getSections().get(0).getX()==getSections().get(i).getX()){
                    isAlive=false;
                    break;
                }
            }
        }

        if (getSections().get(0).getY()==Room.game.getMouse().getY() &&
                getSections().get(0).getX()==Room.game.getMouse().getX()){
            Room.game.eatMouse();
        }else {
            getSections().remove(getSections().size()-1);
        }
    }
}
