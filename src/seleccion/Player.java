package seleccion;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Serializable {

	public static enum Position {
		GOALKEEPER, DEFENDER, MID_FIELDER, FORWARD
	}

	private int number;
	private String name;
	private String position;

	/**
	 * Constructor de Player
	 * 
	 * @param number   Dorsal del jugador
	 * @param name     Nombre del Jugador
	 * @param position Posición del Jugador
	 */
	public Player(int number, String name, Position position) {
		super();
		this.number = number;
		this.name = name;
		this.position = position.toString();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position.toString();
	}

	/*
	 * public String getPosition() { return position; }
	 * 
	 * public void setPosition(String position) { this.position = position; }
	 */

}
