package main.com.hit.java.config.response;

public class ResponseFactory
{
    public static  <T> BodyResponse<T> createSuccessfulResponse(T data)
    {
        return new BodyResponse<>(data, true);
    }

    public static Response createSuccessfulResponse()
    {
        return new Response(true);
    }

    public static BodyResponse<String> createFailedResponse(String error)
    {
        return new BodyResponse<>(error, false);
    }
}
