package nl.programit.spring_test.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import nl.programit.spring_test.domain.Novel;
import nl.programit.spring_test.domain.Page;
import nl.programit.spring_test.persistence.NovelService;

@Path("novels")
public class NovelEndpoint {

	@Autowired
	private NovelService novelService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postNovel(Novel novel)  {
		Novel result = this.novelService.save(novel);
		return Response.accepted(result).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getNovelById(@PathParam("id") Long id ) {
		Novel result = this.novelService.findById(id);
		return Response.ok(result).build();
	}

}
