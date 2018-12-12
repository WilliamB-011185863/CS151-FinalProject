package budgetPackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPanel extends Popup{
	private static final long serialVersionUID = 1L;
	protected JTextArea summeryPanel;
	protected JTextArea limitPanel1;
	protected JTextField limitPanel2;
	protected JTextArea limitPanel3;
	protected JTextArea limitPanel4;
	protected JPanel innerPanel;
	protected JButton creationButton;
	protected JButton saveButton;
	private double curLimit;

	public void setContents() {
		//This lays out the contents of MainPanel, assembling the UI and attaching listeners
		curLimit = 0;
		WeightXY(1,1);
		gbc.fill = GridBagConstraints.BOTH;
		summeryPanel = new JTextArea();
		setLayout(summeryPanel,0,0,4,1,20);
		limitPanel1 = new JTextArea();
		limitPanel1.setText("Current Limit:");
		limitPanel1.setEditable(false);
		setLayout(limitPanel1,0,1,1,1,10);
		limitPanel2 = new JTextField();
		limitPanel2.addKeyListener(new KeyListener(){
			//This listener is used for declaring new "limit" values (aka curLimit)
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_ENTER){
		        	try {
		        		curLimit = Double.parseDouble(limitPanel2.getText());
		        		refreshLimit();
		        	}
		        	catch (NumberFormatException error){
		        		//limitPanel2.getText() cannot be parsed to Double; reset to last value
		        		refreshLimit();
		        	}}}
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
			}});
		setLayout(limitPanel2,1,1,1,1,10);
		limitPanel3 = new JTextArea();
		limitPanel3.setText("Limit remaining:");
		limitPanel3.setEditable(false);
		setLayout(limitPanel3,2,1,1,1,10);
		limitPanel4 = new JTextArea();
		limitPanel4.setEditable(false);
		setLayout(limitPanel4,3,1,1,1,10);
		innerPanel = new SubPanel(percept);
		gbc.ipady = 250;
		setLayout(innerPanel, 0,2,4,2,0);
		gbc.ipady = 0;
		gbc.gridwidth = 1;
		creationButton = new JButton();
		creationButton.setText("New Item");
		creationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Popup Adder = new ItemAddr();
				Adder.declareUnclosing();
				//This button triggers the creation of a new BugetItem
			}
		});
		setLayout(creationButton,0,4,2,1,20);
		saveButton = new JButton();
		saveButton.setText("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This button triggers the saving of current data
				//percept.saveData();
			}});
		setLayout(saveButton,2,4,2,1,20);
	}

	public Dimension objectSize() {
		return new Dimension (300,500);
	}

	public void refreshLimit() {
		Double curRemaining = curLimit;
		limitPanel2.setText(Double.toString(curLimit));
		limitPanel4.setText(Double.toString(curRemaining));	
	}
}
