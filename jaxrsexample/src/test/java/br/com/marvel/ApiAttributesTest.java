package br.com.marvel;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.marvel.Model.Movie;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import kong.unirest.HttpMethod;
import kong.unirest.MockClient;
import kong.unirest.json.JSONObject;

public class ApiAttributesTest {

    private HttpServer server;
    private WebTarget target;
    private Builder builder;
    private Movie responseMovie; 

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();
        
        target = c.target(Main.BASE_URI);

        MockClient mock = MockClient.register();

        mock.expect(HttpMethod.GET, "https://www.whenisthenextmcufilm.com/api")
                        .thenReturn(createMainMovie());

        builder = target.path("api").request();        
        responseMovie = builder.get(Movie.class);  
    }

    public JSONObject createMainMovie(){
        JSONObject json = new JSONObject();
        json.put("days_until", 4);
        json.put("following_production", createFP());
        json.put("overview", "Shang-Chi must confront the past he thought he left behind when he is drawn"+
        " into the web of the mysterious Ten Rings organization.");
        json.put("poster_url", "https://image.tmdb.org/t/p/w500/9f2Q0U3IOsLgrI2HkvldwSABZy5.jpg");
        json.put("release_date", "2021-09-01");	
        json.put("title", "Shang-Chi and the Legend of the Ten Rings");	
        json.put("type", "Movie");	
        return json;
    }

    public JSONObject createFP(){
        JSONObject json = new JSONObject();
        json.put("days_until", 67);
        json.put("overview", "The Eternals are a team of ancient aliens who have been living on Earth" + 
        "in secret for thousands of years. When an unexpected tragedy forces them out of the shadows,"+
        " they are forced to reunite against mankind’s most ancient enemy, the Deviants.");
        json.put("poster_url", "https://image.tmdb.org/t/p/w500/4DiJQ1mBp4ztoznZADIrPg69v46.jpg");
        json.put("release_date", "2021-11-03");	
        json.put("title", "Eternals");	
        json.put("type", "Movie");	
        return json;
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();;
    }

    @Test
    public void testIfNameIsCorrect() {              
        assertEquals(responseMovie.getTitle(), "Shang-Chi and the Legend of the Ten Rings");
    }

    @Test
    public void testIfTypeIsCorrect() {    
        assertEquals(responseMovie.getType(), "Movie");
    }

    @Test
    public void testIfDaysUntilIsCorrect() {     
        assertEquals(responseMovie.getDaysUntil(), 4);
    }

    @Test
    public void testIfOverviewIsCorrect() { 
        String overview = "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.";    
        assertEquals(responseMovie.getOverview(), overview);
    }

    @Test
    public void testIfReleaseDateIsCorrect() {   
        LocalDate date = LocalDate.parse("2021-09-01");  
        assertEquals(responseMovie.getReleaseDate(), date);
    }

    @Test
    public void testIfPosterURLIsCorrect() {   
        String url = "https://image.tmdb.org/t/p/w500/9f2Q0U3IOsLgrI2HkvldwSABZy5.jpg";
        assertEquals(responseMovie.getPosterURL(), url);
    }

    @Test
    public void testIfFPReleaseDateIsCorrect() {   
        LocalDate date = LocalDate.parse("2021-11-03");
        assertEquals(responseMovie.getFollowingProduction().getReleaseDate(), date);
    }

    @Test
    public void testIfFPTitleIsCorrect() {   
        assertEquals(responseMovie.getFollowingProduction().getTitle(), "Eternals");
    }

}



