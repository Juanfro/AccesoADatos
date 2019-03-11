package examenNeodatis;

import java.util.Date;
import java.util.List;

/**
 * Clase que define Venta
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class Venta {
	private int id;
	private int idCLiente;
	private Date fechaVenta;
	private List<LineaVenta> lineasVenta;

	// Constructor vacío
	public Venta() {
	}

	public Venta(int id, int idCLiente, Date fechaVenta, List<LineaVenta> lineasVenta) {
		this.id = id;
		this.idCLiente = idCLiente;
		this.fechaVenta = fechaVenta;
		this.lineasVenta = lineasVenta;
	}

	// Setters & Getters

	// ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// ID Cliente
	public int getIdCLiente() {
		return idCLiente;
	}

	public void setIdCLiente(int idCLiente) {
		this.idCLiente = idCLiente;
	}

	// FECHA DE VENTA
	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	// LINEAS DE VENTA
	public List<LineaVenta> getLineasVenta() {
		return lineasVenta;
	}

	public void setLineasVenta(List<LineaVenta> lineasVenta) {
		this.lineasVenta = lineasVenta;
	}

	// Fin Setters & Getters

	// *********************************************************************************//

	/**
	 * Calcule el importe total de la venta.
	 */
	public void importeTotal() {
		int importe = 0;
		for (LineaVenta lineaVenta : lineasVenta) {
			importe += lineaVenta.getCantidad() * lineaVenta.getPvp();
		}

		System.out.println("El importe total de la venta " + getId() + " es: " + importe + "€");
	}

}
