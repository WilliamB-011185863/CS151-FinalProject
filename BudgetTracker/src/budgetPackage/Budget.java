package budgetPackage;

import java.io.File;
import java.util.ArrayList;

public class Budget {
	String customerName;
	ArrayList<BudgetItem> BudgetList;
	BudgetFileInterface fInterface;
	boolean fileExists;
	Double budgetLimit;

	
	public Budget(String nameInput) {
		this.BudgetList = new ArrayList<BudgetItem>();
		this.customerName = nameInput;
		//this.fileExists = false; //fInterface.CheckFile(nameInput);
		//if (fileExists == true) {
			//load the file
		String fileName = "BudgetDatabase";
		
		try{
			File f = new File(fileName);
			if(f.exists() == false) {
				f.createNewFile();
				fileExists = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void finishingTouches() {
		//setDefaultCloseOperation(Budget.finishingTouches())
		//intended to save the current Budget after closing the window
		//TODO
		cleanUp();
	}
	
	public void newItem(String setName, Double setValue) {
		BudgetList.add(new BudgetItem(setName, setValue));
	}
	
	public int getListSize() {
		return BudgetList.size();
	}
	
	public Double getValue(int id) {
		//gets the value of id
		id--;
		try {
			return BudgetList.get(id).getTrueValue();
		}
		catch (NullPointerException e) {
			System.out.println("Error: getValue nullPoint, id = " + id);
			return (double) -1;
		}
	}
	
	public void setValue(int id, double newValue) {
		//Sets the value of id to V
		id--;
		try {
			BudgetList.get(id).setItemValue(newValue);
			return;
		}
		catch (NullPointerException e) {
			System.out.println("Error: setValue nullPoint, id = " + id + ", value to set = " + newValue);
			return;
		}
		// TODO - add some update function when V = 0?
	}
	
	public int removeByName(String toRemove) {
		for (int i = 0; i < BudgetList.size(); i++) {
			if (BudgetList.get(i).getItemName().equals(toRemove)){
				BudgetList.remove(i);
				return 1;
			}
		}
		return -1;
	}
	
	public void removeItem(int id) {
		//Removes id from the list
		id--;
		try {
			BudgetList.remove(id);
			return;
		}
		catch (NullPointerException e) {
			System.out.println("Error: removeItem nullpoint, id = " + id );
			return;
		}
	}
	
	public void rename(int id, String newName) {
		id--;
		try {
			BudgetList.get(id).setItemName(newName);
			return;
		}
		catch (NullPointerException e) {
			System.out.println("Error: rename nullPoint, id = " + id + ", newName to set = " + newName);
			return;
		}
	}
	
	public void cleanUp() {
		//Intended to prune away objects with no value
		for (int i = 0; i < BudgetList.size(); i++) {
			if (BudgetList.get(i).getItemValue() == 0){
				BudgetList.remove(i);
				i--;
			}
		}
	}
	
	public double totalValue() {
		double tally = 0;
		for (int i = 0; i < BudgetList.size(); i++) {
			tally += BudgetList.get(i).getTrueValue();
		}
		return tally;
	}
	
	public double totalAsset() {
		double tally = 0;
		for (int i = 0; i < BudgetList.size(); i++) {
			if (BudgetList.get(i).assetDebt() == true) {
				tally += BudgetList.get(i).getItemValue();
			}
		}
		return tally;
	}
	
	public double totalDebt() {
		double tally = 0;
		for (int i = 0; i < BudgetList.size(); i++) {
			if (BudgetList.get(i).assetDebt() == false) {
				tally += BudgetList.get(i).getItemValue();
			}
		}
		return tally;
	}
	
	public void debugCheck() {
		for (int i = 0; i < BudgetList.size(); i++) {
			System.out.print("Item " + (i + 1) + ": " + BudgetList.get(i).getItemName() + "," + BudgetList.get(i).getItemValue());
			System.out.println();
		}
	}
}
