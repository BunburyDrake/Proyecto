package Celular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataCelularTest {

	@Test
	void testInsertarCel() {
		Celular x=new Celular();
		x.setId(15);
		x.setMarca("xaimo");
		x.setModelo("holi");
		x.setProcesador("snap");
		x.setSistema("eowjgore");
		assertTrue(x.insertarCel());
	}

	@Test
	void testCargarCel() {
		Celular x=new Celular();
		x.setId(15);
		
		assertTrue(x.cargarCel());
	}
	@Test
	void testActualizarCel() {
		Celular x=new Celular();
		x.setId(12);
		x.setMarca("xaimo");
		x.setModelo("holi");
		x.setProcesador("snap11");
		x.setSistema("eowjgore");
		assertTrue(x.actualizarCel());
	}
	@Test
	void testEliminarCel() {
		Celular x=new Celular();
		x.setId(15);
		assertTrue(x.eliminarCel());
	}

}
