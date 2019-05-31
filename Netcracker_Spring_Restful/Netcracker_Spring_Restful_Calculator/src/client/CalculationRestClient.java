package client;

import model.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Scanner;

public class CalculationRestClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        Scanner in = new Scanner(System.in);
        double a, b;
        System.out.print("Enter a: "); a = in.nextDouble();
        System.out.print("Enter b: "); b = in.nextDouble();
        WebTarget addTarget = client.target("http://localhost:8080/rest/calc/add/" + a + "/" + b);
        WebTarget subTarget = client.target("http://localhost:8080/rest/calc/sub/" + a + "/" + b);
        WebTarget multTarget = client.target("http://localhost:8080/rest/calc/mult/" + a + "/" + b);
        WebTarget divTarget = client.target("http://localhost:8080/rest/calc/div/" + a + "/" + b);

        System.out.println("Add result: ");
        System.out.println("\tJSON: " + addTarget.request(MediaType.APPLICATION_JSON).get().readEntity(Response.class));
        System.out.println("\tTEXT: " + addTarget.request(MediaType.TEXT_PLAIN).get().readEntity(String.class));
        System.out.println("Sub result: ");
        System.out.println("\tJSON: " + subTarget.request(MediaType.APPLICATION_JSON).get().readEntity(Response.class));
        System.out.println("\tTEXT: " + subTarget.request(MediaType.TEXT_PLAIN).get().readEntity(String.class));
        System.out.println("Mult result: ");
        System.out.println("\tJSON: " + multTarget.request(MediaType.APPLICATION_JSON).get().readEntity(Response.class));
        System.out.println("\tTEXT: " + multTarget.request(MediaType.TEXT_PLAIN).get().readEntity(String.class));
        System.out.println("Div result: ");
        System.out.println("\tJSON: " + divTarget.request(MediaType.APPLICATION_JSON).get().readEntity(Response.class));
        System.out.println("\tTEXT: " + divTarget.request(MediaType.TEXT_PLAIN).get().readEntity(String.class));
    }
}
