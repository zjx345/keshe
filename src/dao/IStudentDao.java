package dao;

import java.util.ArrayList;

import vo.Course;
import vo.Courseware;
import vo.Student;
import vo.Video;

/**
 * �ýӿڶ�����һЩѧ���������ݿ�ķ���
 * @author zjx
 *
 */

public interface IStudentDao {
	/**
	 * ѧ���޸��ļ��е�����
	 * @param stu ��Ҫ�޸������ѧ��
	 * @param newPassword ��Ҫ�޸ĵ�������
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 * @throws Exception
	 */
	public boolean doUpdatePassword(Student stu,String newPassword)throws Exception;
	/**
	 * ѧ���������ݵ��ļ�
	 * @param stu Ҫ���������
	 * @return ����һ��booleanֵ�������Ƿ����ɹ�
	 * @throws Exception
	 */
	public boolean doInsert(Student stu)throws Exception;
	/**
	 * �ж�ѧ���Ƿ����ļ��д���
	 * @param stu Ҫ�жϵ�ѧ��
	 * @return ������ڣ�����true�����򷵻�false
	 * @throws Exception
	 */
	public boolean isExist(Student stu)throws Exception;
	/**
	 * �жϿγ��Ƿ������ݿ��д���
	 * @param cname Ҫ�жϵĿγ�
	 * @return ������ڣ�����true�����򷵻�false
	 * @throws Exception
	 */
	public boolean isExist(String cname)throws Exception;
	/**
	 * ѧ�����ݿγ������ҿγ�
	 * @param cname Ҫ���ҵĿγ���
	 * @return ���ز��ҵĿγ̶���
	 * @throws Exception
	 */
	public Course findCourse(String cname)throws Exception;
	/**
	 * �÷��������������еĿμ�
	 * @param cid Ҫ���ҵĿγ̺�
	 * @return ����һ���μ�����
	 * @throws Exception
	 */
	public ArrayList<Courseware> findAllCourseware(String cid)throws Exception;
	/**
	 * �÷��������������е���Ƶ
	 * @param cid Ҫ���ҵĿγ̺�
	 * @return ����һ����Ƶ����
	 * @throws Exception
	 */
	public ArrayList<Video> findAllVideo(String cid) throws Exception;
}
