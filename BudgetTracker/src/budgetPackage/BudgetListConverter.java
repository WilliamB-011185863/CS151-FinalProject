package budgetPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BudgetListConverter {

	public static ArrayList<BudgetItem> ConvertFile(ArrayList<String> data)
	{
		ArrayList<BudgetItem> budgetlist = new ArrayList<BudgetItem>();
		BudgetItem bi;
		
		for (String dt : data)
		{
			List<String> record = Arrays.asList(dt.split(","));
			bi = new BudgetItem(record.get(0), Double.parseDouble(record.get(1)));
			budgetlist.add(bi);
		}
		
		return budgetlist;
		
	}
	
	public static ArrayList<String> ConvertData(ArrayList<BudgetItem> data)
	{
		ArrayList<String> output = new ArrayList<String>();
		
		for (BudgetItem bi : data) 
		{
			output.add(String.format("{0},{1}", bi.getItemName(), bi.getItemValue().toString()));
		}
		
		return null;
	}
	
}
