package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rata {
	
	private Integer numer;
	private Double kwotaKapitalu;
	private Double kwotaOdsetek;
	private Double oplataStala;
	private Double kosztCalkowity;	
	
	public Rata(Integer numer, Double kwotaKapitalu, Double kwotaOdsetek, Double oplataStala, Double kosztCalkowity) {
		super();
		this.numer = numer;
		this.kwotaKapitalu = new BigDecimal(kwotaKapitalu).setScale(2, RoundingMode.HALF_UP).doubleValue();
		this.kwotaOdsetek = new BigDecimal(kwotaOdsetek).setScale(2, RoundingMode.HALF_UP).doubleValue();
		this.oplataStala = new BigDecimal(oplataStala).setScale(2, RoundingMode.HALF_UP).doubleValue();
		this.kosztCalkowity = new BigDecimal(kosztCalkowity + this.oplataStala).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	public Integer getNumer() {
		return numer;
	}

	public void setNumer(Integer numer) {
		this.numer = numer;
	}

	public Double getKwotaKapitalu() {
		return kwotaKapitalu;
	}

	public void setKwotaKapitalu(Double kwotaKapitalu) {
		this.kwotaKapitalu = kwotaKapitalu;
	}

	public Double getKwotaOdsetek() {
		return kwotaOdsetek;
	}

	public void setKwotaOdsetek(Double kwotaOdsetek) {
		this.kwotaOdsetek = kwotaOdsetek;
	}

	public Double getOplataStala() {
		return oplataStala;
	}

	public void setOplataStala(Double oplataStala) {
		this.oplataStala = oplataStala;
	}

	public Double getKosztCalkowity() {
		return kosztCalkowity;
	}

	public void setKosztCalkowity(Double kosztCalkowity) {
		this.kosztCalkowity = kosztCalkowity;
	}
	
	
}
