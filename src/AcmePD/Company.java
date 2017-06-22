package AcmePD;

public class Company {
	private String name;
	private String street;
	private String avenue;
	private int fixedbillAmount;
	private int bonusAmount;
	private int bonusMinTotal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAvenue() {
		return avenue;
	}
	public void setAvenue(String avenue) {
		this.avenue = avenue;
	}
	public int getFixedbillAmount() {
		return fixedbillAmount;
	}
	public void setFixedbillAmount(int fixedbillAmount) {
		this.fixedbillAmount = fixedbillAmount;
	}
	public int getBonusAmount() {
		return bonusAmount;
	}
	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}
	public int getBonusMinTotal() {
		return bonusMinTotal;
	}
	public void setBonusMinTotal(int bonusMinTotal) {
		this.bonusMinTotal = bonusMinTotal;
	}

}
