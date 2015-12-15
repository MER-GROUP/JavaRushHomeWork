package ThreadPoolExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by M.E.R.lin on 14.12.2015.
 */
public class WebWorker implements Runnable {
    private String pageUrl;
    private ThreadPoolExecutor executor;
    private HashMap<String,Integer> map;

    public WebWorker(String pageUrl, ThreadPoolExecutor executor, HashMap<String, Integer> map) {
        this.pageUrl = pageUrl;
        this.executor = executor;
        this.map = map;
    }

    private String getBaseUrl(String pageUrl){
        if (pageUrl.endsWith("/")||pageUrl.endsWith("\\")){
            return pageUrl;
        }
        int index=Math.max(pageUrl.lastIndexOf("/"),pageUrl.lastIndexOf("\\"));
        return pageUrl.substring(0,index);
    }

    private String checkUrl(String link, String baseUrl){
        if (link.startsWith("http://")||link.startsWith("https")||link.startsWith("ftp://")){
            return link;
        }
        if (link.startsWith("/")||link.startsWith("\\")||link.startsWith("?")){
            return baseUrl.substring(0,baseUrl.length()-1).concat(link);
        }else {
            return baseUrl.concat(link);
        }
    }

    private StringBuffer loadPage(String pageUrl) throws MalformedURLException,IOException{
        URLConnection c=new URL(pageUrl).openConnection();
        //i want to work with google search, and i doing following things
        c.setRequestProperty("Accept","application/xml,application/xhtml+xml,text/html;" +
                "q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        c.setRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US");
        //we working only with text and html pages
        if (!c.getContentType().startsWith("text/plain")&&
                !c.getContentType().startsWith("text/html")){
            return null;
        }
        System.out.println("Start working with "+pageUrl);
        BufferedReader in=new BufferedReader(new InputStreamReader(c.getInputStream(),"UTF-8"));
        StringBuffer content=new StringBuffer();
        String string;
        while ((string=in.readLine())!=null){
            content.append(string);
        }
        return content;
    }

    private void doIndexingWords(StringBuffer content){
        //words indexing, calculate hashes and other manipulations with page content
    }

    @Override
    public void run() {
        try{
            StringBuffer content=loadPage(pageUrl);
            if (content==null){
                return;
            }
            doIndexingWords(content);
            Pattern p=Pattern.compile("href=\\\"(.*?)\\\"",Pattern.CASE_INSENSITIVE);
            Matcher m=p.matcher(content);
            String baseUrl=getBaseUrl(pageUrl);
            while (m.find()){
                String link=m.group();
                link=checkUrl(link.substring("href=\"".length(),link.length()-1),baseUrl);
                //if page already proccessed, do not start new task
                if (!map.containsKey(link)){
                    executor.execute(new WebWorker(link,executor,map));
                }
            }
            map.put(pageUrl,0);
            System.out.println("Pages proccessed "+map.size());
        }catch (Exception e){
            return;
        }
    }

    public static void main(String[] args) {
        int corePoolSize=1000;
        int maxPoolSize=5000;
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                corePoolSize,maxPoolSize,
                5,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>()
        );
        executor.execute(new WebWorker("http://www.google.com/#q=ABC",executor,new HashMap<String, Integer>()));
    }
}