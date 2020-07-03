package service.impl;
import java.io.File;
import java.util.ArrayList;

import dbc.DatabaseConnection;
import factory.DaoFactory;
import service.IStudentService;
import tool.DownLoadTool;
import tool.OpenExeTool;
import vo.Course;
import vo.Courseware;
import vo.Student;
import vo.Video;
/**
 * ����ʵ����ѧ��ҵ���Ľӿ�
 * @author zjx
 *
 */
public class StudentServiceImpl implements IStudentService{

	private DatabaseConnection dbc=new DatabaseConnection();
	private File file=new File("E:\\Student.txt");
	
	@Override
	public boolean updatePassword(Student stu, String newPassword)  {
		try {
			// ����޸ĳɹ����򷵻�true�����򷵻�false
			if(DaoFactory.getIStudentDaoInstance(file).doUpdatePassword(stu, newPassword))
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean register(Student stu) {
		try {
			// �������ɹ����򷵻�true�����򷵻�false
			if(DaoFactory.getIStudentDaoInstance(file).doInsert(stu))
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean login(Student stu){
		try {
			if(DaoFactory.getIStudentDaoInstance(file).isExist(stu))
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Course findCourse(String cname){
		Course course=null;
		try {
			if(DaoFactory.getIStudentDaoInstance(dbc.getConnection()).isExist(cname)) {
				course=DaoFactory.getIStudentDaoInstance(dbc.getConnection()).findCourse(cname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		return course;
	}
	@Override
	public ArrayList<Courseware> findAllCourseware(String cid){
		ArrayList<Courseware> al=null;
		try {
			al=DaoFactory.getIStudentDaoInstance(dbc.getConnection()).findAllCourseware(cid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		return al;
	}
	@Override
	public boolean downloadCourseware(String cpath) {
		boolean flag=false;
		try {
			flag=DownLoadTool.downLoadRrsource(cpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		return flag;
	}
	@Override
	public ArrayList<Video> findAllVideo(String cid) {
		ArrayList<Video> al=null;
		try {
			al=DaoFactory.getIStudentDaoInstance(dbc.getConnection()).findAllVideo(cid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		return al;
	}
	@Override
	public void watchVideo(String vpath) {
		OpenExeTool.openExe(vpath);
	}
}
