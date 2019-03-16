

public class EmployeeMain {
	

	static EmployeeDetails employeeDetails = new EmployeeDetails();
	
	// main method
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				employeeDetails.createAndShowGUI();
			}
		});
	}// end main


}
