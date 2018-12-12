package budgetPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class ItemAddr extends Popup{
	ArrayList<JButton> buttonList;
	//private JButton[] selecter;
	private JButton[][] selectorButtons;
	private int xGrid;
	private int yGrid;
	private JTextField valueEntry1;
	private JTextField valueEntry2;
	private JButton enterButton;
	private JButton expenseButton;
	private JButton assetButton;
	private String curOption;

	public void setContents() {
		int xGrid = 4;
		int yGrid = 2;
		WeightXY(1,1);
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
		
		selectorButtons[0][0].setText("Type 1");
		selectorButtons[1][0].setText("Type 2");
		selectorButtons[2][0].setText("Type 3");
		selectorButtons[3][0].setText("Type 4");
		selectorButtons[0][1].setText("Type 5");
		selectorButtons[1][1].setText("Type 6");
		selectorButtons[2][1].setText("Type 7");
		selectorButtons[3][1].setText("Type 8");
		
		valueEntry1 = new JTextField();
		setLayout(valueEntry1,0,2,1,1,20);
		enterButton = new JButton();
		enterButton.setText("Enter");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		setLayout(enterButton,2,2,2,1,20);
		expenseButton = new JButton();
		expenseButton.setText("expense");
		expenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		setLayout(expenseButton,0,3,2,1,20);
		assetButton = new JButton();
		assetButton.setText("asset");
		assetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		setLayout(assetButton,2,3,2,1,20);
		
//		
//		System.out.println(this.buttonList.size());
//		//prepareListeners();
//		
		
	}

	public Dimension objectSize() {
		return new Dimension(400,300);
	}

	
	private void buttonHandler(ActionEvent e) {
		for (int i = 0; i < xGrid; i++) {
			  for (int j = 0; j < yGrid; j++) {
				  selectorButtons[i][j].setBackground(Color.BLACK);//null
			  }
		}
		//((JButton) e.getSource()).setBackground(Color.GREEN);
		
				
		curOption = ((JButton) e.getSource()).getText();
	}
	
	
}
