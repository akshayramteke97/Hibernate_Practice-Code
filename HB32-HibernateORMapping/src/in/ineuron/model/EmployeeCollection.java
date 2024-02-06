package in.ineuron.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name="EMPLOYEE_COLLECTION")
public class EmployeeCollection implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer eId;
	private String eName;
	private String eAddress;

	@ElementCollection
	@Column(name="friend_name")
	@CollectionTable(name="EMP_FRIENDS", joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eId"))
	@OrderColumn(name="friend_no")
	@ListIndexBase(value= 1)
	private List<String> friendList;
	
	@ElementCollection
	@Column(name="mobile_no")
	@CollectionTable(name="EMP_PHONE", joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eId"))
	private Set<Long> phone;
	
	@ElementCollection
	@Column(name="account_number")
	@CollectionTable(name="EMP_BANK", joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eId"))
	@MapKeyColumn(name="bankName",length = 10)
	private Map<String,Long> bankAccount;

	
	public Integer geteId() {
		return eId;
	}


	public void seteId(Integer eId) {
		this.eId = eId;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public String geteAddress() {
		return eAddress;
	}


	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}


	public List<String> getFriendList() {
		return friendList;
	}


	public void setFriendList(List<String> friendList) {
		this.friendList = friendList;
	}


	public Set<Long> getPhone() {
		return phone;
	}


	public void setPhone(Set<Long> phone) {
		this.phone = phone;
	}


	public Map<String, Long> getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(Map<String, Long> bankAccount) {
		this.bankAccount = bankAccount;
	}


	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eAddress=" + eAddress + ", friendList=" + friendList
				+ ", phone=" + phone + ", bankAccount=" + bankAccount + "]";
	}
	
	
	
}
