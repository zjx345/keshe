package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vo.Admin;
/**
 * ����Ϊ����Ա������
 * @author zjx
 *
 */
public class AdminManagerWindow extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private Admin admin;
	/**
	 * �÷���Ϊ������Ա�εĹ��췽����������ʼ���ô���
	 * @param admin �����ô��ڵĹ���Ա
	 */
	public AdminManagerWindow(Admin admin) {
		this.admin=admin;
		setTitle("\u5728\u7EBF\u8BFE\u7A0B\u5B66\u4E60\u7CFB\u7EDF\u540E\u53F0\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		// �������
		setExtendedState(this.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane() {
			@Override
			protected void paintComponent(Graphics g) {
				ImageIcon image=new ImageIcon("F:\\ѧϰ\\java\\Java�γ����-���߿γ�ѧϰϵͳ\\�ز�\\�������ֽ.jpg");
				g.drawImage(image.getImage(), 0, 0,image.getIconWidth(), image.getIconHeight(),this); 
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 23);
		desktopPane.add(menuBar);
		
		JMenu personalManagement = new JMenu("\u4E2A\u4EBA\u7BA1\u7406");
		menuBar.add(personalManagement);
		
		
		JMenuItem updatePassword = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		personalManagement.add(updatePassword);
		// Ϊ�޸����������¼�
		updatePassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminUpdatePasswordWindow updatePasswordWindow =AdminUpdatePasswordWindow.getInstance();
				updatePasswordWindow.setAdmin(admin);
				showIFrame(updatePasswordWindow);
			}
		});
		
		
		JMenu accountManagement = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menuBar.add(accountManagement);
		// Ϊ�鿴ѧ������¼�
		JMenuItem findStudent = new JMenuItem("\u67E5\u770B\u5B66\u751F");
		accountManagement.add(findStudent);
		findStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminFindStudentWindow findStudentWindow=AdminFindStudentWindow.getInstance();
				showIFrame(findStudentWindow);
			}
		});
		
		// ����ѧ��
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u589E\u52A0\u5B66\u751F");
		accountManagement.add(mntmNewMenuItem_2);
		// Ϊ����ѧ���˵�����¼�
		mntmNewMenuItem_2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminAddStudentWindow addStudentWindow=AdminAddStudentWindow.getInstance();
				showIFrame(addStudentWindow);
			}
		});
		
		// �޸�ѧ���˵�
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u4FEE\u6539\u5B66\u751F");
		accountManagement.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminUpdateStudentWindow updateStudentWindow=AdminUpdateStudentWindow.getInstance();
				showIFrame(updateStudentWindow);
			}
		});
		
		// ɾ��ѧ���˵�
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5220\u9664\u5B66\u751F");
		accountManagement.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminDeleteStudentWindow deleteStudentWindow=AdminDeleteStudentWindow.getInstance();
				showIFrame(deleteStudentWindow);
			}
		});
		
		JMenu mnNewMenu_2 = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		
		// �鿴�γ�
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u67E5\u770B\u8BFE\u7A0B");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminFindCourseWindow findCourseWindow=AdminFindCourseWindow.getInstance();
				showIFrame(findCourseWindow);
			}
		});
		
		// ��ӿγ�
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u589E\u52A0\u8BFE\u7A0B");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminAddCourseWindow addCourseWindow=AdminAddCourseWindow.getInstance();
				showIFrame(addCourseWindow);
			}
		});
		
		// �޸Ŀγ�
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u4FEE\u6539\u8BFE\u7A0B");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminUpdateCourseWindow updateCourseWindow=AdminUpdateCourseWindow.getInstance();
				showIFrame(updateCourseWindow);
			}
		});
		
		// ɾ���γ�
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u5220\u9664\u8BFE\u7A0B");
		mnNewMenu_2.add(mntmNewMenuItem_8);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminDeleteCourseWindow deleteCourseWindow=AdminDeleteCourseWindow.getInstance();
				showIFrame(deleteCourseWindow);
			}
		});
		
		JMenu mnNewMenu_3 = new JMenu("\u8BFE\u4EF6\u7BA1\u7406");
		menuBar.add(mnNewMenu_3);
		
		// �鿴�μ�
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u67E5\u770B\u8BFE\u4EF6");
		mnNewMenu_3.add(mntmNewMenuItem_9);
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminFindCoursewareWindow findCoursewareWindow=AdminFindCoursewareWindow.getInstance();
				showIFrame(findCoursewareWindow);
			}
		});
		
		// ���ӿμ�
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u589E\u52A0\u8BFE\u4EF6");
		mnNewMenu_3.add(mntmNewMenuItem_10);
		mntmNewMenuItem_10.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminAddCoursewareWindow addCoursewareWindow=AdminAddCoursewareWindow.getInstance();
				showIFrame(addCoursewareWindow);
			}
		});
		
		// �޸Ŀμ�
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u4FEE\u6539\u8BFE\u4EF6");
		mnNewMenu_3.add(mntmNewMenuItem_11);
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminUpdateCoursewareWindow updateCoursewareWindow=AdminUpdateCoursewareWindow.getInstance();
				showIFrame(updateCoursewareWindow);
			}
		});
		
		// ɾ���μ�
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("\u5220\u9664\u8BFE\u4EF6");
		mnNewMenu_3.add(mntmNewMenuItem_12);
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminDeleteCoursewareWindow deleteCoursewareWindow=AdminDeleteCoursewareWindow.getInstance();
				showIFrame(deleteCoursewareWindow);
			}
		});
		
		JMenu mnNewMenu_4 = new JMenu("\u89C6\u9891\u7BA1\u7406");
		menuBar.add(mnNewMenu_4);
		
		// �鿴��Ƶ
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("\u67E5\u770B\u89C6\u9891");
		mnNewMenu_4.add(mntmNewMenuItem_13);
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminFindVideoWindow findVideoWindow=AdminFindVideoWindow.getInstance();
				showIFrame(findVideoWindow);
			}
		});
		
		// �����Ƶ
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("\u589E\u52A0\u89C6\u9891");
		mnNewMenu_4.add(mntmNewMenuItem_14);
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminAddVideoWindow addVideoWindow= AdminAddVideoWindow.getInstance();
				showIFrame(addVideoWindow);
			}
		});
		
		// �޸���Ƶ
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("\u4FEE\u6539\u89C6\u9891");
		mnNewMenu_4.add(mntmNewMenuItem_15);
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminUpdateVideoWindow updateVideoWindow = AdminUpdateVideoWindow.getInstance();
				showIFrame(updateVideoWindow);
			}
		});
		
		// ɾ����Ƶ
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("\u5220\u9664\u89C6\u9891");
		mnNewMenu_4.add(mntmNewMenuItem_16);
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminDeleteVideoWindow deleteVideoWindow = AdminDeleteVideoWindow.getInstance();
				showIFrame(deleteVideoWindow);
			}
		});
	}
	
	/**
	 * �÷���������ʾ�Ӵ���
	 * @param iFrame Ҫ��ʾ���Ӵ���
	 */
	public void showIFrame(JInternalFrame iFrame) {
		int count=desktopPane.getAllFrames().length;  // �Ӵ������
		if(count>=1) {
			return;
		}
		else {
			desktopPane.add(iFrame);
			iFrame.setVisible(true);
			try {
				iFrame.setSelected(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
