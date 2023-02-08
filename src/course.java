package project_version1;

public class course {

	private String name;
	private int price;
	private String desc;
	
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public course() {
		this.desc = "none";
		this.price = -1;
		this.name = "none";
	}
	
	public course(String name, int price, String desc) {
	
		this.name = name;
		this.desc = desc;
		this.price = price;
		
	}
	
	public void showEverything() {
		System.out.println( "[name=" + name + ", price=" + price + ", desc=" + desc + "]");
	}
	
	
	
