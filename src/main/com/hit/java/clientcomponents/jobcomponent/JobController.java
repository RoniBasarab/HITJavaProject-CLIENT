package main.com.hit.java.clientcomponents.jobcomponent;
import javax.swing.*;


public class JobController
{

    public JobController(JobModel jobModel, JobView jobView)
    {
        jobView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jobView.setSize(800,800);
        jobView.setResizable(false);
        jobView.setVisible(true);
    }

}
