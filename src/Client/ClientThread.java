//package Client;
//
//import java.awt.*;
//import java.io.*;
//import java.net.Socket;
//import java.text.DecimalFormat;
//import java.util.StringTokenizer;
//import java.util.Vector;
//
//import static java.lang.System.out;
//
//public class ClientThread implements Runnable{
//
//    Socket socket;
//    DataInputStream dis;
//   DataOutputStream dos;
//    MainScreen main;
//    StringTokenizer st;
//    protected DecimalFormat df = new DecimalFormat("##,#00");
//
//    public ClientThread(Socket socket, MainScreen main){
//        this.main = main;
//        this.socket = socket;
//        try {
//            dis = new DataInputStream(socket.getInputStream());
//            dos=new DataOutputStream(socket.getOutputStream());
//        } catch (IOException e) {
//           // main.appendMessage("[IOException]: "+ e.getMessage(), "Lỗi", Color.RED, Color.RED);
//        }
//    }
//    public ClientThread(){
//
//    }
//
//
//
//
//    @Override
//    public void run() {
//        try {
//            while(!Thread.currentThread().isInterrupted()){
//                String data = dis.readUTF();
//                st = new StringTokenizer(data);
//                /** Get Message CMD **/
//                String CMD = st.nextToken();
//                switch(CMD){
//                    case "CMD_MESSAGE" -> {
//                        // SoundEffect.MessageReceive.play(); //  Play Audio clip
//                        String msg = "";
//                        String frm = st.nextToken();
//                        while(st.hasMoreTokens()){
//                            msg = msg +" "+ st.nextToken();
//                        }
//                        main.appendMessage(msg, frm, Color.MAGENTA, Color.BLUE);
//                    }
//
//                    case "CMD_ONLINE" -> {
//                        Vector online = new Vector();
//                        while(st.hasMoreTokens()){
//                            String list = st.nextToken();
//                            if(!list.equalsIgnoreCase(main.username)){
//                                online.add(list);
//                            }
//                        }
//                        main.appendOnlineList(online);
//                    }
//
//                    default -> main.appendMessage("[CMDException]: Không rõ lệnh "+ CMD, "CMDException", Color.RED, Color.RED);
//                }
//            }
//        } catch(IOException e){
//            main.appendMessage(" Bị mất kết nối đến Máy chũ, vui lòng thử lại.!", "Lỗi", Color.RED, Color.RED);
//        }
//    }
//    public void sendFile(String file){
//        try {
//            byte[] buffer = new byte[1024];
//            InputStream in = new FileInputStream(file);
//            dos = new DataOutputStream(socket.getOutputStream());
//
//            int count;
//            while ((count = in.read(buffer)) > 0) {
//                out.write(buffer, 0, count);
//            }
//        }catch (IOException e){
//
//        }
//
////        in.close();
////        out.flush();
//    }
//}