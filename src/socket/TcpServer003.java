package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by M.E.R.lin on 09.12.2015.
 */
public class TcpServer003 {
    //задаем порт серверу
    private static final int DEFAULT_PORT=9999;
    //main
    public static void main(String[] args) {
        //если аргументы отсутствуют, порт принимае значение по умолчанию
        int port=DEFAULT_PORT;
        if (args.length>0){
            port=Integer.parseInt(args[0]);
        }
        //создаем серверный сокет на полученном порту
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(port);
        }
        catch (IOException e) {
            System.out.println("Порт занят: "+port);
            System.exit(-1);
        }
        /*если порт свободен и сокет был успешно создан,
        * можно переходить к следующему шагу - ожиданию клиента
        * */
        Socket clientSocket=null;
        try{
            clientSocket=serverSocket.accept();
        }catch (IOException e){
            System.out.println("Ошибка при подключении к порту: "+port);
            System.exit(-1);
        }
        /*
        * Теперь можно получить поток ввода, в который помещаются
        * сообщения от клиента
        * */
        InputStream inputStream=null;
        try{
            inputStream=clientSocket.getInputStream();
        }catch (IOException e){
            System.out.println("Не удалось получить поток ввода.");
            System.exit(-1);
        }
        /*
        * В этой реализации сервер будет без конца читать поток и выводить
        * его содержимое на консоль
        * */
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        String line=null;
        try{
            while ((line=reader.readLine())!=null){
                System.out.println(line);
                System.out.flush();
            }
        }catch (IOException e){
            System.out.println("Ошибка при чтении сообщения.");
            System.exit(-1);
        }
    }
}
