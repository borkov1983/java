package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class KalkulatorRatyStale extends Kalkulator {

	public KalkulatorRatyStale(Double kwotaKredytu, Integer iloscRat, Double oprocentowanie, Double oplataStala) {
		super(kwotaKredytu, iloscRat, oprocentowanie, oplataStala);
	}
	
	public List<Rata> pobierzRaty() {
		List<Rata> raty = new ArrayList<>(this.iloscRat);
		
		Double oprocentowanie = this.pobierzOprocentowanie();
		Double q = 1 + (double) 1/12 * oprocentowanie;
		Double kosztCalkowity = (this.pozostalyKapitalDoSplaty*Math.pow(q, this.iloscRat)*(1-q)) / (1-Math.pow(q, this.iloscRat));
		
		for (int i = 1; i <= this.iloscRat; i++) {
			Double kwotaOdsetek = this.pozostalyKapitalDoSplaty * oprocentowanie * (double) 1/12;
			Double kwotaKapitalu = kosztCalkowity - kwotaOdsetek;
			
			this.aktualizacjaPozostalegoKapitalu(kwotaKapitalu);
			raty.add(
					new Rata(i, kwotaKapitalu, kwotaOdsetek, this.oplataStala, kosztCalkowity));
		}
		return raty;
	}
	
	private Double pobierzOprocentowanie() {
		return new BigDecimal(this.oprocentowanie / 100).setScale(6, RoundingMode.HALF_UP).doubleValue();
	}
}
