package Exam.ruiming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象, 关联ip  port
        Socket socket  = new Socket("127.0.0.1",8888);
        //2.键盘输入一个字符串,是准备发送给服务器的信息
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //3.通过socket获取OutputStream流
        OutputStream outputStream = socket.getOutputStream();
        //4.通过outputStream   write(byte[]) 把字符串写出去.
        outputStream.write(str.getBytes());

        ///客户端准备接收服务器的信息

        //5.通过socket 获取inputStream (服务器的信息就在流中)
        InputStream inputStream = socket.getInputStream();
        //6.创建一个byte[]
        byte[] arr = new  byte[1024];
        //8.inputStream 调用read方法
        int len = inputStream.read(arr);
        //9.创建一个字符串,将arr 中的数据转成string
        String message = new String(arr,0,len);
        //10.打印字符串
        System.out.println("来自服务器的信息:   "+message);
        //11.关闭资源
        outputStream.close();
        inputStream.close();
        socket.close();

    }
}
