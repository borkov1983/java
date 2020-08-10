package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WeatherResponse {
	private Double clouds;
	private Double temp;
	private Double pressure;
	private Double wind;
	
	public Double getClouds() {
		return clouds;
	}
	public void setClouds(Double clouds) {
		this.clouds = clouds;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	public Double getWind() {
		return wind;
	}
	public void setWind(Double wind) {
		this.wind = wind;
	}
	public WeatherResponse(Double clouds, Double temp, Double pressure, Double wind) {
		super();
		this.clouds = new BigDecimal(clouds).setScale(2, RoundingMode.HALF_UP).doubleValue();
		this.temp = new BigDecimal(temp - 273.15).setScale(2, RoundingMode.HALF_UP).doubleValue();
		this.pressure = new BigDecimal(pressure).setScale(2, RoundingMode.HALF_UP).doubleValue();;
		this.wind = new BigDecimal(wind).setScale(2, RoundingMode.HALF_UP).doubleValue();;
	}
	
	
}
