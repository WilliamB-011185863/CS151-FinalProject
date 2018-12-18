package budgetPackage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MainPanel extends Popup implements FocusListener {

	private static final long serialVersionUID = 1L;
	protected JTextArea summeryPanel;
	protected JTextArea limitPanel1;
	protected JTextField limitPanel2;
	protected JTextArea limitPanel3;
	protected JTextArea limitPanel4;
	protected JTextArea budgetPanel;
	protected JTextArea budgetSummary;
	protected JButton creationButton;
	protected JButton saveButton;

	
	public MainPanel(BudgetPercept p) {
		super(p);
		this.addFocusListener(this);
		this.setName("Budget Sumary");
	}

	public void setContents() {
		//This lays out the contents of MainPanel, assembling the UI and attaching listeners
		
		// item 0, row 0, column span 4, rowspan 1, horizontal space weight 1, vertical space weight 2, font size 15 
		summeryPanel = new JTextArea();
		String sep = System.lineSeparator();
		String message = "Enter your total limit for expenses and press enter," + sep + "then enter your line items for income and indidual expenses.";
		summeryPanel.setText(message);
		summeryPanel.setEditable(false);
		summeryPanel.addFocusListener(this);
		setLayout(summeryPanel,0,0,4,1,1,1,15);
		
		// item 0, row 1, column span 1, rowspan 1, horizontal space weight 1, vertical space weight 1, font size 15 
		limitPanel1 = new JTextArea();
		limitPanel1.setText("Current Limit:");
		limitPanel1.setEditable(false);
		setLayout(limitPanel1,0,1,1,1,1,1,15);
		
		// current limit display
		// item 1, row 1, column span 1, rowspan 1, horizontal space weight 1, vertical space weight 1, font size 15 
		limitPanel2 = new JTextField();
		limitPanel2.setText(String.valueOf(percept.aBudget.getBudgetLimit()));
		limitPanel2.addKeyListener(new KeyListener(){
			//This listener is used for declaring new "limit" values (aka curLimit)
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_ENTER){
		        	try {
		        		percept.aBudget.setBudgetLimit(Double.parseDouble(limitPanel2.getText()));
		        		refreshLimit();
		        	}
		        	catch (NumberFormatException error){
		        		//limitPanel2.getText() cannot be parsed to Double; reset to last value
		        		refreshLimit();
		        	}}}
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
			}});
		limitPanel2.addFocusListener(this);
		setLayout(limitPanel2,1,1,1,1,1,1,15);
		
		// item 2, row 1, column span 1, rowspan 1, horizontal space weight 1, vertical space weight 1, font size 15 
		limitPanel3 = new JTextArea();
		limitPanel3.setText("Limit remaining:");
		limitPanel3.setEditable(false);
		
		setLayout(limitPanel3,2,1,1,1,1,1,15);
		
		// remaining limit display
		// item 3, row 1, column span 1, rowspan 1, horizontal space weight 1, vertical space weight 1, font size 15 
		limitPanel4 = new JTextArea();
		limitPanel4.setEditable(false);
		limitPanel4.setText(String.valueOf(percept.aBudget.remainingBalance()));
		setLayout(limitPanel4,3,1,1,1,1,1,15);
		
		// display of budget items
		// item 0, row 2, column span 4, rowspan 1, horizontal space weight 1, vertical space weight 10, font size 15 
		budgetPanel = new JTextArea();
		budgetPanel.setText(percept.aBudget.toString());
		budgetPanel.setEditable(false);
		budgetPanel.addFocusListener(this);
		setLayout(budgetPanel,0,2,4,1,1,10,15);
		
		// item 0, row 3, column span 4, rowspan 1, horizontal space weight 1, vertical space weight 1, font size 15 
		budgetSummary = new JTextArea();
		budgetSummary.setText(percept.aBudget.budgetTally());
		budgetSummary.setEditable(false);
		budgetSummary.addFocusListener(this);
		setLayout(budgetSummary,0,3,4,1,1,1,15);
		
		gbc.ipady = 250;
		gbc.ipady = 0;
		gbc.gridwidth = 1;
		
		// item 0, row 4, column span 2, rowspan 1, horizontal space weight 1, vertical space weight 1, font size 15 
		creationButton = new JButton();
		creationButton.setText("New Item");
		creationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This button triggers the creation of a new BugetItem
				Popup Adder = new ItemAddr(percept);
				Adder.setPointer(percept);
				Adder.declareUnclosing();
			}
		});
		creationButton.addFocusListener(this);
		setLayout(creationButton,0,4,2,1,1,1,15);
		
		// item 0, row 4, column span 2, rowspan 1, horizontal space weight 1, vertical space weight 1, font size 15
		saveButton = new JButton();
		saveButton.setText("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This button triggers the saving of current data
				percept.saveData();
			}});
		saveButton.addFocusListener(this);
		setLayout(saveButton,2,4,2,1,1,1,15);
		
	}

	public Dimension objectSize() {
		return new Dimension (600,800);
	}

	public void refreshLimit() {
		limitPanel2.setText(percept.aBudget.getBudgetLimit().toString());
		limitPanel4.setText(String.valueOf(percept.aBudget.remainingBalance()));	
	}
	
	public void refreshBudgetPanel() {
		budgetPanel.setText(percept.aBudget.toString());
		budgetSummary.setText(percept.aBudget.budgetTally());
	}
	
	public void update() {
		refreshBudgetPanel();
		refreshLimit();	
	}

	@Override
	public void focusGained(FocusEvent e) {
		update();
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		update();
		
	}
}
