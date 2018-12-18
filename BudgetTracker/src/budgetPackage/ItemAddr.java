package budgetPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;


public class ItemAddr extends Popup {
	private static final long serialVersionUID = 1L;
	ArrayList<JButton> buttonList;
	private JButton[][] selectorButtons;
	private int xGrid;
	private int yGrid;
	private JTextField valueEntry;
	private JButton enterButton;
	private JButton expenseButton;
	private JButton assetButton;
	private String curOption;
	private int assetExpense;
	private Double output;
	
	public ItemAddr(BudgetPercept p) {
		super(p);
		this.setName("Add Budget Item");
	}

	public void setContents() {
		this.xGrid = 4;
		this.yGrid = 2;
		gbc.fill = GridBagConstraints.BOTH;
		selectorButtons = new JButton[xGrid][yGrid];
		for (int i = 0; i < xGrid; i++) {
		  for (int j = 0; j < yGrid; j++) {
			  //String toAssign = ("button" + i + j);
			  selectorButtons[i][j] = new JButton();
			  selectorButtons[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonHandler(e);
					}});
			  setLayout(selectorButtons[i][j], i, j, 1, 1, 20);
		  }
		}
		
		//Text values for the buttons - types of assets/expense, need to be set manually
		selectorButtons[0][0].setText("Type 1");
		selectorButtons[1][0].setText("Type 2");
		selectorButtons[2][0].setText("Type 3");
		selectorButtons[3][0].setText("Type 4");
		selectorButtons[0][1].setText("Type 5");
		selectorButtons[1][1].setText("Type 6");
		selectorButtons[2][1].setText("Type 7");
		selectorButtons[3][1].setText("Type 8");
		
		
		expenseButton = new JButton();
		expenseButton.setText("Expense");
		expenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expenseButton.setBackground(Color.green);
				assetButton.setBackground(null);
				assetExpense = -1;
			}
		});
		setLayout(expenseButton,0,2,2,1,20);
		
		assetButton = new JButton();
		assetButton.setText("Revenue");
		assetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expenseButton.setBackground(null);
				assetButton.setBackground(Color.green);
				assetExpense = 1;
			}
		});
		setLayout(assetButton,2,2,2,1,20);
		
		
		valueEntry = new JTextField();
		valueEntry.addKeyListener(new KeyListener(){
			//
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_ENTER){
		        	enter();
		        }
		    }
		    public void keyTyped(KeyEvent e) {}
		    public void keyReleased(KeyEvent e) {}
		});
		setLayout(valueEntry,0,3,2,1,20);
		
		enterButton = new JButton();
		enterButton.setText("Enter");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enter();
			}
		});
		setLayout(enterButton,2,3,2,1,20);
	
	}

	public Dimension objectSize() {
		return new Dimension(400,300);
	}

	
	private void buttonHandler(ActionEvent e) {
		for (int i = 0; i < this.xGrid; i++) {
			  for (int j = 0; j < this.yGrid; j++) {
				  selectorButtons[i][j].setBackground(null);//null
			  }
		}
		((JButton) e.getSource()).setBackground(Color.GREEN);
		curOption = ((JButton) e.getSource()).getText();
	}
	
	private void enter() {
		if (curOption != null && assetExpense != 0) {
			try {
        		this.output = Math.abs(Double.parseDouble(valueEntry.getText())) * assetExpense;
        		percept.itemAdding(output, curOption);
        		closeThisFrame();
			}
			catch (NumberFormatException error){
				valueEntry.setBackground(Color.RED);
			}
		}
		else {
			enterButton.setBackground(Color.RED);
		}
	}

}
