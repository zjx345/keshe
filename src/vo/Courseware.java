package vo;
/**
 * ����Ϊ�μ�ʵ����
 * @author zjx
 *
 */
public class Courseware {
	private String cid; // �γ̺�
	private String cnum; // �μ���
	private String kname; // �μ���
	private String cpath; // �μ�·��
	private String size;  // �μ���С
	/**
	 * �÷���Ϊ�޲ι��췽��
	 */
	public Courseware() {
		super();
	}
	/**
	 * �÷�����ȫ�����Բ����Ĺ��췽��
	 * @param cid �γ̺�
	 * @param cnum �μ���
	 * @param kname �μ���
	 * @param cpath �μ�·��
	 * @param size �μ���С
	 */
	public Courseware(String cid, String cnum, String kname, String cpath, String size) {
		super();
		this.cid = cid;
		this.cnum = cnum;
		this.kname = kname;
		this.cpath = cpath;
		this.size = size;
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
	 * ȡ���μ���
	 * @return ����һ���μ����ַ���
	 */
	public String getCnum() {
		return cnum;
	}
	/**
	 * ���ÿμ���
	 * @param cnum �μ����ַ�������
	 */
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	/**
	 * ȡ���μ���
	 * @return ����һ���μ����ַ���
	 */
	public String getKname() {
		return kname;
	}
	/**
	 * ���ÿμ���
	 * @param kname �μ����ַ�������
	 */
	public void setKname(String kname) {
		this.kname = kname;
	}
	/**
	 * ȡ���μ�·��
	 * @return ����һ���μ�·���ַ���
	 */
	public String getCpath() {
		return cpath;
	}
	/**
	 * ���ÿμ�·��
	 * @param cpath �μ�·���ַ�������
	 */
	public void setCpath(String cpath) {
		this.cpath = cpath;
	}
	/**
	 * ȡ���μ���С
	 * @return ����һ��string���͵Ŀμ���С
	 */
	public String getSize() {
		return size;
	}
	/**
	 * ���ÿμ���С
	 * @param size String���͵Ŀμ���С����
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
