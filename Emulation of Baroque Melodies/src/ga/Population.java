package ga;

import java.io.File;

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
			int f = TuneEvaluator.getFitness(individuals[i]);
			if (f > max) {
				fittest = individuals[i];
				max = f;
			}
		}
		return fittest;
	}
	
	public int getMaxFitness() {
//		int max = -1;
//		for (int i = 0; i < individuals.length; i++) {
//			int f = TuneEvaluator.getFitness(individuals[i]);
//			if (f > max) {
//				max = f;
//			}
//		}
//		return max;
		return TuneEvaluator.getFitness(getFittest());
	}
	
	public int getAverageFitness() {
		int sum = 0;
		for (Song i: individuals) {
			sum += TuneEvaluator.getFitness(i);
		}
		return sum/individuals.length;
	}

	public void saveSong(int i, Song song) {
		individuals[i] = song;
	}
	
	public void writeToFolder(String path) {
		ABCWriter writer = new ABCWriter();
		writer.setDefaultDirectory(path);
		for (int i = 1; i < individuals.length; i++) {
			//writer.setWriter(new File(path));
			writer.writeSong(individuals[i], true);
			// System.out.println("Holy cow I think i wrote a song to \"" + path + "\"");
		}
		writer.closeWriter();
	}
	
}
