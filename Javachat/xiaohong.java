package day2021_2_19Java聊天室;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class xiaohong {
    //send
    private InetAddress inet;
    private Socket socket;
    private OutputStream os;
    //get
    private   InputStream is;
    private ByteArrayOutputStream baos;
    private ServerSocket ss;
    public void send() throws IOException {
        try {
            inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,1249);
            os = socket.getOutputStream();
            //转换成输出流
            os.write("你好，我是小红".getBytes());


        } catch (IOException e){
            e.printStackTrace();
        } finally {
            os.close();
            socket.close();
        }
    }
    public void get() throws IOException {
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
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        xiaohong xh = new xiaohong();
        xh.send();
        xh.get();
    }

}
