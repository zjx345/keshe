package tool;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import thread.DownLoadThread;
/**
 * ����Ϊ�����ļ�������
 * @author zjx
 *
 */
public class DownLoadTool {
	
	// �߳�����
	private static final int ThreadCount=4;
	/**
	 * �÷���Ϊ�����ļ��ľ�̬����
	 * @param path Ҫ���ص��ļ�·��
	 * @return ����һ��booleanֵ�������Ƿ����سɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public static boolean downLoadRrsource(String path) throws Exception {
		/*try {
			// String boundary = "*****";
			int startPosition=0;
			// ����·������URL����
			URL url=new URL(path);
			// ������
			
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			 conn.setRequestMethod("GET");
			conn.setConnectTimeout(6000);
			conn.setRequestProperty("Range",  "bystes="+startPosition+"-");
			// conn.setRequestProperty("Connection", "Keep-Alive");
			// sconn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// ��ȡ������Դ�Ĵ�С
			int fileSize=conn.getContentLength();
			System.out.println(fileSize);
			// ��ȡÿ���߳���Ҫ��������ݴ�С
			int threadSize=fileSize/ThreadCount+1;
			
			// ��ȡ������Դ���ļ���
			String  fileName=path.substring(path.lastIndexOf("/")+1);
			// ������������ļ�����
			RandomAccessFile raFile=new RandomAccessFile("E:/DownLoad/"+fileName, "rw");
			// �����ļ��Ĵ�С
			raFile.setLength(fileSize);
			
			// ѭ�����������߳�
			for(int i=1;i<=ThreadCount;i++) {
				startPosition=(i-1)*threadSize;
				raFile.seek(startPosition);
				new Thread(new DownLoadThread(raFile,conn,threadSize)).start();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		CloseableHttpClient httpClient = null;
        InputStream inputStream = null;
        File file = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpGet method = new HttpGet(path);
            // ִ�����󣬵õ�һ��response
            HttpResponse result = httpClient.execute(method);
            inputStream = result.getEntity().getContent();
            // System.out.println(result.getAllHeaders().toString());
            //�õ�ͼƬ�Ķ��������ݣ��Զ����Ʒ�װ�õ����ݣ�����ͨ����
            byte[] data = readInputStream(inputStream);
            //newһ���ļ�������������ͼƬ��Ĭ�ϱ��浱ǰ���̸�Ŀ¼
            String  fileName=path.substring(path.lastIndexOf("/")+1);
            File newFile = new File("E:/download/"+fileName);
            
            //���������
            FileOutputStream outStream = new FileOutputStream(newFile);
            //д������
            outStream.write(data);
            //�ر������
            outStream.close();
        } catch (IOException e) {
        	return false;
		}
		return true; 
    }
	/**
	 * �÷���Ϊ��д�ļ��ľ�̬����
	 * @param inStream �ֽ�������
	 * @return ����һ�������ֽ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //����һ��Buffer�ַ���
        byte[] buffer = new byte[1024];
        //ÿ�ζ�ȡ���ַ������ȣ����Ϊ-1������ȫ����ȡ���
        int len = 0;
        //ʹ��һ����������buffer������ݶ�ȡ����
        while( (len=inStream.read(buffer)) != -1 ){
            //���������buffer��д�����ݣ��м����������ĸ�λ�ÿ�ʼ����len�����ȡ�ĳ���
            outStream.write(buffer, 0, len);
        }
        //�ر�������
        inStream.close();
        //��outStream�������д���ڴ�
        return outStream.toByteArray();
    }

	}

