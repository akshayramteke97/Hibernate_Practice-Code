package in.ineuron.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pNo;
	private String pName;
	private String pAddress;
	
	@Lob
	private byte[] pImage;
	@Lob
	private char[] pResume;
	
	
	public Integer getpNo() {
		return pNo;
	}


	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpAddress() {
		return pAddress;
	}


	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}


	public byte[] getpImage() {
		return pImage;
	}


	public void setpImage(byte[] pImage) {
		this.pImage = pImage;
	}


	public char[] getpResume() {
		return pResume;
	}


	public void setpResume(char[] pResume) {
		this.pResume = pResume;
	}


	@Override
	public String toString() {
		return "JobSeeker [pNo=" + pNo + ", pName=" + pName + ", pAddress=" + pAddress + ", pImage="
				+ Arrays.toString(pImage) + ", pResume=" + Arrays.toString(pResume) + "]";
	}
	
	
}
