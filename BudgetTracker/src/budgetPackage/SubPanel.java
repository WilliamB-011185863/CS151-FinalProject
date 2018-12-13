package budgetPackage;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class SubPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	//This panel is to be contained by MainPanel
	//Allows assembly of graphics without gridBagConstraints
	BudgetPercept percept;
	ArrayList<BudgetItem> BudgetList;
	
	
	public SubPanel(BudgetPercept p) {
		this.percept = p;
		this.setBorder(new EtchedBorder());
	}
	
	public void update() {
		//Updates the graphic with current data
		this.BudgetList = percept.fetchBudget();
		if (BudgetList.size() != 0) {
			
		}
	}
	
	
}
