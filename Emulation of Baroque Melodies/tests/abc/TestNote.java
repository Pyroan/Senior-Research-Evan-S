package abc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNote {

	/**
	 * Handles border cases for setting
	 * accidentals.
	 */
	@Test
	public void testSetAccidental() {
		Note note = new Note();
		assertTrue(note.setAccidental("^"));
		assertFalse(note.setAccidental("Q"));
	}
	
	/**
	 * Handles border cases for setting
	 * pitch
	 */
	@Test
	public void testSetPitch() {
		Note note = new Note();
		assertTrue(note.setPitch("G"));
		assertTrue(note.setPitch("g"));
		assertFalse(note.setPitch("q"));
		assertFalse(note.setPitch("gx"));
		assertFalse(note.setPitch("gg"));
		// handle rests.
		assertTrue(note.setPitch("z"));
	}
	
	@Test
	public void setOctave() {
		Note note = new Note();
		assertTrue(note.setOctave(1));
	}
	
	/**
	 * Length almost definitely requires more processing
	 */
	@Test
	public void setLength() {
		Note note = new Note();
		assertTrue(note.setLength(3));
	}

}
