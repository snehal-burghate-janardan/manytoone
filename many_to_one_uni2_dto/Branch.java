package many_to_one_uni2_dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Bid;
	private String ifsc;
	private String name;
	private String address;
	private long phone;
	
	@Override
	public String toString() {
		return "Branch [Bid=" + Bid + ", ifsc=" + ifsc + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", bank=" + bank + "]";
	}

	@ManyToOne
	private Bank bank;

	public int getBid() {
		return Bid;
	}

	public void setBid(int bid) {
		Bid = bid;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
}
