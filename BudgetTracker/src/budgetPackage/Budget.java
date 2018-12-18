package budgetPackage;

import java.io.IOException;
import java.util.ArrayList;

public class Budget {
	String customerName;
	ArrayList<BudgetItem> BudgetList;
	BudgetFileInterface fInterface;
	boolean fileExists;
	private Double budgetLimit;
	String fileName;

	
	public Budget(String nameInput) {
		this.BudgetList = new ArrayList<BudgetItem>();
		this.customerName = nameInput;
		this.fileName = customerName;
		fInterface = new BudgetFileInterface();
		fileExists = fInterface.CheckFile(this.fileName);
		
		if (!fileExists) {
			fInterface.name = this.fileName;
			fInterface.CreateFile();
			fileExists = true;
		}
		
		try {
			ArrayList<String> list =  fInterface.ReadFile(this.fileName);
			BudgetList = 
					BudgetListConverter.ConvertFile(list);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveBudget()
	{
		fInterface = new BudgetFileInterface();
		ArrayList<String> data = 
				BudgetListConverter.ConvertData(this.BudgetList);
		try {
			fInterface.name = this.fileName;
			fInterface.RewriteFile(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void newItem(String setName, Double setValue) {
		this.BudgetList.add(new BudgetItem(setName, setValue));
	}
	
	public int getListSize() {
		return BudgetList.size();
	}
	
	public Double getValue(int id) {
		id--;
		try {
			return BudgetList.get(id).getItemValue();
		}
		catch (NullPointerException e) {
			System.out.println("Error: getValue nullPoint, id = " + id);
			return (double) -1;
		}
	}
	
	public void setValue(int id, double newValue) {
		id--;
		try {
			BudgetList.get(id).setItemValue(newValue);
			return;
		}
		catch (NullPointerException e) {
			System.out.println("Error: setValue nullPoint, id = " + id + 
					", value to set = " + newValue);
			return;
		}
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
			System.out.println("Error: rename nullPoint, id = " + id + 
					", newName to set = " + newName);
			return;
		}
	}
		
	public double remainingBalance() {
		double retVal = budgetLimit != null ? budgetLimit : 0.00;
		
		return retVal - Math.abs(totalDebt());
	}
	
	public double totalValue() {
		double tally = 0;
		for (int i = 0; i < BudgetList.size(); i++) {
			tally += BudgetList.get(i).getItemValue();
		}
		return tally;
	}
	
	public double totalAsset() {
		double tally = 0;
		for (int i = 0; i < BudgetList.size(); i++) {
			if (BudgetList.get(i).getItemValue() > 0) {
				tally += BudgetList.get(i).getItemValue();
			}
		}
		return tally;
	}
	
	public double totalDebt() {
		double tally = 0;
		for (int i = 0; i < BudgetList.size(); i++) {
			if (BudgetList.get(i).getItemValue() < 0) {
				tally += BudgetList.get(i).getItemValue();
			}
		}
		return tally;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		if (BudgetList.size() != 0) {
			for (BudgetItem bi : BudgetList)
			{
				sb.append(bi.getItemName());
				sb.append(" ");
				sb.append(String.valueOf(bi.getItemValue()));
				sb.append(System.getProperty("line.separator"));
			}
		}
		return sb.toString();
	}
	
	public String budgetTally()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Total Income: ");
		sb.append(String.valueOf(totalAsset()));
		sb.append(System.getProperty("line.separator"));
		sb.append("Total Expenses: ");
		sb.append(String.valueOf(totalDebt()));
		sb.append(System.getProperty("line.separator"));
		sb.append("Sub-Total: ");
		sb.append(String.valueOf(totalValue()));
		
		return sb.toString();
	}
	
	public void debugCheck() {
		for (int i = 0; i < BudgetList.size(); i++) {
			System.out.print("Item " + (i + 1) + ": " + BudgetList.get(i).getItemName() 
					+ "," + BudgetList.get(i).getItemValue());
			System.out.println();
		}
	}

	public Double getBudgetLimit() {
		
		return budgetLimit != null ? budgetLimit : 0.00;
	}

	public void setBudgetLimit(Double budgetLimit) {
		this.budgetLimit = budgetLimit;
	}
	
}
