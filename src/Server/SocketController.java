package Server;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;

/**
 *
 * @author DucHuy
 */
//import java.util.List;

/**
 *
 * @author DucHuy
 */
class SocketController {

    public int serverPort;
    ServerSocket s;
    public List<Client> connectedClient;
    public List<Room> allRooms;

    public void OpenSocket(int port){
        try{
            Main.mainScreen.appendMessage("[Server]: Máy Chủ hiện đang khởi động ở port "+ port);
            s=new ServerSocket(port);
            connectedClient=new ArrayList<Client>();
            allRooms = new ArrayList<Room>();
            new Thread(() -> {
                try {
                    Main.mainScreen.appendMessage("[Server]: Máy Chủ đã khởi động.!");
                    do {
                        System.out.println("Waiting for client");
                        Socket clientSocket = s.accept();
                        ClientCommunicateThread clientCommunicator = new ClientCommunicateThread(clientSocket);
                        clientCommunicator.start();


                    } while (s != null && !s.isClosed());
                } catch (IOException e) {
                    System.out.println("Server or client socket closed");
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void CloseSocket() {
        try {
            for (Client client : connectedClient)
                client.socket.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getThisIP() {
        String ip = "";
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("google.com", 80));
            ip = socket.getLocalAddress().getHostAddress();
            socket.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return ip;
    }
}
