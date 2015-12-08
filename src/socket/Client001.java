package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by M.E.R.lin on 08.12.2015.
 */
public class Client001 {
    public static void main(String[] args) {
        //здесь обязательно нужно указать порт к которому привязывается сервер
        int serverPort=6666;
        //это IP-адрес компьюрета, где исполняется наша серверная программа,
        //здесь указан адрес того самого компьютера где будет исполняться и клиент
        String address="127.0.0.1";
        try{
            //создаем объект который отображает вышеописанный IP-адрес
            InetAddress ipAddress=InetAddress.getByName(address);
            System.out.println("Any of you heard of a socket with IP address "+address+
                                " and port "+serverPort+"?");
            //создаем сокет (туда куда хотим подключиться)
            //используя IP-адрес и порт сервера
            Socket socket=new Socket(ipAddress,serverPort);
            System.out.println("Yes! I just got hold of the program.");
            //берем входной и выходной потоки сокета, теперь можем
            //получать и отсылать данные клиентом
            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();
            //конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения
            DataInputStream dataInputStream=new DataInputStream(inputStream);
            DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
            //создаем поток для чтения с клавиатуры
            BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
            String line=null;
            System.out.println("Type in something and press enter. Will sent it to the" +
                    " server and tell you what it thinks.");
            System.out.println();
            while (true){
                //ждем пока пользователь введет что-то и нажмет кнопку Enter
                line=keyboard.readLine();
                System.out.println("Sending this line to the server...");
                //отсылаем введенную строку текста серверу
                dataOutputStream.writeUTF(line);
                //заставляем поток закончить передачу данных
                dataOutputStream.flush();
                //ждем пока сервер отошлет строку текста
                line=dataInputStream.readUTF();
                System.out.println("The server was very polite. It sent me this : "+line);
                System.out.println("Looks like the server is pleased with us. " +
                        "Go ahead and enter more lines.");
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
