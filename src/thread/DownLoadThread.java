package thread;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
/**
 * ����Ϊ�����߳���
 * @author Lenovo
 *
 */
public class DownLoadThread implements Runnable {
	
	// Ŀ���ļ�
	private RandomAccessFile raFile;
	// ������Դ����
	private HttpURLConnection conn;
	// ÿ���߳����صĴ�С
	private int threadSize;
	
	/**
	 * �÷���Ϊ��ȫ�������Ĺ��췽��
	 * @param raFile д����ļ�
	 * @param conn ��������
	 * @param threadSize ÿ���߳���Ҫ���صĴ�С
	 */
	public DownLoadThread(RandomAccessFile raFile, HttpURLConnection conn, int threadSize) {
		this.raFile = raFile;
		this.conn = conn;
		this.threadSize = threadSize;
	}


	@Override
	public void run() {
		try {
			// ��װ����Դ
			BufferedInputStream bis=new BufferedInputStream(conn.getInputStream());
			
			// ��¼��д���ݴ�С
			int readedSize=0;
			
			// ��д����
			byte[] by=new byte[1024];
			int len=0;
			while((len=bis.read(by))!=-1 && readedSize<threadSize) {
				raFile.write(by,0,len);
				readedSize+=len;
			}
			
			// �ͷ���Դ
			raFile.close();
			bis.close();
			conn.disconnect();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
