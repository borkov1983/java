package kalkulatorRat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import calculator.KalkulatorRatyMalejace;
import calculator.KalkulatorRatyStale;
import calculator.Rata;

public class TestKalulatorRatyStale extends Mockito {
	@Test
	public void pobierzRatyStale() {
		Double kwotaKredytu = Double.valueOf("10000"); 
		Integer iloscRat = 3;
		Double oprocentowanie = Double.valueOf("3.5"); 
		Double oplataStala = Double.valueOf("100");
		
		KalkulatorRatyStale kalkulator = new KalkulatorRatyStale(kwotaKredytu, iloscRat, oprocentowanie, oplataStala);
		List<Rata> raty = kalkulator.pobierzRaty();

		assertEquals(3, raty.size());
		
		assertEquals(Double.valueOf("3323.63"), raty.get(0).getKwotaKapitalu());
		assertEquals(Double.valueOf("100"), raty.get(0).getOplataStala());
		assertEquals(Double.valueOf("29.17"), raty.get(0).getKwotaOdsetek());
		assertEquals(Double.valueOf("3452.8"), raty.get(0).getKosztCalkowity());
		
		assertEquals(Double.valueOf("3333.32"), raty.get(1).getKwotaKapitalu());
		assertEquals(Double.valueOf("100"), raty.get(1).getOplataStala());
		assertEquals(Double.valueOf("19.47"), raty.get(1).getKwotaOdsetek());
		assertEquals(Double.valueOf("3452.8"), raty.get(1).getKosztCalkowity());
		
		assertEquals(Double.valueOf("3343.05	"), raty.get(2).getKwotaKapitalu());
		assertEquals(Double.valueOf("100"), raty.get(2).getOplataStala());
		assertEquals(Double.valueOf("9.75"), raty.get(2).getKwotaOdsetek());
		assertEquals(Double.valueOf("3452.8"), raty.get(2).getKosztCalkowity());
		
	}
}
