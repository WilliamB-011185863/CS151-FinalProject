package budgetPackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Login extends Popup{


	protected JTextField inputField;
    protected JTextArea textArea; 
    protected JButton inputButton;
	
	public void setContents() {
		//Sets the contents of the JPanel
		WeightXY(1,1);
		gbc.fill = GridBagConstraints.BOTH;
		inputField = new JTextField();
		inputField.addKeyListener(new KeyListener(){
			//Checks for valid username, sets username not blank
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_ENTER){
		        	String text = inputField.getText();
					if (text != ""){ //NOT WORKING
						percept.userEntry(text);
						declareUnclosing();
						closeThisFrame();
					}
		        }
		    }
		    public void keyTyped(KeyEvent e) {}
		    public void keyReleased(KeyEvent e) {}
		});
		setLayout(inputField,0,1,1,1,20);
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("Enter a username please");
		setLayout(textArea,0,0,1,1,20);
		inputButton = new JButton();
		inputButton.setText("Enter");
		setLayout(inputButton,0,2,1,1,20);
		inputButton.addActionListener(new ActionListener() {
			//Checks for valid username, sets username not blank
			public void actionPerformed(ActionEvent e) {
				String text = inputField.getText();
				if (text != ""){ //NOT WORKING
					percept.userEntry(text);
					declareUnclosing();
					closeThisFrame();
				}
			}
		});
	}

	public Dimension objectSize() {
		return new Dimension (300,180);
	}
	
}