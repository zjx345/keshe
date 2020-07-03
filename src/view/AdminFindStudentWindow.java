package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import factory.ServiceFactory;
import tool.Table;
import vo.Student;
/**
 * ����Ϊ����Ա����ѧ������
 * @author zjx
 *
 */
public class AdminFindStudentWindow extends JInternalFrame {
	
	private static AdminFindStudentWindow findStudentWindow=new AdminFindStudentWindow();
	private JTextField textField;
	TreeSet<Student> ts; // �������Ҫ��ʾ��ѧ��
	private int type=1; // ������ʶ��ʲô�ֶ�������

	/**
	 * �÷���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	public AdminFindStudentWindow() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("\u67E5\u770B\u5B66\u751F");
		setBounds(10, 30, 900, 600);
		getContentPane().setLayout(null);
		// ���������ʾ����ѧ��
		ts=ServiceFactory.getIAdminServiceInstance().searchAllStudent();
		String[] colName= {"        �˺�","        ����","        ����","      ѧУ����","        �꼶","      �ֻ�����"};
		String[][] data=new String[100000][6];
		int i=0;
		for(Student stu : ts) {
			data[i][0]=stu.getAccount();
			data[i][1]=stu.getPassword();
			data[i][2]=stu.getName();
			data[i][3]=stu.getSchool();
			data[i][4]=stu.getGrade();
			data[i][5]=stu.getPhone();
			i++;
		}
		Table.createTable(getContentPane(),colName, data);
		
		// ���������б�������������ť
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 30, 106, 23);
		getContentPane().add(comboBox);
		comboBox.addItem("���˺Ų�ѯ��");
		comboBox.addItem("��������ѯ��");
		textField = new JTextField();
		textField.setBounds(141, 30, 212, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		// Ϊ�����б������¼�
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("���˺Ų�ѯ��")) {
					type=1;
				}else if(e.getItem().equals("��������ѯ��")){
					type=2;
				}
			}
		});
		JButton btnNewButton = new JButton("\u67E5    \u8BE2 ");
		btnNewButton.setBounds(368, 30, 93, 23);
		getContentPane().add(btnNewButton);
		// Ϊ������ť����¼�
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ts=ServiceFactory.getIAdminServiceInstance().searchStudent(textField.getText(), type);
				// ��ձ��
				Table.model.getDataVector().clear();
				// ˢ�±��
				Table.model.fireTableDataChanged();
				// ��ʾ����ѧ��
				for(Student stu : ts) {
					Table.model.addRow(new String[] {stu.getAccount(),stu.getPassword(),stu.getName(),stu.getSchool(),stu.getGrade(),stu.getPhone()});
				}
			}
		});
		
		// ������ʾ����ѧ����ť
		JButton showAllStuButton = new JButton("��ʾ����ѧ��");
		showAllStuButton.setBounds(500, 30, 120, 23);
		getContentPane().add(showAllStuButton);
		showAllStuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ts=ServiceFactory.getIAdminServiceInstance().searchAllStudent();
				// ��ձ��
				Table.model.getDataVector().clear();
				// ˢ�±��
				Table.model.fireTableDataChanged();
				// ��ʾ����ѧ��
				for(Student stu : ts) {
					Table.model.addRow(new String[] {stu.getAccount(),stu.getPassword(),stu.getName(),stu.getSchool(),stu.getGrade(),stu.getPhone()});
				}
			}
		});
	}

	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminFindStudentWindow getInstance() {
		return findStudentWindow;
	}
}
