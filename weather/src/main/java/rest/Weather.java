package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import client.WeatherClient;

@Path("/")
public class Weather {
	
	WeatherClient client = new WeatherClient();

	
	@GET
	@Path("{cityName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWeatherForCity(@PathParam("cityName") String cityName) {
		if(cityName == null) {
			return Response.status(400).build();
		}
		return Response.ok(client.getWeatherForCity(cityName)).header("Access-Control-Allow-Origin", "*").build();
	}
}
