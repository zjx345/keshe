package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import factory.ServiceFactory;
import tool.Table;
import vo.Video;
/**
 * ����Ϊ����Աɾ����Ƶ����
 * @author zjx
 *
 */
public class AdminDeleteVideoWindow extends AdminFindVideoWindow {

	private static AdminDeleteVideoWindow deleteVideoWindow=new AdminDeleteVideoWindow();
	private JButton deleteButton;  // ɾ����ť
	/**
	 * ��˽�з���Ϊ�޲ι��췽����������ʼ���ô���
	 */
	private AdminDeleteVideoWindow() {
		super();
		setTitle("ɾ����Ƶ");
		deleteButton=new JButton("ɾ    ��");
		deleteButton.setBounds(650, 30, 93, 23);
		getContentPane().add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] seletedRows=Table.table.getSelectedRows();
				if(seletedRows.length>0) {
					for(int i=0;i<seletedRows.length;i++) {
						// �����ݿ���ɾ��
						Video video=new Video((String)Table.table.getValueAt(seletedRows[0], 1),(String)Table.table.getValueAt(seletedRows[i]-i, 0),(String)Table.table.getValueAt(seletedRows[i]-i, 2),(String)Table.table.getValueAt(seletedRows[i]-i, 3));
						ServiceFactory.getIAdminServiceInstance().removeVideo(video);
						// �ӱ����ɾ��
						Table.model.removeRow(seletedRows[0]);
						Table.model.fireTableDataChanged();
					}
					JOptionPane.showMessageDialog(deleteVideoWindow, "ɾ���ɹ���");
				}else {
					JOptionPane.showMessageDialog(deleteVideoWindow, "û��ѡ����Ҫɾ�����У�");
				}
			}
		});
	}
	
	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static AdminDeleteVideoWindow getInstance() {
		return deleteVideoWindow;
	}
}
