package examenNeodatis;

/**
 * Clase que define Línea de Venta
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class LineaVenta {

	private int id;
	private int numeroLinea;
	private String producto;
	private int pvp;
	private int cantidad;
	private Venta venta;

	/**
	 * Constructor vacío
	 */
	public LineaVenta() {
	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param id
	 * @param numeroLinea
	 * @param producto
	 * @param pvp
	 * @param cantidad
	 * @param venta
	 */
	public LineaVenta(int id, int numeroLinea, String producto, int pvp, int cantidad, Venta venta) {
		this.id = id;
		this.numeroLinea = numeroLinea;
		this.producto = producto;
		this.pvp = pvp;
		this.cantidad = cantidad;
		this.venta = venta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(int numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getPvp() {
		return pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}
