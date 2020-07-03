package vo;
/**
 * ����Ϊѧ����
 * @author zjx
 *
 */
public class Student {
	private String account;  // �˺�
	private String password; // ����
	private String name;  // ѧ������
	private String school; // ѧУ����
	private String grade; // �꼶
	private String phone; // �ֻ�����
	
	public Student() {
		
	}
	/**
	 * �÷����Ǵ���ȫ�����ԵĹ��췽��
	 * @param account �˺�
	 * @param password ����
	 * @param name ����
	 * @param school ѧУ
	 * @param grade �꼶
	 * @param phone �ֻ���
	 */
	public Student(String account, String password, String name, String school, String grade, String phone) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.school = school;
		this.grade = grade;
		this.phone = phone;
	}
	
	/**
	 * ȡ���û�������
	 * @return ����һ���˺��ַ���
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * �����û�������
	 * @param account �˺��ַ�������
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * ȡ����������
	 * @return ����һ�������ַ���
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * ������������
	 * @param password �����ַ�������
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * ȡ����������
	 * @return ����һ�������ַ���
	 */
	public String getName() {
		return name;
	}
	/**
	 * ������������
	 * @param name �����ַ�������
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ȡ��ѧУ����
	 * @return ����һ��ѧУ�ַ���
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * ����ѧУ
	 * @param school ѧУ�ַ�������
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * ȡ���꼶����
	 * @return ����һ���꼶�ַ���
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * �����꼶
	 * @param grade �꼶�ַ�������
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * ȡ���ֻ�����
	 * @return ����һ���ֻ������ַ���
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * �����ֻ�����
	 * @param phone �ֻ����ַ�������
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return this.account+" "+this.password+" "+this.name+" "+this.school+" "+this.grade+" "+this.phone;
	}
}
