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
		return Response.ok(result).build();
	}

	/**
	 * Adds a page to an existing Novel
	 * @param id the id of the Novel to which the Page is to be added
	 * @param page the new Page to be added to the Novel
	 * @return If there is no existing Novel with id, 204 (No Content) is returned, otherwise 202 (Accepted)
	 */
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
			//result.getPages().add(page);
			result.addPageToPages(newPage);
			this.novelService.save(result);
			return Response.accepted(newPage.getId()).build();
		}
	}
	
	@DELETE
	@Path("{id}/{page_id}/{page_del}")
	public Response removePageFromNovelById(
			@PathParam("id") Long id, 
			@PathParam("page_id") Long PageId, 
			@PathParam("page_del") boolean pageDel) {
		Novel result = this.novelService.findById(id);
		if (result == null) {
			return Response.noContent().build();
		} else {
			Page page = this.pageService.findById(PageId);
			if (page == null) {
				return Response.noContent().build();
			} else {
				//result.getPages().remove(page);
				result.removePageFromPages(page);
				this.novelService.save(result);
				if (pageDel) this.pageService.deletePage(page);
				return Response.accepted().build();
			}
			
		}
		
	}
}
