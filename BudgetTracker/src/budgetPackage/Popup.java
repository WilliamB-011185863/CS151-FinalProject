package budgetPackage;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public abstract class Popup extends JPanel{
	private JFrame thisFrame;
	GridBagConstraints gbc;
	BudgetPercept percept;
	
	
	public abstract void setContents(); //main initialization
	public abstract Dimension objectSize();
	//public abstract void setWindowListener();
	
	public Popup() {
		//Declare GridBagLayout, GridBagConstraints
		this.setLayout(new GridBagLayout());  
		this.gbc = new GridBagConstraints();
		//Set object size
		this.setSize(objectSize());
		//Assemble contents of JPanel
		this.setContents();
		//Finally, create frame (Note: This contains Pack(), so it must come last)
		this.thisFrame = new PopupFrame(objectSize(), this);
	}
	
	
	public void GridXY(int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
	}
	public void PadXY(int x, int y) {
		gbc.ipadx = x;
		gbc.ipady = y;
		
	}
	public void WeightXY(int x, int y) {
		gbc.weightx = x;
		gbc.weighty = y;
	}
	
	protected void setLayout(Component c, int x, int y, int xx, int yy, int textsize) {
		//This is used to add a component to the JPanel,
		//while also declaring relevent gridbagconstraints
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = xx;
		gbc.gridheight = yy;
		gbc.fill = GridBagConstraints.BOTH;
		c.setFont(new Font("Ariel",Font.PLAIN, textsize));
		this.add(c,gbc);
	}
	
	protected void closeThisFrame() {
		//Closes the frame without closing the project. 
		//Side note: Triggers PopupFrame windowClosing listener
		thisFrame.dispatchEvent(new WindowEvent(thisFrame, WindowEvent.WINDOW_CLOSING));
	}
	
	public void setPointer(BudgetPercept p) {
		//Used to set pointer to parent class (BudgetPercept)
		this.percept = p;
	}
	
	public void declareUnclosing() {
		//this is used to add system.exit to popup close
		this.thisFrame.removeWindowListener(this.thisFrame.getWindowListeners()[0]);
	}
}
