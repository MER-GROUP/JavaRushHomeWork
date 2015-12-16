package Callable;

import java.util.concurrent.*;

/**
 * Created by M.E.R.lin on 16.12.2015.
 */
class Solution {
    //main
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        Future<Integer> future1=executorService.submit(new MyThread());
        Future<Integer> future2=executorService.submit(new MyThread());

        try {
            System.out.println(future1.get()+" future1.get()");
            System.out.println(future2.get()+" future2.get()");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}

class MyThread implements Callable<Integer>{
    public int count=0;
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
        return count;
    }
}
