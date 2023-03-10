//package Inventory;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<dumbbell> dubbell_list;
	private ArrayList<yogaMat> yogaMat_list;
//	private String legpressMachine;
//	private String latpulldownBar;
//	private String ergometerMachine;
//	private String chestpressMachine;
//	private String hanginglegraiseMachine;
//	private String dumbbell;
//	private String yogaMat;
	
	
	public Inventory() {

		this.dubbell_list = new ArrayList<dumbbell>();
		this.yogaMat_list = new ArrayList<yogaMat>();
	}
	
	
	public void adddumbbell(dumbbell name) {
		dubbell_list.add(name);
	}

	public void remove(dumbbell dumb) {
	System.out.println("The dumbell " + dumb + " has been removed");
	dubbell_list.remove(dumb);}

	
	public void printdumbbell() {
		System.out.println(  "[dubbell list=" );
		for (int i =0 ; i<dubbell_list.size();i++) {
			System.out.println( dubbell_list.get(i).toString() + "]");
		}
		
	}
	
	public void adddyogaMat(yogaMat name) {
		yogaMat_list.add(name);
	}

	public void remove(yogaMat yogamat) {
	System.out.println("The yogamat " + yogamat + " has been removed");
	yogaMat_list.remove(yogamat);}

	
	public void printyogaMat() {
		System.out.println(  "[yogaMat list=" );
		for (int i =0 ; i<yogaMat_list.size();i++) {
			System.out.println( yogaMat_list.get(i).toString() + "]");
		}
		
	}
	
	public void showAll() {
		System.out.println("\n"+dubbell_list.toString()+ yogaMat_list.toString());
	}
	
}


	class dumbbell extends Inventory{
		private String dumbbellName;
		private double dumbbellPrice;

	
	
		public dumbbell(String dumbbellName, double dumbbellPrice) {
			this.dumbbellName = dumbbellName;
			this.dumbbellPrice = dumbbellPrice;
		}



	@Override
	public String toString() {
		return " [dumbbellName=" + dumbbellName + ", dumbbellPrice=" + dumbbellPrice + "]";
	}

	
	

	}
	
	class yogaMat extends Inventory{
		  private String yogaMatName;
		  private double yogaMatPrice;
		  
		  public yogaMat(String yogaMatName, double yogaMatPrice) {
		   this.yogaMatName = yogaMatName;
		   this.yogaMatPrice = yogaMatPrice;
		  }
		 
		  @Override
		  public String toString() {
		   return " [yogaMatName=" + yogaMatName + ", yogaMatPrice=" + yogaMatPrice + "]";
		  }
	}
	
	
		  
		 


	



//	
//	

//	
//	
//	
//	public double getLegpressPrice() {
//		return legpressPrice;
//	}
//
//	public void setLegpressPrice(double legpressPrice) {
//		this.legpressPrice = legpressPrice;
//	}
//
//	public double getLatpulldownbarPrice() {
//		return latpulldownbarPrice;
//	}
//
//	public void setLatpulldownbarPrice(double latpulldownbarPrice) {
//		this.latpulldownbarPrice = latpulldownbarPrice;
//	}
//
//	public double getErgometerPrice() {
//		return ergometerPrice;
//	}
//
//	public void setErgometerPrice(double ergometerPrice) {
//		this.ergometerPrice = ergometerPrice;
//	}
//
//	public double getChestpressPrice() {
//		return chestpressPrice;
//	}
//
//	public void setChestpressPrice(double chestpressPrice) {
//		this.chestpressPrice = chestpressPrice;
//	}
//
//	public double getHanginglegraisePrice() {
//		return hanginglegraisePrice;
//	}
//
//	public void setHanginglegraisePrice(double hanginglegraisePrice) {
//		this.hanginglegraisePrice = hanginglegraisePrice;
//	}
//
//	public double getDumbbellPrice() {
//		return dumbbellPrice;
//	}
//
//	public void setDumbbellPrice(double dumbbellPrice) {
//		this.dumbbellPrice = dumbbellPrice;
//	}
//
//	public double getYogamatPrice() {
//		return yogamatPrice;
//	}
//
//	public void setYogamatPrice(double yogamatPrice) {
//		this.yogamatPrice = yogamatPrice;
//	}
//
//	public void update(double legpressPrice, double latpulldownbarPrice, double ergometerPrice, 
//			double chestpressPrice, double hanginglegraisePrice, double dumbbellPrice, double yogamatPrice ) {
//		this.legpressPrice = legpressPrice;
//		this.latpulldownbarPrice = latpulldownbarPrice;
//		this.ergometerPrice = ergometerPrice;
//		this.chestpressPrice = chestpressPrice;
//		this.hanginglegraisePrice = hanginglegraisePrice;
//		this.dumbbellPrice = dumbbellPrice;
//		this.yogamatPrice = yogamatPrice;
//		
//		printThePrice();
//	}
//	
//	public void printThePrice() {
//		System.out.println("legpressMachine:" + legpressPrice + "\nlatpulldownBar:" + latpulldownbarPrice +
//				"\nergometerMachine:"+ ergometerPrice + "\nchestpressMachine"+chestpressPrice +"\nhanginglegraiseMachine:"+
//				hanginglegraisePrice + "\ndumbbell:" + dumbbellPrice +"\nyogaMat:" + yogamatPrice + "\n"  );
//	}

