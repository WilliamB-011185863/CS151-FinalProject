package budgetPackage;

public class BudgetItem {
	String itemName; //Name of a object in budget
	Double value; //Value of an object in budget

	public BudgetItem(String setName, Double setValue) {
		this.itemName = setName;
		this.value = setValue;
	}
	
	public void setItemName(String setName) {
		this.itemName = setName;
	}
	
	public void setItemValue(Double setValue) {
			this.value = setValue;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public Double getItemValue() {
		return this.value;
	}
}
