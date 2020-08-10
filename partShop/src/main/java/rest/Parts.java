package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

import domain.Part;
import domain.SearchRequest;

@Path("/parts")
@Stateless
public class Parts {
	
	@PersistenceContext
	EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Part> getAll() {
		return em.createNamedQuery("part.all", Part.class).getResultList();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPart(@PathParam("id") Integer partId) {
		try {
			Part part = em.createNamedQuery("part.id", Part.class).setParameter("partId", partId).getSingleResult();
			return Response.ok(part).build();
		} catch(NoResultException e) {
			return Response.status(404).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Part part) {
		em.persist(part);
		return Response.ok(part).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Integer partId, Part part) {
		try {
			Part partToUpdate = em.createNamedQuery("part.id", Part.class).setParameter("partId", partId).getSingleResult();
			partToUpdate.setName(part.getName());
			partToUpdate.setPrice(part.getPrice());
			partToUpdate.setCategoryName(part.getCategoryName());
			em.persist(partToUpdate);
			return Response.ok(partToUpdate).build();
		} catch(NoResultException e) {
			return Response.status(404).build();
		}
	}
	
	@POST
	@Path("/search")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Part> search(SearchRequest request) {
		TypedQuery<Part> query = em.createNamedQuery("part.search", Part.class);
		query.setParameter("partName", "%" + request.getName() + "%");
		query.setParameter("priceFrom", request.getPriceFrom());
		query.setParameter("priceTo", request.getPriceTo());
		query.setParameter("categoryName", "%" + request.getCategoryName() + "%");
		return query.getResultList();
	}
}
