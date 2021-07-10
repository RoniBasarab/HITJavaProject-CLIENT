package main.com.hit.java.config.response;

public class Response
{
    ResponseHeader header;

    public Response(boolean b)
    {
        this.header = new ResponseHeader(b);
    }

    public boolean isSuccessful() {
        return this.header.isSuccessful;
    }

}
