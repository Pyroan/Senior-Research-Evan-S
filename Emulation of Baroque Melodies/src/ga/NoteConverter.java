package ga;

import abc.Note;

/**
 * Converts numbers to notes, and potentially vice-versa
 * @author Evan Schoenberger
 *
 */
public class NoteConverter {

	/**
	 * What's a Circular Linked List?
	 * FIXME I'm worried about this.
	 * This is supposed to be a reference table.
	 */
	String[][] notes = { 
			{"A"},
			{"^A", "_B"},
			{"B", "_C"}, 
			{"^B", "C"},
			{"^C", "_D"},
			{"D"}, 
			{"^D", "_E"},
			{"E", "_F"},
			{"^E", "F"},
			{"^F", "_G"},
			{"G"},
			{"^G", "_A"}
	};
	
	/**
	 * Why do I feel like I'm going about this thing
	 * all wrong?
	 * TODO still need logic for handling octaves.
	 * @param n
	 * @param key
	 * @return
	 */
	public Note numberToNote(int n, String key) {
		// first we're gonna have to determine
		// whether that's a major or minor key.
		// that may deserve its own class...
		int octave = n/notes.length;
		for (int i = 0; i < notes.length; i++) {
			for (int j = 0; j < notes[i].length; j++) {
				if (notes[i][j].equals(key)) {
					n = n + i; 
					n = (n) % notes.length;
				}
			}
		}
		Note note = new Note(notes[n][0]);
		note.setOctave(octave);
		return note;
	}
	
	public boolean isMinor(String key) {
		if (key.charAt(key.length()-1) == 'm') {
			return true;
		} else {
			return false;
		}
	}
}
