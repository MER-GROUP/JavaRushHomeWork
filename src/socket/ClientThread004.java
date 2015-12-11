package socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by M.E.R.lin on 11.12.2015.
 */
public class ClientThread004 implements Runnable {
    Socket socket;
    private boolean shutdown=false;
    private InputStreamReader inputStreamReader;
    private OutputStreamWriter outputStreamWriter;
    private Scanner scanner;
    private String stringMessage;
    private PrintWriter printWriter;

    public ClientThread004(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (socket!=null){
            try{
                inputStreamReader=new InputStreamReader(socket.getInputStream(),"UTF8");
                outputStreamWriter=new OutputStreamWriter(socket.getOutputStream(),"UTF8");
                scanner=new Scanner(inputStreamReader);
                printWriter=new PrintWriter(outputStreamWriter);
                printWriter.println("Welcom!");
                while (!shutdown && scanner.hasNextLine()){
                    stringMessage=scanner.nextLine();
                    ControlServer004.controlServer004.SendAll(stringMessage);
                    System.out.println(stringMessage);
                }
            }catch (IOException e){
                System.out.println("Error initialization clients streams : "+e.getMessage());
            }finally {
                try{
                    inputStreamReader.close();
                    shutdown=true;
                    socket.close();
                    socket=null;
                    ControlServer004.controlServer004.ShutdownClient(this);
                    System.out.println("Client disconnect");
                }catch (IOException e){
                    System.out.println("Client thread error : "+e.getMessage());
                }
            }
        }
    }

    public void Send(String stringMessage){
        printWriter.println(stringMessage);
    }
}
