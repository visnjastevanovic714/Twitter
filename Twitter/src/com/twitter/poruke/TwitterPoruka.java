package com.twitter.poruke;

/**
 * 
 * @author Visnja Stevanovic
 *
 */

public class TwitterPoruka {

	/**
	 * Ime korisnika
	 */
	private String korisnik;

	/**
	 * Tekst poruke
	 */
	private String poruka;

	/**
	 * Metoda vraca ime korisnika
	 * 
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda postavlja ime korisnika
	 * 
	 * @param korisnik
	 * @throws java.lang.RuntimeException
	 *             ako je uneta vrednost atributa korisnik
	 *             <ul>
	 *             <li>null
	 *             <li>prazan String
	 *             </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca tekst poruke
	 * 
	 * @return tekst poruke
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Metoda postavlja tekst poruke
	 * 
	 * @param poruka
	 *            * @throws java.lang.RuntimeException ako je uneta vrednost
	 *            atributa poruka
	 *            <ul>
	 *            <li>null
	 *            <li>duzina veca od 140 karaktera
	 *            </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterPoruka other = (TwitterPoruka) obj;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (poruka == null) {
			if (other.poruka != null)
				return false;
		} else if (!poruka.equals(other.poruka))
			return false;
		return true;
	}

}
