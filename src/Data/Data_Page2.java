package Data;

public class Data_Page2 {
	private String license[] = {"자격증을 선택해주세요","정보처리기사", "전기기사", 
			"소방설비기사(전기)", "건축기사", "토목기사", "화공기사"};
	
	private String title[] = {"시나공", "이기적", "수제비",
							"초격차", "에듀윌 소방설비기사", "초스피드기억법",
							"미듬","건축기사 4주완성",
							"7개년 과년도 토목기사", "토목기사 4주완성",
							"화공기사 기출문제집 필기", "(Ⅰ.Ⅱ)","2022 화공기사 실기 필답형+작업형"};
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
	private String contnet[] = {"출제 내용을 문장 그대로 개념에 실어뒀다.\nSQL과 프로그래밍이 특히 강점",
								"후기는 많지만 이 수험서만의 강점은 잘 모르겠다.",
								"두음쌤 특유의 암기법으로 암기에 좋다.\n 카페가 있어 공부하기 좋다.",
								"이미지를 통한 설명과, 계산공식을 삽입해 이해 용이",
								"방대한 이론이 핵심위주로 짧게 구성되어있음",
								"수험서의 특징인 초스피드 기억법을 통해 이론,\n용어를 단시간에 습득 가능.",
								"나열식 구조가 아닌 표로 정리해서 파악이 쉽다.\n공기단축 단축 순서마다 변화되는 공정 모두 수록",
								"합격리뷰가 많은 수험서\n분량이 많지않아 짧은기간 공부에 용이함.",
								"명불허전 1위 토목기사 수험서\n빠른 시간 안에 시험 대비가능한 구성",
								"출제경향에 따라 국제단위인 SI단위로 표기\n계산기 SOLVE 사용법을 적용",
								"전공자 및 시험대비 최종정리용으로 좋다", "필수내용 간략화\n 조금의 난이도있음", "필수내용 간략화\\n 조금의 난이도있음"};
							
	
	


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
