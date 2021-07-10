package main.com.hit.java.clientcomponents.searchcomponent;
import main.com.hit.java.config.datamodel.Job;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Arrays;

public class SearchModel {

    private String userReq;
    private String searchState;
    private Job[] recievedJobDataFromDB;
    private DefaultTableModel tableModel;
    private String[] tableHeaders;
    private String[][] tableJobData;


    @Override
    public String toString() {
        return "{" +
                "jobsTable=" + Arrays.toString(recievedJobDataFromDB) +
                '}';
    }

    public Job[] getRecievedJobDataFromDB() {
        return recievedJobDataFromDB;
    }

    public void setRecievedJobDataFromDB(Job[] recievedJobDataFromDB) {
        this.recievedJobDataFromDB = recievedJobDataFromDB;
    }

    public String getSearchState() {
        return searchState;
    }

    public void setSearchState(String searchState) {
        this.searchState = searchState;
    }

    public String getUserReq() {
        return userReq;
    }

    public void setUserReq(String userReq) {
        this.userReq = userReq;
    }

    public void setTableHeaders(String[] columns) {
        this.tableHeaders = columns;
    }

    public String[] getTableHeaders() {
        return this.tableHeaders;
    }
    public void setTable() {
        this.tableJobData = this.setJobsTableData();
        this.tableModel = new DefaultTableModel(this.tableJobData, this.tableHeaders) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
    }

    public TableModel getTableModel() {
        return this.tableModel;
    }
    private String[][] setJobsTableData()
    {
        var tableJobData = new String[this.recievedJobDataFromDB.length][4];
        for (int i = 0; i < tableJobData.length; i++) {
            tableJobData[i][0] = this.recievedJobDataFromDB[i].getId();
            tableJobData[i][1] = this.recievedJobDataFromDB[i].getCity();
            tableJobData[i][2] = this.recievedJobDataFromDB[i].getSalary();
            tableJobData[i][3] = this.recievedJobDataFromDB[i].getWorkercount();
        }
        return tableJobData;
    }

}