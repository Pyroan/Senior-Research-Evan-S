package abc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents an ABC notation music file (.abc)
 * ABC files should definitely be opened as part of this constructor.
 * @author Evan S.
 *
 */
public class SongBuilder {

	// BufferedReader for reading the file.
	private BufferedReader buffRead;

	// The header of the file, containing Information Fields (metadata)
	private String header = "";
	// The body of the file, containing the tune.
	private String body = "";

	/**
	 * Builds a song from a specified file.
	 * @param path
	 * @return
	 */
	public Song buildSong(String path) {
		// attempts to open the file, returns null if it doesn't work.
		if (!openReader(path))
			return null;
		// Now we know that works, attempt to create the song.

		Song song = new Song();

		// Creates header and body strings to prepare them
		// for further processing.
		try {
			// Read the entire header.
			String s = buffRead.readLine();
			while (s.matches("[A-Za-z]:.*")) {
				header += s + "\n";
				s = buffRead.readLine();
			}
			// Read the rest of the file.
			while (buffRead.ready()) {
				body += buffRead.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Close the reader, freeing memory
		closeReader();
		
		processHeader(song);
		processBody(song);

		return song;
	}

	/**
	 * Breaks down the header into its information fields
	 * and fills song's instance variables with their values.
	 * @param song
	 */
	private void processHeader(Song song) {
		Scanner lineReader = new Scanner(header);
		while (lineReader.hasNext()) {
			String line = lineReader.nextLine();
			// Break up a line into the category and the value
			String[] infoField = line.split(":");
			
			switch(infoField[0]) {
			// Title
			case "T":
				song.setTitle(infoField[1]);
				break;
			// Composer
			case "C":
				song.setComposer(infoField[1]);
				break;
			// Meter
			case "M":
				song.setTimeSignature(infoField[1]);
			// Key
			case "K":
				song.setKey(infoField[1]);
				break;
			// Unit note length
			case "L":
				song.setNoteLength(infoField[1]);
				break;
			// We'll ignore other values for now.
			default:
				break;
			}
		}
		lineReader.close();
	}

	/**
	 * Breaks down the body into its notes and "other stuff"
	 * and fills the song's instance variables with their values.
	 */
	private void processBody(Song song) {
		//TODO build this.
	}

	/**
	 * Attempts to open the specified file for reading
	 * @param path - the path to the requested file
	 * @return true if file was opened, false otherwise.
	 */
	boolean openReader(String path) {
		try {
			FileReader fileRead = new FileReader(path);
			buffRead = new BufferedReader(fileRead);
			return true;
		} catch (FileNotFoundException e) {
			System.err.println("File \"" + path + "\" was not found");
			return false;
		}
	}

	/**
	 * Frees resources by closing the BufferedReader
	 * @return true if successfully closed the buffer.
	 */
	boolean closeReader() {
		try {
			buffRead.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (NullPointerException e) {
			System.err.println("Tried to close null file");
			//e.printStackTrace();
			return false;
		}
	}

}
