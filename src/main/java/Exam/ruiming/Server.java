package Exam.ruiming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        /**
         * 服务端
         */
        try {
            //创建socket链接，端口6000
            ServerSocket server=new ServerSocket(6000);

            //接收客户端消息
            Socket socket=server.accept();
            InputStream inputStream=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String temp=null;
            while((temp=bufferedReader.readLine())!=null){
                if (temp.equals("EXIT")){
                    // 关闭连接
                    bufferedReader.close();
                    inputStream.close();
                }
            }

            //反馈给客户端消息
            OutputStream outputStream=socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(outputStream);
            printWriter.print("Message Raceive");
            printWriter.flush();
            socket.shutdownOutput();

            //关闭资源
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 客户端
         */

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
