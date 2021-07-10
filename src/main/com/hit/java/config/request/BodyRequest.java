package main.com.hit.java.config.request;

public class BodyRequest<T> extends Request
{
    private final T body;

    public BodyRequest(String action, T body) {
        super(action);
        this.body = body;
    }

    public T getBody() {
        return body;
    }
}
