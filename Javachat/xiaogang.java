package day2021_2_19Java聊天室;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class xiaogang {



    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        ServerSocket ss = null;
        try {

            ss = new ServerSocket(1250);
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
            System.out.println(baos.toString());

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            baos.close();
            is.close();
            socket.close();
        }
    }
}
