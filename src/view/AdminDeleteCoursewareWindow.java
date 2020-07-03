package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import factory.ServiceFactory;
import tool.Table;
import vo.Courseware;
/**
 * ����Ϊ����Աɾ���μ�����
 * @author zjx
 *
 */
public class AdminDeleteCoursewareWindow extends AdminFindCoursewareWindow {

	private static AdminDeleteCoursewareWindow deleteCoursewareWindow=new AdminDeleteCoursewareWindow();
	private JButton deleteButton;  // ɾ����ť
	/**
	 * ��˽�з���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	private AdminDeleteCoursewareWindow() {
		super();
		setTitle("ɾ���μ�");
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
						Courseware courseware=new Courseware((String)Table.table.getValueAt(seletedRows[0], 1),(String)Table.table.getValueAt(seletedRows[i]-i, 0),(String)Table.table.getValueAt(seletedRows[i]-i, 2),(String)Table.table.getValueAt(seletedRows[i]-i, 3),(String)Table.table.getValueAt(seletedRows[i]-i, 4));
						ServiceFactory.getIAdminServiceInstance().removeCourseware(courseware);
						// �ӱ����ɾ��
						Table.model.removeRow(seletedRows[0]);
						Table.model.fireTableDataChanged();
					}
					JOptionPane.showMessageDialog(deleteCoursewareWindow, "ɾ���ɹ���");
				}else {
					JOptionPane.showMessageDialog(deleteCoursewareWindow, "û��ѡ����Ҫɾ�����У�");
				}
			}
		});
	}
	
	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminDeleteCoursewareWindow getInstance() {
		return deleteCoursewareWindow;
	}
}
