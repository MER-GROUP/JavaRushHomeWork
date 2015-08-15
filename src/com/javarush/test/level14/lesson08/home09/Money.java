package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double money;

    public Money(double amount)
    {
        this.money=amount;
    }

    public double getAmount(){
        return money;
    }

    public abstract String getCurrencyName();
}

