package br.com.marvel.Resource;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;

import br.com.marvel.Model.Movie;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

@Path("api")
public class Api {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovie(@QueryParam("date") String date) {
        
        String url = "https://www.whenisthenextmcufilm.com/api";
        GetRequest getRequest = Unirest.get(url);
        Movie response;

        if(StringUtils.isEmpty(date)){
            response = getRequest.asObject(Movie.class)
                                       .getBody();

            return Response.ok(response).build();
        }

        if (!isValidDate(date)) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        
        response = getRequest.queryString("date",date)
                                   .asObject(Movie.class)
                                   .getBody();
        
        return Response.ok(response).build();
    }
    
    public boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

}
