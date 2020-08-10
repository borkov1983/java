package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Comment;
import domain.Part;

@Path("/parts/{id}/comments")
@Stateless
public class Comments {

	@PersistenceContext
	EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getComments(@PathParam("id") Integer partId) {
		Part part;
		try {
			part = em.createNamedQuery("part.id", Part.class).setParameter("partId", partId).getSingleResult();
		} catch(NoResultException e) {
			return Response.status(404).build();
		}
		
		return Response.ok(part.getComments()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("id") Integer partId, Comment comment) {
		Part part;
		try {
			part = em.createNamedQuery("part.id", Part.class).setParameter("partId", partId).getSingleResult();
		} catch(NoResultException e) {
			return Response.status(404).build();
		}
		part.getComments().add(comment);
		comment.setPart(part);
		em.persist(comment);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{commentId}")
	public Response removeComment(@PathParam("id") Integer partId, @PathParam("commentId") Integer commentId) {
		Part part;
		Comment comment;
		try {
			part = em.createNamedQuery("part.id", Part.class).setParameter("partId", partId).getSingleResult();
			comment = em.createNamedQuery("comment.id", Comment.class).setParameter("commentId", commentId).getSingleResult();
		} catch(NoResultException e) {
			return Response.status(404).build();
		}
		
		part.getComments().remove(comment);
		em.remove(comment);
		em.persist(part);
		return Response.ok().build();
	}
}
