package kalkulatorRat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import calculator.KalkulatorRatyMalejace;
import calculator.Rata;

public class TestKalulatorRatyMalejace extends Mockito {
	@Test
	public void pobierzRatyMalejace() {
		Double kwotaKredytu = Double.valueOf("10000"); 
		Integer iloscRat = 3;
		Double oprocentowanie = Double.valueOf("3.5"); 
		Double oplataStala = Double.valueOf("100");
		
		KalkulatorRatyMalejace kalkulator = new KalkulatorRatyMalejace(kwotaKredytu, iloscRat, oprocentowanie, oplataStala);
		List<Rata> raty = kalkulator.pobierzRaty();

		assertEquals(3, raty.size());
		
		assertEquals(Double.valueOf("3333.33"), raty.get(0).getKwotaKapitalu());
		assertEquals(Double.valueOf("100"), raty.get(0).getOplataStala());
		assertEquals(Double.valueOf("29.17"), raty.get(0).getKwotaOdsetek());
		
		assertEquals(Double.valueOf("3333.33"), raty.get(1).getKwotaKapitalu());
		assertEquals(Double.valueOf("100"), raty.get(1).getOplataStala());
		assertEquals(Double.valueOf("19.44"), raty.get(1).getKwotaOdsetek());
		
		assertEquals(Double.valueOf("3333.33"), raty.get(2).getKwotaKapitalu());
		assertEquals(Double.valueOf("100"), raty.get(2).getOplataStala());
		assertEquals(Double.valueOf("9.72"), raty.get(2).getKwotaOdsetek());
		
	}
}
