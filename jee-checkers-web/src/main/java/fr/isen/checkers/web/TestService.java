package fr.isen.checkers.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("test")
@Produces({"application/json", "text/xml"})
public class TestService {

	@GET
	@Path("/list")
	public Response test(){
		List<String> list = new ArrayList<String>();
		list.add("quentin");
		list.add("roeland");
		GenericEntity<List<String>> entity = new GenericEntity<List<String>>(list) {};
		Response response = Response.ok().entity(entity).build();
		return response;
	}
	
	@GET
	@Path("/list2")
	public List<String> test2(){
		List<String> list = new ArrayList<String>();
		list.add("quentin");
		list.add("roeland");
		return list;
	}
}
