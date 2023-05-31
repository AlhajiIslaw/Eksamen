//Written by Sturla, based on example from example app

package gui;

/*
 * Creates main menu of the application
 * */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import database.DatabaseHelper;
import frames.AboutThisApp;
import frames.AddEmployeeFrame;
import frames.ListAllProducts;
import frames.TestDatabaseFrame;


public class ApplicationMenu extends JMenuBar implements ActionListener {
	
	private JMenu menu_file = null;
	private JMenuItem dBconnectionItem = null;
	private JMenuItem selectFileItem = null;
	private JMenuItem writeCustomersItem = null;
	private JMenuItem bulkImportItem = null;
	private JMenuItem exitItem = null;
	
	private JMenu menu_database = null;
	private JMenuItem testDatabaseItem = null;
	private JMenuItem executeSqlItem = null;
	private JMenuItem addOrModifyItem = null;
	private JMenuItem listAllProductsItem = null;
	private JMenuItem filterAndPresentItem = null;
	
	private JMenu menu_help = null;
	private JMenuItem option_tip = null;
	
	private Font bigFont = new Font("Calibri", Font.PLAIN, 28);
	private Font smallFont = new Font("Calibri", Font.PLAIN, 24);
	
	protected ApplicationMenu() {
		displayMenuBar();
	}
	
	
	protected void displayMenuBar() {
		UIManager.put("Menu.font", bigFont);
		UIManager.put("MenuItem.font", smallFont);
		
		//Defines file menu
		menu_file = new JMenu("File");
		
		
		selectFileItem = new JMenuItem("Select file");
		selectFileItem.addActionListener(this);
		
		writeCustomersItem = new JMenuItem("Write customers into file");
		writeCustomersItem.addActionListener(this);
		
		bulkImportItem = new JMenuItem("Bulk import of orders");
		bulkImportItem.addActionListener(this);
		
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);

		//Adds items to file menu
		menu_file.add(selectFileItem);
		menu_file.add(writeCustomersItem);
		menu_file.add(bulkImportItem);
		menu_file.add(exitItem);
		
		//Define Database menu
		menu_database = new JMenu("Database");
		
		testDatabaseItem = new JMenuItem("Test database connection");
		testDatabaseItem.addActionListener(this);
		
		executeSqlItem = new JMenuItem("Execute SQL query");
		executeSqlItem.addActionListener(this);
		
		addOrModifyItem = new JMenuItem("Add employee");
		addOrModifyItem.addActionListener(this);
		
		listAllProductsItem = new JMenuItem("List all products");
		listAllProductsItem.addActionListener(this);
		
		filterAndPresentItem = new JMenuItem("Filter and present offices from a country");
		filterAndPresentItem.addActionListener(this);
		
		
		
		//Add items to database menu
		menu_database.add(testDatabaseItem);
		menu_database.add(executeSqlItem);
		menu_database.add(addOrModifyItem);
		menu_database.add(listAllProductsItem);
		menu_database.add(filterAndPresentItem);
		
		//Defines Help menu
		menu_help = new JMenu("Help");
		
		option_tip = new JMenuItem("About");
		option_tip.addActionListener(this);
		menu_help.add(option_tip);
		
		//Adds the menus
		this.add(menu_file);
		this.add(menu_database);
		this.add(menu_help);
	}
	
	
	// Actions that are performed upon the clicks on the main menu by the user
	public void actionPerformed(ActionEvent event) {
		String arg = event.getActionCommand();
		if (arg.equals("Test database connection")) {
			 new TestDatabaseFrame();
    	

		}else if (arg.equals("Exit")) {
			System.exit(0);		
		}else if (arg.equals("About")) {
			AboutThisApp frame = new AboutThisApp();
            frame.showMessage();
		}
		else if (arg.equals("List all products")) {
			try {
				ListAllProducts frame = new ListAllProducts();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (arg.equals("Add employee")) {
			AddEmployeeFrame frame = new AddEmployeeFrame();
		}
		

		
		
	}

	// simple method that display option pane with the provided message
	private void displayMessage(String message) {
		UIManager.put("OptionPane.messageFont", bigFont);
		UIManager.put("OptionPane.buttonFont", bigFont);
		JOptionPane.showMessageDialog(this, message);
	}
	
	
}









