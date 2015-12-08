package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by M.E.R.lin on 08.12.2015.
 */
public class Server001 {
    public static void main(String[] args) {
        //случайный порт
        //может быть любое число от 1025 до 65535
        int port=6666;
        try{
            //создаем сокет сервера и привязываем его к вышеуказанному порту
            ServerSocket serverSocket=new ServerSocket(port);
            System.out.println("Waiting for a client ...");
            //заставляем сервер ждать подключений и выводим сообщение
            //когда кто-то связался с сервером
            Socket socket= serverSocket.accept();
            System.out.println("Got a client :) ... Finaly, someone saw me througt all the cover!");
            System.out.println();
            //берем входной и выходной потоки сокета,
            //теперь можем получать и отсылать данные клиенту
            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();
            //конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения
            DataInputStream dataInputStream=new DataInputStream(inputStream);
            DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
            String line=null;
            while (true){
                //ожидаем пока клиент пришлет строку текста
                line=dataInputStream.readUTF();
                System.out.println("The dumb client just sent me this line : "+line);
                System.out.println("I'm sending it back ...");
                //отсылаем клиенту обратно ту самую строку текста
                dataOutputStream.writeUTF(line);
                //заставляем поток закончить передачу данных
                dataOutputStream.flush();
                System.out.println("Waiting for the next line ...");
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
