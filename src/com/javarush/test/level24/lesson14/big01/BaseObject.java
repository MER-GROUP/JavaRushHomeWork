package com.javarush.test.level24.lesson14.big01;

/**
 * Created by M.E.R.lin on 28.11.2015.
 */
public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;
    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
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

    public abstract void draw();
    public abstract void move();

    public boolean isIntersec(BaseObject o){
        double x1=getX();
        double x2=o.getX();
        double y1=getY();
        double y2=o.getY();
        double r1=getRadius();
        double r2=o.getRadius();
        double distance=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        double maxRadius=Math.max(r1,r2);
        if (distance<maxRadius) return true;
        return false;
    }
}
