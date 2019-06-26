package com.ipartek.formacion.uf2216;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class RevistaTest {

	Revista rev;

	@Before
	public void setUp() throws Exception {
		rev = new Revista();
	}

	@Test
	public void test() {
	}

	@Test
	public void testSetTitulo() throws Exception {

		try {
			rev.setTitulo(null);
			fail("No se puede guardar el título a NULL.");
		} catch (Exception e) {
		}

		try {
			rev.setTitulo("12");
			fail("No se puede guardar el título tan corto.");
		} catch (Exception e) {
		}

		try {
			rev.setTitulo(
					"1123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
			fail("No se puede guardar el título tan largo.");
		} catch (Exception e) {
		}

		rev.setTitulo(
				"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		assertEquals(
				"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
				rev.getTitulo());
	}

	@Test
	public void testSetIsbn() throws Exception {
		try {
			rev.setIsbn(0);
			fail("El ISBN no puede ser menor que 10.");
		} catch (Exception e) {
		}

		rev.setIsbn(1234567890);
		assertEquals(1234567890, rev.getIsbn());
	}

	@Test
	public void testSetPaginas() throws Exception {
		try {
			rev.setPaginas(0);
			fail("El número de páginas no puede ser menor que 1.");
		} catch (Exception e) {
		}

		rev.setPaginas(1);
		assertEquals(1, rev.getPaginas());

		rev.setPaginas(100);
		assertEquals(100, rev.getPaginas());

	}
}
