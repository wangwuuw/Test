package NetModules.SocketDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @classDesc： 功能描述：（UDP连接服务器）
 * @author：王武
 * @createTime 2018/1/15
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class UDPServer {
    public static void main(String[] args) throws Exception{
        System.out.println("udp 服务器端启动。。。。。。");
        int port=8080;
       DatagramSocket ds = new DatagramSocket(port);
       byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf,buf.length);
        //等待客户端进行发送内容，如果客户端不发送内容，一直等待，阻塞的效果
        ds.receive(dp);
        String str =new String(dp.getData(),0,dp.getLength());
        System.out.println("客户端发送的数据是："+str);
        ds.close();
    }
}
