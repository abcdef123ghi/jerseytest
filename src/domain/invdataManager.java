package domain;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="invdataManager")
public class invdataManager {
	
	 private final String url = "jdbc:microsoft:sqlserver://";
     private final String serverName= "localhost";
     private final String portNumber = "1433";
     private final String databaseName= "dataexchange";
     private final String databaseName2= "yyxt01";
     private final String userName = "sa";
     private final String password = "";
	
	public int checkAuth(String usr,String pass)
	{
		 Connection conn = null;
		 int returncode=0;
	        try {
	 
	        	
	        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
	             conn = java.sql.DriverManager.getConnection(getConnectionUrl(1),userName,password);
	            if (conn != null) {
	            	 PreparedStatement ps = conn.prepareStatement( "SELECT * FROM cli_jflogin WHERE cli_no = ? and password=?" ) ;

	                 // Set the first parameter of the statement
	                 ps.setString( 1, usr ) ;
	                 ps.setString( 2, pass) ;
	                 // Execute the query
	                 ResultSet rs = ps.executeQuery() ;
	                 if(rs.next())
	                   returncode=0;
	                 else
	                   returncode=-3;
	  
	            }
	            
	           
	            
	 
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            return -1;
	        } finally {
	            try {
	                if (conn != null && !conn.isClosed()) {
	                    conn.close();
	                    return returncode;
	                    
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	                return -2;
	            }
	        }
	}
	
	
	public int  inserttherecord(List<invdatas> invdatalist,String clino)
	{
		 Connection conn = null;
		 int returncode=0;
	        try {
	        	
	             int arrylength=invdatalist.size(); 
	        	Date mydate[]=new Date[arrylength];
	        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
	             conn = java.sql.DriverManager.getConnection(getConnectionUrl(2),userName,password);
	             conn.setAutoCommit(false);
	             int theindex=0;
	            if (conn != null) {
	            	
	            	for (invdatas item : List<invdatas>) {
	            	  
	            	 PreparedStatement ps = conn.prepareStatement( "SELECT * FROM ls_inv_back   WHERE cli_no = ? and list_no=? and prod_no=? and batch_no=? and prod_add=?" ) ;

	                 // Set the first parameter of the statement
	                 ps.setString( 1, clino ) ;
	                 ps.setString( 2, item.getListno()) ;
	                 ps.setString( 3, item.getProdno()) ;
	                 ps.setString( 4, item.getBatchno()) ;
	                 ps.setString( 5, item.getProdadd()) ;
	                 // Execute the query
	                 ResultSet rs = ps.executeQuery() ;
	                 if(rs.next())
	                 {
	                   returncode=-5;
	                   break;
	                 }
	                 
	                 mydate[theindex]=parseDate(item.getInvdate());
	                 if (mydate[theindex]==null)
	                 {
	                	 returncode=-6;
	                	 break;
	                 }
	                 theindex++;
	            	}
	            	if (returncode==0)
	            	{
	            		int theindex=0;
	            		for (invdatas item : List<invdatas>) {
	            		
	            			String insertTableSQL = "INSERT INTO ls_inv_back"
	            					+ "(cli_no,list_no,inv_date"
                                    +" ,prod_no,batch_No,prod_add"
                                    +",inv_num,std_price,sell_price"
                                    +",buy_price,pzjj,inv_bywho"
                                    +" ,st_type,retail_price ) VALUES"
	            					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            			PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
	            			preparedStatement.setString(1, clino);
	            			preparedStatement.setString(2, item.getListno());
	            			preparedStatement.setDate(3, mydate[theindex]);
	            			preparedStatement.setString(4, item.getProdno());
	            			preparedStatement.setString(5, item.getBatchno());
	            			preparedStatement.setString(6, item.getProdadd());
	            			preparedStatement.setDouble(7, item.getInvnum());
	            			preparedStatement.setDouble(8, item.getStdprice());
	            			preparedStatement.setDouble(9,item.getSellprice());
	            			preparedStatement.setString(10, item.getBuyprice());
	            			preparedStatement.setString(11, item.getPzjj());
	            			preparedStatement.setString(12, item.getBywho());
	            			preparedStatement.setString(13, item.getSttype());
	            			preparedStatement.setDouble(14, item.getRetailprice());
	            			// execute insert SQL stetement
	            			preparedStatement .executeUpdate();
	            			
	            			theindex++;
	            			
	            		}
	            		
	            		conn.commit();
	            		
	            	
	            	}
	            	
	            }
	            
	 
	        } catch (SQLException ex) {
	        
	            ex.printStackTrace();
	      	  if (conn != null) 
	      	  {
                  try 
                  {
        	           conn.rollback();
                  }
                  catch(SQLException excep) 
                  {
                      JDBCTutorialUtilities.printSQLException(excep);
                  }
	              
	          }
	      	      return -1;
	      	  } 
	            
	        
	      	  finally {
	            try {
	                if (conn != null && !conn.isClosed()) {
	                	 conn.setAutoCommit(true);
	                    conn.close();
	                    return returncode;
	                    
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	                return -2;
	            }
	        }
	}
	
	private String getConnectionUrl( int dbselect){
		if (dbselect==1)
        return url+serverName+":"+portNumber+";databaseName="+databaseName+";";
		else
			return url+serverName+":"+portNumber+";databaseName="+databaseName2+";";
   }
	
	private Date parseDate(String date) {
		  if (date == null) {
		    return null;
		  }

		  SimpleDateFormat format = (date.charAt(4) == '/') ? new SimpleDateFormat("yyyy/MM/dd")
		                                                   : new SimpleDateFormat("yyyy-MM-dd");
		  try {
		    return format.parse(date);
		  } catch (ParseException e) {
		    // Log a complaint and include date in the complaint
		  }
		  return null;
		}
	
}
