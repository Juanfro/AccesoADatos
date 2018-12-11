package agenda;

class Contacto {

	private int codContacto;
	private String nombre;
	private long telefono;
	private String email;

	Contacto(int codContacto, String nombre, long telefono, String email) {
		this.codContacto = codContacto;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	int getCodContacto() {
		return codContacto;
	}

	void setCodContacto(int codContacto) {
		this.codContacto = codContacto;
	}

	String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	long getTelefono() {
		return telefono;
	}

	void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

}
