package main.com.hit.java.config.socket;

import main.com.hit.java.config.response.BodyResponse;

@FunctionalInterface
public interface RequestCallback<T>
{
    void run(BodyResponse<T> data);
}
