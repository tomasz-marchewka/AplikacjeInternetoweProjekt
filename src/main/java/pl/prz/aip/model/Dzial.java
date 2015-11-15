package pl.prz.aip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DZIAL")
public class Dzial extends BaseModel<Integer> {
	
	public static final String OPIS = "opis";
	public static final String NAZWA = "nazwa";
	
	private String opis;
	private String nazwa;
	
	@Column(name = "OPIS")
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	@Column(name = "NAZWA")
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	

}
