package tool;
import java.io.IOException;
/**
 * ����Ϊ��exe�ļ�������
 * @author zjx
 *
 */
public class OpenExeTool{
	/**
	 * �÷���Ϊ��exe�ļ��ľ�̬����
	 * @param path Ҫ���ļ���·��
	 */
	public static void openExe(String path) {
		Runtime r=Runtime.getRuntime();
		Process p=null;
		try {
			p=r.exec("D:\\QQӰ��\\QQPlayer.exe "+path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
