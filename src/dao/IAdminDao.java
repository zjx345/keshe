package dao;
import java.util.ArrayList;
import java.util.TreeSet;

import vo.Admin;
import vo.Course;
import vo.Courseware;
import vo.Student;
import vo.Video;

/**
 * �ýӿڶ�����һЩ����Ա�������ݿ�ķ���
 * @author zjx
 *
 */
public interface IAdminDao {
	/**
	 * �÷��������жϹ���Ա�Ƿ����
	 * @param admin Ҫ�жϵĹ���Ա
	 * @return ����һ��booleanֵ�������Ƿ����
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean isExist(Admin admin) throws Exception;
	/**
	 * �÷��������޸Ĺ���Ա������
	 * @param admin �޸�����Ĺ���Ա
	 * @param newPassword �޸ĺ������
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean updatePassword(Admin admin,String newPassword)throws Exception;
	/**
	 * �÷��������ж��ļ����Ƿ���ڸ�ѧ��
	 * @param stu Ҫ�жϵ�ѧ��
	 * @return ����һ��booleanֵ�������Ƿ����
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean isExist(Student stu)throws Exception;
	/**
	 * �÷����������ļ�������ѧ��
	 * @param stu Ҫ���ӵ�ѧ��
	 * @return ����һ��booleanֵ�������Ƿ����ӳɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doAddStudent(Student stu)throws Exception;
	/**
	 * �÷����������ļ���ɾ��ѧ��
	 * @param stu Ҫɾ����ѧ��
	 * @return ����һ��booleanֵ�������Ƿ�ɾ���ɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doRemoveStudent(Student stu)throws Exception;
	/**
	 * �÷����������ļ����޸�ѧ��
	 * @param stu Ҫ�޸ĵ�ѧ��
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doUpdateStudent(Student stu)throws Exception;
	/**
	 * �÷��������˺Ż����������ļ��в���ѧ��
	 * @param str Ҫ���ҵ��˺Ż�������
	 * @param type 1�����˺ţ�2��������
	 * @return ����һ��ѧ�����϶���
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public TreeSet<Student> findStudent(String str,int type)throws Exception;
	/**
	 * �÷������������ļ������е��û���Ϣ
	 * @return ��������ѧ���ļ���
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public TreeSet<Student> findAllStudent()throws Exception;
	/**
	 * �÷��������жϿγ��Ƿ������ݿ��д���
	 * @param course �γ̶������
	 * @return ����һ��booleanֵ�������Ƿ����
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean isExist(Course course)throws Exception;
	/**
	 * �÷������������ݿ������ӿγ�
	 * @param course �γ̶������
	 * @return ����һ��booleanֵ�������Ƿ����ӳɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doAddCourse(Course course)throws Exception;
	/**
	 * �÷������������ݿ���ɾ���γ�
	 * @param course Ҫɾ���Ŀγ�
	 * @return ����һ��booleanֵ�������Ƿ�ɾ���ɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doRemoveCourse(Course course)throws Exception;
	/**
	 * �÷������������ݿ����޸Ŀγ�
	 * @param course Ҫ�޸ĵĿγ�
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doUpdateCourse(Course course)throws Exception;
	/**
	 * �÷������ݿγ̺Ż�γ��������ݿ��в��ҿγ� 
	 * @param str Ҫ���ҵ��ַ���
	 * @param type ��ʲô��ѯ��1�����γ̺Ų��ң�2�����γ�������
	 * @return ����Ҫ���ҵĿγ̶���
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public ArrayList<Course> findCourse(String str,int type)throws Exception;
	/**
	 * �÷��������������ݿ������еĿγ̶���
	 * @return �������пγ̶���ļ���
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public ArrayList<Course> findAllCourse()throws Exception;
	/**
	 * �÷��������жϿμ��Ƿ����
	 * @param courseware Ҫ���ҵĿμ�
	 * @return ����һ��booleanֵ�������Ƿ����
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean isExist(Courseware courseware)throws Exception;
	/**
	 * �÷����������ӿμ�
	 * @param courseware Ҫ���ӵĿμ�
	 * @return ����һ��booleanֵ�������Ƿ����ӳɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doAddCourseware(Courseware courseware)throws Exception;
	/**
	 * �÷�������ɾ���μ�
	 * @param courseware Ҫɾ���Ŀμ�
	 * @return ����һ��booleanֵ�������Ƿ�ɾ���ɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doRemoveCourseware(Courseware courseware)throws Exception;
	/**
	 * �÷��������޸Ŀμ�
	 * @param courseware Ҫ�޸ĵĿμ�
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doUpdateCourseware(Courseware courseware)throws Exception;
	/**
	 * �÷������Ը��ݿγ̺š��μ��š��μ������ҿμ�
	 * @param str Ҫ���ҵĿγ̺Ż��߿μ��Ż��߿μ���
	 * @param type 1����γ̺ţ�2����μ��ţ�3����μ���
	 * @return ����һ���μ����϶���
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public ArrayList<Courseware> findCourseware(String str,int type)throws Exception;
	/**
	 * �÷��������������еĿμ�
	 * @return ����һ���μ�����
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public ArrayList<Courseware> findAllCourseware()throws Exception;
	/**
	 * �÷����ж���Ƶ�Ƿ����
	 * @param video Ҫ�жϵ���Ƶ
	 * @return ����һ��booleanֵ�������Ƿ����
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean isExist(Video video)throws Exception;
	/**
	 * �÷�������������Ƶ
	 * @param video Ҫ���ӵ���Ƶ
	 * @return ����һ��booleanֵ�������Ƿ����ӳɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doAddVideo(Video video)throws Exception;
	/**
	 * �÷�������ɾ����Ƶ
	 * @param video Ҫɾ������Ƶ
	 * @return ����һ��booleanֵ�������Ƿ�ɾ���ɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doRemoveVideo(Video video)throws Exception;
	/**
	 * �÷��������޸���Ƶ
	 * @param video Ҫ�޸ĵ���Ƶ
	 * @return ����һ��booleanֵ�������Ƿ��޸ĳɹ�
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public boolean doUpdateVideo(Video video)throws Exception;
	/**
	 * �÷������ݿγ̺Ż�����Ƶ�Ż�����Ƶ��������Ƶ
	 * @param str Ҫ���ҵĿγ̺Ż�����Ƶ�Ż�����Ƶ��
	 * @param type 1����γ̺ţ�2������Ƶ�ţ�3������Ƶ��
	 * @return ����һ����Ƶ���϶���
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public ArrayList<Video> findVideo(String str,int type)throws Exception;
	/**
	 * �÷����������е���Ƶ
	 * @return ����һ����Ƶ���϶���
	 * @throws Exception �׳�һ��Exception�쳣
	 */
	public ArrayList<Video> findAllVideo()throws Exception;
}
