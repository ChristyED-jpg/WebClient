package rocks.zipcode;

import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
  static  HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) {
        // start the program with a string[]
      String path = args[0];   // get the input
     /* if(!path.equals("")|| !path.equals("foo")||!path.equals("test")||!path.equals("bar")){ // check correct path
        System.out.println("Incorrect input:" + path);
        System.exit(1);// Error code*/
      //}
         // it correct add it on to our server address
      URI uri = URI.create("http://localhost:8000/" + path);
      // build our request
      HttpRequest request =  HttpRequest.newBuilder()
              .uri(uri)
              .GET()
              .build();

      // URI is the address to a resources web or local.


      // try catch to send our request and catch any errors
      try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode()!= 200){
          System.out.println( "error with the request:" + response.body() );
          System.exit(1);
        }

        System.out.println(response.body());

      } catch (Exception e) {
        System.out.println("error connecting the server");
          throw new RuntimeException(e);
      }


//            .version(HttpClient.Version.HTTP_2)
//            .followRedirects(HttpClient.Redirect.NORMAL)
//            .proxy(ProxySelector.of(new InetSocketAddress("localhost", 8000)))
//            .build();
//
//    HttpRequest request = HttpRequest.newBuilder(
//    .uri(URI.create("http://localhost:8000/"))
//            .build();
//    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//            .thenApply(HttpResponse::body)
//            .thenAccept(System.out::println)
//            .join();

}
}