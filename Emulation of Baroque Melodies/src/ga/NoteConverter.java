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
			{"^B", "=C",  "C"},
			{"^C", "_D"},
			{"=D",  "D"}, 
			{"^D", "_E"},
			{"=E",  "E", "_F"},
			{"^E", "=F"},
			{"^F", "_G"},
			{"=G",  "G"},
			{"^G", "_A"},
			{"=A",  "A"},
			{"^A", "_B"},
			{"=B",  "B", "_C"} 
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
					n = (((n % notes.length)+notes.length)
							%notes.length);
				}
			}
		}
		Note note = new Note(notes[n][0]);
		note.setOctave(octave);
		return note;
	}
	
	/**
	 * Converts a Note to a number,
	 * its distance in semitones from the base note.
	 * TODO: this
	 * @param n
	 * @param base
	 * @return
	 */
	public int noteToNumber(Note n, Note base) {
		// Prepare strings for comparison
		String nPitch = ""+n.getPitch(); 
		if (n.getAccidental() != 0)
			nPitch = n.getAccidental()+nPitch;
		String bPitch = ""+base.getPitch();
		if (base.getAccidental() != 0) 
			bPitch = base.getAccidental() + bPitch;
		int nLoc = -1;
		int bLoc = -1;
		// Start trying to find the notes in the array.
		for (int i = 0; i < notes.length; i++) {
			for (int j = 0; j < notes[i].length;j++) {
				if (nPitch.equals(notes[i][j])) {
					nLoc = i;
				}
				if (bPitch.equals(notes[i][j])) {
					bLoc = i;
				}
			}
		}
		nLoc = nLoc + (12*n.getOctave());
		bLoc = bLoc + (12*base.getOctave());
		return nLoc - bLoc;
	}
	
	public boolean isMinor(String key) {
		if (key.charAt(key.length()-1) == 'm') {
			return true;
		} else {
			return false;
		}
	}
}
