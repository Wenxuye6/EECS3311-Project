
package Inventory;

public class Test {
	

	

	 public static void main(String[] args) {
		 
		 dumbbell dumb1 = new dumbbell("50kg", 200.5);
		 
		 dumbbell dumb2 = new dumbbell("1000kg", 200.5);
		 
		 
		 Inventory wenxudejia = new Inventory();
		 wenxudejia.adddumbbell(dumb1);
		 wenxudejia.adddumbbell(dumb2);
		 wenxudejia.printdumbbell();	
		 
		 wenxudejia.remove(dumb2);
		 wenxudejia.printdumbbell();
		
		 
		 
		 yogaMat yogaMat1 = new yogaMat("large", 100.0);
		 yogaMat yogaMat2 = new yogaMat("small", 200.0);
		 wenxudejia.adddyogaMat(yogaMat1);
		 wenxudejia.adddyogaMat(yogaMat2);
		wenxudejia.remove(yogaMat1);
		 wenxudejia.printyogaMat();
	  
	 }

	
}

