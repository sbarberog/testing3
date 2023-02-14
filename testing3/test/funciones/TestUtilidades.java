package funciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestUtilidades {

	private static Utilidades u;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		u=new Utilidades();
	}

	@Test
	void testDevuelveNota() {
		assertThrows(ArithmeticException.class, ()->u.devuelveNota(-0.1));
		assertThrows(ArithmeticException.class, ()->u.devuelveNota(10.1));
		assertEquals("Suspenso", u.devuelveNota(0));
		assertEquals("Suspenso", u.devuelveNota(4.9));
		assertEquals("Bien", u.devuelveNota(5));
		assertEquals("Bien", u.devuelveNota(6.4));
		assertEquals("Notable", u.devuelveNota(6.5));
		assertEquals("Notable", u.devuelveNota(8.4));
		assertEquals("Sobresaliente", u.devuelveNota(8.5));
		assertEquals("Sobresaliente", u.devuelveNota(9.9));
		assertEquals("Matrícula", u.devuelveNota(10));
	}

	@Test
	void testCalculaSalario() {
		assertEquals((Utilidades.HORASJORNADA-2)*10, u.calculaSalario(
				Utilidades.HORASJORNADA-2, 10, 20));
		assertEquals(
				Utilidades.HORASJORNADA*10 + 2*20, u.calculaSalario(
						Utilidades.HORASJORNADA+2, 10, 20));
		//caso límite
		assertEquals(Utilidades.HORASJORNADA*10, u.calculaSalario(
				Utilidades.HORASJORNADA, 10, 20));
		//excepción
		assertEquals(420, u.calculaSalario(40, 10, 20));
		assertThrows(ArithmeticException.class, ()-> u.calculaSalario(-5, 10, 20));
		assertThrows(ArithmeticException.class, ()-> u.calculaSalario(5, -10, 20));
		assertThrows(ArithmeticException.class, ()-> u.calculaSalario(5, 10, -20));
		assertThrows(ArithmeticException.class, ()-> u.calculaSalario(0, 10, 20));
		assertThrows(ArithmeticException.class, ()-> u.calculaSalario(5, 0, 20));
		assertThrows(ArithmeticException.class, ()-> u.calculaSalario(5, 10, 0));
	}

	@Test
	void testCuentaDivisores() {
		assertEquals(1, u.cuentaDivisores(1));
		assertEquals(2, u.cuentaDivisores(5));
		assertEquals(6, u.cuentaDivisores(12));
		assertEquals(2, u.cuentaDivisores(37));
	}

	@Test
	void testDevuelveMenor() {
		int prueba[]= {2,-5,0};
		assertEquals(-5, u.devuelveMenor(prueba),
				"El menor valor del vector debe ser -5");
		int prueba2[]= {-10,-5,0};
		assertEquals(-10, u.devuelveMenor(prueba2),
				"El menor valor del vector debe ser -5");
	}

	@Test
	void testBurbuja() {
		int prueba[]= {4,3,3,-7};
		int resultado[]= {-7,3,3,4};
		int prueba2[]= {1,2,3,4,5};
		assertArrayEquals(resultado, u.burbuja(prueba));
		assertArrayEquals(prueba2, u.burbuja(prueba2));
	}

}
