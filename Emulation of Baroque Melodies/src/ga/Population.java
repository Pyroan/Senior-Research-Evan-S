package ga;

import abc.Song;

/**
 * Represents a population of several songs.
 * @author Evan Schoenberger
 *
 */
public class Population {
	Song[] individuals;

	/**
	 * I think generate new is probably true except when it's not.
	 */
	public Population(int size, boolean generateNew, String title) {
		individuals = new Song[size];
			TuneGenerator T = new TuneGenerator();
			for (int i = 0; i < size; i++) {
				if (generateNew) {
					individuals[i] = T.createTune(title + "-" + i);
				} else {
					individuals[i] = new Song();
					individuals[i].setTitle(title + "-" + i);
				}
			}
	}

	/********************
	 * Getters, setters *
	 ********************/

	public int size() {
		return individuals.length;
	}

	public Song getSong(int i) {
		return individuals[i];
	}

	public void saveSong(int i, Song son) {
		individuals[i] = son;
	}
	
	public void writeToFolder(String path) {
		
	}
}
