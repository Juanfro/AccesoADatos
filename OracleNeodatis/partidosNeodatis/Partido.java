package partidosNeodatis;

import java.util.Date;

public class Partido {

	private Date fechapartido;
	private Equipo local, visitante;
	private int golesLocal, golesVisitante;

	public Partido() {
	}

	public Partido(Date fechapartido, Equipo local, Equipo visitante, int golesLocal, int golesVisitante) {
		this.fechapartido = fechapartido;
		this.local = local;
		this.visitante = visitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}

	@Override
	public String toString() {
		return "Partido [fechapartido=" + fechapartido + ", local=" + local + ", visitante=" + visitante
				+ ", golesLocal=" + golesLocal + ", golesVisitante=" + golesVisitante + "]";
	}

	public Date getFechapartido() {
		return fechapartido;
	}

	public void setFechapartido(Date fechapartido) {
		this.fechapartido = fechapartido;
	}

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

}
