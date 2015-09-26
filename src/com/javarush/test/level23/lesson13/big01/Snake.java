package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Класс змея
 */
public class Snake
{
    //Направление движения змеи
    private SnakeDirection direction;
    //Состояние - жива змея или нет.
    private boolean isAlive;
    //Список кусочков змеи.
    private ArrayList<SnakeSection> sections = new ArrayList<SnakeSection>();

    public Snake(int x, int y)
    {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public int getX()
    {
        return sections.get(0).getX();
    }

    public int getY()
    {
        return sections.get(0).getY();
    }

    public SnakeDirection getDirection()
    {
        return direction;
    }

    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public ArrayList<SnakeSection> getSections()
    {
        return sections;
    }

    /**
     * Метод перемещает змею на один ход.
     * Направление перемещения задано переменной direction.
     */
    public void move()
    {
        if (!isAlive) return;

        if (direction == SnakeDirection.UP)
            move(0, -1);
        else if (direction == SnakeDirection.RIGHT)
            move(1, 0);
        else if (direction == SnakeDirection.DOWN)
            move(0, 1);
        else if (direction == SnakeDirection.LEFT)
            move(-1, 0);
    }

    /**
     * Метод перемещает змею в соседнюю клетку.
     * Кординаты клетки заданы относительно текущей головы с помощью переменных (dx, dy).
     */
    private void move(int dx, int dy)
    {
        //Создаем новую голову - новый "кусочек змеи".
        SnakeSection head=new SnakeSection(getX()+dx,getY()+dy);
        //Проверяем - не вылезла ли голова за границу комнаты
        checkBorders(head);
        //Проверяем - не пересекает ли змея  саму себя
        checkBody(head);
        //Проверяем - не съела ли змея мышь.
        if (head.getX()==Room.game.getMouse().getX() && head.getY()==Room.game.getMouse().getY()){
            Room.game.eatMouse();
        }else {
            getSections().remove(getSections().size()-1);
        }
        //Двигаем змею.
        getSections().add(0,head);

    }

    /**
     *  Метод проверяет - находится ли новая голова в пределах комнаты
     */
    private void checkBorders(SnakeSection head)
    {
        if (head.getY()<0 || head.getY()>=Room.game.getHeight() ||
                head.getX()<0 || head.getX()>=Room.game.getWidth()){
            isAlive=false;
        }
    }

    /**
     *  Метод проверяет - не совпадает ли голова с каким-нибудь участком тела змеи.
     */
    private void checkBody(SnakeSection head)
    {
        if (getSections().contains(head)) isAlive=false;
    }
}
