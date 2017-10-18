package ga;

import abc.Note;
import abc.Song;

/**
 * Handles crossover and mutation of tunes.
 * @author Evan Schoenberger
 */
public class TuneMutator {
	
	double mutationRate = .015;
	double uniformRate = .5; 
	
	private NoteConverter nc;
	
	public Song crossover(Song a, Song b, String name) {
		Song newSong = new Song();
		newSong.setTitle(name);
		newSong.notes = new Note[a.notes.length];
		
		for (int i = 0; i < a.notes.length; i++) {
			if (Math.random() <= uniformRate) {
				newSong.notes[i] = a.notes[i];
			} else {
				newSong.notes[i] = b.notes[i];
			}
		}
		
		return newSong;
	}
	
	public Song mutation(Song a, String name) {
		Song newSong = new Song();
		newSong.setTitle(name);
		newSong.notes = new Note[a.notes.length];
		
		for (int i = 0; i < a.notes.length; i++) {
			if (Math.random() <= mutationRate) {
				int n = (int)Math.random() * 48 - 24;
				Note newNote = nc.numberToNote(n, newSong.getKey());
				a.notes[i] = newNote;
			}
		}
		
		return newSong;
	}
}
