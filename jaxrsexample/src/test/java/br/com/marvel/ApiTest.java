package br.com.marvel;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.marvel.Model.Movie;

import static org.junit.Assert.assertEquals;

public class ApiTest {

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

        builder = target.path("api").request();
        response = builder.get();
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();;
    }

    @Test
    public void testIsStatusOk() {
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
    }
    
    @Test
    public void testIfReturnJSON() {
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
    }

    @Test
    public void testIfNameIsCorrect() {
        Movie responseMovie = builder.get(Movie.class);        
        assertEquals(responseMovie.getTitle(), "Shang-Chi and the Legend of the Ten Rings");
    }
}
