package membership;

import java.util.Scanner;

public class membership {

	
	private String name;
	private int answer;
	private String gender;
	private int age;
	private int number;
	private int addMoney;


	private int remainFund=0;
	private int bodyindex;
	private int price;
	private int fund;
	
	
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
		this.answer=answer;
		this.remainFund = remainFund;
		this.bodyindex = bodyindex;
		this.price=price;
		
	}
	


	
//type the personal information;	
	public void showInformation() {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter username");
	    name = myObj.nextLine();  // Read user input
	    System.out.println("Enter gender");
	    gender = myObj.nextLine();
	    Scanner myInput = new Scanner( System.in );
	    System.out.println( "Enter age " );
	    age = myInput.nextInt();
	    
	    Scanner Input = new Scanner( System.in );
	    System.out.print( "The remainFund for your account is"+ remainFund + "Do you want add more money? 1 for YES, 0 For NO");
	    answer = Input.nextInt();
	    if (answer==1) {
	    	Scanner add = new Scanner( System.in );
	    	System.out.println( "how much you want to add?" );
		    addMoney = add.nextInt();
		    remainFund=remainFund +addMoney;
	    }
	    if (answer==0) {
	    	System.out.println( "loser" );
	    }else {
	    	System.out.println( "Please follow the instruction!" );
	    }

	}
	
//check the remainFund for different age person;
	public int fundCheck() {
			
			if(age<18){
				price=25;
			}
			else {
				if (age>55) {
					price=15;
					}
					else {
						price=35;
						}
			}
		fund = remainFund-price;
		return fund;
		}

	public void showEverything() {
		System.out.println( "membership [name=" + name + ", gender=" + gender + ", age=" + age + ", remainFund=" +  fundCheck() + ", bodyindex=" + bodyindex + "]");
	}
	
	
	
}
