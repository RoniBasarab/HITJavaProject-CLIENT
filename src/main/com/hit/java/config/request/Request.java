package main.com.hit.java.config.request;

public class Request
{
    public Request(String action)
    {
        this.header = new RequestHeader(action);
    }

    RequestHeader header;
}
