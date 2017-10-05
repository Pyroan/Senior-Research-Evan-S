package ga;

import abc.Note;
import abc.Song;

/**
 * When given an array of notes,
 * can process them into a
 * fitness value.
 * @author Evan Schoenberger
 */
public class TuneEvaluator {
	
	public static int getFitness(Note[] notes) {
		return 0;
	}
	
	public static int getFitness(Song song) {
		return getFitness(song.notes);
	}
}
