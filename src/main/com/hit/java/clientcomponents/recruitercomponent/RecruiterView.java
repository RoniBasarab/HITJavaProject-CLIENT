package main.com.hit.java.clientcomponents.recruitercomponent;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecruiterView extends JFrame
{

    private JPanel recruiterPanel;
    private JButton addJobButton;
    private JTextField idTxt;
    private JTextField cityTxt;
    private JTextField salaryTxt;
    private JTextField wcTxt;
    private JLabel idLabel;
    private JLabel cityLabel;
    private JLabel salaryLabel;
    private JLabel wcLabel;
    private JButton removeByIDButton;
    private JTextField removeIDTxtField;

    public RecruiterView(String title) throws InterruptedException {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setResizable(false);
        this.add(recruiterPanel);
        Thread.sleep(500);
    }

    public void addNewJobActionListener(ActionListener al)
    {
        this.addJobButton.addActionListener(al);
    }

    public void addRemoveByIdActionListener(ActionListener al) {this.removeByIDButton.addActionListener(al);}

    public String getIdTxt() {
        return idTxt.getText();
    }

    public String getCityTxt() {
        return cityTxt.getText();
    }

    public String getSalaryTxt() {
        return salaryTxt.getText();
    }

    public String getWcTxt() {
        return wcTxt.getText();
    }

    public JButton getAddJobButton()
    {
        return this.addJobButton;
    }

    public JButton getRemoveByIDButton()
    {
        return removeByIDButton;
    }

    public String getRemoveIDTxtField()
    {
        return removeIDTxtField.getText();
    }

    public void setIdTxt() {
        this.idTxt.setText(null);
    }

    public void setCityTxt() {
        this.cityTxt.setText(null);
    }

    public void setSalaryTxt() {
        this.salaryTxt.setText(null);
    }

    public void setWcTxt() {
        this.wcTxt.setText(null);
    }

    public void setRemoveIDTxtField(JTextField removeIDTxtField) {
        this.removeIDTxtField = removeIDTxtField;
    }

    public void resetTextFields()
    {
        this.setIdTxt();
        this.setCityTxt();
        this.setSalaryTxt();
        this.setWcTxt();
    }
}
