package examen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "SOCIOS_GIM")
//@XmlType(propOrder = { "socios" })
public class Socios_gim implements Serializable{

	private List<Socio> socios = new ArrayList<>();

	public Socios_gim() {
	}


	public List<Socio> getSocios() {
		return socios;
	}

	@XmlElementWrapper(name = "socios")
	@XmlElement(name = "fila_socios")
	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}

}
