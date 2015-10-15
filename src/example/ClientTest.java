package example;/**
 * Created by BenjaminSelnaes on 15/10/15.
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientTest {
  public static void main(String[] argv) {
    // Please, do not remove this line from file template, here invocation of web service will be inserted

    Client client = Client.create();

    WebResource webResource = client.resource("http://localhost:9998/api");

    ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);

    if (response.getStatus() != 200) {
      throw new RuntimeException("Failed: HTTP error code: "
              + response.getStatus());
    }

    String output = response.getEntity(String.class);

    System.out.println(output);


  }
}
