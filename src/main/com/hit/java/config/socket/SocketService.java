package main.com.hit.java.config.socket;
import com.google.gson.reflect.TypeToken;
import main.com.hit.java.MVCDriver;
import main.com.hit.java.config.request.BodyRequest;
import main.com.hit.java.config.request.Request;
import main.com.hit.java.config.response.BodyResponse;
import main.com.hit.java.config.response.Response;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketService
{
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public <T> void send(Request r, RequestCallback<T> requestCallback, Type responseClass)
    {
        executor.submit(() -> {
            SocketExchange exchange = null;
            try {
                exchange = new SocketExchange(new Socket(MVCDriver.clientAddress, MVCDriver.port));
                exchange.sendData(r);
                Response response = MVCDriver.gson.fromJson(exchange.recieveData(), Response.class);
                if (response.isSuccessful()) {
                    try {
                        var data = (BodyResponse<T>) MVCDriver.gson.fromJson(exchange.recieveData(), responseClass);
                        requestCallback.run(data);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    var type = new TypeToken<BodyResponse<String>>() {}.getType();
                    BodyResponse<String> errorResponse = MVCDriver.gson.fromJson(exchange.recieveData(), type);
                    System.out.println(errorResponse.getBody());
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (exchange != null) {
                    exchange.closeConnection();
                }
            }
        });
    }


    public <T,S> void send(BodyRequest<T> r, RequestCallback<S> requestCallback, Type responseClass)
    {
        executor.submit(() -> {
            SocketExchange exchange = null;
            try {
                exchange = new SocketExchange(new Socket(MVCDriver.clientAddress, MVCDriver.port));
                exchange.sendData(r);
                Response response = MVCDriver.gson.fromJson(exchange.recieveData(), Response.class);
                if (response.isSuccessful()) {
                    try {
                        var data = (BodyResponse<S>) MVCDriver.gson.fromJson(exchange.recieveData(), responseClass);
                        requestCallback.run(data);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    var type = new TypeToken<BodyResponse<String>>() {}.getType();
                    BodyResponse<String> errorResponse = MVCDriver.gson.fromJson(exchange.recieveData(), type);
                    System.out.println(errorResponse.getBody());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(exchange != null){
                    exchange.closeConnection();
                }
            }
        });
    }
}
