package calculator;

public class Kalkulator {
	protected Double kwotaKredytu;
	protected Integer iloscRat;
	protected Double oprocentowanie;
	protected Double oplataStala;
	protected Double pozostalyKapitalDoSplaty;
	
	public Kalkulator(Double kwotaKredytu, Integer iloscRat, Double oprocentowanie, Double oplataStala) {
		this.kwotaKredytu = kwotaKredytu;
		this.iloscRat = iloscRat;
		this.oprocentowanie = oprocentowanie;
		this.oplataStala = oplataStala;
		this.pozostalyKapitalDoSplaty = kwotaKredytu;
	}
	
	public void aktualizacjaPozostalegoKapitalu(Double zaplacono) {
		this.pozostalyKapitalDoSplaty -= zaplacono;
	}

}
