package vo;
/**
 * ����Ϊ����Ա��
 * @author zjx
 *
 */
public class Admin {
	private String account; // �˺�
	private String password; // ����
	
	/**
	 * �÷���Ϊ�޲ι��췽��
	 */
	public Admin() {
		super();
	}
	/**
	 * �÷���Ϊ����ȫ�����ԵĹ��췽��
	 * @param account �˺�
	 * @param password ����
	 */
	public Admin(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	/**
	 * ȡ���˺�
	 * @return ����һ���˺��ַ���
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * �����˺�
	 * @param account �˺��ַ�������
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * ȡ������
	 * @return ����һ�������ַ���
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * ��������
	 * @param password �����ַ�������
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
