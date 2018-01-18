package NetModules.SocketDemo;

import java.io.IOException;
import java.net.*;

/**
 * @classDesc： 功能描述：（UDP客户端发送数据到服务器端）
 * @author：王武
 * @createTime 2018/1/15
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("udp 客户端发送数据。。。");
        DatagramSocket ds = new DatagramSocket();
        String str = "客户端发送数据。。。";
        byte[] strByte = str.getBytes();
        DatagramPacket dp = new DatagramPacket(strByte, strByte.length, InetAddress.getByName("192.168.2.111"), 8080);
        ds.send(dp);
        ds.close();
    }
}
