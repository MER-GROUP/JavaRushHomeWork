package RunnableFuture;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by M.E.R.lin on 15.12.2015.
 */
public class CallableExample {
    //nested class
    public static class WordLengthCallable implements Callable<Integer>{
        private String word;

        public WordLengthCallable(String word) {
            this.word = word;
        }

        @Override
        public Integer call() throws Exception {
            return word.length();
        }
    }

    //main
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool= Executors.newFixedThreadPool(3);
        Set<Future<Integer>> set=new HashSet<Future<Integer>>();
        for (String word:args){
            Callable<Integer> callable=new WordLengthCallable(word);
            Future<Integer> future=pool.submit(callable);
            set.add(future);
        }
        int sum=0;
        for (Future<Integer> future:set){
            sum+=future.get();
        }
        System.out.println("The sum of lengths is "+sum);
        System.exit(sum);
    }
}
