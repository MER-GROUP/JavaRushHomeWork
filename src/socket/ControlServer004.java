package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by M.E.R.lin on 11.12.2015.
 */
public class ControlServer004 {
    public boolean shutdown=false;
    public static ControlServer004 controlServer004;
    ArrayList clientList=new ArrayList();

    public ControlServer004() {
        controlServer004=this;
        StartServer();
    }

    private void StartServer() {
        try{
            ServerSocket serverSocket=new ServerSocket(1000);
            System.out.println("Server started");
            System.out.println("Connection wait ...");
            while (!shutdown){
                ClientThread004 clientThread004=new ClientThread004(new Socket("localhost",1000));//
                Socket socket=serverSocket.accept();
                System.out.println("Client connected");
                //ClientThread004 clientThread004=new ClientThread004(socket);
                clientList.add(clientThread004);
                Thread thread=new Thread(clientThread004);
                thread.start();
            }
        }catch (IOException e){
            System.out.println("Server internal error "+e.getMessage());
        }
    }

    public void ShutdownClient(ClientThread004 clientThread004){
        clientList.remove(clientThread004);
    }

    public ClientThread004 getClientThread004(int index){
        return (ClientThread004) clientList.get(index);
    }

    public void SendAll(String message){
        for (int i = 0; i < clientList.size(); i++) {
            getClientThread004(i).Send(message);
        }
    }
}
