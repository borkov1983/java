package services;

import domain.Rating;

public class RatingService {
	public static Boolean isValidRating(Rating rating) {
		Boolean isValid = false;
		if(rating.getRating() > 0 && rating.getRating() <= 10) {
			isValid = true;
		}
		return isValid;
	}
}
