package main.com.hit.java.clientcomponents.recruitercomponent;
import com.google.gson.reflect.TypeToken;
import main.com.hit.java.MVCDriver;
import main.com.hit.java.config.commands.Commands;
import main.com.hit.java.config.datamodel.Job;
import main.com.hit.java.config.request.Request;
import main.com.hit.java.config.request.RequestFactory;
import main.com.hit.java.config.response.BodyResponse;

import javax.swing.*;

public class RecruiterController
{
    private RecruiterModel recruiterModel;
    private RecruiterView recruiterView;


    public RecruiterController() throws InterruptedException {
        this.recruiterModel = new RecruiterModel();
        this.recruiterView = new RecruiterView("Job Posting Application");
        this.addNewJobActionListener();
        this.addRemoveByIdActionListener();
    }

    public void addNewJobActionListener()
    {
        this.recruiterView.addNewJobActionListener((al) -> {
            this.recruiterModel.setSingleUserID(this.recruiterView.getIdTxt());
            this.recruiterModel.setSingleUserCity(this.recruiterView.getCityTxt());
            this.recruiterModel.setSingleUserSalary(this.recruiterView.getSalaryTxt());
            this.recruiterModel.setSingleUserWorkerCount(this.recruiterView.getWcTxt());
            this.recruiterModel.createNewJob();
            if(this.recruiterModel.getJob() == null) return;
            String action = Commands.ADD.toString();
            Request req = null;
            req = RequestFactory.createRequest(action,this.recruiterModel.getJob());
            if (req == null) return;

            var type = new TypeToken<BodyResponse<Job>>() {}.getType();
            MVCDriver.socketService.send(req, (BodyResponse<Job> res) -> {
                JOptionPane.showMessageDialog(this.recruiterView.getAddJobButton(),"Job Added!");
                this.recruiterView.resetTextFields();
            }, type);

        });
    }

    private void addRemoveByIdActionListener()
    {
        this.recruiterView.addRemoveByIdActionListener((al)->
        {
            this.recruiterModel.setRemoveID(this.recruiterView.getRemoveIDTxtField());
            var itemToRemoveFromDB = this.recruiterModel.getRemoveID();
            var action = Commands.REMOVE_SEVERAL.toString();
            var req = RequestFactory.createRequest(action,itemToRemoveFromDB);
            if(req == null) return;

            var type = new TypeToken<BodyResponse<Job[]>>() {}.getType();
            MVCDriver.socketService.send(req, (BodyResponse<Job[]> res) -> {
                    JOptionPane.showMessageDialog(this.recruiterView.getRemoveByIDButton(),"Job Removed!");
                    this.recruiterView.setRemoveIDTxtField(null);
            }, type);
        });
    }
}
