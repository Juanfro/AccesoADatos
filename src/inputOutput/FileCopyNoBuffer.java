package inputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Copying a file byte-by-byte without Buffering
 * 
 * @author Juan
 *
 */
public class FileCopyNoBuffer {

	public static void main(String[] args) {

		String inFileStr = "sc.jpg";
		String outFileStr = "copysc.jpg";

		FileInputStream in = null;
		FileOutputStream out = null;
		long startTime, elapsedTime;

		File fileIn = new File(inFileStr);
		System.out.println("File size is " + fileIn.length() + " bytes");

		try {
			in = new FileInputStream(inFileStr);
			out = new FileOutputStream(outFileStr);

			startTime = System.nanoTime();

			int byteRead;
			// Read raw byte, return an int of 0 to 255
			while ((byteRead = in.read()) != -1) {
				out.write(byteRead);
			}

			elapsedTime = System.nanoTime() - startTime;

			System.out.println("Elapsed time is " + (elapsedTime / 1000000.0) + " msec");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
