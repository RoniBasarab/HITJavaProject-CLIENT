package main.com.hit.java.clientcomponents.searchcomponent;

import main.com.hit.java.clientcomponents.jobcomponent.JobController;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.WindowEvent;

public class SearchView extends JFrame {

    private JPanel SearchPanel;
    private JComboBox<String> searchByDropDown;
    private JLabel searchInstructions;
    private JTable JobsTable;
    private JTextField txtField;
    private JButton removeByIDButton;
    private JTextField removeTxtField;

    public SearchView(String title) throws InterruptedException
    {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setResizable(false);
        this.add(SearchPanel);

        Thread.sleep(500);

        for (String item : new String[]{"ID", "SALARY", "CITY","ALL"})
        {
            searchByDropDown.addItem(item);
        }

    }

    public String getRemoveByIdTextField()
    {
        return this.removeTxtField.getText();
    }

    public String getTxtField()
    {
        return txtField.getText();
    }

    public String getSearchByDropDown()
    {
        return (String) searchByDropDown.getSelectedItem();
    }

    public void addTextChangeActionListener(DocumentListener dl)
    {
        this.txtField.getDocument().addDocumentListener(dl);
    }

    public void addRemoveByIdActionListener(ActionListener al)
    {
        this.removeByIDButton.addActionListener(al);
    }

    public void addDropDownActionListener(ActionListener al)
    {
        this.searchByDropDown.addActionListener(al);
    }

    public JTable getJobsTable()
    {
            return JobsTable;
    }


    public void setTableModel(TableModel tableModel) {
        this.JobsTable.setModel(tableModel);
    }

    public JButton getRemoveByIDButton() {
        return removeByIDButton;
    }
}
