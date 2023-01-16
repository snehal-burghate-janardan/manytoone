package many_to_one_uni2_dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String headoffice;
	private String Ceo;
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", headoffice=" + headoffice + ", Ceo=" + Ceo + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadoffice() {
		return headoffice;
	}
	public void setHeadoffice(String headoffice) {
		this.headoffice = headoffice;
	}
	public String getCeo() {
		return Ceo;
	}
	public void setCeo(String ceo) {
		Ceo = ceo;
	}
	
}
