package util;
import ga.*;

/**
 * Main runner. Runs the whole experiment!
 * @author es0414
 *
 */
public class Runner {

	public static final int MEASURE_SIZE = 4;
	public static final int NUM_GENERATIONS = 1000;

	public static final String INPUT_FOLDER = "abc files";
	public static final String OUTPUT_FOLDER = "output tests/prelim_test";

	public static final boolean GEN_NEW_TUNES = false;

	public static void main(String[] args) {
		// Set up frequency analysis table
		TuneEvaluator.generateFrequencyAnalysisTable(INPUT_FOLDER);
		System.out.println("Finished generating freqanalysis Table");
		// Generate initial tunes.
		Population p = new Population(100, true, "prelim_test");
		p.writeToFolder(OUTPUT_FOLDER+"/Initial Population");
		System.out.println("Initial Population written to folder");
		
		TuneOptimizer to = new TuneOptimizer();
		to.pop = p;
		to.OptimizeTunes();
	}
}
