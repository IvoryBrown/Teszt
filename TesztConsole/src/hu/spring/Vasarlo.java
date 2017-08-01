package hu.spring;

public class Vasarlo {

	private Integer vasarloID;
	private String vasarloNev;
	private int vasarloPont;
	private int vasarlotOsszeg;
	private String vasarloAdatok;

	public Integer getVasarlo_id() {
		return vasarloID;
	}
	
	public void setVasarlo_id(Integer vasarlo_id) {
		this.vasarloID = vasarlo_id;
	}
	public String getVasarlo_nev() {
		return vasarloNev;
	}

	public void setVasarlo_nev(String vasarlo_nev) {
		this.vasarloNev = vasarlo_nev;
	}

	public int getVasarlo_pont() {
		return vasarloPont;
	}

	public void setVasarlo_pont(int vasarlo_pont) {
		this.vasarloPont = vasarlo_pont;
	}

	public int getVasarlot_osszeg() {
		return vasarlotOsszeg;
	}

	public void setVasarlot_osszeg(int vasarlot_osszeg) {
		this.vasarlotOsszeg = vasarlot_osszeg;
	}

	public String getVasarlo_adatok() {
		return vasarloAdatok;
	}

	public void setVasarlo_adatok(String vasarlo_adatok) {
		this.vasarloAdatok = vasarlo_adatok;
	}

	@Override
	public String toString() {
		return "Vasarlo [vasarlo_id=" + vasarloID + ", vasarlo_nev=" + vasarloNev + ", vasarlo_pont=" + vasarloPont
				+ ", vasarlot_osszeg=" + vasarlotOsszeg + ", vasarlo_adatok=" + vasarloAdatok + "]";
	}
}
