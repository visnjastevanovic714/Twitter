package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * Ova klasa sadrzi metode za unos i pronalazenje i vracanje poruka
 * 
 * @author Visnja Stevanovic
 *
 */

public class Twitter {
	/**
	 * Inicijalizacija liste objekata klase TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda koja vraca sve poruke
	 * 
	 * @return lista poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda unosi novu poruku na kraj liste
	 * 
	 * @param korisnik
	 *            Ime korisnika
	 * @param poruka
	 *            Tekst poruke
	 * 
	 * @throws java.lang.RuntimeException
	 *             ako je uneta vrednost atributa korisnik ili atributa poruka
	 *             <ul>
	 *             <li>null
	 *             <li>prazan String
	 *             </ul>
	 * 
	 */
	public void unesi(String korisnik, String poruka) {
		if (korisnik == "" || poruka == "" || korisnik == null || poruka == null) {
			throw new RuntimeException("Korisnik i poruka ne smeju biti null, kao ni prazan String");
		}
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * 
	 * @param maxBroj
	 *            Maximalan broj poruka
	 * @param tag
	 *            Tag koji se prosledjuje
	 * @throws java.lang.RuntimeException
	 *             ako je vrednost atributa tag
	 *             <ul>
	 *             <li>null
	 *             <li>prazan String
	 *             </ul>
	 * @return niz poruka koje sadrze unet tag
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
