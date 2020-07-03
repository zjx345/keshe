package vo;

/**
 * ����Ϊ��Ƶʵ����
 * @author zjx
 *
 */
public class Video {
	private String cid;   // �μ���
	private String vnum; // ��Ƶ��
	private String vname; // ��Ƶ��
	private String vpath; // ��Ƶ·��
	/**
	 * �÷���Ϊ�޲ι��췽��
	 */
	public Video() {
		super();
	}
	/**
	 * �÷���Ϊ��ȫ���εĹ��췽��
	 * @param cid �γ̺��ַ�������
	 * @param vnum �μ����ַ�������
	 * @param vname �μ����ַ�������
	 * @param vpath �μ�·���ַ�������
	 */
	public Video(String cid, String vnum, String vname, String vpath) {
		super();
		this.cid = cid;
		this.vnum = vnum;
		this.vname = vname;
		this.vpath = vpath;
	}
	/**
	 * ȡ���γ̺�
	 * @return ����һ���γ̺��ַ���
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * ���ÿγ̺�
	 * @param cid �γ̺��ַ�������
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * ȡ����Ƶ��
	 * @return ����һ����Ƶ���ַ���
	 */
	public String getVnum() {
		return vnum;
	}
	/**
	 * ������Ƶ��
	 * @param vnum ��Ƶ���ַ�������
	 */
	public void setVnum(String vnum) {
		this.vnum = vnum;
	}
	/**
	 * ȡ����Ƶ��
	 * @return ����һ����Ƶ���ַ���
	 */
	public String getVname() {
		return vname;
	}
	/**
	 * ������Ƶ��
	 * @param vname ��Ƶ���ַ�������
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}
	/**
	 * ȡ����Ƶ·���ַ���
	 * @return ����һ����Ƶ·���ַ���
	 */
	public String getVpath() {
		return vpath;
	}
	/**
	 * ������Ƶ·��
	 * @param vpath ��Ƶ·���ַ�������
	 */
	public void setVpath(String vpath) {
		this.vpath = vpath;
	}
	
}
