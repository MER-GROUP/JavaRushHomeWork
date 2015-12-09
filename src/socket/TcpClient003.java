package socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by M.E.R.lin on 09.12.2015.
 */
public class TcpClient003 {
    private static final String DEFAULT_HOST="localhost";
    private static final int DEFAULT_PORT=9999;
    /*
    * main
    * */
    public static void main(String[] args) {
        /*
        * определяем хост сервера и порт
        * */
        String host=DEFAULT_HOST;
        int port=DEFAULT_PORT;
        if (args.length>0){
            host=args[0];
        }
        if (args.length>1){
            port=Integer.parseInt(args[1]);
        }
        /*
        * создаем сокет для полученной пары хост/порт
        * */
        Socket socket=null;
        try {
            socket=new Socket(host,port);
        }catch (UnknownHostException e){
            System.out.println("Неизвестный хост: "+host);
            System.exit(-1);
        }catch (IOException e){
            System.out.println("Ошибка ввода/вывода при создании сокета "+host+":"+port);
            System.exit(-1);
        }
        /*
        * Для удобства обернем стандартный поток ввода в BufferedReader
        * */
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        /*
        * Получаем поток вывода, через который будут передаваться сообщения
        * серверу
        * */
        OutputStream outputStream=null;
        try{
            outputStream=socket.getOutputStream();
        }catch (IOException e){
            System.out.println("Не удалось получить поток вывода.");
            System.exit(-1);
        }
        /*
        * Все вводимые пользователем сообщения будем транслировать
        * в поток вывода созданного сокета
        * */
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream));
        String line=null;
        try{
            while ((line=reader.readLine())!=null){
                writer.write(line+"\n");
                writer.flush();
            }
        }catch (IOException e){
            System.out.println("Ошибка при записи сооъбщения.");
            System.exit(-1);
        }
    }
}
