package gui;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import database.DatabaseHelper;
import entities.Office;

public class ListOfficesFrame extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;

    public ListOfficesFrame() throws SQLException {
        setTitle("List of offices");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout());

        // Define the column names for your table
        String[] columnNames = {"officeCode",  "city", "phone", "adressLine1", "adressLine2", "state", "country", "postalCode", "territory"};

        // Initialize the table model
        tableModel = new DefaultTableModel(columnNames, 0); // The '0' argument means the table starts off with zero rows

        // Initialize the table
        table = new JTable(tableModel);

        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        this.add(scrollPane);
        
        DatabaseHelper db = new DatabaseHelper();
        
        ResultSet resultat = db.selectSql("SELECT * FROM offices");
        
        while (resultat.next()) {
        	
        	int officeCode = resultat.getInt("officeCode");
        	String city = resultat.getString("city");
        	String phone = resultat.getString("phone");
        	String adressLine1 = resultat.getString("adressLine1");
        	String adressLine2 = resultat.getString("adressLine2");
        	String state = resultat.getString("state");
        	String country = resultat.getString("country");
        	String postalCode = resultat.getString("postalCode");
        	String territory = resultat.getString("territory");
	        Office tmp = new Office(officeCode, city, phone, adressLine1, adressLine2, state, country, postalCode, territory);
	        
	        Object[] test = {city, phone, adressLine1, adressLine2, state, country, postalCode, territory };
	        tableModel.addRow(test);
        }
        
        
        setResizable(false);
        setVisible(true);
    
}
    }