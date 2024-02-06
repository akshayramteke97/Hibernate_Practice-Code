package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DynamicInsert(value=true)
public class Student {
	
//	@GenericGenerator(name="gen1", strategy = "increment")
//	@GeneratedValue(generator="gen1")
	@Id
	@GenericGenerator(name="gne1",strategy = "sequence")
	@GeneratedValue(generator="gne1")
	private Integer sid;
	
	private String sname;
	
	private String saddress;
	
	private Integer sage;
	
	public Student() {
		System.out.println("zero-arg Constructer"
				+ "");
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}
	
}
