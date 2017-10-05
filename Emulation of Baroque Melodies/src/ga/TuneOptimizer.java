package ga;

import abc.Song;

/**
 * The actual GA part.
 * Given 
 * @author Evan Schoenberger
 */
public class TuneOptimizer {
	
	public static final int tournamentSize = 5;
	
	
	// Essentially how long we want our code to run.
	private int numberOfGenerations;

	// The best fitness we've seen so far.
	private float maxFitness;
	
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

