package domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class invdatamain {
	private String clino;
	private Long recordcount;
	private String pass;
	private List<invdatas> invdatalist = new ArrayList<invdatas>();

	public String getClino() {
		return clino;
	}
	public void setClino(String clino) {
		this.clino = clino;
	}
	public Long getRecordcount() {
		return recordcount;
	}
	public void setRecordcount(Long recordcount) {
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
