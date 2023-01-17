package Data;

public class Data_Page0 {
	private String license[] = {"자격증을 선택해주세요", "지게차운전기능사","굴착기운전기능사","제과기능사",
			"제빵기능사","한식조리기능사","양식조리기능사","중식조리기능사","일식조리기능사"
			,"미용사(일반)","미용사(피부)","미용사(네일)","미용사(메이크업)"};
	
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
