package ga;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import abc.Note;
import abc.Song;
import abc.SongBuilder;

public class TestTuneEvaluator {

	@Test
	public void testTableGeneration() {
		TuneEvaluator.generateFrequencyAnalysisTable("abc files");
		//TuneEvaluator.printFreqAnalysisTable();
		TuneEvaluator.printFAAsTable();
	}

	@Test
	public void testJump() {
		NoteConverter nc = new NoteConverter();
		Note n = new Note("_E");
		Note n2 = new Note("C");
		assertEquals(3, nc.noteToNumber(n, n2));
		n = new Note("_E'");
		assertEquals(15, nc.noteToNumber(n, n2));
		n = new Note("B,,");
		n2 = new Note("D");
		assertEquals(15, nc.noteToNumber(n2, n));
	}

	@Test
	public void testSeeds() {
		TuneEvaluator.generateFrequencyAnalysisTable("abc files");
		File folder = new File("abc files");
		SongBuilder sb = new SongBuilder();
		// -1 because of the "Wrong format" file
		int[] fitnesses = new int[folder.listFiles().length-1];
		int sum = 0;
		int i =0;
		for (File entry: folder.listFiles()) {
			Song s = sb.buildSong(entry.toString());
			if (s != null) {
				int x = TuneEvaluator.getFitness(s);
				System.out.format("%-48s%20d\n",entry,x);
				fitnesses[i] = x;
				i++;
				sum += x;
			}
		}
		// Print Mean
		double mean = (1.0*sum)/fitnesses.length;
		System.out.format("%-48s%20.02f\n","Mean:",mean);
		// Print SD
		double variance = 0;
		for (int j: fitnesses) {
			variance += Math.pow((j-mean),2);
		}
		variance /= fitnesses.length;
		System.out.format("%-48s%20.02f\n","Standard Deviation: ", Math.sqrt(variance));
	}

}
