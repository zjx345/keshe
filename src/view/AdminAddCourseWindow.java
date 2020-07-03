package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import factory.ServiceFactory;
import vo.Course;
/**
 * ����Ϊ����Ա���ӿγ̴���
 * @author zjx
 *
 */
public class AdminAddCourseWindow extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextArea textArea3;
	private static AdminAddCourseWindow addCourseWindow=new AdminAddCourseWindow();
	/**
	 * ��˽�з���Ϊ�޲ι��췽����������ʼ������
	 */
	private AdminAddCourseWindow() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("��ӿγ���Ϣ");
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�γ̺ţ�");
		lblNewLabel.setBounds(92, 33, 60, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�γ�����");
		lblNewLabel_1.setBounds(92, 60, 60, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�γ̼�飺");
		lblNewLabel_2.setBounds(92, 112, 60, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("��ѧ��٣�");
		lblNewLabel_3.setBounds(92, 203, 60, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("�ڿμƻ���");
		lblNewLabel_4.setBounds(92, 280, 60, 15);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(160, 30, 300, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 57, 300, 21);
		getContentPane().add(textField_1);
		
		textArea1 = new JTextArea();
		textArea1.setBounds(160, 85, 300, 72);
		textArea1.setLineWrap(true);
		getContentPane().add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.setBounds(160, 168, 300, 72);
		textArea2.setLineWrap(true);
		getContentPane().add(textArea2);
		
		textArea3 = new JTextArea();
		textArea3.setBounds(160, 251, 300, 72);
		textArea2.setLineWrap(true);
		getContentPane().add(textArea3);
		
		// ȡ����ť
		JButton btnNewButton = new JButton("\u53D6    \u6D88");
		btnNewButton.setBounds(135, 345, 93, 23);
		getContentPane().add(btnNewButton);
		// ���ȡ����ť�¼�
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addCourseWindow.dispose();
			}
		});
		
		// ��Ӱ�ť
		JButton btnNewButton_1 = new JButton("\u6DFB    \u52A0");
		btnNewButton_1.setBounds(407, 345, 93, 23);
		getContentPane().add(btnNewButton_1);
				
		// Ϊ��ť����¼�
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cid=textField.getText();
				String cname=textField_1.getText();
				String presentation=textArea1.getText();
				String syllabus=textArea2.getText();
				String plan=textArea3.getText();
				Course course=new Course(cid,cname,presentation,syllabus,plan);
				if(cid.equals("")||cname.equals("")||presentation.equals("")||syllabus.equals("")||plan.equals("")) {
					JOptionPane.showMessageDialog(addCourseWindow, "���ı�������Ϊ�գ��벹�䣡");
				}else if(ServiceFactory.getIAdminServiceInstance().isExist(course)) {
					JOptionPane.showMessageDialog(addCourseWindow, "�ÿγ̺��Ѵ��ڣ�������γ̺ţ�");
				}else {
					ServiceFactory.getIAdminServiceInstance().addCourse(course);
					JOptionPane.showMessageDialog(addCourseWindow, "��ӳɹ���");
				}
			}
		});
	}
	
	/**
	 * �þ�̬����ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminAddCourseWindow getInstance() {
		return addCourseWindow;
	}
}
