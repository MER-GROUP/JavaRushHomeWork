package socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by M.E.R.lin on 11.12.2015.
 */
public class HttpServer005 {
    public static void main(String[] args) throws Throwable {
        ServerSocket serverSocket=new ServerSocket(8080);
        while (true){
            System.out.println("Server started");
            Socket socket=serverSocket.accept();
            System.out.println("Client accepted");
            new Thread(new SocketProcessor(socket)).start();
        }
    }

    private static class SocketProcessor implements Runnable{
        private Socket socket;
        private InputStream inputStream;
        private OutputStream outputStream;

        public SocketProcessor(Socket socket) throws Throwable {
            this.socket = socket;
            this.inputStream=socket.getInputStream();
            this.outputStream=socket.getOutputStream();
        }

        private void ReadInputHeaders() throws Throwable{
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            while (true){
                String stringMessage=bufferedReader.readLine();
                System.out.println("stringMessage = "+stringMessage);
                if (stringMessage==null || stringMessage.trim().length()==0){
                    break;
                }
            }
        }

        private void WriteResponse(String stringMessage) throws Throwable{
            String stringResponse="HTTP/1.1 200 OK\r\n"+
                                    "Server : MaxRamanenkaServer/2015-11-15\r\n"+
                                    "Content-Type : text/html\r\n"+
                                    "Content-Length : "+stringMessage.length()+"\r\n"+
                                    "Connection : close\r\n\r\n";
            String stringResult=stringResponse+" "+stringMessage;
            outputStream.write(stringResult.getBytes());
            outputStream.flush();
        }

        @Override
        public void run() {
            try{
                ReadInputHeaders();
                WriteResponse("<html><body><h1>Hello from Max Ramanenka</h1></body></html>");
            }catch (Throwable t){
                //do nothing
            }finally {
                try{
                    socket.close();
                }catch (Throwable t){
                    //do nothing
                }
            }
            System.err.println("Client processing finished");
        }
    }
}
