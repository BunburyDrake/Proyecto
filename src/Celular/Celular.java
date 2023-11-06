package Celular;

public class Celular {
int id;
String Marca;
String Modelo;
String Sistema;
String Procesador;
DataCelular dc=new DataCelular();
public boolean insertarCel() {
	if(dc.insertarCel(this)) {
		return true;
	}else {
		return false;
	}
}
public boolean cargarCel() {
	if(dc.cargarCel(this)) {
		return true;
	}else {
		return false;
	}
}

public boolean eliminarCel() {
	return true;
}
public boolean actualizarCel() {
	return true;
}

public Celular() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMarca() {
	return Marca;
}
public void setMarca(String marca) {
	Marca = marca;
}
public String getModelo() {
	return Modelo;
}
public void setModelo(String modelo) {
	Modelo = modelo;
}
public String getSistema() {
	return Sistema;
}
public void setSistema(String sistema) {
	Sistema = sistema;
}
public String getProcesador() {
	return Procesador;
}
public void setProcesador(String procesador) {
	Procesador = procesador;
}


}
