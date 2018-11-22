package seleccion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import seleccion.Player.Position;
import seleccionJDBC.JugadorJDBC;
import seleccionJDBC.JugadorJDBC.PositionJDBC;

public class PlayerDao implements Dao<Player> {

	public static final String FILE_NAME = "players";
	public static final String DATA_EXT = ".dat";
	public static final int PLAYER_OBJECT_MAX_SIZE = 500;

	private FileChannel fcd;

	/**
	 * Serializa un Objeto
	 * 
	 * @param obj Objeto a serializar
	 * @return Array de bytes con los datos del objeto serializados
	 * @throws IOException
	 */
	public static byte[] serialize(Object obj) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(obj);
		os.flush();

		return out.toByteArray();
	}

	public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream is = new ObjectInputStream(in);

		return is.readObject();
	}

	@SuppressWarnings("resource")
	public PlayerDao() {
		try {
			fcd = new RandomAccessFile(PlayerDao.FILE_NAME + PlayerDao.DATA_EXT, "rw").getChannel();
			fcd.force(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Player get(int numPlayer) {
		Player player = null;

		try {
			int dataOffset = PlayerDao.PLAYER_OBJECT_MAX_SIZE * (numPlayer);
			fcd.position(dataOffset);
			ByteBuffer sizeBB = ByteBuffer.allocate(4);
			int bytesRead = fcd.read(sizeBB);

			if (bytesRead != -1) {
				sizeBB.flip();
				int size = sizeBB.getInt();

				if (size > 0) {
					fcd.position(dataOffset + 4);
					ByteBuffer playerBB = ByteBuffer.allocate(size);
					fcd.read(playerBB);
					playerBB.flip();
					byte[] se2 = playerBB.array();
					player = (Player) PlayerDao.deserialize(se2);
				}
			} else {
				player = new Player(-1, "Fin", Position.GOALKEEPER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}// End get

	@Override
	public List<Player> getAll() {

		List<Player> lista = new ArrayList<Player>();
		int numPlayer = 0;
		boolean finFichero = false;

		try {

			while (!finFichero) {
				/*
				 * Player player = null; int dataOffset = PlayerDao.PLAYER_OBJECT_MAX_SIZE *
				 * numPlayer; fcd.position(dataOffset); ByteBuffer sizeBB =
				 * ByteBuffer.allocate(4); int bytesRead = fcd.read(sizeBB);
				 * 
				 * if (bytesRead != -1) { sizeBB.flip(); int size = sizeBB.getInt();
				 * 
				 * if (size > 0) { fcd.position(dataOffset + 4); ByteBuffer playerBB =
				 * ByteBuffer.allocate(size); fcd.read(playerBB); playerBB.flip(); byte[] se2 =
				 * playerBB.array(); player = (Player) PlayerDao.deserialize(se2);
				 * lista.add(player); } numPlayer++; } else { finFichero = true; }
				 */

				// Player player = null;
				Player player = get(numPlayer);

				if (player == null) {
					numPlayer++;
				} else if (player.getNumber() == -1) {
					finFichero = true;
				} else {
					lista.add(player);
					numPlayer++;
				}

			}

			// System.out.println("DEBUG: " + fcd.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}// END getAll

	@Override
	public void save(Player player) {
		try {
			// Append serialized object data to the data file
			byte[] se = PlayerDao.serialize(player);
			ByteBuffer bytes = ByteBuffer.allocate(4 + se.length).putInt(se.length);
			bytes.put(se);
			bytes.flip();
			int dataOffset = PlayerDao.PLAYER_OBJECT_MAX_SIZE * player.getNumber();
			fcd.position(dataOffset);
			fcd.write(bytes);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Override public void update(Player player) { this.save(player); }
	 */

	@Override
	public void delete(int number) {
		int dataOffset = PlayerDao.PLAYER_OBJECT_MAX_SIZE * number;
		try {
			ByteBuffer sizeBB = ByteBuffer.allocate(4).putInt(0);
			sizeBB.flip();
			fcd.position(dataOffset);
			fcd.write(sizeBB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
