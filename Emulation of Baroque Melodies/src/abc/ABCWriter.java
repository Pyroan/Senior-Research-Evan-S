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
	String defaultDirectory = "";
	 
	/**
	 * Writes the song to the PrintStream.
	 * @param song The song to be written.
	 * @param overwrite True if writer should be allowed
	 * to overwrite an existing file.
	 */
	public void writeSong(Song song, boolean overwrite) {
		//if (writer == null) {
			File f = new File(buildFileName(song, overwrite));
			try {
//				f.createNewFile();
//				FileOutputStream fos = new FileOutputStream(f);
//				writer = new PrintStream(fos, true);
				setWriter(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//}
		writer.println("X:1"); // Just a thing ABC files require.
		writer.println("T:"+song.getTitle());
		writer.println("C:"+song.getComposer());
		writer.println("M:"+song.getMeterString());
		writer.println("L:"+song.getNoteLength());
		for(int i=0; i < song.notes.length; i++) {
			if ((i+1)%song.getNoteLengthInt() == 0) {
				writer.print("| ");
			}
			writer.print(song.notes[i] + " ");
		}
		writer.print("|]");
	}
	
	/**
	 * Builds a filename using the Song's title
	 * and composer data.
	 * @param song
	 * @param overwrite Set to true if this is allowed
	 * to overwrite existing files.
	 * @return
	 */
	public String buildFileName(Song song, boolean overwrite) {
		String path = "";
		String composer = song.getComposer().toLowerCase();
		composer.replaceAll(" ", "_");
		String title = song.getTitle().toLowerCase();
		title.replaceAll(" ", "_");
		path = defaultDirectory+"/"+composer + "-" + title + ".abc";
		if (!overwrite) {
			int count = 0;
			while (new File(path).exists()) {
				count++;
				path = defaultDirectory+"/"+composer+"-"+title+"-"+count+".abc";
			}
		}
		return path;
	}
	
	/**
	 * If no writer is open, opens a new writer
	 * with the given File. Otherwise, replaces
	 * the current writer with a new one.
	 * If the File is null, it sets the writer to null
	 * Which will make it create its own file on a
	 * writeSong() call.
	 */
	public boolean setWriter(File f) {
		if (f == null) {
			if (writer != null)
				closeWriter();
			return true;
		}
		try {
			//System.out.println(f.getParent()+"\t"+f.getParentFile().exists());

			if (!f.getParentFile().exists())
				f.getParentFile().mkdir();
			f.createNewFile();
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
	
	public void setDefaultDirectory(String s) {
		defaultDirectory = s;
	}
	
}
