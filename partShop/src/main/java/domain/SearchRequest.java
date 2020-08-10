package domain;

public class SearchRequest {
	private String name;
	private Double priceFrom;
	private Double priceTo;
	private String categoryName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPriceFrom() {
		return priceFrom;
	}
	public void setPriceFrom(Double priceFrom) {
		this.priceFrom = priceFrom;
	}
	public Double getPriceTo() {
		return priceTo;
	}
	public void setPriceTo(Double priceTo) {
		this.priceTo = priceTo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
