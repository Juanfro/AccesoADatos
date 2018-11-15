package ejercicio1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class Ej1niopractica {

	public static void main(String[] args) {
		Path path = Paths.get(".");

		EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

		try {
			Files.walkFileTree(path, opts, 1, new FileVisitorTest());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static class FileVisitorTest extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			System.out.println("Directorio: " + dir.toAbsolutePath());
			return super.postVisitDirectory(dir, exc);
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			System.out.println("Fichero: " + file.getFileName() + " | Tamaño=" + attrs.size());
			return super.visitFile(file, attrs);
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			return super.visitFileFailed(file, exc);
		}
		

	}

}
