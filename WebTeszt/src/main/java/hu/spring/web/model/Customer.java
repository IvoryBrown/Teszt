package hu.spring.web.model;

public class Customer {
	private Integer vasarloID;
	private String vasarloNev;
	private int vasarloPont;
	private int vasarlotOsszeg;
	private String vasarloAdatok;

	public Customer() {

	}

	public Customer(String name, int point, int amount, String data) {
		this.vasarloNev = name;
		this.vasarloPont = point;
		this.vasarlotOsszeg = amount;
		this.vasarloAdatok = data;
	}

	

	public String getVasarloNev() {
		return vasarloNev;
	}

	public void setVasarloNev(String vasarloNev) {
		this.vasarloNev = vasarloNev;
	}

	public int getVasarloPont() {
		return vasarloPont;
	}

	public void setVasarloPont(int vasarloPont) {
		this.vasarloPont = vasarloPont;
	}

	public int getVasarlotOsszeg() {
		return vasarlotOsszeg;
	}

	public void setVasarlotOsszeg(int vasarlotOsszeg) {
		this.vasarlotOsszeg = vasarlotOsszeg;
	}

	public String getVasarloAdatok() {
		return vasarloAdatok;
	}

	public void setVasarloAdatok(String vasarloAdatok) {
		this.vasarloAdatok = vasarloAdatok;
	}
	public Integer getVasarloID() {
		return vasarloID;
	}

	public void setVasarloID(Integer vasarloID) {
		this.vasarloID = vasarloID;
	}

}
