package ga;

import static org.junit.Assert.*;

import org.junit.Test;

import abc.Note;

public class TestNoteConverter {

	@Test
	public void testNumberToNote() {
		NoteConverter nc = new NoteConverter();
		Note note = nc.numberToNote(0, "C");
		assertEquals("^B", note.toString());
		// First things first, let's be able to
		// get the second note in the C Major scale
		note = nc.numberToNote(2, "C");
		assertEquals("D", note.toString());
		note = nc.numberToNote(-1, "G");
		assertEquals("^F", note.toString());
		note = nc.numberToNote(12, "C");
		assertEquals("^b", note.toString());
	}

	@Test
	public void testIsMinor() {
		NoteConverter nc = new NoteConverter();
		assertFalse(nc.isMinor("C"));
		assertTrue(nc.isMinor("Cm"));
		assertFalse(nc.isMinor("CM"));
	}
	
}
