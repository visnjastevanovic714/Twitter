package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {
	TwitterPoruka tp;

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testSetKorisnikSveOk() {
		tp.setKorisnik("Visnja");
		assertEquals("Visnja", tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
	}

	@Test
	public void testSetPorukaSveOk() {
		tp.setPoruka("Ajmooo FOOOON");
		assertEquals("Ajmooo FOOOON", tp.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPreko140() {
		String p = "";
		for (int i = 0; i <= 50; i++) {
			p += "fon";
		}
		tp.setPoruka(p);
		assertEquals(p, tp.getPoruka());
	}

	@Test
	public void testToString() {
		String korisnik = "Visnja";
		String poruka = "Car";
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		assertEquals("KORISNIK:" + korisnik + " PORUKA:" + poruka, tp.toString());
	}

}
