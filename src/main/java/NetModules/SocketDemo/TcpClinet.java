
package NetModules.SocketDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @classDesc: 功能描述:(scoekt客户端 )
 * @author: 余胜军
 * @createTime: 2017年8月27日 下午12:30:33
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class TcpClinet {

	public static void main(String[] args) throws IOException {
		System.out.println("socket启动....");
		Socket s = new Socket("192.168.2.111", 8080);
		OutputStream outputStream = s.getOutputStream();
		outputStream.write("我是客戶端....".getBytes());
		s.close();
	}

}
