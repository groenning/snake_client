import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Tobias on 15/10/15.
 */
public class Client {

    private String hostname;
    private int port;
    Socket socketClient;

        //Skriv en kommentar (konstruktør)
        public Client (String hostname, int port){
            this.hostname = hostname;
            this.port = port;

        }
    // UnknownHostException

    public void connection() throws UnknownHostException, IOException{

        SocketClient = new Socket(hostname,port);
    }


    public static void main(String[] args) {

        //This line create a socketclient object
        SocketClient client = new SocketClient ("Localhost",12312);
    }

}

