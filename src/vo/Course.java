package vo;
/**
 * ����Ϊ�γ���
 * @author zjx
 *
 */
public class Course{
	private String cno;  // �γ̺�
	private String cname;  // �γ���
	private String presentation; // �γ̼��
	private String syllabus;   // ��ѧ���
	private String plan; // �ڿμƻ�
	/**
	 * �޲ι���
	 */
	public Course() {}
	/**
	 * �÷����Ǵ���ȫ�����ԵĹ��췽��
	 * @param cno �γ̺�
	 * @param cname �γ���
	 * @param presentation �γ̼��
 	 * @param syllabus ��ѧ���
	 * @param plan �ڿμƻ�
	 */
	public Course(String cno, String cname, String presentation, String syllabus, String plan) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.presentation = presentation;
		this.syllabus = syllabus;
		this.plan = plan;
	}
	/**
	 * ȡ���γ̵Ŀγ̺�
	 * @return ����һ���γ̺��ַ���
	 */
	public String getCno() {
		return cno;
	}
	/**
	 * ���ÿγ̺�
	 * @param cno �γ̺��ַ�������
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}
	/**
	 * ȡ���γ���
	 * @return ����һ���γ����ַ���
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * ���ÿγ���
	 * @param cname �γ����ַ�������
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * ȡ���γ̼��
	 * @return ����һ���γ̼���ַ���
	 */
	public String getPresentation() {
		return presentation;
	}
	/**
	 * ���ÿγ̼��
	 * @param presentation �γ̼���ַ�������
	 */
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	/**
	 * ȡ����ѧ���
	 * @return ����һ����ѧ����ַ���
	 */
	public String getSyllabus() {
		return syllabus;
	}
	/**
	 * ���ý�ѧ���
	 * @param syllabus ��ѧ����ַ�������
	 */
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	/**
	 * ȡ���ڿμƻ�
	 * @return ����һ���ڿμƻ��ַ���
	 */
	public String getPlan() {
		return plan;
	}
	/**
	 * �����ڿμƻ�
	 * @param plan �ڿμƻ��ַ�������
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}
}
