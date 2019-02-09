package seleccionEXISTDB;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import nationalTeam.Player;
import seleccion.PlayerDao;
import seleccionJDBC.JugadorJDBC.PositionJDBC;

public class JugadorRAFDao implements DaoSeleccion<JugadorJDBC> {

	public static final String FILE_NAME = "players";
	public static final String DATA_EXT = ".dat";
	public static final int PLAYER_OBJECT_MAX_SIZE = 500;

	private FileChannel fcd;

	public static byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(obj);
		os.flush();

		return out.toByteArray();
	}

	public static Object deserialize(byte[] data) throws ClassNotFoundException, IOException {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream is = new ObjectInputStream(in);

		return is.readObject();
	}

	@SuppressWarnings("resource")
	public JugadorRAFDao() {

		try {
			fcd = new RandomAccessFile(PlayerDao.FILE_NAME + PlayerDao.DATA_EXT, "rw").getChannel();
			fcd.force(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public JugadorJDBC get(int numPlayer) {

		JugadorJDBC jugador = null;

		try {
			int dataOffset = JugadorRAFDao.PLAYER_OBJECT_MAX_SIZE * (numPlayer);
			fcd.position(dataOffset);
			ByteBuffer sizeBB = ByteBuffer.allocate(4);
			int bytesRead = fcd.read(sizeBB);

			if (bytesRead != -1) {
				int size = sizeBB.getInt();

				if (size > 0) {
					fcd.position(dataOffset + 4);
					ByteBuffer playerBB = ByteBuffer.allocate(size);
					fcd.read(playerBB);
					playerBB.flip();
					byte[] se2 = playerBB.array();
					jugador = (JugadorJDBC) JugadorRAFDao.deserialize(se2);

				}
			} else {
				jugador = new JugadorJDBC(-1, "Fin", PositionJDBC.PORTERO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jugador;
	}// END get

	@Override
	public List<JugadorJDBC> getAll() {

		List<JugadorJDBC> lista = new ArrayList<JugadorJDBC>();
		int numPlayer = 0;
		boolean finFichero = false;

		try {
			while (!finFichero) {

				JugadorJDBC jugador = get(numPlayer);

				if (jugador == null) {
					numPlayer++;
				} else if (jugador.getDorsal() == -1) {
					finFichero = true;
				} else {
					lista.add(jugador);
					numPlayer++;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public void save(JugadorJDBC jugador) {

		try {
			byte[] se = JugadorRAFDao.serialize(jugador);
			ByteBuffer bytes = ByteBuffer.allocate(4 + se.length).putInt(se.length);
			bytes.put(se);
			bytes.flip();
			int dataOffset = JugadorRAFDao.PLAYER_OBJECT_MAX_SIZE * jugador.getDorsal();
			fcd.position(dataOffset);
			fcd.write(bytes);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void delete(int num) {
		int dataOffset = JugadorRAFDao.PLAYER_OBJECT_MAX_SIZE * num;

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
