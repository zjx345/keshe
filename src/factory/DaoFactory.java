package factory;
import java.io.File;
import java.sql.Connection;

import dao.IAdminDao;
import dao.IStudentDao;
import dao.impl.AdminDaoImpl;
import dao.impl.StudentDaoImpl;

/**
 * ������Ϊһ���������󹤳��࣬����ʵ����һЩ����������
 * @author zjx
 *
 */
public class DaoFactory {
	/**
	 * ȡ���û��������ݿ���
	 * @param conn �ò���Ϊ����һ�����ݿ����Ӷ���
	 * @return �����û����������
	 */
	public static IStudentDao getIStudentDaoInstance(Connection conn) {
		return new StudentDaoImpl(conn);
	}
	/**
	 * ȡ���û������ļ���
	 * @param conn �ò���Ϊ����һ���ļ�����
	 * @return ����ѧ�����������
	 */
	public static IStudentDao getIStudentDaoInstance(File file) {
		return new StudentDaoImpl(file);
	}
	/**
	 * ȡ������Ա�������ݿ���
	 * @param conn �ò���Ϊ����һ�����ݿ����Ӷ���
	 * @return ���ع���Ա���������
	 */
	public static IAdminDao getIAdminDaoInstance(Connection conn) {
		return new AdminDaoImpl(conn);
	}
	/**
	 * ȡ������Ա�����ļ���
	 * @param conn �ò���Ϊ����һ���ļ�����
	 * @return ���ع���Ա���������
	 */
	public static IAdminDao getIAdminDaoInstance(File file) {
		return new AdminDaoImpl(file);
	}
}
