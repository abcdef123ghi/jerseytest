package service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("test")
public class testGet {

	@GET
	@Path("/test")
    @Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
	
	public String Hello()
	{
		return "Test";
	}
}
