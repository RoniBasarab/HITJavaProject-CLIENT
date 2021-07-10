package main.com.hit.java.config.socket;

public interface ISocketExchange
{
    public String recieveData();
    void sendData(String myData);
    <T>void sendData(T myData);
    public void closeConnection();
}
