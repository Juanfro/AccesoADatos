package library;

import java.util.HashMap;

public class BookshopManager {

	public static void main(String[] args) {
		
		try {
			
			con = DBConection.getInstance.getConnection();
			BookShopActions bookshoActions = new BookShopActions(con);
			
			//Prueba para ej 1
			System.out.println("\ncatalogo en orden inverso:");
			bookshoActions.shoCatalogInverse();
			
			//Prueba para el ejercicio2
			HashMap<Integer, Integer> copies = new HashMap<Integer, Integer>();//TODO
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
