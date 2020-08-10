package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Actor;
import domain.Movie;

public class ActorMovieService {
	
	private MovieService movieService = new MovieService();
	private ActorService actorService = new ActorService();
	
	private static Map<Integer, List<Movie>> actorMoviesMap = new HashMap<>();
	private static Map<Integer, List<Actor>> movieActorsMap = new HashMap<>();
	
	public void assignMovieToActor(Integer actorId, Movie movie) {
		List<Movie> movies = actorMoviesMap.get(actorId);
		if(movies == null) {
			movies = new ArrayList<>();
		}
		movies.add(movie);
		actorMoviesMap.put(actorId, movies);
		
		Actor actor = actorService.get(actorId);
		List<Actor> actorsForMovie = movieActorsMap.get(movie.getId());
		if(actorsForMovie == null) {
			actorsForMovie = new ArrayList<>();
		}
		actorsForMovie.add(actor);
		
		movieActorsMap.put(movie.getId(), actorsForMovie);
	}
	
	public List<Movie> getMoviesForActor(Integer actorId) {
		List<Movie> movies = actorMoviesMap.get(actorId);
		if(movies == null) {
			actorMoviesMap.put(actorId, new ArrayList<>());
		}

		return actorMoviesMap.get(actorId);
	}
	
	public List<Actor> getActorsForMovie(Integer movieId) {
		List<Actor> actors = movieActorsMap.get(movieId);
		if(actors == null) {
			movieActorsMap.put(movieId, new ArrayList<>());
		}
		return movieActorsMap.get(movieId);
	}

}
