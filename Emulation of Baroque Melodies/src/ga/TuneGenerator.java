package ga;

import abc.Song;
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
		// NONE OF THE FOLLOWING CAN STAY
		Note[] thing = new Note[12];
		thing[0] = new Note("C");
		for (int i = 1; i < 12; i++) {
			thing[i] = nc.numberToNote(i, "C");
		}
		// Stuff after here is fine tho
		s.notes = thing;
		return s;
	}
}
