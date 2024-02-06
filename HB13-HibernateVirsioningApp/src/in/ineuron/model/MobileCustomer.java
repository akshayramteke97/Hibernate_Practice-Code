package in.ineuron.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class MobileCustomer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	private String cName;
	private Long cMobileNumber;
	private String cCallertune;

	@Version
	private Integer versionCount;
	
	

	public Integer getcId() {
		return cId;
	}



	public void setcId(Integer cId) {
		this.cId = cId;
	}



	public String getcName() {
		return cName;
	}



	public void setcName(String cName) {
		this.cName = cName;
	}



	public Long getcMobileNumber() {
		return cMobileNumber;
	}



	public void setcMobileNumber(Long cMobileNumber) {
		this.cMobileNumber = cMobileNumber;
	}



	public String getcCallertune() {
		return cCallertune;
	}



	public void setcCallertune(String cCallertune) {
		this.cCallertune = cCallertune;
	}



	public Integer getVersionCount() {
		return versionCount;
	}



	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}



	@Override
	public String toString() {
		return "MobileCustomer [cId=" + cId + ", cName=" + cName + ", cMobileNumber=" + cMobileNumber + ", cCallertune="
				+ cCallertune + ", versionCount=" + versionCount + "]";
	}
	
	
	
	
}
