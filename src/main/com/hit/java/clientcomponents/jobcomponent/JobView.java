package main.com.hit.java.clientcomponents.jobcomponent;
import main.com.hit.java.MVCDriver;
import main.com.hit.java.clientcomponents.recruitercomponent.RecruiterController;
import main.com.hit.java.clientcomponents.searchcomponent.SearchController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobView extends JFrame
{
    private JLabel mainTitle;
    private JPanel panel;
    private JButton searchEngineButton;
    private JButton addNewJobsButton;


    public JobView(String title)
    {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.add(panel);

        searchEngineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new SearchController();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        addNewJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new RecruiterController();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
    }

    public void addActionListnerSearch(ActionListener al)
    {
        searchEngineButton.addActionListener(al);
    }

    public void addActionListnerNew(ActionListener al)
    {
        addNewJobsButton.addActionListener(al);
    }
}
