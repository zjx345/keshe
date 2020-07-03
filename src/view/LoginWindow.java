package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import factory.ServiceFactory;
import vo.Admin;
import vo.Student;
/**
 * ����Ϊ��½����
 * @author zjx
 *
 */
public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField userName_textField;
	private JPasswordField password_Field;
	private JButton register_Button;
	private JButton userLogin_Button;
	private JButton adminLogin_Button;
	private static LoginWindow loginWindow=new LoginWindow();
	
	/**
	 * ��˽�з���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	private LoginWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\\u5B66\u4E60\\java\\Java\u8BFE\u7A0B\u8BBE\u8BA1-\u5728\u7EBF\u8BFE\u7A0B\u5B66\u4E60\u7CFB\u7EDF\\\u7D20\u6750\\\u56FE\u6807.jpg"));
		setTitle("���߿γ�ѧϰϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		// ���ñ���ͼƬ
		ImageIcon image1=new ImageIcon("F:\\ѧϰ\\java\\Java�γ����-���߿γ�ѧϰϵͳ\\�ز�\\��½�����ֽ.jpg");
		JLabel label=new JLabel(image1);
		label.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
		contentPane.add(label);
		
		// ���ô���Ĵ�С
		this.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
		
		// �����û����������ı���
		userName_textField=new JTextField();
		userName_textField.setBounds(210, 218, 255, 26);
		label.add(userName_textField);
		userName_textField.setColumns(20);
		
		password_Field=new JPasswordField();
		password_Field.setBounds(210, 282, 255, 26);
		label.add(password_Field);
		password_Field.setColumns(20);
		
		// ����ע�ᰴť
		register_Button=new JButton("ע  ��");
		register_Button.setBounds(124, 357, 95, 23);
		label.add(register_Button);
		
		// ���ע�ᰴť�¼�
		register_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterWindow frame = RegisterWindow.getRegisterWindow();
				frame.setVisible(true);
			}
		});
		
		// ���ù���Ա��½��ť
		adminLogin_Button=new JButton("����Ա��½");
		adminLogin_Button.setBounds(249, 357, 95, 23);
		label.add(adminLogin_Button);
		// ������Ա��ť����¼�
		adminLogin_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Admin admin=new Admin(userName_textField.getText(),password_Field.getText());
				// ����û����ڣ����½�ɹ���������ʾ�û������������
				if(ServiceFactory.getIAdminServiceInstance().login(admin)) {
					String lookAndFeel=UIManager.getSystemLookAndFeelClassName();
					try {
						UIManager.setLookAndFeel(lookAndFeel);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					AdminManagerWindow adw=new AdminManagerWindow(admin);
					adw.setVisible(true);
					loginWindow.dispose();
				}else {
					JOptionPane.showMessageDialog(loginWindow, "�û����������������������룡");
				}
			}
		});
		
		// �����û���½��ť
		userLogin_Button=new JButton("�û���½");
		userLogin_Button.setBounds(374, 357, 95, 23);
		label.add(userLogin_Button);
		// ���û���½��ť����¼�
		userLogin_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student stu=new Student(userName_textField.getText(),password_Field.getText(),"�Ӽ���","���״�ѧ","���","17347516760");
				// ����û����ڣ����½�ɹ���������ʾ�û������������
				if(ServiceFactory.getIStudentServiceInstance().login(stu)) {
					String lookAndFeel=UIManager.getSystemLookAndFeelClassName();
					try {
						UIManager.setLookAndFeel(lookAndFeel);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					MainWindow frame = MainWindow.getMainWindow();
					frame.setStudent(stu);
					frame.setVisible(true);
					loginWindow.dispose();
				}else {
					JOptionPane.showMessageDialog(loginWindow, "�û����������������������룡");
				}
			}
		});
		
		// �����˸
		userName_textField.requestFocus();
		
		setContentPane(contentPane);
	}
	
	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static LoginWindow getLoginWindow() {
		return loginWindow;
	}
}
