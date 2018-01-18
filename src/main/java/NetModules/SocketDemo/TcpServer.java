
package NetModules.SocketDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @classDesc: 功能描述:(scoekt服务器端)
 * @author: 余胜军
 * @createTime: 2017年8月27日 下午12:30:33
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class TcpServer {

	 public static void main(String[] args) throws IOException {
		System.out.println("socket服务器端启动....");
		ServerSocket serverSocket = new ServerSocket(8080);
	    //获取客户端对象
		Socket accept = serverSocket.accept();
		InputStream inputStream = accept.getInputStream();
		byte[] buf= new byte[1024];
		int len=inputStream.read(buf);
		String str =new String(buf,0,len);
		System.out.println("str:"+str);
		serverSocket.close();
	}
	
}
