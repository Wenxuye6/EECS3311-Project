package membership;
import java.util.ArrayList;
import course.java;

public class membership {

	
	private String name;
	private String gender;
	private int age;
	private int remainFund;
	private int bodyindex;
	private ArrayList<course> courses;
	
	
	public int getRemainFund() {
		return remainFund;
	}
	public void setRemainFund(int remainFund) {
		this.remainFund = remainFund;
	}
	public int getBodyindex() {
		return bodyindex;
	}
	public void setBodyindex(int bodyindex) {
		this.bodyindex = bodyindex;
	}
	

	public membership(String name, String gender, int age, int remainFund, int bodyindex) {
		
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.remainFund = remainFund;
		this.bodyindex = bodyindex;
		this.courses = new ArrayList<course>();
	}
	
	public void addcourse(String name, int price, String desc){
		courses.add(new course(name, price, desc));
	
		
	}	
	
	public void showEverything() {
		System.out.println( "membership [name=" + name + ", gender=" + gender + ", age=" + age + ", remainFund=" + remainFund
				+ ", bodyindex=" + bodyindex + "]");
	}
	
	
	
	
}

