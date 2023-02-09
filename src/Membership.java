package membership;
import java.util.Scanner;

/*This class requair user to type personal imformation(eg.name, gender...), calculate the body fat rate by considering person's weight and height. 
print the membership card with basic imfromation; */

public class membership {	
// declare and initialize twelve variables;
	public String name;
	public String gender;
	public String bodyFat;
	public int answer;
	public int age;
	public int addMoney;
	public int bodyindex;
	public int bodyFatRate;
	public int weight;
	public int height;
	public int price;
	public int fund;
	
//declare and initialize remaining fund for membership account;
	public int remainFund=0;
	

//Constructor
	public membership(String name, String gender, int age, int remainFund, int bodyindex) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.answer=answer;
		this.remainFund = remainFund;
		this.bodyindex = bodyindex;
		this.price=price;
	}
	
//This method require user to type the personal information and choose whether to add money to account;
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
	    System.out.print( "The remainFund for your account is"+ " = "+ remainFund + " " + " ."+ "Do you want add more money? 1 for YES, 0 For NO");
	    answer = Input.nextInt();
	    if (answer!=1&answer!=0) {
	    	System.out.println( "Please follow the instruction!" );
	    }else {	    
	    	if (answer==1) {
	    		Scanner add = new Scanner( System.in );
	    		System.out.println( "how much you want to add?" );
	    		addMoney = add.nextInt();
	    		remainFund=remainFund +addMoney;
	    	}
	    	else  {
	    		System.out.println( "loser" );
	    }
	    }
	}	
	
//Check which level payment base on the age, deduct money from account
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
	
//show the bodyindex;
	public String bodyCheck() {
		Scanner H = new Scanner( System.in );
	    System.out.print( "Enter your height (cm)");
	    height = H.nextInt();
	    
		Scanner W = new Scanner( System.in );
	    System.out.print( "Enter your weight (Kg)");
	    weight = W.nextInt();
	    height=height/100;

	    bodyFatRate=weight/(height*height);

	    if (bodyFatRate>50) {	
	    	bodyFat="notHealthy";
	    }else {
	    		if (bodyFatRate<10) {
	    				bodyFat="Healthy";
	    			}else {
	    				bodyFat="justOk";
	    			}
	    }
	    return bodyFat;
	}
	
// Show all the personal information
	public void showMemberCard() {
		System.out.println( "Membership [name=" + name + ", gender=" + gender + ", age=" + age+", " +"weight="+weight +", "+"height="+" "+height +"]");
		System.out.println("Personal information [remainFund=" + fundCheck()+" "+ "bodyindex = "+ bodyFat+"]");
	}
	
}

