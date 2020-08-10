package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Actor;
import domain.Movie;

public class ActorService {
	
	private static Map<Integer, Actor> db = new HashMap<>();
	private static Integer currentId = 1;
	
	public List<Actor> getAll() {
		return new ArrayList<>(db.values());
	}
	
	public Actor get(Integer id) {
		return db.get(id);
	}

	public void update(Actor actor) {
		Actor oldActor = db.get(actor.getId());
		
		oldActor.setName(actor.getName());
		oldActor.setSurname(actor.getSurname());
	}
	
	public Actor add(Actor actor) {
		actor.setId(currentId);
		currentId++;
		db.put(actor.getId(), actor);
		return actor;
	}
	
	public void delete(Actor actor) {
		db.remove(actor.getId());
	}
}
