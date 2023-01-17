package Data;

public class Data_Combo {
	private static int page_num = -1;
	private int index = -1;
	private static String text = null;
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public static int getPage_num() {
		return page_num;
	}
	public static void setPage_num(int page_num) {
		Data_Combo.page_num = page_num;
	}
}

