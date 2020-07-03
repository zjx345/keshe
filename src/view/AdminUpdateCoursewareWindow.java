package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import factory.ServiceFactory;
import tool.Table;
import vo.Courseware;
import vo.Student;
/**
 * ����Ϊ����Ա�޸Ŀμ�����
 * @author zjx
 *
 */
public class AdminUpdateCoursewareWindow extends AdminFindCoursewareWindow {

	private static AdminUpdateCoursewareWindow updateCoursewareWindow=new AdminUpdateCoursewareWindow();
	private JButton updateButton; // �޸İ�ť
	private int selectedRow;   // ѡ�е��к� 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * �÷���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	public AdminUpdateCoursewareWindow() {
		super();
		setTitle("�޸Ŀμ���Ϣ");
		setBounds(10, 30, 1200, 600);
		updateButton=new JButton("����޸�");
		updateButton.setBounds(650, 30, 93, 23);
		getContentPane().add(updateButton);
		JLabel lblNewLabel = new JLabel("�� �� �ţ�");
		lblNewLabel.setBounds(870, 126, 227, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�γ̺ţ�");
		lblNewLabel_1.setBounds(870, 154, 62, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�μ�����");
		lblNewLabel_2.setBounds(870, 187, 65, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("�μ�·����");
		lblNewLabel_3.setBounds(870, 218, 68, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("�μ���С��");
		lblNewLabel_4.setBounds(870, 247, 68, 15);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(930, 150, 211, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(930, 184, 211, 21);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(930, 215, 211, 21);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(930, 244, 211, 21);
		getContentPane().add(textField_3);
		
		// Ϊ����޸İ�ť����¼�
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedRow=Table.table.getSelectedRow();
				Courseware oldCou=new Courseware((String)Table.table.getValueAt(selectedRow, 1),(String)Table.table.getValueAt(selectedRow, 0),(String)Table.table.getValueAt(selectedRow, 2),(String)Table.table.getValueAt(selectedRow, 3),(String)Table.table.getValueAt(selectedRow, 4));
				
				// ����ı���
				lblNewLabel.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
				// ���ı���ֵ
				lblNewLabel.setText("�μ��ţ�"+oldCou.getCnum());
				textField.setText(oldCou.getCid());
				textField_1.setText(oldCou.getKname());
				textField_2.setText(oldCou.getCpath());
				textField_3.setText(oldCou.getSize());
			}
		});
		
		// ���ȷ���޸İ�ť
		JButton submitButton=new JButton("ȷ���޸�");
		submitButton.setBounds(990, 330, 93, 23);
		getContentPane().add(submitButton);
		// ��Ӱ�ť�¼�
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Courseware newCou=new Courseware(lblNewLabel.getText().substring(4),textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
				if(ServiceFactory.getIAdminServiceInstance().updateCourseware(newCou)) {
					Table.table.setValueAt(newCou.getCid(), selectedRow, 1);
					Table.table.setValueAt(newCou.getKname(), selectedRow, 2);
					Table.table.setValueAt(newCou.getCpath(), selectedRow, 3);
					Table.table.setValueAt(newCou.getSize(), selectedRow, 4);
					Table.model.fireTableDataChanged();
					JOptionPane.showMessageDialog(updateCoursewareWindow, "�޸ĳɹ���");
				}else {
					JOptionPane.showMessageDialog(updateCoursewareWindow, "�޸�ʧ�ܣ�");
				}
			}
		});
	}

	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminUpdateCoursewareWindow getInstance() {
		return updateCoursewareWindow;
	}
}
