package pl.prz.aip.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EWIDENCJA")
public class Ewidencja extends BaseModel<Integer> {
	
	public static final String DATA_WEJSCIA = "dataWejscia";
	public static final String DATA_WYJSCIA = "dataWyjscia";
	public static final String PRACOWNIK = "pracownik";
	
	private Date dataWejscia;
	private Date dataWyjscia;
	private Pracownik pracownik;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_WEJSCIA")
	public Date getDataWejscia() {
		return dataWejscia;
	}
	public void setDataWejscia(Date dataWejscia) {
		this.dataWejscia = dataWejscia;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_WYJSCIA")
	public Date getDataWyjscia() {
		return dataWyjscia;
	}
	public void setDataWyjscia(Date dataWyjscia) {
		this.dataWyjscia = dataWyjscia;
	}
	@ManyToOne
	@JoinColumn(name = "PRACOWNIK")
	public Pracownik getPracownik() {
		return pracownik;
	}
	public void setPracownik(Pracownik pracownik) {
		this.pracownik = pracownik;
	}
	
	

}
