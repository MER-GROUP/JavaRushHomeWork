package Callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by M.E.R.lin on 16.12.2015.
 */
public class MyCallable implements Callable<String> {
    //implements Callable
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //возвращает имя потока, который выполняет Callable task
        return Thread.currentThread().getName();
    }
    //main
    public static void main(String[] args) {
        //получаем ExecutorService утилитного класса Executors с размером
        //пула потоков равному 10
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        //создаем список Future, которые ассоциированы с Callable
        List<Future<String>> list=new ArrayList<Future<String>>();
        //создаем экземпляр MyCallable
        Callable<String> callable=new MyCallable();
        for (int i = 0; i < 100; i++) {
            //сабмитим Callable таски, которые будут выполнены пулом потоков
            Future<String> future=executorService.submit(callable);
            //добавляя Future в список, мы сможем получить результат выполнения
            list.add(future);
        }
        for (Future<String> future:list){
            try{
                //печатаем в консоль возвращенное значение Future
                //будет задержка в 1 секунду, потому что Future.get
                //ждет пока таск закончит выполнение
                System.out.println(new Date()+"::"+future.get());
            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //завершаем исполнителя
        executorService.shutdown();
    }
}
