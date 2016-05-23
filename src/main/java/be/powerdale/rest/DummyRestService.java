package be.powerdale.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
public class DummyRestService {

    @GET
    @Path("dummy")
    @Produces("text/plain")
    public Response getDummyText() {
        return Response.ok("Dummy").build();
    }

}
