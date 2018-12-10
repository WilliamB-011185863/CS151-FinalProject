package budgetPackage;

public class BudgetItem {
	String itemName; //Name of a object in budget
	Double value; //Value of an object in budget
	Boolean plusMinus; //If object is revenue or expense
	int dateMonth;
	int dateDay;
	
	public BudgetItem(String setName, Double setValue) {
		this.itemName = setName;
		if (setValue < 0) {
			this.value = Math.abs(setValue);
			this.plusMinus = false;
		}
		else {
			this.value = setValue;
			this.plusMinus = true;
		}
	}
	public void setItemName(String setName) {
		this.itemName = setName;
	}
	public void setItemValue(Double setValue) {
		if (setValue < 0) {
			this.value = Math.abs(setValue);
			this.plusMinus = false;
		}
		else {
			this.value = setValue;
			this.plusMinus = true;
		}
	}
	public String getItemName() {
		return this.itemName;
	}
	public Double getItemValue() {
		return this.value;
	}
	public Double getTrueValue() {
		if (this.plusMinus = true) {
			return this.value;
		}
		else {
			return (-this.value);
		}
	}
	
	public Boolean assetDebt() {
		return this.plusMinus;
	}
	
	public void setDate(String dateToSet) {
		dateToSet = dateToSet.toLowerCase();
		if (dateToSet.contains("january")) {
			this.dateMonth = 1;
		}
		else if (dateToSet.contains("febuary")) {
			this.dateMonth = 2;
		}
		else if (dateToSet.contains("march")) {
			this.dateMonth = 3;
		}
		else if (dateToSet.contains("april")) {
			this.dateMonth = 4;
		}
		else if (dateToSet.contains("may")) {
			this.dateMonth = 5;
		}
		else if (dateToSet.contains("june")) {
			this.dateMonth = 6;
		}
		else if (dateToSet.contains("july")) {
			this.dateMonth = 7;
		}
		else if (dateToSet.contains("augest")) {
			this.dateMonth = 8;
		}
		else if (dateToSet.contains("september")) {
			this.dateMonth = 9;
		}
		else if (dateToSet.contains("october")) {
			this.dateMonth = 10;
		}
		else if (dateToSet.contains("november")) {
			this.dateMonth = 11;
		}
		else if (dateToSet.contains("december")) {
			this.dateMonth = 12;
		}
		this.dateDay = Integer.parseInt(dateToSet.replaceAll("\\D", ""));
		if (dateMonth == 0 || dateDay == 0 || dateDay < 0 || dateDay > 31) {
			//Error, something went wrong
			this.dateMonth = 0;
			this.dateDay = 0;
		}
	}
	

	
}
