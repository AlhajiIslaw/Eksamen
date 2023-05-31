package gui;

import java.awt.Font;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import frames.ListOfficesFrame;
import frames.TestDatabaseFrame;
import frames.AboutThisApp;

public class PanelMenu extends JPanel implements ActionListener {

    private JButton button1, button2, button3, button4;

    public PanelMenu() {
        super();
        setLayout(new GridBagLayout());

        // Initialize the buttons
        button1 = new JButton("Test database connection");
        button2 = new JButton("Execute SQL query");
        button3 = new JButton("Exit application");
        button4 = new JButton("About the app");

        // Make this class the action listener for the buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        Font boldFontExit = new Font(button3.getFont().getName(), Font.BOLD, button3.getFont().getSize());
        button3.setFont(boldFontExit);
        
        Font boldFontAbout = new Font(button3.getFont().getName(), Font.BOLD, button3.getFont().getSize());
        button4.setFont(boldFontAbout);
        
        // Add the buttons to the panel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Position the first button at (0,0)
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(button1, c);

        // Position the second button at (0,1)
        c.gridx = 0;
        c.gridy = 1;
        this.add(button2, c);

        // Position the third button at (0,2)
        c.gridx = 0;
        c.gridy = 4;
        this.add(button3, c);

        // Add an invisible component that takes up all the extra space
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.VERTICAL;
        this.add(new JPanel(), c); // Adding a new empty JPanel

        // Position the fourth button at (0,4) - at the bottom of the panel
        c.weighty = 0; // Reset to default
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(button4, c);
    
    }


    	 @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // Handle button clicks here
    	        // For example:
    	    	
    	    	if (e.getSource() == button1) {
    	    	    new TestDatabaseFrame();
    	    	}
   	        
    	        if (e.getSource() == button3) {
    	            System.out.println("Exit button clicked");
    	            System.exit(0);
    	     
    	        }
    	        
    	        if (e.getSource() == button4) {
    	            
    	            AboutThisApp aboutThisApp = new AboutThisApp();
    	            aboutThisApp.showMessage();
    	        }
    	    }
    	}
    
    
    
    
    









