package domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class invdatas {
private String listno;
private String invdate;
private String prodno;
private String batchno;
private String prodadd;
private Double invnum;
private Double stdprice;
private Double sellprice;
private String pzjj;
private String bywho;
private String sttype;


public invdatas() {
	super();
	// TODO Auto-generated constructor stub
}

//auto generated constructor
 
	
	public invdatas(String listno, String invdate, String prodno, String batchno,
		String prodadd, Double invnum, Double stdprice, Double sellprice,
		String pzjj, String bywho, String sttype) {
	super();
	this.listno = listno;
	this.invdate = invdate;
	this.prodno = prodno;
	this.batchno = batchno;
	this.prodadd = prodadd;
	this.invnum = invnum;
	this.stdprice = stdprice;
	this.sellprice = sellprice;
	this.pzjj = pzjj;
	this.bywho = bywho;
	this.sttype = sttype;
}


	public String getListno() {
			return listno;
		}
		public void setListno(String listno) {
			this.listno = listno;
		}
	
		public String getInvdate() {
			return invdate;
		}
		public void setInvdate(String invdate) {
			this.invdate = invdate;
		}
		public String getProdno() {
			return prodno;
		}
		public void setProdno(String prodno) {
			this.prodno = prodno;
		}
		public String getBatchno() {
			return batchno;
		}
		public void setBatchno(String batchno) {
			this.batchno = batchno;
		}
		public String getProdadd() {
			return prodadd;
		}
		public void setProdadd(String prodadd) {
			this.prodadd = prodadd;
		}
		public Double getInvnum() {
			return invnum;
		}
		public void setInvnum(Double invnum) {
			this.invnum = invnum;
		}
		public Double getStdprice() {
			return stdprice;
		}
		public void setStdprice(Double stdprice) {
			this.stdprice = stdprice;
		}
		public Double getSellprice() {
			return sellprice;
		}
		public void setSellprice(Double sellprice) {
			this.sellprice = sellprice;
		}
		public String getPzjj() {
			return pzjj;
		}
		public void setPzjj(String pzjj) {
			this.pzjj = pzjj;
		}

		public String getBywho() {
			return bywho;
		}
		public void setBywho(String bywho) {
			this.bywho = bywho;
		}
		public String getSttype() {
			return sttype;
		}
		public void setSttype(String sttype) {
			this.sttype = sttype;
		}

 
}
