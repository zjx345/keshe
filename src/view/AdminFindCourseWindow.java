package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import factory.ServiceFactory;
import tool.Table;
import vo.Course;
import vo.Student;
/**
 * ����Ϊ����Ա���ҿγ̴���
 * @author zjx
 *
 */
public class AdminFindCourseWindow extends JInternalFrame {

	private static AdminFindCourseWindow findCourseWindow=new AdminFindCourseWindow();
	private JTextField textField;
	ArrayList<Course> al; // �������Ҫ��ʾ��ѧ��
	private int type=1; // ������ʶ��ʲô�ֶ�������

	/**
	 * �÷���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	public AdminFindCourseWindow() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("\u67E5\u770B\u5B66\u751F");
		setBounds(10, 30, 900, 600);
		getContentPane().setLayout(null);
		// ���������ʾ����ѧ��
		al=ServiceFactory.getIAdminServiceInstance().searchAllCourse();
		String[] colName= {"        �γ̺�","        �γ���","        �γ̼��","      ��ѧ���","        �ڿμƻ�"};
		String[][] data=new String[100000][5];
		int i=0;
		for(Course course : al) {
			data[i][0]=course.getCno();
			data[i][1]=course.getCname();
			data[i][2]=course.getPresentation();
			data[i][3]=course.getSyllabus();
			data[i][4]=course.getPlan();
			i++;
		}
		Table.createTable(getContentPane(),colName, data);
		
		// ���������б�������������ť
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 30, 106, 23);
		getContentPane().add(comboBox);
		comboBox.addItem("���γ̺Ų�ѯ��");
		comboBox.addItem("���γ�����ѯ��");
		textField = new JTextField();
		textField.setBounds(141, 30, 212, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		// Ϊ�����б������¼�
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("���γ̺Ų�ѯ��")) {
					type=1;
				}else if(e.getItem().equals("���γ�����ѯ��")){
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
				al=ServiceFactory.getIAdminServiceInstance().searchCourse(textField.getText(), type);
				// ��ձ��
				Table.model.getDataVector().clear();
				// ˢ�±��
				Table.model.fireTableDataChanged();
				// ��ʾ���ֿγ�
				for(Course course : al) {
					Table.model.addRow(new String[] {course.getCno(),course.getCname(),course.getPresentation(),course.getSyllabus(),course.getPlan()});
				}
			}
		});
		
		// ������ʾ���пγ̰�ť
		JButton showAllCouButton = new JButton("��ʾ���пγ�");
		showAllCouButton.setBounds(500, 30, 120, 23);
		getContentPane().add(showAllCouButton);
		showAllCouButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				al=ServiceFactory.getIAdminServiceInstance().searchAllCourse();
				// ��ձ��
				Table.model.getDataVector().clear();
				// ˢ�±��
				Table.model.fireTableDataChanged();
				// ��ʾ����ѧ��
				for(Course course : al) {
					Table.model.addRow(new String[] {course.getCno(),course.getCname(),course.getPresentation(),course.getSyllabus(),course.getPlan()});
				}
			}
		});
	}

	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminFindCourseWindow getInstance() {
		return findCourseWindow;
	}
}
