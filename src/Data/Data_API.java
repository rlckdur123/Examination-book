package Data;

import java.util.ArrayList;


public class Data_API {
	
	private static ArrayList<Data_API> list = new ArrayList<Data_API>();
	private String title;
	private String link;
	private String image;
	private String author;
	private String discount;	//판매가격
	private String publisher;	//출판사
	private String pubdate;		//출간일
	private String description;	//도서소개
	
	public Data_API() {
	
	}
	
	public Data_API(String title, String link, String image, String author, String discount, String publisher, String pubdate, String description) {
		this.title = title;
		this.link = link;
		this.image = image;
		this.author = author;
		this.discount = discount;	//판매가격
		this.publisher = publisher;	//출판사
		this.pubdate = pubdate;	//출간일
		this.description = description;	//도서소개
	}
	
	public ArrayList<Data_API> getList() {
		return list;
	}
	public void setList(ArrayList<Data_API> list) {
		Data_API.list = list;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
