package Data;

public class Data_Page2 {
	private String license[] = {"�ڰ����� �������ּ���","����ó�����", "������", 
			"�ҹ漳����(����)", "������", "�����", "ȭ�����"};
	
	private String title[] = {"�ó���", "�̱���", "������",
							"�ʰ���", "������ �ҹ漳����", "�ʽ��ǵ����",
							"�̵�","������ 4�ֿϼ�",
							"7���� ���⵵ �����", "����� 4�ֿϼ�",
							"ȭ����� ���⹮���� �ʱ�", "(��.��)","2022 ȭ����� �Ǳ� �ʴ���+�۾���"};
	private String title_url[] = {"https://sinagong.gilbut.co.kr/it",
								"https://license.youngjin.com/",
								"https://it.wannaedu.com/",
								"",
								"","",
								"http://www.yeamoonsa.com/sub/sub_movie.php?s_search=&s_category=%EA%B1%B4%EC%B6%95",
								"https://www.inup.co.kr/center/main/main1.jsp",
								"",
								"https://www.inup.co.kr/center/main/main1.jsp",
								"https://www.yadoc.co.kr/lecture/lecture_main.html?ca_id=2&ca_sen_id=1716&gclid=CjwKCAiAhKycBhAQEiwAgf19euElYjaiZ1JoLNykhn4BKFw9fqMO547e7qEANDrKq-7txn23xctMzBoCYmcQAvD_BwE",
								"http://www.yeamoonsa.com/sub/index.php", 
								"http://www.yeamoonsa.com/sub/index.php"};
	private String contnet[] = {"���� ������ ���� �״�� ���信 �Ǿ�״�.\nSQL�� ���α׷����� Ư�� ����",
								"�ı�� ������ �� ���輭���� ������ �� �𸣰ڴ�.",
								"������ Ư���� �ϱ������ �ϱ⿡ ����.\n ī�䰡 �־� �����ϱ� ����.",
								"�̹����� ���� �����, �������� ������ ���� ����",
								"����� �̷��� �ٽ����ַ� ª�� �����Ǿ�����",
								"���輭�� Ư¡�� �ʽ��ǵ� ������ ���� �̷�,\n�� �ܽð��� ���� ����.",
								"������ ������ �ƴ� ǥ�� �����ؼ� �ľ��� ����.\n������� ���� �������� ��ȭ�Ǵ� ���� ��� ����",
								"�հݸ��䰡 ���� ���輭\n�з��� �����ʾ� ª���Ⱓ ���ο� ������.",
								"������� 1�� ����� ���輭\n���� �ð� �ȿ� ���� ��񰡴��� ����",
								"�������⿡ ���� ���������� SI������ ǥ��\n���� SOLVE ������ ����",
								"������ �� ������ �������������� ����", "�ʼ����� ����ȭ\n ������ ���̵�����", "�ʼ����� ����ȭ\\n ������ ���̵�����"};
							
	
	


	public Data_Page2() {
		String license[] = this.license;
		String title[] = this.title;
		String title_url[] = this.title_url;
		String content[] = this.contnet;
	}
	
	public String[] getTitle() {
		return title;
	}
	
	
	public String[] getContnet() {
		return contnet;
	}

	public void setContnet(String[] contnet) {
		this.contnet = contnet;
	}

	public String[] getTitle_url() {
		return title_url;
	}

	public void setTitle_url(String[] title_url) {
		this.title_url = title_url;
	}

	public void setTitle(String[] title) {
		this.title = title;
	}
	
	public String[] getLicense() {
		return license;
	}
	public void setLicense(String[] license) {
		this.license = license;
	}
}
