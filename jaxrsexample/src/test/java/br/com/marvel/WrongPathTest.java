package br.com.marvel;

import static org.junit.Assert.assertEquals;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class WrongPathTest {

    private HttpServer server;
    private WebTarget target;
    private Builder builder;
    private Response response;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();
        
        target = c.target(Main.BASE_URI);

        builder = target.path("api").queryParam("date", "2021-13-32").request();
        response = builder.get();
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();;
    }

    @Test
    public void testIsStatusOk() {
        assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }   


}



