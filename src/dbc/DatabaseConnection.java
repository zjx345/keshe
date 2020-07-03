package dbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ฺ�����ݿ�������ر�
 * @author zjx
 *
 */
public class DatabaseConnection {
	// Driver���·��
	private static final String DRIVER_PATH="com.mysql.jdbc.Driver";
	
	//private static final String URL="jdbc:mysql://localhost:3306/���߿γ�ѧϰϵͳ?characterEncoding=utf-8&amp;serverTimezone=UTC&amp;useSSL=false";
	// ���ݿ�URL
	private static final String URL="jdbc:mysql://localhost:3306/���߿γ�ѧϰϵͳ?useSSL=false";
	// �û���
	private static final String USER="root";
	// ����
	private static final String PASSWORD="mysql123456";
	// ���Ӷ���
	private Connection conn=null;
	
	/**
	 * �ù��췽������ʵ�������Ӷ���ֱ�Ӹ�ֵ��conn����
	 */
	public DatabaseConnection() {
		try {
			Class.forName(DRIVER_PATH);
			conn=DriverManager.getConnection(URL, USER,PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ȡ��һ�����Ӷ���
	 * @return ����һ��Connection����
	 */
	public Connection getConnection()  {
		return conn;
	}
	
	/**
	 * �ر�����
	 */
	public void close() {
		if(this.conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

