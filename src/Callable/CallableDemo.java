package Callable;

import java.util.concurrent.*;

/**
 * Created by M.E.R.lin on 16.12.2015.
 */
class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        SumTask sumTask=new SumTask(20);
        Future<Integer> future=executorService.submit(sumTask);
        Integer result=future.get();
        System.out.println(result);
        executorService.shutdown();
    }
}

class SumTask implements Callable<Integer>{
    private int num=0;

    public SumTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int result=0;
        for (int i = 0; i <= num; i++) {
            result+=i;
        }
        return result;
    }
}
