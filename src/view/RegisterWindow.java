package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import factory.ServiceFactory;
import vo.Student;
/**
 * ����Ϊע�����
 * @author zjx
 *
 */
public class RegisterWindow extends JFrame {

	private LoginWindow loginWindow;
	private JPanel contentPane;
	private JTextField userName_textField;
	private JPasswordField password_Field;
	private JTextField email_textField;
	private JButton cancel_Button;
	private JButton submit_Button;
	private static RegisterWindow registerWindow=new RegisterWindow();

	/**
	 * ��˽�з���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	private RegisterWindow() {
		this.loginWindow=LoginWindow.getLoginWindow();
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\\u5B66\u4E60\\java\\Java\u8BFE\u7A0B\u8BBE\u8BA1-\u5728\u7EBF\u8BFE\u7A0B\u5B66\u4E60\u7CFB\u7EDF\\\u7D20\u6750\\\u56FE\u6807.jpg"));
		setTitle("�û�ע��");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		this.setBounds(200, 100, 800, 500);
		
		// ���ñ���ͼƬ
		ImageIcon image1=new ImageIcon("F:\\ѧϰ\\java\\Java�γ����-���߿γ�ѧϰϵͳ\\�ز�\\ע������ֽ.jpg");
		JLabel label=new JLabel(image1);
		label.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
		contentPane.add(label);
		
		// �����û����������ı���
		JLabel userNameLabel=new JLabel("�û�����");
		userNameLabel.setBounds(100, 115, 130, 105);
		label.add(userNameLabel);
		userName_textField=new JTextField();
		userName_textField.setBounds(150, 158, 200, 20);
		label.add(userName_textField);
		userName_textField.setColumns(20);
		
		JLabel passwordLabel=new JLabel("��   �룺");
		passwordLabel.setBounds(100, 145, 130, 105);
		label.add(passwordLabel);
		password_Field=new JPasswordField();
		password_Field.setBounds(150, 188, 200, 20);
		label.add(password_Field);
		password_Field.setColumns(20);
		
		JLabel emailLabel=new JLabel("��   �䣺");
		emailLabel.setBounds(100, 175, 130, 105);
		label.add(emailLabel);
		email_textField=new JTextField();
		email_textField.setBounds(150, 218, 200, 20);
		label.add(email_textField);
		email_textField.setColumns(20);
		
		cancel_Button=new JButton("��    ��");
		cancel_Button.setBounds(150, 250, 80, 20);
		label.add(cancel_Button);
		// Ϊ���ذ�ť�����¼�
		cancel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registerWindow.dispose();
				loginWindow.setVisible(true);
			}
		});
		
		submit_Button=new JButton("ȷ    ��");
		submit_Button.setBounds(270, 250, 80, 20);
		label.add(submit_Button);
		// Ϊȷ����ť�����¼�
		submit_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student stu=new Student(userName_textField.getText(),password_Field.getText(),"�Ӽ���","���״�ѧ","���","17347516760");
				// �ж��û����Ƿ������ݿ��д��ڣ�������ڣ�����ʾ�û���������û����뵽���ݿ�
				if(ServiceFactory.getIStudentServiceInstance().login(stu)) {
					JOptionPane.showMessageDialog(registerWindow, "���û����Ѵ��ڣ�");
				}else {
					// ��ʾ��
					ServiceFactory.getIStudentServiceInstance().register(stu);
					JOptionPane.showMessageDialog(registerWindow, "ע��ɹ���");
					// ����ı���
					userName_textField.setText("");
					password_Field.setText("");
					email_textField.setText("");
				}
			}
		});
		
		setContentPane(contentPane);
	}

	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static RegisterWindow getRegisterWindow() {
		return registerWindow;
	}
}
