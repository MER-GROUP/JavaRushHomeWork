package RunnableFuture;

import com.javarush.test.level20.lesson02.task05.Solution;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by M.E.R.lin on 16.12.2015.
 */
public class Main {
    //copy
    public static void copy(String[] urls, Path dst){
        //количество потоков
        int THREADS=4;
        ExecutorService pool= Executors.newFixedThreadPool(THREADS);
        List<Callable<Object>> tasks=new ArrayList<Callable<Object>>();
        try{
            for (int i = 0; i < urls.length; i++) {
                final String url=urls[i];
                final Path dstPath=dst.resolve(i+".html");
                //добавляем задачи
                tasks.add(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        download(url,dstPath);
                        return null;
                    }
                });
            }
            //запускаем пулл потоков и дожидаемся
            List<Future<Object>> invokeAll=pool.invokeAll(tasks);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }
    //копируем содержимое url в dst (и так тоже лучше не делать в продакшене)
    private static long download(String url,Path dst){
        try{
            URI u= URI.create(url);
            try(InputStream in=u.toURL().openStream()){
                Files.copy(in,dst, StandardCopyOption.REPLACE_EXISTING);
            }
            System.out.printf("%s -> %s %n",url,dst);
            return dst.toFile().length();
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }
    //main
    public static void main(String[] args) {
        String[] urls={"http://oracle.com",
                        "http://google.com",
                        "http://apple.com",
                        "http://ibm.com",
                        "http://sap.com"};
        copy(urls, Paths.get(""));
    }
}
