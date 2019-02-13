package xqj;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class QuickStart {
	public static void main(String[] args) throws XQException {
		XQDataSource xqs = new ExistXQDataSource();
		xqs.setProperty("serverName", "localhost");
		xqs.setProperty("port", "8080");

		XQConnection conn = xqs.getConnection();

		
		//XQPreparedExpression xqpe = conn.prepareExpression("declare variable $x as xs:string external; $x");
		/*XQPreparedExpression xqpe = conn.prepareExpression("for $book in /catalog//book\r\n" + 
				"where $book/price > 30.00\r\n" + 
				"return $book/title");*/
		XQPreparedExpression xqpe = conn.prepareExpression("for $producto in /catalogo/productos/producto\r\n" + 
				"    where $producto/categoria = \"verdura\"\r\n" + 
				"    return $producto/nombre/text()");
		
		
		
		

		//xqpe.bindString(new QName("x"), "Hello World!", null);

		XQResultSequence rs = xqpe.executeQuery();

		while (rs.next())
			System.out.println(rs.getItemAsString(null));

		conn.close();
	}
}
