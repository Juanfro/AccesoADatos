package inputOutput;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyBufferedStream {

	public static void main(String[] args) {

		String inFileStr = "sc.jpg";
		String outFileStr = "sccopy.jpg";

		File fileIn = new File(inFileStr);

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {

			int byteRead;
			while ((byteRead = in.read()) != -1) {
				out.write(byteRead);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
