package neodatis;

public class Jugador {

	// Atributos

	private String nombre;
	private int fechaNacimiento;
	private Equipo equipo;

	// Constructor vacio
	public Jugador() {
	}

	public Jugador(String nombre, int fechaNacimiento, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", equipo=" + equipo.getNombre() + "]";
	}

	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(int fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

}
