package day2021_2_19Java聊天室;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        ServerSocket ss = null;
        ServerSocket ss1 = null;
        List<String> list = new ArrayList<String>();
        OutputStream os = null;
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
            list.add(new String(String.valueOf(baos)));
            //将服务器发过来的信息存到list中
            System.out.println(list);
            //将list输出


//            //发送
//
            socket = new Socket(socket.getInetAddress().getHostName(),1250);
            os = socket.getOutputStream();
            os.write(new String(String.valueOf(baos)).getBytes());


        } catch (IOException e){
            e.printStackTrace();
        } finally {
            baos.close();
            is.close();
            socket.close();
            ss.close();
        }
    }

}
