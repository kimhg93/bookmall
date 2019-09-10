package kr.co.itcen.bookmall.vo;

public class BookVo {
	private Long no;
	private String name;
	private int price;
	private String category;
	private Long category_no;

	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", name=" + name + ", price=" + price + ", category=" + category + ", category_no="
				+ category_no + "]";
	}	

}
