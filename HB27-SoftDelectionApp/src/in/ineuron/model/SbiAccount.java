package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name="sbiaccount")
@SQLDelete(sql="update sbiaccount set status='disabled' where acno=?")
@DynamicUpdate(value=true)
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
