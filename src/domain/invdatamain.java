package domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class invdatamain {
	private String clino;
	private int recordcount;
	private String pass;
	private List<invdatas> invdatalist;

	public invdatamain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public invdatamain(String clino, int recordcount, String pass,
			List<invdatas> invdatalist) {
		super();
		this.clino = clino;
		this.recordcount = recordcount;
		this.pass = pass;
		this.invdatalist = invdatalist;
	}




	@Override
	public String toString() {
		return "invdatamain [clino=" + clino + ", recordcount=" + recordcount
				+ ", pass=" + pass + ", invdatalist=" + invdatalist + "]";
	}




	public String getClino() {
		return clino;
	}
	public void setClino(String clino) {
		this.clino = clino;
	}
	
	public int getRecordcount() {
		return recordcount;
	}
	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<invdatas> getInvdatalist() {
		return invdatalist;
	}

	public void setInvdatalist(List<invdatas> invdatalist) {
		this.invdatalist = invdatalist;
	}
	
}
