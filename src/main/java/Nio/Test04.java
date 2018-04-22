/**
 * 
 */
package Nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ����
 * @website:www.cowfish.net
 * @QQ:834667820
 */
public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		//�������
		RandomAccessFile raf = new RandomAccessFile("test.txt","rw");
		//��ȡͨ��
		FileChannel channel = raf.getChannel();
		//����ָ����Сָ��������
		ByteBuffer buf1 = ByteBuffer.allocate(100);
		ByteBuffer buf2 = ByteBuffer.allocate(1024);
		//��ɢ��ȡ
		
	}

}
