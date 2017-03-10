/* =============================================================================== */
/* This is a JerseyConfig file that is used for the demo project MyFirstSpring.    */
/*   It can be reused for other projects                                           */
/*   Whenever creating a new Endpoint, import and register it here.                */
/*     import nl.programit.spring_test.rest.service.BookEndpoint;                  */
/*     register(BookEndpoint.class);                                               */
/*                                                                                 */
/*   The @ApplicationPath("/api") can be changed and sets the root of your ReST    */
/*     service                                                                     */
/*   @author: FaerieRose                                                           */
/* =============================================================================== */
package nl.programit.spring_test.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import nl.programit.spring_test.rest.service.NovelEndpoint;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(NovelEndpoint.class);
	}
}
