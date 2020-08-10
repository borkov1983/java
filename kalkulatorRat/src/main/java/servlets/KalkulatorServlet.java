package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calculator.KalkulatorRatyMalejace;
import calculator.KalkulatorRatyStale;
import calculator.Rata;

@WebServlet("/kalkulator")
public class KalkulatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Rata> raty = new ArrayList<>();
		
		List<String> bledy = this.walidacja(request);
		
		if(bledy.size() > 0) {
			request.setAttribute("bledy", bledy);
			
			this.ustawWartoscPolaFormularza("kwotaKredytu", request);
			this.ustawWartoscPolaFormularza("iloscRat", request);
			this.ustawWartoscPolaFormularza("oprocentowanie", request);
			this.ustawWartoscPolaFormularza("oplataStala", request);
			this.ustawWartoscPolaFormularza("typRat", request);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		Double kwotaKredytu = Double.valueOf(request.getParameter("kwotaKredytu"));
		Integer iloscRat = Integer.valueOf(request.getParameter("iloscRat"));
		Double oprocentowanie = Double.valueOf(request.getParameter("oprocentowanie"));
		Double oplataStala = Double.valueOf(request.getParameter("oplataStala"));
		String typRat = request.getParameter("typRat");
		
		if(typRat.equals("stale")) {
			KalkulatorRatyStale kalkulator = new KalkulatorRatyStale(kwotaKredytu, iloscRat, oprocentowanie, oplataStala);
			raty = kalkulator.pobierzRaty();
		} else {
			KalkulatorRatyMalejace kalkulator = new KalkulatorRatyMalejace(kwotaKredytu, iloscRat, oprocentowanie, oplataStala);
			raty = kalkulator.pobierzRaty();
		}

        request.setAttribute("raty", raty);
        request.getRequestDispatcher("/output.jsp").forward(request, response);
	}
	
	private List<String> walidacja(HttpServletRequest request) {
		List<String> bledy = new ArrayList<>();
		request.getParameterMap().forEach((name, value) -> {
			if(request.getParameter(name).isEmpty()) {
				bledy.add(name);
			}
		});
		return bledy;
	}
	
	private void ustawWartoscPolaFormularza(String name, HttpServletRequest request) {		
		try {
			request.setAttribute(name, request.getParameter(name));
		} catch (Exception e) {
			System.out.println("Nie można pobrać wartości dla pola " + name);
		}
	}
}
