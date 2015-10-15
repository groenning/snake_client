/**
 * Created by Tobias on 15/10/15.
 */
public class client {

    private String hostname;
    private int port;
    Socket socketClient;

    
    public static void main(String[] args) {

        //This line create a socketclient object
        SocketClient client = new SocketClient ("Localhost",12312);
    }

}

