package com.javarush.test.level23.lesson13.big01;


import java.awt.event.KeyEvent;

/**
 * Основной класс программы.
 */
public class Room
{
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake)
    {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public Snake getSnake()
    {
        return snake;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setSnake(Snake snake)
    {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse)
    {
        this.mouse = mouse;
    }

    /**
     *  Основной цикл программы.
     *  Тут происходят все важные действия
     */
    public void run()
    {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive())
        {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents())
            {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Выводим на экран текущее состояние игры
     */
    public void print()
    {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        //Рисуем все кусочки змеи
        //Рисуем мышь
        //Выводим все это на экран
        int[][] display=new int[getWidth()][getHeight()];
        for (int i = 0; i < getSnake().getSections().size(); i++) {
            if (i==0){
                display[getSnake().getSections().get(i).getX()][getSnake().getSections().get(i).getY()]=2;
            }else {
                display[getSnake().getSections().get(i).getX()][getSnake().getSections().get(i).getY()]=1;
            }
        }
        display[getMouse().getX()][getMouse().getY()]=3;
        for (int i = 0; i < display.length; i++) {
            for (int j = 0; j < display[i].length; j++) {
                if (display[i][j]==0) System.out.print(".");
                else if (display[i][j]==1) System.out.print("x");
                else if (display[i][j]==2) System.out.print("X");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Метод вызывается, когда мышь съели
     */
    public void eatMouse()
    {
        createMouse();
    }

    /**
     * Создает новую мышь
     */
    public void createMouse()
    {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }


    public static Room game;

    public static void main(String[] args)
    {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }


    /**
     * Прогрмма делает паузу, длинна которой зависит от длинны змеи.
     */
    public void sleep()
    {
        try{
            if (getSnake().getSections().size()==1){
                Thread.sleep(500);
            }
            else if (getSnake().getSections().size()==2){
                Thread.sleep(450);
            }
            else if (getSnake().getSections().size()==3){
                Thread.sleep(430);
            }
            else if (getSnake().getSections().size()==4){
                Thread.sleep(410);
            }
            else if (getSnake().getSections().size()==5){
                Thread.sleep(400);
            }
            else if (getSnake().getSections().size()==6){
                Thread.sleep(380);
            }
            else if (getSnake().getSections().size()==7){
                Thread.sleep(360);
            }
            else if (getSnake().getSections().size()==8){
                Thread.sleep(340);
            }
            else if (getSnake().getSections().size()==9){
                Thread.sleep(320);
            }
            else if (getSnake().getSections().size()==10){
                Thread.sleep(300);
            }
            else if (getSnake().getSections().size()>10){
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
