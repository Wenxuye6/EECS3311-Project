package Inventory;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<String> inventory;
	private String legpressMachine;
	private String latpulldownBar;
	private String ergometerMachine;
	private String chestpressMachine;
	private String hanginglegraiseMachine;
	private String dumbbell;
	private String yogaMat;
	
	
	private double legpressPrice;
	private double latpulldownbarPrice;
	private double ergometerPrice;
	private double chestpressPrice;
	private double hanginglegraisePrice;
	private double dumbbellPrice;
	private double yogamatPrice;
	
	
	public Inventory() {
		inventory = new ArrayList<String>();
	}
	
	public void register(String newMachine) {
		inventory.add(newMachine);
	}
	
	public void remove(String deletwMachine) {
		int deleteIndex = inventory.indexOf(deletwMachine);
		System.out.println("The Machine" + (deleteIndex+1) + "has been removed");
		inventory.remove(deleteIndex);
	}
	
	public double getLegpressPrice() {
		return legpressPrice;
	}

	public void setLegpressPrice(double legpressPrice) {
		this.legpressPrice = legpressPrice;
	}

	public double getLatpulldownbarPrice() {
		return latpulldownbarPrice;
	}

	public void setLatpulldownbarPrice(double latpulldownbarPrice) {
		this.latpulldownbarPrice = latpulldownbarPrice;
	}

	public double getErgometerPrice() {
		return ergometerPrice;
	}

	public void setErgometerPrice(double ergometerPrice) {
		this.ergometerPrice = ergometerPrice;
	}

	public double getChestpressPrice() {
		return chestpressPrice;
	}

	public void setChestpressPrice(double chestpressPrice) {
		this.chestpressPrice = chestpressPrice;
	}

	public double getHanginglegraisePrice() {
		return hanginglegraisePrice;
	}

	public void setHanginglegraisePrice(double hanginglegraisePrice) {
		this.hanginglegraisePrice = hanginglegraisePrice;
	}

	public double getDumbbellPrice() {
		return dumbbellPrice;
	}

	public void setDumbbellPrice(double dumbbellPrice) {
		this.dumbbellPrice = dumbbellPrice;
	}

	public double getYogamatPrice() {
		return yogamatPrice;
	}

	public void setYogamatPrice(double yogamatPrice) {
		this.yogamatPrice = yogamatPrice;
	}

	public void update(double legpressPrice, double latpulldownbarPrice, double ergometerPrice, 
			double chestpressPrice, double hanginglegraisePrice, double dumbbellPrice, double yogamatPrice ) {
		this.legpressPrice = legpressPrice;
		this.latpulldownbarPrice = latpulldownbarPrice;
		this.ergometerPrice = ergometerPrice;
		this.chestpressPrice = chestpressPrice;
		this.hanginglegraisePrice = hanginglegraisePrice;
		this.dumbbellPrice = dumbbellPrice;
		this.yogamatPrice = yogamatPrice;
		
		printThePrice();
	}
	
	public void printThePrice() {
		System.out.println("legpressMachine:" + legpressPrice + "\nlatpulldownBar:" + latpulldownbarPrice +
				"\nergometerMachine:"+ ergometerPrice + "\nchestpressMachine"+chestpressPrice +"\nhanginglegraiseMachine:"+
				hanginglegraisePrice + "\ndumbbell:" + dumbbellPrice +"\nyogaMat:" + yogamatPrice + "\n"  );
	}
}
