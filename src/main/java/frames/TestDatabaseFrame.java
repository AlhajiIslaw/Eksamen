package frames;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import database.DatabaseHelper;
import gui.PanelMenu;

public class TestDatabaseFrame extends JFrame {

    public TestDatabaseFrame() {
        super("Test Database Connection");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout());

        String result;

        try {
            DatabaseHelper db = new DatabaseHelper();
            db.open();
            db.test();
            db.close();
            result = "Connection successful";
        } catch (Exception ex) {
            result = "Connection not successful";
        }

        JLabel label = new JLabel(result);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(label, constraints);

        add(mainPanel);

        setSize(300, 120); // Set the desired size

        setLocationRelativeTo(null);
        setVisible(true);
    }
}




