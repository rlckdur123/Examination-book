package Data;

public class Data_Page1 {
	private String license[] = {"자격증을 선택해주세요","정보처리 산업기사", "전기산업기사", "위험물산업기사", "산업안전산업기사", "사무자동화산업기사",
			"공조냉동기계산업기사", "가스산업기사", "건설안전산업기사" };
	
	private String title[] = {"시나공 정보처리", "이기적 정보처리산업기사",
							"2022 전기산업기사 실기 (한국전기설비규정(KEC)", "2022 전기산업기사실기 (26년간 기출문제집 & 동영상)", "E60-2",
							"2022 위험물 산업기사 필기", "원큐패스 위험물산업기사 실기", "2022 위험물산업기사 필기+실기 (무료 동영상 강의 수록/CBT",
							"2023 산업안전산업기사 과년도문제해설", "2022 산업안전산업기사 실기 (필답형+작업형)", "2022 산업안전산업기사 실기 (필답형+작업형)",
							"이기적 사무자동화산업기사", "시나공 총정리", "시나공 기출문제집",
							"2022 공조냉동기계산업기사 실기 (21년 동영상 주관식 기출", "모아",
							"가스산업기사 실기 (필답형.동영상/최근20년간 과년도", "Win-Q", "2023 가스산업기사 필기 총정리 (과년도 출제문제 중심)",
							"2023 건설안전산업기사 필기 (ONLY ONE 합격교재 전과목 7","2023 건설안전산업기사 필기 (ONLY ONE 합격교재 전과목 7","2022 건설안전산업기사 필기 (건설안전산업기사 필기 대비 | "};
	
	private String title_url[] = {"https://sinagong.gilbut.co.kr/it",
								"https://license.youngjin.com/",
								"https://www.yoonjo.co.kr/yoonjo/",
								"https://dongilbook.com/",
								"https://www.ent1.co.kr/",
								"http://yeamoonsa.com/sub/index.php",
								"http://www.darakwon.co.kr/",
								"https://dangerpsg_pro.cyber.co.kr/",
								"http://www.unbooks.co.kr/",
								"https://sehwa.biz/",
								"http://kuhminsa.co.kr/",
								"https://license.youngjin.com/",
								"https://www.gilbut.co.kr/", 
								"https://www.gilbut.co.kr/",
								"", "https://www.moa-ba.com/?gclid=CjwKCAiAhKycBhAQEiwAgf19en0yd33GWLqT4a1NQMcT1Sw7U5USx_ZpbANHJSP7oeUO68Xf7DtWfBoCUh0QAvD_BwE",
								"https://www.iljinsa.com/shop/main/index.php",
								"https://www.sdedu.co.kr/popkon/",
								"https://www.iljinsa.com/shop/main/index.php",
								"https://sehwa.biz/", "https://sehwa.biz/",
								"http://yeamoonsa.com/sub/index.php"};

	private String contnet[] = {"출제 내용을 문장 그대로 개념에 실어뒀다.\nSQL과 프로그래밍이 특히 강점",
							"출제기준에 맞춰 다양한 유형의 예상문제와 모의고사를 수록하였다.",
							"코멘트 없음",
							"무료 유투브 강의 제공",
							"기출문제 기반으로 난이도분석",
							"수험생들이 단기간에 취득할 수 있도록 책의 내용을 구성.",
							"무료 동영상 강의 제공\n 정보 제공 카페 운영",
							"해설에 집중한 기출문제 풀이 제공",
							"유니크한 문제풀이 제공",
							"반드시 알아야 할 법규내용만을 정리",
							"오랜 강의경험과 노하우를 통해 필요한 부분에대한 설명\n★로 표시하여 합격에 최적화",
							"[별책] 기출공략집에서 자주 출제되는 기출문제 190선과\n 기출공략문제 5회분을 통해 시험 유형을 파악할 수 있다.",
							"합격에 꼭 필요한 핵심 개념을 짧게 공부하고 기출문제로\n 바로 확인시켜 지루하지 않게 학습할 수 있습니다.",
							"합격에 꼭 필요한 핵심 개념을 짧게 공부하고 기출문제로\n 바로 확인시켜 지루하지 않게 학습할 수 있습니다.",
							"풀이의 이해를 돕기 위하여 참고적인 해설을 많이 수록\n정확한 답과 명쾌한 해설",
							"공학 단위를 SI단위로 환산하여 예상문제 수록",
							"문제 난이도에 따른 요점식 해설\n과년도 출제문제 철저히 분석",
							"핵심이론만으로는 아쉬운 내용을 보충 학습\n기출복원문제를 통하여 가장 최신의 출제경향을 파악",
							"문제 난이도에 따른 요점식 해설\n과년도 출제문제 철저히 분석",
							"1회에서 이해하지 못하더라도 2회 4회에서 반드시\n이해되는 구성",
							"1회에서 이해하지 못하더라도 2회 4회에서 반드시\n 이해되는 구성",
							"건설안전전문가로서 안전에 관한 전문가로서 수록"};

	public Data_Page1() {
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
