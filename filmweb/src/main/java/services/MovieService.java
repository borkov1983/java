package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Movie;

public class MovieService {
	
	private static Map<Integer, Movie> db = new HashMap<>();
	private static Integer currentId = 1;
	
	public List<Movie> getAll() {
		return new ArrayList<>(db.values());
	}
	
	public Movie get(Integer id) {
		return db.get(id);
	}

	public void update(Movie movie) {
		Movie oldMovie = db.get(movie.getId());
		
		oldMovie.setTitle(movie.getTitle());
		oldMovie.setDirector(movie.getDirector());
		oldMovie.setProductionYear(movie.getProductionYear());
	}
	
	public Movie add(Movie movie) {
		movie.setId(currentId);
		currentId++;
		db.put(movie.getId(), movie);
		return movie;
	}
	
	public void delete(Movie movie) {
		db.remove(movie.getId());
	}
}
