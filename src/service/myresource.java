package service;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.http.HTTPException;

import domain.invdatamain;
import domain.invdataManager;



@Path("myresource")
public class myresource {
	@POST
	@Path("/uploadinv")
	@Consumes({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
	@Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
	
	public int uploadinv(invdatamain ivm)
	{
		if(ivm.getClino()==null)
			throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
		
		if(ivm.getPass()==null)
			throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
		
		if(ivm.getRecordcount()==null)
			throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
		
		if(ivm.getInvdatalist()==null)
			throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
		
		if (ivm.getRecordcount()>2000)
			return 1;
		
		if (checkAuth(ivm.getClino(),ivm.getPass())!=0)
			return 2;
				
	    int theresult=inserttherecord(ivm.getClino(),ivm.getInvdatalist());
	      if(theresult==-5)
			return 3;
	      else if(theresult==-6)
	    	return 4;
	      else if(theresult==0)
		    return 0;
	      else
	    	return 5;
	}

}
