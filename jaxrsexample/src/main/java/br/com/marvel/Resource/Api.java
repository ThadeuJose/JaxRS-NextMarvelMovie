package br.com.marvel.Resource;

import br.com.marvel.Model.Movie;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import kong.unirest.Unirest;

@Path("api")
public class Api {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Movie getMovie() {
        String url = "https://www.whenisthenextmcufilm.com/api";
        Movie response = Unirest.get(url).asObject(Movie.class).getBody();
        return response;
    }
}
