package ga;

import static org.junit.Assert.*;

import org.junit.Test;

import abc.Note;

public class TestFrequencyAnalysis {

	@Test
	public void testTableGeneration() {
		TuneEvaluator.generateFrequencyAnalysisTable("abc files");
		TuneEvaluator.printFreqAnalysisTable();
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

}
