package budgetPackage;

import java.util.ArrayList;

public class BudgetPercept {
	private int debugmode = 0;
	protected Budget aBudget;
	String username;
	
	public int getDebugMode () {return debugmode;}
	public void setDebugMode(int debugMode) {debugmode = debugMode;}
	
	public BudgetPercept() {
		//This is the initializing phase, the login will be created 
		//(or another component in debug mode)
		if (debugmode == 0) {
			Popup login = new Login(this);
			login.setPointer(this);
		}
		else if (debugmode == 1) {
			Popup mainUI = new MainPanel(this);
			mainUI.setPointer(this);
		}
	}
	
	public void userEntry(String name) {
		//This is when username is declared (through Login())
		//Budget is instantiated, mainpanel is initialized
		username = name;
		aBudget = new Budget(name);
		Popup mainUI = new MainPanel(this);
		mainUI.setPointer(this);
	}
	
	public void saveData() {
		aBudget.saveBudget();		
	}
	
	public ArrayList<BudgetItem> fetchBudget(){
		//used to pass the BudgetList to SubPanel
		return aBudget.BudgetList;
	}
	
	public void itemAdding(double amount, String type) {
		aBudget.newItem(type, amount);
	}
}
