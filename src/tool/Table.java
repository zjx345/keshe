package tool;

import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 * ����Ϊ��񹤾���
 * @author Lenovo
 *
 */
public class Table {
	
	public static DefaultTableModel model;
	public static JTable table;
	
	/**
	 * �þ�̬���������������
	 * @param contentpane ��ű�������
	 * @param colName ����
	 * @param data �������
	 */
	public static void createTable(Container contentpane,String[] colName,Object[][] data) {
		model=new DefaultTableModel(data,colName);
		table=new JTable(model);
		table.setBounds(50, 80, 605, 190);
		// ������ݾ�����ʾ
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		// �������Ϲ�����
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(50, 80, 800, 460);
		contentpane.add(jsp);
		jsp.setVisible(true);
	}
}
