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
	// How many consecutive notes to copy
	int phraseLength = 4;
	
	private NoteConverter nc = new NoteConverter();
	
	public Song crossover(Song a, Song b, String name) {
		Song newSong = new Song();
		newSong.setTitle(name);
		newSong.notes = new Note[a.notes.length];
		
		for (int i = 0; i < a.notes.length-phraseLength+1; i+=phraseLength) {
			if (Math.random() <= uniformRate) {
				for (int j = i; j < i+phraseLength;j++) {
					newSong.notes[j] = a.notes[j];
				}
			} else {
				for (int j = i; j < i+phraseLength;j++) {
					newSong.notes[j] = b.notes[j]; 
				}
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
				int n = (int)(Math.random() * 48) - 24;
				Note newNote = nc.numberToNote(n, newSong.getKey());
				newSong.notes[i] = newNote;
			} else {
				newSong.notes[i] = a.notes[i];
			}
		}
		
		return newSong;
	}
}
