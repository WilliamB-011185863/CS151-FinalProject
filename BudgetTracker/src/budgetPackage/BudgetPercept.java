package budgetPackage;

import java.util.ArrayList;

public class BudgetPercept {
	int debugmode = 0;
	protected Budget aBudget;
	String username;
	
	public BudgetPercept() {
		//This is the initializing phase, the login will be created 
		//(or another component in debug mode)
		if (debugmode == 0) {
			Popup login = new Login();
			login.setPointer(this);
		}
		else if (debugmode == 1) {
			Popup mainUI = new MainPanel();
		}
	}
	
	public void userEntry(String name) {
		//This is when username is declared (through Login())
		//Budget is instantiated, mainpanel is initialized
		username = name;
		aBudget = new Budget(name);
		Popup mainUI = new MainPanel();
		mainUI.setPointer(this);
	}
	
	
	
	public void saveData() {
		//Triggered by saveButton in mainPanel, records current data in file
	}
	
	public ArrayList<BudgetItem> fetchBudget(){
		//used to pass the BudgetList to SubPanel
		return aBudget.BudgetList;
	}
	
}
