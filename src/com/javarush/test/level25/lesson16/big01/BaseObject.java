package com.javarush.test.level25.lesson16.big01;

/**
 * Created by M.E.R.lin on 18.12.2015.
 */
public class BaseObject {
    private double x;
    private double y;
    private double radius;
    private boolean isAlive;

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive=true;
    }

    public void draw(){
        //
    }

    public void move(){
        //
    }

    public void die(){
        this.isAlive=false;
    }

    public boolean isIntersec(BaseObject o){
        double distanse=Math.sqrt(Math.pow(o.getX()-this.getX(),2)+Math.pow(o.getY()-this.getY(),2));
        double max=o.getRadius()>this.getRadius()?o.getRadius():this.getRadius();
        return distanse<max;
    }
}
