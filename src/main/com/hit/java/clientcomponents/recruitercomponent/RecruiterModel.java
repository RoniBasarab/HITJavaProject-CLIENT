package main.com.hit.java.clientcomponents.recruitercomponent;

import main.com.hit.java.config.datamodel.Job;

public class RecruiterModel
{
    private String singleUserID;
    private String singleUserCity;
    private String singleUserSalary;
    private String singleUserWorkerCount;
    private Job newJobToAdd;
    private String[] removeID;

    public void createNewJob()
    {
        newJobToAdd = new Job(this.getSingleUserID(),this.getSingleUserSalary(),this.getSingleUserCity(),this.getSingleUserWorkerCount());
    }

    public Job getJob()
    {
        return this.newJobToAdd;
    }

    public String getSingleUserID() {
        return singleUserID;
    }

    public void setSingleUserID(String singleUserID) {
        this.singleUserID = singleUserID;
    }

    public String getSingleUserCity() {
        return singleUserCity;
    }

    public void setSingleUserCity(String singleUserCity) {
        this.singleUserCity = singleUserCity;
    }

    public String getSingleUserSalary() {
        return singleUserSalary;
    }

    public void setSingleUserSalary(String singleUserSalary) {
        this.singleUserSalary = singleUserSalary;
    }

    public String getSingleUserWorkerCount() {
        return singleUserWorkerCount;
    }

    public void setSingleUserWorkerCount(String singleUserWorkerCount) {
        this.singleUserWorkerCount = singleUserWorkerCount;
    }
    public void setRemoveID(String id)
    {
        this.removeID = new String[1];
        this.removeID[0] = id;
    }
    public String[] getRemoveID()
    {
        return this.removeID;
    }
}
