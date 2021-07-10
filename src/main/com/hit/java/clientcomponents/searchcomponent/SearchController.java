package main.com.hit.java.clientcomponents.searchcomponent;
import com.google.gson.reflect.TypeToken;
import main.com.hit.java.MVCDriver;
import main.com.hit.java.config.commands.Commands;
import main.com.hit.java.config.datamodel.Job;
import main.com.hit.java.config.request.Request;
import main.com.hit.java.config.request.RequestFactory;
import main.com.hit.java.config.response.BodyResponse;
import main.com.hit.java.shared.utils.Debouncer;
import main.com.hit.java.shared.utils.SearchDocumentListener;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SearchController
{
    private SearchModel searchModel;
    private SearchView searchView;
    private Debouncer searchDebouncer = new Debouncer();

    public SearchController() throws InterruptedException {
        this.searchModel = new SearchModel();
        this.searchView = new SearchView("Job Posting Application");
        this.searchModel.setSearchState("ID");
        this.searchView.getJobsTable().getTableHeader().setReorderingAllowed(false);
        this.searchModel.setTableHeaders(new String[]{"ID", "CITY", "SALARY", "WORKER COUNT"});
        this.addSearchActionListener();
        this.addDropDownActionListener();

    }

    private void addSearchActionListener()
    {
        this.searchView.addTextChangeActionListener(new SearchDocumentListener(() -> {
            searchDebouncer.debounce(()->
            {
                var body = searchView.getTxtField();
                String dropDownState = this.searchModel.getSearchState();
                String action;
                switch (dropDownState) {
                    case ("ID") -> action = Commands.GET_ID.toString();
                    case ("SALARY") -> action = Commands.GET_SALARY.toString();
                    case ("CITY") -> action = Commands.GET_CITY.toString();
                    case ("ALL") -> action = Commands.GET_ALL.toString();
                    default -> action = null;
                }
                if(action == null) return;
                Request req = null;
                if (!action.equals(Commands.GET_ALL.toString()))
                {
                     req = RequestFactory.createRequest(action,body);
                }
                else
                {
                     req = RequestFactory.createRequest(action);
                }
                if (req == null) return;
                var model = this.searchModel;

                if(action.equals(Commands.GET_ID.toString()))
                {
                    var type = new TypeToken<BodyResponse<Job>>() {}.getType();
                    MVCDriver.socketService.send(req, (BodyResponse<Job> res) -> {
                        var token = new TypeToken<BodyResponse<Job>>() {}.getType();
                        Job[] jobList = new Job[]{res.getBody()};
                        this.searchModel.setRecievedJobDataFromDB(jobList);
                        this.searchModel.setTable();
                        this.searchView.setTableModel(this.searchModel.getTableModel());
                    }, type);
                }
                else {
                    var type = new TypeToken<BodyResponse<Job[]>>() {}.getType();
                    MVCDriver.socketService.send(req, (BodyResponse<Job[]> res) -> {
                        this.searchModel.setRecievedJobDataFromDB(res.getBody());
                        this.searchModel.setTable();
                        this.searchView.setTableModel(this.searchModel.getTableModel());
                    },type);
                }
            }, 1000, TimeUnit.MILLISECONDS);
        }));

    }
    private void addDropDownActionListener()
    {
        this.searchView.addDropDownActionListener((al) -> {
            this.searchModel.setSearchState(this.searchView.getSearchByDropDown());
        });
    }
}
