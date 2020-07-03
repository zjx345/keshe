package service;

import java.util.ArrayList;
import java.util.TreeSet;

import vo.Admin;
import vo.Course;
import vo.Courseware;
import vo.Student;
import vo.Video;

/**
 * �ýӿڶ���Admin��ҵ����ִ�б�׼
 * @author zjx
 *
 */
public interface IAdminService {
	/**
	 * �÷���������½�˺�
	 * @param admin Ҫ��½�Ĺ���Ա
	 * @return ����һ��boolean�����Ƿ��½�ɹ�
	 */
	public boolean login(Admin admin);
	/**
	 * �÷��������޸��Լ�������
	 * @param admin Ҫ�޸�����Ĺ���Ա
	 * @param newPassword �޸ĺ������
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 */
	public boolean updatePassword(Admin admin, String newPassword);
	/**
	 * �÷��������ж�ѧ���Ƿ����
	 * @param stu Ҫ�жϵ�ѧ��
	 * @return ����һ��booleanֵ�������Ƿ����
	 */
	public boolean isExist(Student stu);
	/**
	 * �÷�����������ѧ����Ϣ
	 * @param stu Ҫ���ӵ�ѧ��
	 * @return ����һ��booleanֵ�������Ƿ����ӳɹ�
	 */
	public boolean addStudent(Student stu);
	/**
	 * �÷�������ɾ��ѧ��
	 * @param stu Ҫɾ����ѧ��
	 * @return ����һ��booleanֵ�������Ƿ�ɾ���ɹ�
	 */
	public boolean removeStudent(Student stu);
	/**
	 * �÷��������޸�ѧ��
	 * @param stu �޸�ǰ��ѧ��
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 */
	public boolean updateStudent(Student stu);
	/**
	 * �÷�������ѧ���˺Ż���ѧ������������ѧ��
	 * @param str Ҫ���ҵ�ѧ���˺Ż���ѧ������
	 * @param type 1����ѧ���˺ţ�2����ѧ������
	 * @return ����һ��ѧ�����϶���
	 */
	public TreeSet<Student> searchStudent(String str,int type);
	/**
	 * �÷���������������ѧ��
	 * @return ����һ��ѧ�����϶���
	 */
	public TreeSet<Student> searchAllStudent();
	/**
	 * �÷��������жϿγ��Ƿ����
	 * @param course Ҫ�жϵĿγ�
	 * @return ����һ��booleanֵ�������Ƿ����
	 */
	public boolean isExist(Course course);
	/**
	 * �÷����������ӿγ���Ϣ
	 * @param course Ҫ���ӵĿγ�
	 * @return ����һ��booleanֵ�������Ƿ����ӳɹ�
	 */
	public boolean addCourse(Course course);
	/**
	 * �÷�������ɾ���γ�
	 * @param course Ҫɾ���Ŀγ�
	 * @return ����һ��booleanֵ�������Ƿ�ɾ���ɹ�
	 */
	public boolean removeCourse(Course course);
	/**
	 * �÷��������޸Ŀγ�
	 * @param course Ҫ�޸ĵĿγ�
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 */
	public boolean updateCourse(Course course);
	/**
	 * �÷������ݿγ̺Ż��߿γ��������ҿγ�
	 * @param str Ҫ���ҵĿγ̺Ż��߿γ���
	 * @param type 1����γ̺ţ�2����γ���
	 * @return ����һ���γ̼��϶���
	 */
	public ArrayList<Course> searchCourse(String str,int type);
	/**
	 * �÷��������������пγ�
	 * @return ����һ���γ̼��϶���
	 */
	public ArrayList<Course> searchAllCourse();
	/**
	 * �÷��������жϿμ��Ƿ����
	 * @param courseware Ҫ�жϵĿμ�
	 * @return ����һ��booleanֵ�������Ƿ����
	 */
	public boolean isExist(Courseware courseware);
	/**
	 * �÷����������ӿμ���Ϣ
	 * @param courseware Ҫ���ӵĿμ�
	 * @return ����һ��booleanֵ�������Ƿ����ӳɹ�
	 */
	public boolean addCourseware(Courseware courseware);
	/**
	 * �÷�������ɾ���μ�
	 * @param courseware Ҫɾ���Ŀμ�
	 * @return ����һ��booleanֵ�������Ƿ�ɾ���ɹ�
	 */
	public boolean removeCourseware(Courseware courseware);
	/**
	 * �÷��������޸Ŀμ�
	 * @param courseware Ҫ�޸ĵĿμ�
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 */
	public boolean updateCourseware(Courseware courseware);
	/**
	 * �÷������ݿγ̺š��μ��Ż�μ��������ҿγ�
	 * @param str Ҫ���ҵĿγ̺š��μ��Ż�μ���
	 * @param type 1����γ̺ţ�2����μ��ţ�3����μ���
	 * @return ����һ���μ����϶���
	 */
	public ArrayList<Courseware> searchCourseware(String str,int type);
	/**
	 * �÷��������������пγ�
	 * @return ����һ���γ̼��϶���
	 */
	public ArrayList<Courseware> searchAllCourseware();
	/**
	 * �÷��������ж���Ƶ�Ƿ����
	 * @param video Ҫ�жϵ���Ƶ
	 * @return ����һ��booleanֵ�������Ƿ����
	 */
	public boolean isExist(Video video);
	/**
	 * �÷�������������Ƶ��Ϣ
	 * @param video Ҫ���ӵ���Ƶ
	 * @return ����һ��booleanֵ�������Ƿ����ӳɹ�
	 */
	public boolean addVideo(Video video);
	/**
	 * �÷�������ɾ����Ƶ
	 * @param video Ҫɾ������Ƶ
	 * @return ����һ��booleanֵ�������Ƿ�ɾ���ɹ�
	 */
	public boolean removeVideo(Video video);
	/**
	 * �÷��������޸���Ƶ
	 * @param video Ҫ�޸ĵ���Ƶ
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 */
	public boolean updateVideo(Video video);
	/**
	 * �÷������ݿγ̺š���Ƶ�Ż���Ƶ�������ҿγ�
	 * @param str Ҫ���ҵĿγ̺š���Ƶ�Ż���Ƶ��
	 * @param type 1����γ̺ţ�2������Ƶ�ţ�3������Ƶ��
	 * @return ����һ����Ƶ���϶���
	 */
	public ArrayList<Video> searchVideo(String str,int type);
	/**
	 * �÷�����������������Ƶ
	 * @return ����һ����Ƶ���϶���
	 */
	public ArrayList<Video> searchAllVideo();
}
