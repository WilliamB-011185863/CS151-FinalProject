package budgetPackage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Login extends Popup{
	private static final long serialVersionUID = 1L;
	protected JTextField inputField;
    protected JTextArea textArea; 
    protected JButton inputButton;
	
	public Login(BudgetPercept p) {
		super(p);
		this.setName("Login");
	}
	
	public void setContents() {
		//Sets the contents of the JPanel
		inputField = new JTextField();
		inputField.addKeyListener(new KeyListener(){
			//Checks for valid username, requires user to enter a name
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_ENTER){
		        	String text = inputField.getText();
		        	if (text != "" && !text.isEmpty()){
						percept.userEntry(text);
						declareUnclosing();
						closeThisFrame();
					} else {
						textArea.setText(" User name is required."); }
		        }
		    }
		    public void keyTyped(KeyEvent e) {}
		    public void keyReleased(KeyEvent e) {}
		});
		setLayout(inputField,0,1,1,1,15);
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(" Enter a username please:");
		setLayout(textArea,0,0,1,1,15);
		inputButton = new JButton();
		inputButton.setText("Enter");
		setLayout(inputButton,0,2,1,1,15);
		inputButton.addActionListener(new ActionListener() {
			//Checks for valid username, requires user to enter a name
			public void actionPerformed(ActionEvent e) {
				String text = inputField.getText();
				if (text != "" && !text.isEmpty()){
					percept.userEntry(text);
					declareUnclosing();
					closeThisFrame();
				}else {
					textArea.setText(" User name is required."); }
			}
		});
	}

	public Dimension objectSize() {
		return new Dimension (300,180);
	}
}