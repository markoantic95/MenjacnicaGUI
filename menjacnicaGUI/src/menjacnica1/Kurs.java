package menjacnica1;

import java.util.GregorianCalendar;

public class Kurs {
	private double prodajni;
	private double srednji;
	private double kupovni;
	private String sifra, naziv, skraceniNaziv;
	
	
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	public double getProdajni() {
		return prodajni;
	}
	public void setProdajni(double prodajni) {
		if (prodajni <= 0){
			throw new RuntimeException("Greska.");
		}
		this.prodajni = prodajni;
	}
	public double getSrednji() {
		return srednji;
	}
	public void setSrednji(double srednji) {
		if (srednji <= 0){
			throw new RuntimeException("Greska.");
		}
		this.srednji = srednji;
	}
	public double getKupovni() {
		return kupovni;
	}
	public void setKupovni(double kupovni) {
		if (kupovni <= 0){
			throw new RuntimeException("Greska.");
		}
		this.kupovni = kupovni;
	}
	@Override
	public String toString() {
		return "Šifra: " + sifra + ", Naziv: " + naziv + ", Prodajni kurs: " + prodajni + ", Kupovni kurs: " + kupovni
				+ ", Srednji kurs: " + srednji + ", Skraceni naziv: " + skraceniNaziv + "\n";
	}
	
	
	

	
}
