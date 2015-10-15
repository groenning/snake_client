/*package example;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

*//**
 * Created by Tobias on 15/10/15.
 *//*

public class ClientSocket {

    private String hostname;
    private int port;
    Socket socketClient;

    //Skriv en kommentar (konstruktør)
    public ClientSocket (String hostname, int port){
        this.hostname = hostname;
        this.port = port;

    }

    // UnknownHostException gør at hvis den ikke finder nogen host adresse bryder programmet ikke ned

    public void connection() throws UnknownHostException, IOException{

        System.out.println("Try to connect to " + hostname + port);

        System.out.println("Attempting to connect to "+hostname+":"+port);

        SocketClient = new Socket(hostname,port);

        System.out.println("Connection is established");
    }



    public static void main(String[] args) {

        //This line create a socketclient object
        SocketClient client = new SocketClient ("Localhost",12312);



    }*/
