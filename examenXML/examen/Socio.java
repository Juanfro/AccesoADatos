package examen;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "fila_socios")
@XmlType(propOrder = { "codigo", "nombre", "fecha", "direccion", "cuota_fija" })
public class Socio implements Serializable{

	int codigo;
	String nombre;
	String Fecha;
	String direccion;
	int cuota_fija;

	public Socio() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCuota_fija() {
		return cuota_fija;
	}

	public void setCuota_fija(int cuota_fija) {
		this.cuota_fija = cuota_fija;
	}

	@Override
	public String toString() {
		return "Socio [codigo=" + codigo + ", nombre=" + nombre + ", Fecha=" + Fecha + ", direccion=" + direccion
				+ ", cuota_fija=" + cuota_fija + "]";
	}

}
