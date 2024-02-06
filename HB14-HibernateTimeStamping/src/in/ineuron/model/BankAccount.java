package in.ineuron.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aNo;
	private String aName;
	private Double balance;
	private String type;
	
	@CreationTimestamp
	private LocalDateTime openingDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	
	
	public Long getaNo() {
		return aNo;
	}



	public void setaNo(Long aNo) {
		this.aNo = aNo;
	}



	public String getaName() {
		return aName;
	}



	public void setaName(String aName) {
		this.aName = aName;
	}



	public Double getBalance() {
		return balance;
	}



	public void setBalance(Double balance) {
		this.balance = balance;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public LocalDateTime getOpeningDate() {
		return openingDate;
	}



	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}



	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}



	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}



	@Override
	public String toString() {
		return "BankAccount [aNo=" + aNo + ", aName=" + aName + ", balance=" + balance + ", type=" + type
				+ ", openingDate=" + openingDate + ", lastUpdated=" + lastUpdated + "]";
	}
	
	
	
	
}
