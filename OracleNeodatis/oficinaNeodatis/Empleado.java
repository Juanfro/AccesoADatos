package oficinaNeodatis;

import java.util.Date;
import java.util.List;

public class Empleado {

	private int idEmpleado;
	private String nombre;
	private Date fechaNacimiento;
	private Empleado jefe;
	private List<Empleado> subordinados;
	private List<Direccion> direcciones;

	public Empleado() {
	}

	public Empleado(int idEmpleado, String nombre, Date fechaNacimiento, Empleado jefe, List<Empleado> subordinados,
			List<Direccion> direcciones) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.jefe = jefe;
		this.subordinados = subordinados;
		this.direcciones = direcciones;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado //
				+ ", nombre=" + nombre //
				+ ", fechaNacimiento=" + fechaNacimiento.toString() //
				+ ", jefe=" + jefe.getNombre() //
				+ ", subordinados=" + subordinados //
				+ ", direcciones=" + direcciones + "]"; //
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Empleado getJefe() {
		return jefe;
	}

	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}

	public List<Empleado> getSubordinados() {
		return subordinados;
	}

	public void setSubordinados(List<Empleado> subordinados) {
		this.subordinados = subordinados;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

}
