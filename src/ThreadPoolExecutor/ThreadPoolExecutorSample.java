package ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by M.E.R.lin on 14.12.2015.
 */
public class ThreadPoolExecutorSample {
    public ThreadPoolExecutorSample() {
    }

    public static void main(String[] args) {
        Runnable firstTask=new Runnable() {
            int number=0;
            @Override
            public void run() {
                while (number<50){
                    System.out.println("Thread : "+Thread.currentThread().getName()+" Number = "+number);
                    number+=10;
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable secondTask=new Runnable() {
            int number=50;
            @Override
            public void run() {
                while (number<100){
                    System.out.println("Thread : "+Thread.currentThread().getName()+" Number = "+number);
                    number+=10;
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable thirdTask=new Runnable() {
            int number=100;
            @Override
            public void run() {
                while (number<150){
                    System.out.println("Thread : "+Thread.currentThread().getName()+" Number = "+number);
                    number+=10;
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable fourthTask=new Runnable() {
            int number=150;
            @Override
            public void run() {
                while (number<200){
                    System.out.println("Thread : "+Thread.currentThread().getName()+" Number = "+number);
                    number+=10;
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        LinkedBlockingQueue<Runnable> queue=new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2,2,10,TimeUnit.MINUTES,queue);
        threadPoolExecutor.execute(firstTask);
        threadPoolExecutor.execute(secondTask);
        threadPoolExecutor.execute(thirdTask);
        threadPoolExecutor.execute(fourthTask);
    }
}