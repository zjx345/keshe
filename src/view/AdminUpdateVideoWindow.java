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
import vo.Video;
/**
 * ����������������Ա�޸���Ƶ����
 * @author zjx
 *
 */
public class AdminUpdateVideoWindow extends AdminFindVideoWindow {

	private static AdminUpdateVideoWindow updateVideoWindow=new AdminUpdateVideoWindow();
	private JButton updateButton; // �޸İ�ť
	private int selectedRow;   // ѡ�е��к� 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * �÷���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	public AdminUpdateVideoWindow() {
		super();
		setTitle("�޸���Ƶ��Ϣ");
		setBounds(10, 30, 1200, 600);
		updateButton=new JButton("����޸�");
		updateButton.setBounds(650, 30, 93, 23);
		getContentPane().add(updateButton);
		JLabel lblNewLabel = new JLabel("�� Ƶ �ţ�");
		lblNewLabel.setBounds(870, 126, 227, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�γ̺ţ�");
		lblNewLabel_1.setBounds(870, 154, 62, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("��Ƶ����");
		lblNewLabel_2.setBounds(870, 187, 65, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("��Ƶ·����");
		lblNewLabel_3.setBounds(870, 218, 68, 15);
		getContentPane().add(lblNewLabel_3);
		
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
		
		// Ϊ����޸İ�ť����¼�
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedRow=Table.table.getSelectedRow();
				Video oldVideo=new Video((String)Table.table.getValueAt(selectedRow, 1),(String)Table.table.getValueAt(selectedRow, 0),(String)Table.table.getValueAt(selectedRow, 2),(String)Table.table.getValueAt(selectedRow, 3));
				
				// ����ı���
				lblNewLabel.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				
				// ���ı���ֵ
				lblNewLabel.setText("��Ƶ�ţ�"+oldVideo.getVnum());
				textField.setText(oldVideo.getCid());
				textField_1.setText(oldVideo.getVname());
				textField_2.setText(oldVideo.getVpath());
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
				Video newVideo=new Video(lblNewLabel.getText().substring(4),textField.getText(),textField_1.getText(),textField_2.getText());
				if(ServiceFactory.getIAdminServiceInstance().updateVideo(newVideo)) {
					Table.table.setValueAt(newVideo.getCid(), selectedRow, 1);
					Table.table.setValueAt(newVideo.getVname(), selectedRow, 2);
					Table.table.setValueAt(newVideo.getVpath(), selectedRow, 3);
					Table.model.fireTableDataChanged();
					JOptionPane.showMessageDialog(updateVideoWindow, "�޸ĳɹ���");
				}else {
					JOptionPane.showMessageDialog(updateVideoWindow, "�޸�ʧ�ܣ�");
				}
			}
		});
	}

	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminUpdateVideoWindow getInstance() {
		return updateVideoWindow;
	}
}
