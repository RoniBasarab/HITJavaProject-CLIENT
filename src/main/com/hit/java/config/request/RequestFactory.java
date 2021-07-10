package main.com.hit.java.config.request;

public class RequestFactory
{
    public static  <T> BodyRequest<T> createRequest(String action, T data)
    {
        return new BodyRequest(action, data);
    }

    public static Request createRequest(String action)
    {
        return new Request(action);
    }
}
