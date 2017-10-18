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
	private int numberOfGenerations = 1000;

	// The best fitness we've seen so far.
	private float maxFitness = 0;
	
	Population pop;
	TuneMutator t;
	
	/**
	 * The Big Nasty™
	 * returns the final population of tunes.
	 */
	public Population OptimizeTunes() {
		for (int i = 1; i <= numberOfGenerations; i++) {
			System.out.println("Generation: " + i + "\tFittest: " + maxFitness);
			pop = evolve(pop, "gen-"+i);
			pop.writeToFolder("generation-"+i);
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

