package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="HQL_TRANSFER_POLICIES", query = "INSERT INTO in.ineuron.model.OtherStudent(sid,saddress,sage,sname) SELECT i.sid,i.saddress,i.sage,i.sname FROM in.ineuron.model.Student as i WHERE i.sage>=:age")
public class OtherStudent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer sid;
	private String saddress;
	private Integer sage;
	private String sname;
	
	
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public String getSaddress() {
		return saddress;
	}


	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}


	public Integer getSage() {
		return sage;
	}


	public void setSage(Integer sage) {
		this.sage = sage;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", saddress=" + saddress + ", sage=" + sage + ", sname=" + sname + "]";
	}
	
	
}