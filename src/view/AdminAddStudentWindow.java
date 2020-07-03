package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import factory.ServiceFactory;
import vo.Student;
/**
 * ����Ϊ����Ա����ѧ������
 * @author zjx
 *
 */
public class AdminAddStudentWindow extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static AdminAddStudentWindow addStudentWindow=new AdminAddStudentWindow();
	/**
	 * ��˽�з���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	private AdminAddStudentWindow() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("\u589E\u52A0\u5B66\u751F");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26    \u53F7\uFF1A");
		lblNewLabel.setBounds(92, 33, 60, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6    \u7801\uFF1A");
		lblNewLabel_1.setBounds(92, 60, 60, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3    \u540D\uFF1A");
		lblNewLabel_2.setBounds(92, 85, 60, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66    \u6821\uFF1A");
		lblNewLabel_3.setBounds(92, 112, 60, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5E74    \u7EA7\uFF1A");
		lblNewLabel_4.setBounds(92, 140, 60, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		lblNewLabel_5.setBounds(92, 166, 60, 15);
		getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(160, 30, 205, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 57, 205, 21);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 83, 205, 21);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 111, 205, 21);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 138, 205, 21);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 167, 205, 21);
		getContentPane().add(textField_5);
		
		// ȡ����ť
		JButton btnNewButton = new JButton("\u53D6    \u6D88");
		btnNewButton.setBounds(78, 217, 93, 23);
		getContentPane().add(btnNewButton);
		// ���ȡ����ť�¼�
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addStudentWindow.dispose();
			}
		});
		
		// ��Ӱ�ť
		JButton btnNewButton_1 = new JButton("\u6DFB    \u52A0");
		btnNewButton_1.setBounds(288, 217, 93, 23);
		getContentPane().add(btnNewButton_1);
		// Ϊ��ť����¼�
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String account=textField.getText();
				String password=textField_1.getText();
				String name=textField_2.getText();
				String school=textField_3.getText();
				String grade=textField_4.getText();
				String phone=textField_5.getText();
				Student stu=new Student(account,password,name,school,grade,phone);
				if(account.equals("")||password.equals("")||name.equals("")||school.equals("")||grade.equals("")||phone.equals("")) {
					JOptionPane.showMessageDialog(addStudentWindow, "���ı�������Ϊ�գ��벹�䣡");
				}else if(ServiceFactory.getIAdminServiceInstance().isExist(stu)) {
					JOptionPane.showMessageDialog(addStudentWindow, "���˺��Ѵ��ڣ�������˺ţ�");
				}else {
					ServiceFactory.getIAdminServiceInstance().addStudent(stu);
					JOptionPane.showMessageDialog(addStudentWindow, "��ӳɹ���");
				}
			}
		});
	}
	
	/**
	 * �þ�̬����ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminAddStudentWindow getInstance() {
		return addStudentWindow;
	}
}
