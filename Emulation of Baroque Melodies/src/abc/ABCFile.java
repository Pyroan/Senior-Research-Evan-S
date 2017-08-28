package abc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Represents an ABC notation music file (.abc)
 * ABC files should definitely be opened as part of this constructor.
 * @author Evan S.
 *
 */
public class ABCFile {

	private BufferedReader buffRead;

	/**
	 * Attempts to open the specified file for reading
	 * @param path - the path to the requested file
	 * @return true if file was opened, false otherwise.
	 */
	boolean openForReading(String path) {
		try {
			FileReader fileRead = new FileReader(path);
			buffRead = new BufferedReader(fileRead);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	boolean close() {
		try {
			buffRead.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}
}
