package factory;
import service.IAdminService;
import service.IStudentService;
import service.impl.AdminServiceImpl;
import service.impl.StudentServiceImpl;
/**
 * ����Ϊҵ�񹤳��࣬����ʵ����һЩҵ����
 * @author zjx
 *
 */
public class ServiceFactory {
	/**
	 * ����ʵ�����û�ҵ����
	 * @return �����û�ҵ�������
	 */
	public static IStudentService getIStudentServiceInstance() {
		return new StudentServiceImpl();
	}
	/**
	 * ����ʵ��������Աҵ����
	 * @return ���ع���Աҵ�������
	 */
	public static IAdminService getIAdminServiceInstance() {
		return new AdminServiceImpl();
	}
}
