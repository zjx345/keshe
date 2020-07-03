package service;

import java.util.ArrayList;

import vo.Course;
import vo.Courseware;
import vo.Student;
import vo.Video;

/**
 * �ýӿڶ���Student��ҵ����ִ�б�׼
 * @author zjx
 *
 */
public interface IStudentService {
	/**
	 * �÷��������޸�ѧ������
	 * @param stu ��Ҫ�޸ĵ�ѧ��
	 * @param newPassword ��Ҫ�޸ĵ�������
	 * @return ����һ��boolean�����Ƿ��޸ĳɹ�
	 */
	public boolean updatePassword(Student stu,String newPassword);
	/**
	 * �÷�������ע��
	 * @param stu ��Ҫע���ѧ��
	 * @return ����һ��boolean�����Ƿ�ע��ɹ�
	 */
	public boolean register(Student stu);
	/**
	 * �÷���������½�˺�
	 * @param stu Ҫ��½��ѧ��
	 * @return ����һ��boolean�����Ƿ��½�ɹ�
	 */
	public boolean login(Student stu);
	/**
	 * �÷����������ҿγ�
	 * @param cname Ҫ���ҵĿγ���
	 * @return ���ز��ҵĿγ̶���
	 */
	public Course findCourse(String cname);
	/**
	 * �÷������ݿγ̺Ų������пμ�
	 * @param cid Ҫ���ҵĿγ̺�
	 * @return ����һ���μ����϶���
	 */
	public ArrayList<Courseware> findAllCourseware(String cid);
	/**
	 * �÷����������ؿμ�
	 * @param cpath �μ�·���ַ�������
	 * @return ����һ��booleanֵ�������Ƿ����سɹ�
	 */
	public boolean downloadCourseware(String cpath);
	/**
	 * �÷������ݿγ̺Ų������е���Ƶ
	 * @param cid Ҫ���ҵĿγ̺�
	 * @return ����һ����Ƶ����
	 */
	public ArrayList<Video> findAllVideo(String cid);
	/**
	 * �÷��������ۿ���Ƶ
	 * @param vpath ��Ƶ·���ַ�������
	 */
	public void watchVideo(String vpath);
}
