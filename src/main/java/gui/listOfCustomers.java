package gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import database.DatabaseHelper;

public class listOfCustomers extends JPanel {

    private JLabel selectionLabel;
    private JRadioButton cityRadioButton;
    private JRadioButton stateRadioButton;
    private JComboBox<String> selectionComboBox;
    private JButton writeListButton;

    public listOfCustomers() {
       super();
       setLayout(new GridBagLayout());

        selectionLabel = new JLabel("Select: ");
        cityRadioButton = new JRadioButton("City");
        stateRadioButton = new JRadioButton("State");
        selectionComboBox = new JComboBox<>();
        writeListButton = new JButton("Write customer list");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(cityRadioButton);
        buttonGroup.add(stateRadioButton);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(cityRadioButton);
        radioPanel.add(stateRadioButton);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        contentPanel.add(selectionLabel, gbc);

        gbc.gridx = 1;
        contentPanel.add(selectionComboBox, gbc);
        
        
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        contentPanel.add(writeListButton, gbc);
        
        

        setLayout(new BorderLayout());
        add(radioPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        cityRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    List<String> cities = getCitiesFromDatabase();
                    updateSelectionComboBox(cities);
                }
            }
        });

        stateRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    List<String> states = getStatesFromDatabase();
                    updateSelectionComboBox(states);
                }
            }
        });

        setVisible(true);
    }
    
    
    private List<String> getCitiesFromDatabase() {
        List<String> cities = new ArrayList<>();

        	DatabaseHelper db = new DatabaseHelper();
        	

        	ResultSet resultSet;
			try {
	        	db.open();
				resultSet = db.selectSql("SELECT DISTINCT city FROM customers");
				
	            while (resultSet.next()) {
	                String city = resultSet.getString("city");
	                cities.add(city);
	            }
	            
	            return cities;
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
        	
        return cities;
    }

    private List<String> getStatesFromDatabase() {
        List<String> states = new ArrayList<>();

    	DatabaseHelper db = new DatabaseHelper();
    	

    	ResultSet resultSet;
		try {
        	db.open();
			resultSet = db.selectSql("SELECT DISTINCT state FROM customers");
			
            while (resultSet.next()) {
                String city = resultSet.getString("state");
                states.add(city);
            }
            
            return states;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    return states;
    }

    private void updateSelectionComboBox(List<String> items) {
        selectionComboBox.removeAllItems();
        for (String item : items) {
            selectionComboBox.addItem(item);
        }
    }

}
