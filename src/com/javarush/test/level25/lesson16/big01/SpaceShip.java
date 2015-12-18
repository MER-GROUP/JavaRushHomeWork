package com.javarush.test.level25.lesson16.big01;

/**
 * Created by M.E.R.lin on 18.12.2015.
 */
public class SpaceShip extends BaseObject{
    private double dx=0;

    public SpaceShip(double x, double y, double radius) {
        super(x, y, radius);
    }

    public SpaceShip(int x, int y) {
        super(x, y, 3);
    }

    public void moveLeft(){
        dx=-1;
    }

    public void moveRight(){
        dx=1;
    }

    public void move(){
        this.setX(this.getX()+this.dx);
        this.checkBorders(0,Space.game.getWidth(),0,Space.game.getHeight());
    }

    public void fire(){
        Space.game.getRockets().add(new Rocket(getX(),getY()));
        Space.game.getRockets().add(new Rocket(getX(),getY()));
    }
}
