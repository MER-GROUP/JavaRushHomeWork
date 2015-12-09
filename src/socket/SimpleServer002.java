package socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by M.E.R.lin on 09.12.2015.
 */
public class SimpleServer002 extends Thread {
    Socket socket;
    int num;

    public SimpleServer002(int i, Socket socket) {
        //копиреум данные
        this.num=i;
        this.socket=socket;
        //и запускаем новый вычислительный поток, смотри функцию run()
        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    @Override
    public void run() {
        try{
            //из сокета клиента берем поток входящих данных
            InputStream inputStream=socket.getInputStream();
            //и оттуда же - поток данных от сервера к клиенту
            OutputStream outputStream=socket.getOutputStream();
            //буфер данных в 64 килобайта
            byte[] buf=new byte[64*1024];
            //читаем 64кб от клиента, результат - количество реально принятых данных
            int r=inputStream.read(buf);
            //создаем строку, содержащую полученную от клиента информацию
            String data=new String(buf,0,r);
            //добавляем данные об адресе сокета
            data=""+num+": "+"\n"+data;
            //выводим данные (отправляем назад клиенту)
            outputStream.write(data.getBytes());
            //завершаем соединение
            socket.close();
        }catch (Exception e){
            //вывод исключений
            System.out.println("init error : "+e);
        }
    }

    public static void main(String[] args) {
        try{
            //счетчик подключений
            int i=0;
            //привинтить сокет на локалхост, порт 3128
            ServerSocket serverSocket=new ServerSocket(3128,0, InetAddress.getByName("localhost"));
            System.out.println("server is started");
            //слушаем порт
            while (true){
                //ждем нового подключения, после чего запускаем обработку клиента
                //в новый вычислительный поток и увеличиваем счетчик на единичку
                new SimpleServer002(i,serverSocket.accept());
                i++;
            }
        }catch (Exception e){
            //вывод исключений
            System.out.println("init error : "+e);
        }
    }
}
