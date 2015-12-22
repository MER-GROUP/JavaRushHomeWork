package com.javarush.test.level25.lesson16.big01;

/**
 * Created by M.E.R.lin on 18.12.2015.
 */
public class Ufo extends BaseObject{
    private static int[][] matrix = {
            {1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {0, 0, 1, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
    };
    private static int hod=0;

    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'U');
    }

    @Override
    public void move() {
        double dx=Math.random()*2-1;
        double dy=Math.random()*2-1;
        setX(getX()+dx);
        setY(getY()+dy);
        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight()/2);
        ++hod;
        if (10==hod){
            hod=0;
            fire();
        }
    }

    public void fire(){
        Space.game.getBombs().add(new Bomb(x,y));
    }
}
