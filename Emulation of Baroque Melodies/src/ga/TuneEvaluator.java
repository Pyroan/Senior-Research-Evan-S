package ga;

import java.io.File;

import abc.Note;
import abc.Song;
import abc.SongBuilder;

/**
 * When given an array of notes,
 * can process them into a
 * fitness value.
 * @author Evan Schoenberger
 */
public class TuneEvaluator {

	/**
	 * A table of floats that indicate the probability of the next note,
	 * given the previous note.
	 * should ONLY be accessed through getFreqPrediction(int prev, int next),
	 * since this shouldn't use default indices.
	 */
	private static double freqAnalysisTable[][] = new double[49][49];

	public static int getFitness(Note[] notes) {
		int fitness = frequencyAnalysis(notes);
		fitness += sequenceAnalysis(notes);

		return fitness;
	}

	public static int getFitness(Song song) {
		return getFitness(song.notes);
	}

	/**
	 * @return sum of all frequency hits the notes got
	 * I mean it's simple but why not?
	 */
	private static int frequencyAnalysis(Note[] notes) {
		NoteConverter nc = new NoteConverter();
		double sum = 0;
		for (int i = 1; i < notes.length-1; i++) {
			int prevToNow = nc.noteToNumber(notes[i-1], notes[i]);
			int nowToNext = nc.noteToNumber(notes[i+1], notes[i]);
			sum += getFreqPrediction(prevToNow,nowToNext);
		}
		return (int)(sum*1000);
	}

	/**
	 * TODO: Implement Sequence Analysis.
	 * @param notes
	 * @return
	 */
	private static int sequenceAnalysis(Note[] notes) {
		return -1;
	}
	/**
	 * Provides safe access to the frequency analysis table, adjusting indexes
	 * so you can pass in NumberToNote values and have it work properly.
	 * @param prev
	 * @param next
	 * @return
	 */
	private static double getFreqPrediction(int prev, int next) {
		if (prev <= 24 && prev >= -24 && next <= 24 && next >= -24)
			return freqAnalysisTable[prev+24][next+24];
		else return 0;
	}

	/**
	 * When given a folder of ABC files, reads them all to generate
	 * A frequency analysis table.
	 * The frequency analysis table will be 49 lists of the numbers -24 to 24,
	 * each followed by the likelihood of a jump that size given the size of the previous
	 * jump.
	 */
	public static void generateFrequencyAnalysisTable(String path) {
		File folder = new File(path);
		SongBuilder sb = new SongBuilder();
		NoteConverter nc = new NoteConverter();
		int numberOfJumps = 0;
		for (File entry : folder.listFiles()) {
			Song s = sb.buildSong(entry.toString());
			if (s != null) {
				Note[] n = s.notes;
				numberOfJumps += n.length-2;
				for (int i = 1; i < n.length-1;i++) {
					if (!(n[i-1].isRest() || n[i+1].isRest() || n[i].isRest())) {
						int prevToNow = nc.noteToNumber(n[i-1], n[i]);
						int nowToNext = nc.noteToNumber(n[i+1], n[i]);
						try {
						freqAnalysisTable[prevToNow+24][nowToNext+24]+=1.0;
						} catch (ArrayIndexOutOfBoundsException e) {
							System.err.println("TuneEvaluation Error");
							System.err.println(entry + " caused a problem with note "+ i+", " + n[i]);
							System.err.println("\tJumps were size "+prevToNow+", "+nowToNext);
						}
					}
				}
			}
		}
		// Divide everything in the table by the number of jumps
		for (int i = 0; i < freqAnalysisTable.length;i++) {
			for (int j = 0; j < freqAnalysisTable[i].length;j++) {
				freqAnalysisTable[i][j] /= numberOfJumps;
			}
		}
	}

	/**
	 * Prints values of frequency analysis table, for testing.
	 */
	public static void printFreqAnalysisTable() {
		System.out.println("Probability that a jump of x follows a jump of y for [x,y]: ");
		for (int i = -24; i <= 24; i++) {
			for (int j = -24; j <= 24; j++) {
				if (getFreqPrediction(i,j) != 0) {
					System.out.println("["+j+", "+i+"]: "
							+ getFreqPrediction(i,j));
				}
			}
		}

	}
}
