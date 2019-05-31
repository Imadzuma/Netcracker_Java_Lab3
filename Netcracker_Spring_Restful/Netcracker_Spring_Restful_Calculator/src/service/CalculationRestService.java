package service;

import model.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalculationRestService {
    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addJSON(@PathParam("a") Double a, @PathParam("b") Double b) {
        return new Response("Add", a, b, a+b);
    }

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String addTEXT(@PathParam("a") Double a, @PathParam("b") Double b) {
        return a + " + " + b + " = " + (a + b);
    }

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String addHTML(@PathParam("a") Double a, @PathParam("b") Double b) {
        return "<p>" + a + " + " + b + " = " + (a + b) + "</p>";
    }

    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response subJSON(@PathParam("a") Double a, @PathParam("b") Double b) {
        return new Response("Sub", a, b, a - b);
    }

    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String subTEXT(@PathParam("a") Double a, @PathParam("b") Double b) {
        return a + " - " + b + " = " + (a - b);
    }

    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String subHTML(@PathParam("a") Double a, @PathParam("b") Double b) {
        return "<p>" + a + " - " + b + " = " + (a - b) + "</p>";
    }

    @GET
    @Path("/mult/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response multJSON(@PathParam("a") Double a, @PathParam("b") Double b) {
        return new Response("Mult", a, b, a * b);
    }

    @GET
    @Path("/mult/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String multTEXT(@PathParam("a") Double a, @PathParam("b") Double b) {
        return a + " * " + b + " = " + (a * b);
    }

    @GET
    @Path("/mult/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String multHTML(@PathParam("a") Double a, @PathParam("b") Double b) {
        return "<p>" + a + " * " + b + " = " + (a * b) + "</p>";
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response divJSON(@PathParam("a") Double a, @PathParam("b") Double b) {
        return new Response("Div", a, b, a / b);
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String divTEXT(@PathParam("a") Double a, @PathParam("b") Double b) {
        return a + " / " + b + " = " + (a / b);
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String divHTML(@PathParam("a") Double a, @PathParam("b") Double b) {
        return "<p>" + a + " / " + b + " = " + (a / b) + "</p>";
    }
}
