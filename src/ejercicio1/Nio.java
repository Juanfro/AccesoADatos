package ejercicio1;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/**
 * Escribe un programa Java que lea la ruta de un directorio y muestre en
 * pantalla el listado de ficheros que cuelgan de él.
 * 
 * @author alumno
 *
 */
public class Nio {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:\\archivos");

		EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
		// Files.walkFileTree(path,/* opts, Integer.MAX_VALUE,*/ new FileVisitorTest());

		System.out.println("*****************************");

		// Files.walkFileTree(path, new FileVisitorTest());//Todos los niveles
		Files.walkFileTree(path, opts, 1, new FileVisitorTest());// Primer Nivel
	}

	static class FileVisitorTest extends SimpleFileVisitor<Path> {

		public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
			System.out.println(
					/* "Accediendo al fichero " */ "Fichero: " + file.getFileName() + "(" + attr.size() + "bytes)");
			return FileVisitResult.CONTINUE;
		}

		public FileVisitResult postVisitDirectory(Path dir, IOException esx) {
			System.out.println("Directorio: " + dir.toAbsolutePath());
			return FileVisitResult.CONTINUE;
		}

		public FileVisitResult visitFileFailed(Path file, IOException exc) {
			System.err.println(exc);
			return FileVisitResult.CONTINUE;
		}

	}
}