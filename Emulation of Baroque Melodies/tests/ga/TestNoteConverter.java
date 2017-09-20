package ga;

import static org.junit.Assert.*;

import org.junit.Test;

import abc.Note;

public class TestNoteConverter {

	@Test
	public void testNumberToNote() {
		NoteConverter nc = new NoteConverter();
		Note note = nc.numberToNote(0, "C");
		assertEquals("C", note.toString());
		// First things first, let's be able to
		// get the second note in the C Major scale
		note = nc.numberToNote(1, "C");
		assertEquals("D", note.toString());
	}

}
