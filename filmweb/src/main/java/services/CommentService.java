package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Comment;
import domain.Movie;

public class CommentService {
	private static Integer currentId = 0;
	
	public Integer getNewId() {
		currentId++;
		return currentId;
	}
}
