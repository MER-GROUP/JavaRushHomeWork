package RunnableFuture;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by M.E.R.lin on 15.12.2015.
 */
public class FutureTest {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Укажите базовый каталог (например, D:\\TEMP) : ");
        String directory=in.nextLine();
        System.out.println("Введите ключевое слово (например, volatile) : ");
        String keyword=in.nextLine();
        MatchCounter counter=new MatchCounter(new File(directory),keyword);
        FutureTask<Integer> task=new FutureTask<Integer>(counter);
        Thread t=new Thread(task);
        t.start();
        try
        {
            System.out.println(task.get()+" файлов найдено.");
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

/* *
* Задача подсчитывает файлы в каталоге и всех его подкаталогах,
* которые содержат указанное ключевое слово
*
* конструктор public MatchCounter(File directory, String keyword)
* @param directory - каталог, с которого начинается поиск
* @param keyword - искомое ключевое слово
*
* метод public boolean search(File file)
* ищем в файле заданное ключевое слово.
* @param file - файл, в котором идет поиск
* @return true - если слово найдено в файле
* */
class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private int count;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        count=0;
        try{
            File[] files=directory.listFiles();
            ArrayList<Future<Integer>> results=new ArrayList<Future<Integer>>();
            for (File file:files){
                if (file.isDirectory()){
                    MatchCounter counter=new MatchCounter(file,keyword);
                    FutureTask task=new FutureTask(counter);
                    results.add(task);
                    Thread t=new Thread(task);
                    t.start();
                }else {
                    if (search(file)){
                        count++;
                    }
                }
            }
            for (Future<Integer> result:results){
                try {
                    count+=result.get();
                }catch (ExecutionException e){
                    e.printStackTrace();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }

    public boolean search(File file){
        try{
            Scanner in=new Scanner((Readable) new FileImageInputStream(file));
            boolean found=false;
            while (!found && in.hasNextLine()){
                String line=in.nextLine();
                if (line.contains(keyword)){
                    found=true;
                }
            }
            in.close();
            return found;
        }catch (IOException e){
            return  false;
        }
    }
}
