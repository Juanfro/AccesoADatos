package oficinaNeodatis;

public class Direccion {

	private int idDireccion;
	private String calle;
	private String codPostal;
	private String Localidad;
	private String Provincia;
	private Empleado empleado;

	public Direccion() {
		super();
	}

	public Direccion(int idDireccion, String calle, String codPostal, String localidad, String provincia,
			Empleado empleado) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.codPostal = codPostal;
		Localidad = localidad;
		Provincia = provincia;
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", codPostal=" + codPostal
				+ ", Localidad=" + Localidad + ", Provincia=" + Provincia + ", empleado=" + empleado + "]";
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
