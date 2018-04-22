/**
 * 
 */
package Nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/**
 * @author ����
 * @website:www.cowfish.net
 * @QQ:834667820
 */
public class Test03 {
	//��ֱ�ӻ��������----276--281--289
	@Test
	public void test002() throws IOException{
		long startTime = System.currentTimeMillis();
		FileChannel inChannel = FileChannel.open(Paths.get("d://��������.mp4"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("d://��������copy.mp4"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		//����ӳ���ļ�
		MappedByteBuffer inMappedByte = inChannel.map(MapMode.READ_ONLY,0, inChannel.size());
		MappedByteBuffer outMappedByte = outChannel.map(MapMode.READ_WRITE,0, inChannel.size());
        //ֱ�ӶԻ���������
		byte[] bytes = new byte[inMappedByte.limit()];
		inMappedByte.get(bytes);
		outMappedByte.put(bytes);
		inChannel.close();
		outChannel.close();
		long endTime = System.currentTimeMillis();
		
		System.out.println("����ֱ�ӻ��������"+"--"+(endTime-startTime));
	}
    //������ֱ�ӻ��������--2534--1975--1915
	@Test
	public void test001() throws IOException{
		long startTime = System.currentTimeMillis();
		//������
		FileInputStream fis = new FileInputStream("d://��������.mp4");
		//д����
		FileOutputStream fos = new FileOutputStream("d://��������copy.mp4");
		//����ͨ��
		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();
		//����ָ����С������
		ByteBuffer buf = ByteBuffer.allocate(1024);
		while (inChannel.read(buf)!=-1) {
			//������ȡģʽ
			buf.flip();
			//������д��ͨ����
			outChannel.write(buf);
			buf.clear();
		}
		//�ر�ͨ�����ر�����
		inChannel.close();
		outChannel.close();
		fis.close();
		fos.close();
		long endTime = System.currentTimeMillis();
		System.out.println("������ֱ�ӻ��������"+"--"+(endTime-startTime));
	}
	//��򵥵��ֽ������� �򵥵�io�������byte[1024]--2005--1716--2058
	@Test
	public void test003() throws IOException{
		long startTime = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("d://��������.mp4");
		FileOutputStream fos = new FileOutputStream("d://��������copy.mp4");
		try {
			
			byte[] bytes =	new byte[1024];
			int read = 0;
			while ((read=fis.read(bytes))!=-1) {
				fos.write(bytes,0,read);
			}
			fos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			fos.close();
			fis.close();
			long endTime = System.currentTimeMillis();
			System.out.println("�򵥵�io�������"+"--"+(endTime-startTime));
		}
	
		
	}

}
