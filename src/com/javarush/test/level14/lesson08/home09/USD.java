package com.javarush.test.level14.lesson08.home09;

/**
 * Created by smu-68 on 17.04.2015.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return this.getClass().getSimpleName();
    }
}
