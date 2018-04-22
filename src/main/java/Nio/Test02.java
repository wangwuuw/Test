/**
 * 
 */
package Nio;

import java.nio.ByteBuffer;

/**
 * @author ����
 * @website:www.cowfish.net
 * @QQ:834667820
 */
public class Test02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
         ByteBuffer byteBuffer = ByteBuffer.allocate(10);
         String str = "abcd";
         byteBuffer.put(str.getBytes());
         //��������ģʽ
         byteBuffer.flip();
         byte[] bytes =  new byte[byteBuffer.limit()];
         byteBuffer.get(bytes,0,2);
         byteBuffer.mark();
         System.out.println(new String(bytes,0,2));
         System.out.println(byteBuffer.position());
         System.out.println("-----------------------------");
       
         System.out.println(byteBuffer.position());
         byteBuffer.get(bytes,2,2);
         System.out.println(new String(bytes,2,2));
         byteBuffer.reset();
         System.out.println(byteBuffer.position());
	}

}
