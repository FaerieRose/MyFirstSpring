package nl.programit.spring_test.rest.service;

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

import org.springframework.beans.factory.annotation.Autowired;

import nl.programit.spring_test.domain.Novel;
import nl.programit.spring_test.domain.Page;
import nl.programit.spring_test.persistence.NovelService;
import nl.programit.spring_test.persistence.PageService;

@Path("novels")
public class NovelEndpoint {

	@Autowired
	private NovelService novelService;
	
	@Autowired
	private PageService pageService;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postNovel(Novel novel)  {
		Novel result = this.novelService.save(novel);
		return Response.accepted(result.getId()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getNovelById(@PathParam("id") Long id ) {
		Novel result = this.novelService.findById(id);
		if (result == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(result).build();
		}
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}/page")
	public Response addPageToNovel(@PathParam("id") Long id, Page page) {
		Novel result = this.novelService.findById(id);
		if (result == null) {
			return Response.noContent().build();
		} else {
			Page newPage = this.pageService.save(page);
			result.addPage(newPage);
			this.novelService.save(result);
			return Response.accepted(newPage.getId()).build();
		}
	}
	
	@DELETE
	@Path("{id}/{page_id}/{page_del}")
	public Response deletePageFromNovel(@PathParam("id") Long id, @PathParam("page_id") Long pageId, @PathParam("page_del") boolean pageDel) {
		Novel result = this.novelService.findById(id);
		if (result != null) {
			Page page = this.pageService.findById(pageId);
			if (page != null) {
				result.removePage(page);
				this.novelService.save(result);
				if (pageDel) this.pageService.deleteById(pageId);
				return Response.accepted().build();
			}
		}
		return Response.noContent().build();
	}
}
