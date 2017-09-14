package abc;

import java.io.*;

/**
 * An ABCWriter is sort of the inverse of a SongBuilder.
 * It takes a Song class that already exists and writes it
 * to a new file.
 * Always remember to close the writer when you're done,
 * to avoid leaks.
 * @author Evan S.
 *
 */
public class ABCWriter {
	PrintStream writer;
	
	/**
	 * Writes the song to the PrintStream.
	 * @param song The song to be written.
	 */
	public void writeSong(Song song) {
		writer.println("X:1"); // Just a thing ABC files require.
		writer.println("T:"+song.getTitle());
		writer.println("C:"+song.getComposer());
		writer.println("M:"+song.getMeterString());
		writer.println("K:"+song.getNoteLength());
		for(int i=0; i < song.notes.length; i++) {
			writer.print(song.notes[i] + " ");
		}
	}
	
	/**
	 * If no writer is open, opens a new writer
	 * with the given File. Otherwise, replaces
	 * the current writer with a new one.
	 */
	public boolean setWriter(File f) {
		try {
			FileOutputStream fos = new FileOutputStream(f);
			writer = new PrintStream(fos, true);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Useful for setting writer directly,
	 * esp. for printing to console.
	 */
	public boolean setWriter(PrintStream ps) {
		writer = ps;
		return true;
	}
	
	/**
	 * Close the PrintStream, freeing memory.
	 */
	public void closeWriter() {
		writer.close();
	}
	
}
