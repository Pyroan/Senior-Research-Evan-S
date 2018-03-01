package ga;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import abc.Song;
import util.Runner;

/**
 * The actual GA part.
 * Given 
 * @author Evan S.
 */
public class TuneOptimizer {

	public static final int tournamentSize = 5;


	// The best fitness we've seen so far.
	public int averageFitness = 0;
	public int maxFitness = 0;

	public Population pop;
	TuneMutator t = new TuneMutator();

	File f = new File(Runner.OUTPUT_FOLDER + "/FITNESS_DATA");
	/**
	 * The Big Nasty™
	 * returns the final population of tunes.
	 */
	public Population OptimizeTunes() {
		PrintStream writer = null;
		try {
			FileOutputStream fos = new FileOutputStream(f);
			writer = new PrintStream(fos);
		} catch (Exception e) {
			System.err.println("I DON'T EVEN CARE ANYMORE");
			e.printStackTrace();
		}

		for (int i = 1; i <= Runner.NUM_GENERATIONS; i++) {
			averageFitness = pop.getAverageFitness();
			maxFitness = pop.getMaxFitness();
			String s = "Generation: " + i + "\tAverage Fitness: " + averageFitness
					+ "\tMax Fitness: " + maxFitness + "\tFittest: " + pop.getFittest().getTitle();
			System.out.println(s);
			if (writer != null) writer.println(i + "\t" + averageFitness);
			pop = evolve(pop, "gen-"+i);
			pop.writeToFolder(Runner.OUTPUT_FOLDER + "/generation-"+i);
		}
		return pop;
	}

	public Population evolve(Population opop, String name) {
		Population newPop = new Population(opop.size(), false, name);

		// Crossover
		for (int i = 0; i < opop.size(); i++) {
			Song a = tournamentSelection(opop);
			Song b = tournamentSelection(opop);

			Song newSong = t.crossover(a, b, newPop.getSong(i).getTitle());
			newPop.saveSong(i, newSong);
		}

		// Mutation
		for (int i = 0; i < newPop.size(); i++) {
			newPop.saveSong(i, t.mutation(newPop.getSong(i), 
					newPop.getSong(i).getTitle()));
		}
		//System.out.println(newPop.getSong(0).notes[0]);
		return newPop;
	}

	// Select Individuals for cross over.
	private Song tournamentSelection(Population p) {

		Population tournament = new Population(tournamentSize,false,null);

		for (int i = 0; i < tournamentSize; i++) {
			int randomId = (int) (Math.random() * p.size());
			tournament.saveSong(i, p.getSong(randomId));
		}
		// Get fittest member of tournament
		Song fittest = tournament.getFittest();
		return fittest;
	}
}

