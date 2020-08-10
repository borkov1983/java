package calculator;

import java.util.ArrayList;
import java.util.List;

public class KalkulatorRatyMalejace extends Kalkulator {

	public KalkulatorRatyMalejace(Double kwotaKredytu, Integer iloscRat, Double oprocentowanie, Double oplataStala) {
		super(kwotaKredytu, iloscRat, oprocentowanie, oplataStala);
	}

	public List<Rata> pobierzRaty() {
		List<Rata> raty = new ArrayList<>(this.iloscRat);	
		Double kwotaKapitalu = this.kwotaKredytu / this.iloscRat;
		
		for (int i = 1; i <= this.iloscRat; i++) {
			Double kwotaOdesetek = this.pobierzKwoteOdsetek();
			this.aktualizacjaPozostalegoKapitalu(kwotaKapitalu);
			Double totalPayment = kwotaKapitalu + kwotaOdesetek;
			
			raty.add(
					new Rata(i, kwotaKapitalu, kwotaOdesetek, this.oplataStala, totalPayment));
		}
		return raty;
	}
	
	private Double pobierzKwoteOdsetek() {
		return this.pozostalyKapitalDoSplaty * ((this.oprocentowanie/100)/12);
	}
}
