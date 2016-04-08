package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.vratiSvePoruke();
	}

	@Test
	public void testUnesiSveOk() {
		String k = "Visnja";
		String p = "Viki car";

		t.unesi(k, p);
		assertEquals(k, t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals(p, t.vratiSvePoruke().getLast().getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiNull() {
		String k = null;
		String p = null;

		t.unesi(k, p);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPrazanString() {
		String k = "";
		String p = "";

		t.unesi(k, p);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPredugaPoruka() {
		String k = "Visnja";
		String p = "";

		while (p.length() < 150) {
			p += "v";
		}

		t.unesi(k, p);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		int maxBroj = 20;
		String tag = null;

		t.vratiPoruke(maxBroj, tag);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() {
		int maxBroj = 20;
		String tag = "";

		t.vratiPoruke(maxBroj, tag);
	}

	@Test
	public void testVratiPorukeKapacitetManjiJednakNuli() {
		int maxBroj = 0;
		String tag = "fon";

		t.vratiPoruke(maxBroj, tag);
	}

	@Test
	public void testVratiPorukeSveOk() {

		t.unesi("Visnja", "#bg");
		t.unesi("Pera", "#kv");
		t.unesi("Mika", "#bg");
		t.unesi("Zika", "#ue");

		TwitterPoruka[] nizTviterPoruka = new TwitterPoruka[2];

		for (int i = 0; i < 2; i++) {
			nizTviterPoruka[i] = new TwitterPoruka();
		}
		nizTviterPoruka[0].setKorisnik("Visnja");
		nizTviterPoruka[0].setPoruka("#bg");

		nizTviterPoruka[1].setKorisnik("Mika");
		nizTviterPoruka[1].setPoruka("#bg");

		assertArrayEquals(nizTviterPoruka, t.vratiPoruke(2, "#bg"));
	}

}
