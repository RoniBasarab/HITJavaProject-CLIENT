package main.com.hit.java;
import com.google.gson.Gson;
import main.com.hit.java.clientcomponents.jobcomponent.JobController;
import main.com.hit.java.clientcomponents.jobcomponent.JobModel;
import main.com.hit.java.clientcomponents.jobcomponent.JobView;
import main.com.hit.java.clientcomponents.searchcomponent.SearchController;
import main.com.hit.java.config.socket.SocketService;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MVCDriver
{
    private static JobController jobController;
    private static JobView jobView;
    private static JobModel jobModel;
    public static final int port = 1441;
    public static final Gson gson = new Gson();
    public static InetAddress clientAddress;
    public static SocketService socketService;

    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        clientAddress = InetAddress.getLocalHost();
        jobView = new JobView("Job Posting Application");
        jobModel = new JobModel();
        socketService = new SocketService();
        jobController = new JobController(jobModel,jobView);
    }
}
