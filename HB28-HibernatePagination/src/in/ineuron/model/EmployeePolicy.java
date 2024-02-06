package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeepolicy")
public class EmployeePolicy {
	
	@Id
	private Integer policyId;
	private String policyName;
	private String PolicyType;
	private String company;
	private Integer tenure;
	
	static {
		System.out.println("EmployeePolicy .class file is loading...");
	}
	public EmployeePolicy() {
		System.out.println("EmployeePolicy object is created");
	}
	
	
	public Integer getPolicyId() {
		return policyId;
	}




	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}




	public String getPolicyName() {
		return policyName;
	}




	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}




	public String getPolicyType() {
		return PolicyType;
	}




	public void setPolicyType(String policyType) {
		PolicyType = policyType;
	}




	public String getCompany() {
		return company;
	}




	public void setCompany(String company) {
		this.company = company;
	}




	public Integer getTenure() {
		return tenure;
	}




	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}




	@Override
	public String toString() {
		return "EmployeePolicy [policyId=" + policyId + ", policyName=" + policyName + ", PolicyType=" + PolicyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}
	
	
}
