package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accNo;
	private String holderName;
	private Double balance;
	private String type;

	@CreationTimestamp
	private LocalDateTime openingDate;

	@UpdateTimestamp
	private LocalDateTime lastUpdated;

	@Version
	private Integer count;

	public Long getAccNo() {
		return accNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public Double getBalance() {
		return balance;
	}

	public String getType() {
		return type;
	}

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public Integer getCount() {
		return count;
	}

	static {
		System.out.println("BankAccount.class file is loading...");
	}

	public BankAccount() {
		System.out.println("BankAccount object is instantiated...");
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", holderName=" + holderName + ", balance=" + balance + ", type=" + type
				+ ", openingDate=" + openingDate + ", lastUpdated=" + lastUpdated + ", count=" + count + "]";
	}

}
