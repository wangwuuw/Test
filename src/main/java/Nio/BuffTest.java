package Nio;

import org.junit.Test;

import java.nio.ByteBuffer;


/**
 * 
 * @author ����
 * @website:www.cowfish.net
 * @QQ:834667820
 */
public class BuffTest {
   @Test
	public void test01(){
	   //��ʼ��byteBuffer��С
	   /**
	        private int position = 0;<br>���������ڲ�����λ�� Ĭ�ϴ�0��ʼ
	        private int limit;<br> ����(���������ô�С)
	        private int capacity;<br>�������������,һ���������ܸı�
	        ���ķ���:
	        put() ��buff�������
	        get() ��ȡ����
	    */
	   try {
		   ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		   System.out.println(byteBuffer.position());
		   System.out.println(byteBuffer.limit());
		   System.out.println(byteBuffer.capacity());
		   System.out.println("---------------------");
		   System.out.println("��bytebuff�������");
		   byteBuffer.put("abcd1".getBytes());
		   System.out.println(byteBuffer.position());
		   System.out.println(byteBuffer.limit());
		   System.out.println(byteBuffer.capacity());
		   System.out.println("-----��ȡֵ...-------");
		   //������ȡģʽ
		   byteBuffer.rewind();
		   System.out.println(byteBuffer.position());
		   System.out.println(byteBuffer.limit());
		   System.out.println(byteBuffer.capacity());
		   byte[] bytes =   new byte[byteBuffer.limit()];
		   byteBuffer.get(bytes);
		   System.out.println(new String(bytes,0,bytes.length));
		   //�ظ���ȡ
		   byteBuffer.rewind();
		   System.out.println("-------�ظ���ȡ-------");
		   System.out.println(byteBuffer.position());
		   System.out.println(byteBuffer.limit());
		   System.out.println(byteBuffer.capacity());
		   byte[] bytes2 =   new byte[byteBuffer.limit()];
		   byteBuffer.get(bytes);
		   System.out.println(new String(bytes2,0,bytes2.length));
		    //��ջ��������ݱ�����
		   System.out.println("------��ջ�����------");
		   byteBuffer.clear();
		   System.out.println("position:"+byteBuffer.position());
		   System.out.println(byteBuffer.limit());
		   System.out.println(byteBuffer.capacity());
		   System.out.println((char)byteBuffer.get());
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
   }
   @Test
  	public void test02(){
  	   System.out.println("test002");
     }
   @Test
   //���Ի������ͺ��������ʹ�ֵ����
   public void test03(){
	   StringBuffer s =new StringBuffer("hello");
	   stringAdd(s);
	   System.out.println(s);
   }
   public static void stringAdd(StringBuffer s){
	 s =  s.append("world");
   }
}
