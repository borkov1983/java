package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Actor;
import domain.Movie;
import services.ActorMovieService;
import services.ActorService;
import services.MovieService;

@Path("/actors")
public class Actors {
	
	private MovieService movieDb = new MovieService();
	private ActorService db = new ActorService();
	private ActorMovieService actorMovieService = new ActorMovieService();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Integer id) {
		Actor actor = db.get(id);
		if(actor == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(actor).build();
		}
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Actor actor) {
		db.add(actor);
		return Response.ok(actor).build();
	}
	
	@GET
	@Path("/{id}/movies")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovies(@PathParam("id") Integer actorId) {
		Actor actor = db.get(actorId);
		return Response.ok(actorMovieService.getMoviesForActor(actorId)).build();
	}

	@PUT
	@Path("/{id}/movies/{movieId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActors(@PathParam("id") Integer actorId, @PathParam("movieId") Integer movieId) {
		Movie movie = movieDb.get(movieId);
		Actor actor = db.get(actorId);
		
		if(movie == null || actor == null) {
			return Response.status(404).build();
		} else {
			actorMovieService.assignMovieToActor(actorId, movie);
			return Response.ok(actorMovieService.getMoviesForActor(actorId)).build();
		}
		
	}
}
