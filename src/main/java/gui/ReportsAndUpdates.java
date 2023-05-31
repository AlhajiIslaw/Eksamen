package gui;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

import frames.AddEmployeeFrame;
import frames.ListAllProducts;
import frames.ListOfficesFrame;

import java.awt.Font;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
        import java.sql.SQLException;

	public class ReportsAndUpdates extends JPanel implements ActionListener {
	
		
	    public ReportsAndUpdates() {
	    	
	        super(); 
	   
	        setLayout(new GridBagLayout());
                
	        JButton addModifyEmployeeButton = new JButton("Add Employee");
	        JButton modifyEmployeeButton = new JButton("Modify Employee");
	        JButton listAllProductsButton = new JButton("List All Products");
	        JButton listAllOfficesButton = new JButton("List All Offices");
	        JButton bulkImportOrdersButton = new JButton("Bulk Import of Orders");

	        
	        JLabel selectCommandLabel = new JLabel("Select command:");
	        GridBagConstraints labelConstraints = new GridBagConstraints();
	        
	        GridBagConstraints buttonConstraints = new GridBagConstraints();
	        buttonConstraints.gridx = 2;
	        buttonConstraints.gridy = 2; // Set the grid y position to 1 (bottom row)
	        buttonConstraints.gridwidth = 1; // Set the grid width to 1
	        buttonConstraints.fill = GridBagConstraints.HORIZONTAL;
	        buttonConstraints.weightx = 1; // Set the horizontal weight to expand the buttons
	        buttonConstraints.insets = new Insets(1, 1, 1, 1); // Add spacing around the buttons
	        this.add(selectCommandLabel, labelConstraints);
	        
	        
	        
	        
	        buttonConstraints.gridx = 0;
	        this.add(addModifyEmployeeButton, buttonConstraints);
	        
	        buttonConstraints.gridx = 1;
	        this.add(modifyEmployeeButton, buttonConstraints);
	        
	        buttonConstraints.gridx = 2;
	        this.add(listAllProductsButton, buttonConstraints);

	        buttonConstraints.gridx = 3;
	        this.add(listAllOfficesButton, buttonConstraints);

	        buttonConstraints.gridx = 4;
	        this.add(bulkImportOrdersButton, buttonConstraints);

	        addModifyEmployeeButton.addActionListener(this);
	        modifyEmployeeButton.addActionListener(this); 
	        listAllProductsButton.addActionListener(this);
	        listAllOfficesButton.addActionListener(this);
	        bulkImportOrdersButton.addActionListener(this);       
	    }

	    // Define the action to perform when a button is clicked
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getActionCommand().equals("Add Employee")) {
	            System.out.println("Add or Modify Employee button clicked");
	           AddEmployeeFrame frame = new AddEmployeeFrame();
	        } else if (e.getActionCommand().equals("List All Products")) {
	            System.out.println("List All Products button clicked");
                   try {
			ListAllProducts frame = new ListAllProducts();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                   }
	            // Perform action for list all products button
	        } else if (e.getActionCommand().equals("List All Offices")) {
	        	try {
					ListOfficesFrame frame = new ListOfficesFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            // Perform action for list all offices button
	        } else if (e.getActionCommand().equals("Bulk Import of Orders")) {
	            System.out.println("Bulk Import of Orders button clicked");
	            // Perform action for bulk import orders button
	            
	        }
	    }	    
}
