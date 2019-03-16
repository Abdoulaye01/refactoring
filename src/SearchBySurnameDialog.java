/*
 * 
 * This is a dialog for searching Employees by their surname.
 * 
 * */

/*
 * 
 * This is a dialog for searching Employees by their surname.
 * 
 * */

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class SearchBySurnameDialog extends JDialog implements ActionListener{
	EmployeeDetails employeeDetails;
	JButton search_btn, cancel_btn;
	JTextField searchField;
	// constructor for search by surname dialog
	public SearchBySurnameDialog(EmployeeDetails parent) {
		setTitle("Search by Surname");
		setModal(true);
		this.employeeDetails = parent;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane(searchPane());
		setContentPane(scrollPane);

		getRootPane().setDefaultButton(search_btn);
		
		setSize(500, 190);
		setLocation(350, 250);
		setVisible(true);
	}// end SearchBySurnameDialog
	
	// initialize search container
	public Container searchPane() {
		JPanel searchPanel = new JPanel(new GridLayout(3,1));
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel searchLabel;

		searchPanel.add(new JLabel("Search by Surname"));
	
		textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		textPanel.add(searchLabel = new JLabel("Enter Surname:"));
		searchLabel.setFont(this.employeeDetails.font1);
		textPanel.add(searchField = new JTextField(20));
		searchField.setFont(this.employeeDetails.font1);
		searchField.setDocument(new JTextFieldLimit(20));

		buttonPanel.add(search_btn = new JButton("Search"));
		search_btn.addActionListener(this);
		search_btn.requestFocus();
		
		buttonPanel.add(cancel_btn = new JButton("Cancel"));
		cancel_btn.addActionListener(this);
		
		searchPanel.add(textPanel);
		searchPanel.add(buttonPanel);

		return searchPanel;
	}// end searchPane

	// action listener for save and cancel button
	public void actionPerformed(ActionEvent e) {
		// if option search, search for Employee
		if(e.getSource() == search_btn){
			this.employeeDetails.searchBySurnameField.setText(searchField.getText());
			// search Employee by surname
			this.employeeDetails.searchEmployeeBySurname();
			dispose();// dispose dialog
		}// end if
		// else dispose dialog
		else if(e.getSource() == cancel_btn)
			dispose();// dispose dialog
	}// end actionPerformed
}// end class SearchBySurnameDialog
