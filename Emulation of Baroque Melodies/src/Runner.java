import abc.*;
import ga.*;

/**
 * Main runner. Runs the whole experiment!
 * @author es0414
 *
 */
public class Runner {
	
	public static final int MEASURE_SIZE = 4;
	public static final int NUM_GENERATIONS = 1000;
	
	public static void main(String[] args) {
		TuneEvaluator.generateFrequencyAnalysisTable("abc files");
		
	}
}
