package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.invdatamain;
import domain.invdataManager;



@Path("myresource")
public class myresource {
	@POST
	@Path("/uploadinv")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public int uploadinv(invdatamain ivm)
	{
		if (ivm.getRecordcount()>2000)
			return 1;
		if (checkAuth(ivm.getClino(),ivm.getPass())!=0)
			return 2;
		if (inserttherecord(ivm.getClino(),ivm.getInvdatalist())!=0)
			return 3;
		return 0;
	}

}
