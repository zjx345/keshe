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
import vo.Courseware;
import vo.Video;
/**
 * ����Ϊ����Ա������Ƶ����
 * @author zjx
 *
 */
public class AdminFindVideoWindow extends JInternalFrame {
	private static AdminFindVideoWindow findVideoWindow=new AdminFindVideoWindow();
	private JTextField textField;
	ArrayList<Video> al; // �������Ҫ��ʾ����Ƶ
	private int type=1; // ������ʶ��ʲô�ֶ�������

	/**
	 * �÷���Ϊ�޲ι��췽����������ʼ������
	 */
	public AdminFindVideoWindow() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("�鿴��Ƶ��Ϣ");
		setBounds(10, 30, 900, 600);
		getContentPane().setLayout(null);
		// ���������ʾ������Ƶ
		al=ServiceFactory.getIAdminServiceInstance().searchAllVideo();
		String[] colName= {"        ��Ƶ��","        �γ̺�","        ��Ƶ��","      ��Ƶ·��"};
		String[][] data=new String[100000][5];
		int i=0;
		for(Video video : al) {
			data[i][0]=video.getVnum();
			data[i][1]=video.getCid();
			data[i][2]=video.getVname();
			data[i][3]=video.getVpath();
			i++;
		}
		Table.createTable(getContentPane(),colName, data);
		
		// ���������б�������������ť
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 30, 106, 23);
		getContentPane().add(comboBox);
		comboBox.addItem("���γ̺Ų�ѯ��");
		comboBox.addItem("����Ƶ�Ų�ѯ��");
		comboBox.addItem("����Ƶ����ѯ��");
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
				}else if(e.getItem().equals("����Ƶ�Ų�ѯ��")){
					type=2;
				}else if(e.getItem().equals("����Ƶ����ѯ��")) {
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
				al=ServiceFactory.getIAdminServiceInstance().searchVideo(textField.getText(), type);
				// ��ձ��
				Table.model.getDataVector().clear();
				// ˢ�±��
				Table.model.fireTableDataChanged();
				// ��ʾ������Ƶ
				for(Video video : al) {
					Table.model.addRow(new String[] {video.getVnum(),video.getCid(),video.getVname(),video.getVpath()});
				}
			}
		});
		
		// ������ʾ������Ƶ��ť
		JButton showAllCouButton = new JButton("��ʾ������Ƶ");
		showAllCouButton.setBounds(500, 30, 120, 23);
		getContentPane().add(showAllCouButton);
		showAllCouButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				al=ServiceFactory.getIAdminServiceInstance().searchAllVideo();
				// ��ձ��
				Table.model.getDataVector().clear();
				// ˢ�±��
				Table.model.fireTableDataChanged();
				// ��ʾ����ѧ��
				for(Video video : al) {
					Table.model.addRow(new String[] {video.getVnum(),video.getCid(),video.getVname(),video.getVpath()});
				}
			}
		});
	}

	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminFindVideoWindow getInstance() {
		return findVideoWindow;
	}
}
