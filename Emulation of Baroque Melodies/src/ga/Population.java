package ga;

import abc.ABCWriter;
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
	
	/**
	 * @return the fittest song in this population
	 */
	public Song getFittest() {
		int max = -1;
		Song fittest = null;
		for (int i = 0; i < individuals.length; i++) {
			if (TuneEvaluator.getFitness(individuals[i]) > max) {
				fittest = individuals[i];
			}
		}
		return fittest;
	}

	public void saveSong(int i, Song song) {
		individuals[i] = song;
	}
	
	public void writeToFolder(String path) {
		ABCWriter writer = new ABCWriter();
		writer.setDefaultDirectory(path);
		for (int i = 1; i < individuals.length; i++) {
			writer.writeSong(individuals[i], false);
		}
		writer.closeWriter();
	}
	
}
