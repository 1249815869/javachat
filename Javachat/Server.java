package day2021_2_19Java聊天室;

import day2020_8_13集合.Person;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    class User{
        private String admin;
        private String duankou;
        private String ip;


    }
    private HashMap<String, User> user= new HashMap<>();

    //记录在线用户
    public static void admin() throws IOException {
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        ServerSocket ss = null;
        List<String> chatmessage = new ArrayList<String>();
        try {
            //接收
            ss = new ServerSocket(1249);
            //创建绑定特定端口的套接字
            socket = ss.accept();
            //监听并接受此套接字的连接



            is = socket.getInputStream();
            //返回此套接字的输入流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            chatmessage.add(new String(String.valueOf(baos)));
            //将服务器发过来的信息存到list中

            System.out.println("一个用户已连接，共"+chatmessage.size()+"个在线用户为：");

            System.out.println(chatmessage);
            //将list输出

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            baos.close();
            is.close();
            socket.close();
        }
    }

    //接收信息
    public static void get() throws IOException {
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        ServerSocket ss = null;
        List<String> chatmessage = new ArrayList<String>();
        try {
            //接收
            ss = new ServerSocket(1249);
            //创建绑定特定端口的套接字
            socket = ss.accept();
            //监听并接受此套接字的连接

            System.out.println("客户端已连接IP地址为："+socket.getInetAddress().getHostName());

            is = socket.getInputStream();
            //返回此套接字的输入流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            chatmessage.add(new String(String.valueOf(baos)));
            //将服务器发过来的信息存到list中
            System.out.println(chatmessage);
            //将list输出
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            baos.close();
            is.close();
            socket.close();
        }
    }

    //发送信息
    public static void send() throws IOException {
        Socket socket = null;

        ByteArrayOutputStream baos = null;
        ServerSocket ss = null;
        OutputStream os = null;
        try {
//            //发送
            socket = new Socket(socket.getInetAddress().getHostName(),1250);
            os = socket.getOutputStream();
            os.write(new String(String.valueOf(baos)).getBytes());

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            ss.close();
        }
    }

    public static void main(String[] args) throws IOException {
       Server server = new Server();
       //server.get();
       //server.send();

        server.admin();
//        while (true){
//            server.admin();
//        }
    }

}
