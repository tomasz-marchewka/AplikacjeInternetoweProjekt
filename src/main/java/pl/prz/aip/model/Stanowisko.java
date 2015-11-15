package pl.prz.aip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STANOWISKO")
public class Stanowisko extends BaseModel<Integer> {
	
	public static final String NAZWA = "nazwa";
	
	private String nazwa;

	@Column(name = "STANOWISKO")
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	

}
