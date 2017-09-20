package ga;

import java.util.LinkedList;

import abc.Note;

/**
 * Converts numbers to notes, and potentially vice-versa
 * @author Evan Schoenberger
 *
 */
public class NoteConverter {

	/**
	 * What's a Circular Linked List?
	 * FIXME I'm worried about this. It only knows
	 * What sharps are, for example.
	 * This is supposed to be a reference table.
	 */
	String[] notes = { 
			 "A","^A", "B", 
			 "C","^C", "D", 
			"^D", "E", "F",
			"^F", "G","^G"
	};
	
	public Note numberToNote(int n, String key) {
		// first we're gonna have to determine
		// whether that's a major or minor key.
		// that may deserve its own class...

		return new Note("C");
	}
}
