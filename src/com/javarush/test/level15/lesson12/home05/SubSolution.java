package com.javarush.test.level15.lesson12.home05;

import java.math.BigDecimal;

/**
 * Created by smu-68 on 23.04.2015.
 */
public class SubSolution extends Solution {
    public SubSolution()//
    {
    }

    public SubSolution(int s)//
    {
        super(s);
    }

    public SubSolution(short s)//
    {
        super(s);
    }

    protected SubSolution(Integer s)
    {
        super(s);
    }

    protected SubSolution(Double s)
    {
        super(s);
    }

    protected SubSolution(double s)
    {
        super(s);
    }

    private SubSolution (byte s) {}
    private SubSolution (long s) {}
    private SubSolution (float s) {}

    SubSolution(BigDecimal s)
    {
        super(s);
    }

    SubSolution(Float s)
    {
        super(s);
    }

    SubSolution(Object s)
    {
        super(s);
    }
}
