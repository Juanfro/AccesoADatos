package xmlPackage;



import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Libro {

	@XmlElementWrapper(name = "authors")
	@XmlElement(name = "author")
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	@XmlAttribute(name = "id")
	public void setId(String id) {
		this.id = id;
	}

}
