package com.javarush.test.level13.lesson11.bonus03;

public abstract class AbstractRobot implements Attackable, Defensable
{
    public abstract BodyPart attack();
    public abstract BodyPart defense();
    public abstract String getName();
}
