package ga;

import abc.Song;

import java.util.Random;

import abc.ABCWriter;
import abc.Note;

/**
 * Generates random songs using a 
 * "directed random walk" (eventually)
 * @author Evan Schoenberger
 */
public class TuneGenerator {
	
	NoteConverter nc = new NoteConverter();
	
	public Song createTune(String title) {
		Song s = new Song();
		s.setTitle(title);

		int[] iNotes = pickNotes(32);
		Note[] notes = new Note[32];
		for (int i = 0; i < iNotes.length; i++) {
			notes[i] = nc.numberToNote(iNotes[i], "C");
		}
		// Stuff after here is fine tho
		s.notes = notes;
		return s;
	}
	
	/**
	 * Fist attempt at a
	 * Basic random walk.
	 * The probability of choosing any
	 * specific note decreases the further
	 * that note is from the current note.
	 * 
	 * It should be noted that this only picks pitches,
	 * not note lengths.
	 * 
	 * @param n - the number of notes
	 * to be generated.
	 * @return an array of ints
	 * that will be turned into notes.
	 */
	public int[] pickNotes(int n) {
		int[] notes = new int[n];
		Random rng = new Random();
		for (int i = 1; i < n; i++) {
			// Pick a pitch.
			double x = rng.nextGaussian();
			// the next pitch distribution 
			// should be centered on the previous pitch.
			x += notes[i-1]; 
			// And should have a std deviation of ???
			x *= 1.15;
			// Must be capped at +- 24 (for now
			if (x > 24) x = 24;
			if (x < -24) x = -24;
			// For now We should never hear the same
			// note twice in a row.
			// to remedy this, round away from notes[i-1]
			if (x > notes[i-1])
			{
				notes[i] = (int)Math.ceil(x);
			} else {
				notes[i] = (int)Math.floor(x);
			}
		}
		return notes;
	}
}
