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
import vo.Courseware;
/**
 * ����Ϊ����Ա���ҿμ�����
 * @author zjx
 *
 */
public class AdminFindCoursewareWindow extends JInternalFrame {

	private static AdminFindCoursewareWindow findCoursewareWindow=new AdminFindCoursewareWindow();
	private JTextField textField;
	ArrayList<Courseware> al; // �������Ҫ��ʾ�Ŀμ�
	private int type=1; // ������ʶ��ʲô�ֶ�������

	/**
	 * �÷���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	public AdminFindCoursewareWindow() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("\u67E5\u770B\u5B66\u751F");
		setBounds(10, 30, 900, 600);
		getContentPane().setLayout(null);
		// ���������ʾ����ѧ��
		al=ServiceFactory.getIAdminServiceInstance().searchAllCourseware();
		String[] colName= {"        �μ���","        �γ̺�","        �μ���","      �μ�·��","        �μ���С"};
		String[][] data=new String[100000][5];
		int i=0;
		for(Courseware courseware : al) {
			data[i][0]=courseware.getCnum();
			data[i][1]=courseware.getCid();
			data[i][2]=courseware.getKname();
			data[i][3]=courseware.getCpath();
			data[i][4]=courseware.getSize();
			i++;
		}
		Table.createTable(getContentPane(),colName, data);
		
		// ���������б�������������ť
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 30, 106, 23);
		getContentPane().add(comboBox);
		comboBox.addItem("���γ̺Ų�ѯ��");
		comboBox.addItem("���μ��Ų�ѯ��");
		comboBox.addItem("���μ�����ѯ��");
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
				}else if(e.getItem().equals("���μ��Ų�ѯ��")){
					type=2;
				}else if(e.getItem().equals("���μ�����ѯ��")) {
					type=3;
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
				al=ServiceFactory.getIAdminServiceInstance().searchCourseware(textField.getText(), type);
				// ��ձ��
				Table.model.getDataVector().clear();
				// ˢ�±��
				Table.model.fireTableDataChanged();
				// ��ʾ���ֿμ�
				for(Courseware courseware : al) {
					Table.model.addRow(new String[] {courseware.getCnum(),courseware.getCid(),courseware.getKname(),courseware.getCpath(),courseware.getSize()});
				}
			}
		});
		
		// ������ʾ���пμ���ť
		JButton showAllCouButton = new JButton("��ʾ���пμ�");
		showAllCouButton.setBounds(500, 30, 120, 23);
		getContentPane().add(showAllCouButton);
		showAllCouButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				al=ServiceFactory.getIAdminServiceInstance().searchAllCourseware();
				// ��ձ��
				Table.model.getDataVector().clear();
				// ˢ�±��
				Table.model.fireTableDataChanged();
				// ��ʾ����ѧ��
				for(Courseware courseware : al) {
					Table.model.addRow(new String[] {courseware.getCnum(),courseware.getCid(),courseware.getKname(),courseware.getCpath(),courseware.getSize()});
				}
			}
		});
	}

	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminFindCoursewareWindow getInstance() {
		return findCoursewareWindow;
	}
}
