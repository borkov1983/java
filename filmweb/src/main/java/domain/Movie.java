package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Movie {
	
	private Integer id;
	private String title;
	private String director;
	private Integer productionYear;
	private List<Comment> comments;
	private List<Integer> ratings;
	private Double rating;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(Integer productionYear) {
		this.productionYear = productionYear;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public Double getRating() {
		if(ratings == null) {
			ratings = new ArrayList<>();
			return 0D;
		}
		return Double.valueOf(ratings.stream().collect(Collectors.summingInt(Integer::intValue)) / (double) ratings.size());
	}
	
	public void addRating(Integer ratingToAdd) {
		if(ratings == null) {
			ratings = new ArrayList<>();
		}
		ratings.add(ratingToAdd);
	}

}
