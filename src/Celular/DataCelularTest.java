package Celular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataCelularTest {

	@Test
	void testInsertarCel() {
		Celular c=new Celular();
		c.setId(11);
		c.setMarca("hola");
		c.setModelo("lol");
		c.setProcesador("lolillo");
		c.setSistema("android");
		assertTrue(c.insertarCel());
	}

	@Test
	void testCargarCel() {
		Celular c=new Celular();
		c.setId(11);
		assertTrue(c.cargarCel());
	}

	

	@Test
	void testActualizarCel() {
		Celular c=new Celular();
		c.setId(11);
		c.setMarca("hola");
		c.setModelo("lol");
		c.setProcesador("lolillo");
		c.setSistema("android");
		assertTrue(c.actualizarCel());
	}
	@Test
	void testEliminarCel() {
		Celular c=new Celular();
		c.setId(12);
		assertTrue(c.eliminarCel());
	}

}
