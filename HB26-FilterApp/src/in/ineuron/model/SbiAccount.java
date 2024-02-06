package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="sbiaccount")
@FilterDef(name="FILTER_SBIACCOUNT_STATUS",parameters = {
				@ParamDef(type="string",name="id2"),
				@ParamDef(type="string",name="id3")
			})
@Filter(name="FILTER_SBIACCOUNT_STATUS",condition="status not in(:id2,:id3)")
public class SbiAccount {
	
	@Id
	private Integer acno;
	private String holdername;
	private float balance;
	private String status;
	
	static {
		System.out.println("SbiAccount .class file is loading...");
	}
	public SbiAccount() {
		System.out.println("SbiAccount object is created");
	}
	
	
	public Integer getAcno() {
		return acno;
	}


	public void setAcno(Integer acno) {
		this.acno = acno;
	}


	public String getHoldername() {
		return holdername;
	}


	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "SbiAccount [acno=" + acno + ", holdername=" + holdername + ", balance=" + balance + ", status=" + status
				+ "]";
	}

	
	
	
}
