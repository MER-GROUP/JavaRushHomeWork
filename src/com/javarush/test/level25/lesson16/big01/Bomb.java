package com.javarush.test.level25.lesson16.big01;

/**
 * Created by M.E.R.lin on 18.12.2015.
 */
public class Bomb extends BaseObject{
    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    public void move(){
        this.setY(this.getY()+1);
    }

    public void draw(Canvas canvas){
        canvas.setPoint(x,y,'B');
    }
}
