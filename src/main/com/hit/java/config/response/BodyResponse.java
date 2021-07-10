package main.com.hit.java.config.response;

public class BodyResponse<T> extends Response
{
    private final T body;

    public T getBody() {
        return body;
    }

    public BodyResponse() {
        super(false);
        body=null;
    }

    public BodyResponse(T data, boolean isSuccessful)
    {
        super(isSuccessful);
        this.body = data;
    }

}
