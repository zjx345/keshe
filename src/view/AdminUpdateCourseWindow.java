package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import factory.ServiceFactory;
import tool.Table;
import vo.Course;
import vo.Student;
/**
 * ����������������Ա�޸Ŀγ̴���
 * @author zjx
 *
 */
public class AdminUpdateCourseWindow extends AdminFindCourseWindow {
	private static AdminUpdateCourseWindow updateCourseWindow=new AdminUpdateCourseWindow();
	private JButton updateButton; // �޸İ�ť
	private int selectedRow;   // ѡ�е��к� 
	private JTextField textField;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextArea textArea3;
	/**
	 * �÷���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	public AdminUpdateCourseWindow() {
		super();
		setTitle("�޸Ŀγ���Ϣ");
		setBounds(10, 30, 1200, 600);
		updateButton=new JButton("����޸�");
		updateButton.setBounds(650, 30, 93, 23);
		getContentPane().add(updateButton);
		JLabel lblNewLabel = new JLabel("�� �� �ţ�");
		lblNewLabel.setBounds(870, 126, 227, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�γ�����");
		lblNewLabel_1.setBounds(870, 154, 62, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�γ̼�飺");
		lblNewLabel_2.setBounds(870, 230, 65, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("��ѧ��٣�");
		lblNewLabel_3.setBounds(870, 315, 68, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("�ڿμƻ���");
		lblNewLabel_4.setBounds(870, 400, 68, 15);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(930, 150, 211, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea1 = new JTextArea();
		textArea1.setLineWrap(true);
		textArea1.setBounds(930, 215, 211, 50);
		getContentPane().add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.setLineWrap(true);
		textArea2.setBounds(930, 300, 211, 50);
		getContentPane().add(textArea2);
		
		textArea3 = new JTextArea();
		textArea3.setLineWrap(true);
		textArea3.setBounds(930, 385, 211, 50);
		getContentPane().add(textArea3);
		
		// Ϊ����޸İ�ť����¼�
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedRow=Table.table.getSelectedRow();
				Course oldCou=new Course((String)Table.table.getValueAt(selectedRow, 0),(String)Table.table.getValueAt(selectedRow, 1),(String)Table.table.getValueAt(selectedRow, 2),(String)Table.table.getValueAt(selectedRow, 3),(String)Table.table.getValueAt(selectedRow, 4));
				
				// ����ı���
				lblNewLabel.setText("");
				textField.setText("");
				textArea1.setText("");
				textArea2.setText("");
				textArea3.setText("");
				
				// ���ı���ֵ
				lblNewLabel.setText("�γ̺ţ�"+oldCou.getCno());
				textField.setText(oldCou.getCname());
				textArea1.setText(oldCou.getPresentation());
				textArea2.setText(oldCou.getSyllabus());
				textArea3.setText(oldCou.getPlan());
			}
		});
		
		// ���ȷ���޸İ�ť
		JButton submitButton=new JButton("ȷ���޸�");
		submitButton.setBounds(990, 470, 93, 23);
		getContentPane().add(submitButton);
		// ��Ӱ�ť�¼�
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Course newCou=new Course(lblNewLabel.getText().substring(4),textField.getText(),textArea1.getText(),textArea2.getText(),textArea3.getText());
				if(ServiceFactory.getIAdminServiceInstance().updateCourse(newCou)) {
					Table.table.setValueAt(newCou.getCname(), selectedRow, 1);
					Table.table.setValueAt(newCou.getPresentation(), selectedRow, 2);
					Table.table.setValueAt(newCou.getSyllabus(), selectedRow, 3);
					Table.table.setValueAt(newCou.getPlan(), selectedRow, 4);
					Table.model.fireTableDataChanged();
					JOptionPane.showMessageDialog(updateCourseWindow, "�޸ĳɹ���");
				}else {
					JOptionPane.showMessageDialog(updateCourseWindow, "�޸�ʧ�ܣ�");
				}
			}
		});
	}

	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminUpdateCourseWindow getInstance() {
		return updateCourseWindow;
	}
}
