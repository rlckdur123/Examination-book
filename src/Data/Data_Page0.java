package Data;

public class Data_Page0 {
	private String license[] = {"�ڰ����� �������ּ���", "������������ɻ�","�����������ɻ�","������ɻ�",
			"������ɻ�","�ѽ�������ɻ�","���������ɻ�","�߽�������ɻ�","�Ͻ�������ɻ�"
			,"�̿��(�Ϲ�)","�̿��(�Ǻ�)","�̿��(����)","�̿��(����ũ��)"};
	
	private String title[] = {};
	
	private String title_url[] = {};
	
	private String contnet[] = {};
	
	public Data_Page0() {
		String license[] = this.license;
		String title[] = this.title;
		String title_url[] = this.title_url;
		String content[] = this.contnet;
	}
	
	public String[] getTitle() {
		return title;
	}

	public void setTitle(String[] title) {
		this.title = title;
	}

	public String[] getTitle_url() {
		return title_url;
	}

	public void setTitle_url(String[] title_url) {
		this.title_url = title_url;
	}

	public String[] getContnet() {
		return contnet;
	}

	public void setContnet(String[] contnet) {
		this.contnet = contnet;
	}

	public String[] getLicense() {
		return license;
	}
	public void setLicense(String[] license) {
		this.license = license;
	}
}
