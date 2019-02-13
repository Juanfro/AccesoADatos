package xqj;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.xqj.exist.ExistXQDataSource;

class Introduction {

	public static void main(String[] args) {

		try {
			XQDataSource xqDataSource = new ExistXQDataSource();
			XQConnection xqConnection = xqDataSource.getConnection();
			XQExpression xqExpression = xqConnection.createExpression();
			XQSequence xqSequence = xqExpression.executeQuery("for $jugador in /seleccion/jugadores/jugador\r\n" + 
					"    return $jugador/nombre//text()");
			xqSequence.writeSequence(System.out, null);
			xqConnection.close();

		} catch (XQException e) {
			e.printStackTrace();
		}

	}

}
