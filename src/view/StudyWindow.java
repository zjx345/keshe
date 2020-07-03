package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import factory.ServiceFactory;
import vo.Course;
import vo.Courseware;
import vo.Video;
/**
 * ����Ϊ�γ�ѧϰ����
 * @author zjx
 *
 */
public class StudyWindow extends JFrame {
	private JTable table;
	private Course course;  // ��ŵ�ǰҪѧϰ�Ŀγ̶���
	private static JDesktopPane desktopPane;  // ����
	private JLabel label;  // ��ӭ��ǩ
	private static JLabel msgLabel; // �γ̼�顢��ѧ��١��ڿμƻ������ǩ
	private static JLabel vcLabel;  // ��Ƶ���μ������ǩ
	private static JLabel imgLabel;  // ͼƬ��ǩ
	private DefaultTableModel model;
	private JScrollPane coursewareJScrollPane;  // �μ�������
	private JScrollPane videoJScrollPane;  // ��Ƶ������
	private JButton downloadButton;  //���ذ�ť
	private JButton playButton;  //��Ƶ���Ű�ť
	private String cpath;  // �μ�·��
	private String vpath;  // ��Ƶ·��
	private static StudyWindow studyWindow=new StudyWindow();

	static {
		msgLabel=new JLabel();
		msgLabel.setBounds(500, 60, 300, 300);
		msgLabel.setFont(new Font("����", 20, 40));
		desktopPane.add(msgLabel);
		
		vcLabel=new JLabel();
		vcLabel.setBounds(400, -50, 300, 300);
		vcLabel.setFont(new Font("����", 20, 40));
		desktopPane.add(vcLabel);
		
		imgLabel=new JLabel();
		imgLabel.setBounds(0, 50, 300, 300);
		desktopPane.add(imgLabel);
	}
	/**
	 * ��˽�з���Ϊ�޲ι��췽��
	 */
	private StudyWindow() {
		init();
	}
	/**
	 * �÷���������ʼ���ô���
	 */
	public void init() {
		setTitle("\u5728\u7EBF\u8BFE\u7A0B\u5B66\u4E60\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\\u5B66\u4E60\\java\\Java\u8BFE\u7A0B\u8BBE\u8BA1-\u5728\u7EBF\u8BFE\u7A0B\u5B66\u4E60\u7CFB\u7EDF\\\u7D20\u6750\\\u56FE\u6807.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(this.MAXIMIZED_BOTH);  // �������
		
		desktopPane = new JDesktopPane() {
			@Override
			protected void paintComponent(Graphics g) {
				ImageIcon image=new ImageIcon("F:\\ѧϰ\\java\\Java�γ����-���߿γ�ѧϰϵͳ\\�ز�\\�������ֽ.jpg");
				g.drawImage(image.getImage(), 0, 0,image.getIconWidth(), image.getIconHeight(),this); 
			}
		};
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 50);
		desktopPane.add(toolBar);
		
		Object[][] data= {};
		String[] colName= {null};
		model=new DefaultTableModel(data,colName);
		table = new JTable();
		table.setModel(model);
		table.setBounds(310, 290, 605, 190);
		table.setFont(new Font("����", Font.PLAIN, 20));
		table.setRowHeight(30);
		table.setBackground(Color.lightGray);
		desktopPane.add(table);
		table.setOpaque(false);
		table.setShowGrid(false);
		
		label = new JLabel("��ӭѧϰ"+MainWindow.getMainWindow().textField.getText()+"��Ŀ");
		label.setBounds(150, 200, 1000, 200);
		label.setFont(new Font("����", 20, 70));
		desktopPane.add(label);
		
		// �γ̼�鰴ť
		JButton btnNewButton = new JButton("\u8BFE \u7A0B \u7B80 \u4ECB ");
		toolBar.add(btnNewButton);
		toolBar.addSeparator(new Dimension(20,45)); // �ָ���
		// ���ӿγ̼���¼�
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String presentation=course.getPresentation();
				imgLabel.setIcon(new ImageIcon("F:\\ѧϰ\\java\\Java�γ����-���߿γ�ѧϰϵͳ\\�ز�2\\6.gif"));
				imgLabel.setVisible(true);
				
				msgLabel.setText("�γ̼��");
				msgLabel.setVisible(true);
				vcLabel.setVisible(false);
				printCourseInfo(presentation);
			}
		});
		
		// ��ѧ��ٰ�ť
		JButton btnNewButton_1 = new JButton("\u6559 \u5B66 \u5927 \u7EB2 ");
		toolBar.add(btnNewButton_1);
		toolBar.addSeparator(new Dimension(20,45)); // �ָ���
		// ���Ӱ�ť�¼�
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String syllabus=course.getSyllabus();
				
				imgLabel.setIcon(new ImageIcon("F:\\ѧϰ\\java\\Java�γ����-���߿γ�ѧϰϵͳ\\�ز�2\\3.gif"));
				imgLabel.setVisible(true);
				
				msgLabel.setText("��ѧ���");
				msgLabel.setVisible(true);
				vcLabel.setVisible(false);
				printCourseInfo(syllabus);
			}
		});
		
		// �ڿμƻ���ť
		JButton btnNewButton_2 = new JButton("\u6388 \u8BFE \u8BA1 \u5212 ");
		toolBar.add(btnNewButton_2);
		toolBar.addSeparator(new Dimension(20,45)); // �ָ���
		// ���Ӱ�ť�¼�
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String plan=course.getPlan();
				
				imgLabel.setIcon(new ImageIcon("F:\\ѧϰ\\java\\Java�γ����-���߿γ�ѧϰϵͳ\\�ز�2\\4.gif"));
				imgLabel.setVisible(true);
				
				msgLabel.setText("�ڿμƻ�");
				msgLabel.setVisible(true);
				vcLabel.setVisible(false);
				printCourseInfo(plan);
			}
		});
		
		// ��Ƶ��ť
		JButton btnNewButton_3 = new JButton("\u6559 \u5B66 \u89C6 \u9891 ");
		toolBar.add(btnNewButton_3);
		toolBar.addSeparator(new Dimension(20,45)); // �ָ���
		// ���Ӱ�ť�¼�
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setVisible(false);
				
				imgLabel.setVisible(false);
				msgLabel.setVisible(false);
				vcLabel.setText("��ѧ��Ƶ");
				vcLabel.setVisible(true);
				// ���ؿμ����
				if(coursewareJScrollPane!=null) {
					coursewareJScrollPane.setVisible(false);
					downloadButton.setVisible(false);
				}
				// ���ؿγ���Ϣ���
				model.setRowCount(0);
				String[] colName= {"��Ƶ���","��Ƶ��"};
				Object[][] data=new Object[100000][100];
				ArrayList<Video> al=ServiceFactory.getIStudentServiceInstance().findAllVideo(course.getCno());
				int i=0;
				for(Video video:al) {
					data[i][0]=video.getVnum();
					data[i][1]=video.getVname();
					i++;
				}
				DefaultTableModel model=new DefaultTableModel(data,colName);
				JTable table=new JTable(model);
				//table.setEnabled(false);
				// ������ݾ�����ʾ
				DefaultTableCellRenderer r=new DefaultTableCellRenderer();
				r.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, r);
				
				// ����������굥��������
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// ѡ�����л�ȡ·��
						int row=table.getSelectedRow();
						String vnum=(String)model.getValueAt(row, 0);
						if(vnum!=null) {
							for(Video video:al) {
								if(vnum.equals(video.getVnum())) {
									vpath=video.getVpath();
									break;
								}
							}
						}
					}
				});
				// �������Ϲ�����
				videoJScrollPane=new JScrollPane(table);
				videoJScrollPane.setBounds(100, 130, 800, 460);
				desktopPane.add(videoJScrollPane);
				videoJScrollPane.setVisible(true);
				
				// ���ذ�ť
				playButton = new JButton("������Ƶ");
				playButton.setBounds(790, 60, 111, 23);
				desktopPane.add(playButton);
				playButton.setVisible(true);
				// �������ذ�ť�¼�
				playButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ServiceFactory.getIStudentServiceInstance().watchVideo(vpath);
					}
				});
			}
		});
		
		// �μ���ť
		JButton btnNewButton_4 = new JButton(" \u8BFE         \u4EF6 ");
		toolBar.add(btnNewButton_4);
		
		// �����¼�
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setVisible(false);
				
				imgLabel.setVisible(false);
				msgLabel.setVisible(false);
				vcLabel.setText("��    ��");
				vcLabel.setVisible(true);
				// ������Ƶ���
				if(videoJScrollPane!=null) {
					videoJScrollPane.setVisible(false);
					playButton.setVisible(false);
				}
				// ���ؿγ���Ϣ���
				model.setRowCount(0);
				String[] colName= {"�μ����","�μ���","�μ���С"};
				Object[][] data=new Object[100000][100];
				ArrayList<Courseware> al=ServiceFactory.getIStudentServiceInstance().findAllCourseware(course.getCno());
				int i=0;
				for(Courseware courseware:al) {
					data[i][0]=courseware.getCnum();
					data[i][1]=courseware.getKname();
					data[i][2]=courseware.getSize();
					i++;
				}
				DefaultTableModel model=new DefaultTableModel(data,colName);
				JTable table=new JTable(model);
				//table.setEnabled(false);
				// ������ݾ�����ʾ
				DefaultTableCellRenderer r=new DefaultTableCellRenderer();
				r.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, r);
				
				// ����������굥��������
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// ѡ�����л�ȡ·��
						int row=table.getSelectedRow();
						String cnum=(String)model.getValueAt(row, 0);
						for(Courseware courseware:al) {
							if(cnum.equals(courseware.getCnum())) {
								cpath=courseware.getCpath();
								break;
							}
						}
					}
				});

				coursewareJScrollPane=new JScrollPane(table);
				coursewareJScrollPane.setBounds(100, 130, 800, 460);
				desktopPane.add(coursewareJScrollPane);
				coursewareJScrollPane.setVisible(true);
				
				// ���ذ�ť
				downloadButton = new JButton("\u5F00 \u59CB \u4E0B \u8F7D ");
				downloadButton.setBounds(790, 60, 111, 23);
				desktopPane.add(downloadButton);
				downloadButton.setVisible(true);
				// �������ذ�ť�¼�
				downloadButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(ServiceFactory.getIStudentServiceInstance().downloadCourseware(cpath)) {
							JOptionPane.showMessageDialog(studyWindow, "���سɹ���");
						}else {
							JOptionPane.showMessageDialog(studyWindow, "����ʧ�ܣ�");
						}
					}
				});
			}
		});
	}
	/**
	 * �þ�̬��������ȡ���ô��ڶ���
	 * @return ���ظô��ڶ���
	 */
	public static StudyWindow getStudyWindow() {
		return studyWindow;
	}
	/**
	 * �÷����������ÿγ�
	 * @param course Ҫ���õĿγ�
	 */
	public void setCourse(Course course) {
		this.course=course;
	}
	/**
	 * �÷���������ʾ�γ���Ϣ
	 * @param msg Ҫ��ʾ�Ŀγ�����
	 */
	public void printCourseInfo(String msg) {
		model.setRowCount(0);
		label.setVisible(false);
		if(coursewareJScrollPane!=null) {
			coursewareJScrollPane.setVisible(false);
			downloadButton.setVisible(false);
		}
		if(videoJScrollPane!=null) {
			videoJScrollPane.setVisible(false);
			playButton.setVisible(false);
		}
		int row=(int)Math.ceil(msg.length()/30.0);
		for(int i=0;i<row;i++) {
			String temp;
			int start_index,end_index;
			if(i==0)
				start_index=0;
			else
				start_index=i*30+1;
			if(i==row-1)
				end_index=msg.length();
			else
				end_index=(i+1)*30;
			temp=msg.substring(start_index,end_index);
			model.addRow(new Object[] {temp});
		}
	}
}
