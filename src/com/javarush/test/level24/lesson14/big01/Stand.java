package com.javarush.test.level24.lesson14.big01;

/**
 * Created by M.E.R.lin on 28.11.2015.
 */
public class Stand extends BaseObject {
    private double speed;
    private double direction;
    public double getSpeed() {
        return speed;
    }
    public double getDirection() {
        return direction;
    }

    public Stand(double x, double y) {
        super(x, y, 3);
        speed=1;
        direction=0;
    }

    @Override
    public void draw(Canvas canvas) {
        //
    }

    @Override
    public void move() {
        //
    }
}
