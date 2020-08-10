package rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Actor;
import domain.Comment;
import domain.Movie;
import domain.Rating;
import services.ActorMovieService;
import services.CommentService;
import services.MovieService;
import services.RatingService;

@Path("/movies")
public class Movies {
	
	private MovieService db = new MovieService();
	private CommentService commentService = new CommentService();
	private ActorMovieService actorMovieService = new ActorMovieService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAllMovies(){
		return db.getAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Integer id) {
		Movie movie = db.get(id);
		if(movie == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(movie).build();
		}
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Movie add(Movie movie) {
		return db.add(movie);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Integer id, Movie movie) {
		Movie movieToUpdate = db.get(id);
		if(movieToUpdate == null) {
			return Response.status(404).build();
		}
		movie.setId(id);
		db.update(movie);
		return Response.ok(movie).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Integer id) {
		Movie movie = db.get(id);
		if(movie == null) {
			return Response.status(404).build();
		}
		db.delete(movie);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getComments(@PathParam("id") Integer id) {
		Movie movie = db.get(id);
		if(movie == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(movie.getComments()).build();
		}
		
	}
	
	@POST
	@Path("/{id}/comments")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("id") Integer id, Comment comment) {
		Movie movie = db.get(id);
		if(movie == null) {
			return Response.status(404).build();
		} else {
			List<Comment> comments = movie.getComments();
			if(comments == null) {
				comments = new ArrayList<>();
			}
			comment.setId(commentService.getNewId());
			comments.add(comment);
			movie.setComments(comments);
			return Response.ok(comment).build();
		}
	}
	
	@DELETE
	@Path("/{id}/comments/{idComment}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteComment(@PathParam("id") Integer movieId, @PathParam("idComment") Integer commentId) {
		System.out.println(movieId);
		final Comment[] commentToRemove = null;
		Movie movie = db.get(movieId);
		if(movie == null) {
			return Response.status(404).build();
		}
		List<Comment> comments = movie.getComments();
		System.out.println(comments);
		List<Comment> commentsToRemove = comments.stream()
                .filter(comment -> comment.getId().equals(commentId)).collect(Collectors.toList());
		System.out.println(commentsToRemove);
		if(commentsToRemove.size() < 1) {
			return Response.status(404).build();
		}
		
		comments.removeAll(commentsToRemove);
		movie.setComments(comments);
				
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}/rating")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRating(@PathParam("id") Integer id) {
		Movie movie = db.get(id);
		if(movie == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(movie.getRating()).build();
		}
		
	}
	
	@POST
	@Path("/{id}/rating")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addRating(@PathParam("id") Integer id, Rating rating) {
		Movie movie = db.get(id);
		if(movie == null) {
			return Response.status(404).build();
		} else {
			if(!RatingService.isValidRating(rating)) {
				return Response.status(400).build();
			}
			movie.addRating(rating.getRating());
			return Response.ok(movie.getRating()).build();
		}
	}
	
	@GET
	@Path("/{id}/actors")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActors(@PathParam("id") Integer id) {
		Movie movie = db.get(id);
		if(movie == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(actorMovieService.getActorsForMovie(id)).build();
		}
		
	}
	
}
