package domain;

public class OpenWeatherMapModel {
	private MainModel main;
	private Wind wind;
	private Clouds clouds;
	public MainModel getMain() {
		return main;
	}
	public void setMain(MainModel main) {
		this.main = main;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	
	
}
