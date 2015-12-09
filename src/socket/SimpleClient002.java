package socket;

import java.net.Socket;

/**
 * Created by M.E.R.lin on 09.12.2015.
 */
public class SimpleClient002 extends Thread {
    public static void main(String[] args) {
        try{
            //открываем сокет и коннектимся к localhost:3128
            //получаем сокет сервера
            Socket socket=new Socket("localhost",3128);
            //берем поток вывода и выводим туда первый аргумент
            //заданный при вызове, адресс открытого сокета и его порт
            args[0]=args[0]+"\n"+socket.getInetAddress().getHostAddress()+
                    ":"+socket.getLocalPort();
            socket.getOutputStream().write(args[0].getBytes());
            //читаем ответ
            byte[] buf=new byte[64*1024];
            int r=socket.getInputStream().read(buf);
            String data=new String(buf,0,r);
            //выводим ответ в консоль
            System.out.println(data);
        }catch (Exception e){
            System.out.println("init error : "+e);
        }
    }
}
