package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import factory.ServiceFactory;
import vo.Courseware;
/**
 * ����Ϊ����Ա���ӿμ�����
 * @author zjx
 *
 */
public class AdminAddCoursewareWindow extends JInternalFrame {

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private static AdminAddCoursewareWindow addCoursewareWindow=new AdminAddCoursewareWindow();

	/**
	 * ��˽�з���Ϊ�޲ι��췽����������ʼ������
	 */
	private AdminAddCoursewareWindow() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("��ӿμ���Ϣ");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�μ��ţ�");
		lblNewLabel.setBounds(92, 33, 60, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�γ̺ţ�");
		lblNewLabel_1.setBounds(92, 60, 60, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�μ�����");
		lblNewLabel_2.setBounds(92, 87, 60, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("�μ�·����");
		lblNewLabel_3.setBounds(92, 114, 60, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("�μ���С��");
		lblNewLabel_4.setBounds(92, 141, 60, 15);
		getContentPane().add(lblNewLabel_4);
		
		textField1 = new JTextField();
		textField1.setBounds(160, 30, 205, 21);
		getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(160, 57, 205, 21);
		getContentPane().add(textField2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(160, 84, 205, 21);
		getContentPane().add(textField3);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(160, 111, 205, 21);
		getContentPane().add(textField4);
		
		textField5 = new JTextField();
		textField5.setColumns(10);
		textField5.setBounds(160, 138, 205, 21);
		getContentPane().add(textField5);
		
		// ȡ����ť
		JButton btnNewButton = new JButton("\u53D6    \u6D88");
		btnNewButton.setBounds(78, 217, 93, 23);
		getContentPane().add(btnNewButton);
		// ���ȡ����ť�¼�
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addCoursewareWindow.dispose();
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
				String cnum=textField1.getText();
				String cid=textField2.getText();
				String kname=textField3.getText();
				String cpath=textField4.getText();
				String size=textField5.getText(); 
				Courseware courseware=new Courseware(cid,cnum,kname,cpath,size);
				if(cid.equals("")||cnum.equals("")||kname.equals("")||cpath.equals("")||size.equals("")) {
					JOptionPane.showMessageDialog(addCoursewareWindow, "���ı�������Ϊ�գ��벹�䣡");
				}else if(ServiceFactory.getIAdminServiceInstance().isExist(courseware)) {
					JOptionPane.showMessageDialog(addCoursewareWindow, "�ÿγ̺��Ѵ��ڣ�������γ̺ţ�");
				}else {
					ServiceFactory.getIAdminServiceInstance().addCourseware(courseware);
					JOptionPane.showMessageDialog(addCoursewareWindow, "��ӳɹ���");
				}
			}
		});
	}
	
	/**
	 * �þ�̬����Ϊ�õ��ô���
	 * @return ����һ�����ڶ���
	 */
	public static AdminAddCoursewareWindow getInstance() {
		return addCoursewareWindow;
	}
}
