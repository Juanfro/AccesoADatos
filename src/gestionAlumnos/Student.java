package gestionAlumnos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {

	private int numExpediente;
	private String nombre;
	private String fechaNacimiento;
	private String address;
	private String phone;

	public Student(int numExpediente, String nombre, String fechaNacimiento, String address, String phone) {
		super();
		this.numExpediente = numExpediente;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.address = address;
		this.phone = phone;
	}

	public int getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student [numExpediente=" + numExpediente + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", address=" + address + ", phone=" + phone + "]";
	}

}
