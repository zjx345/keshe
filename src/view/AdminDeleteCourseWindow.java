package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import factory.ServiceFactory;
import tool.Table;
import vo.Course;
/**
 * ����Ϊ����Աɾ���γ̴���
 * @author zjx
 *
 */
public class AdminDeleteCourseWindow extends AdminFindCourseWindow {

	private static AdminDeleteCourseWindow deleteCourseWindow=new AdminDeleteCourseWindow();
	private JButton deleteButton;  // ɾ����ť
	/**
	 * ��˽�з���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	private AdminDeleteCourseWindow() {
		super();
		deleteButton=new JButton("ɾ    ��");
		deleteButton.setBounds(650, 30, 93, 23);
		getContentPane().add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] seletedRows=Table.table.getSelectedRows();
				if(seletedRows.length>0) {
					for(int i=0;i<seletedRows.length;i++) {
						// �����ݿ���ɾ��
						Course course=new Course((String)Table.table.getValueAt(seletedRows[0], 0),(String)Table.table.getValueAt(seletedRows[i]-i, 1),(String)Table.table.getValueAt(seletedRows[i]-i, 2),(String)Table.table.getValueAt(seletedRows[i]-i, 3),(String)Table.table.getValueAt(seletedRows[i]-i, 4));
						ServiceFactory.getIAdminServiceInstance().removeCourse(course);
						// �ӱ����ɾ��
						Table.model.removeRow(seletedRows[0]);
						Table.model.fireTableDataChanged();
					}
					JOptionPane.showMessageDialog(deleteCourseWindow, "ɾ���ɹ���");
				}else {
					JOptionPane.showMessageDialog(deleteCourseWindow, "û��ѡ����Ҫɾ�����У�");
				}
			}
		});
	}
	
	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminDeleteCourseWindow getInstance() {
		return deleteCourseWindow;
	}
}
