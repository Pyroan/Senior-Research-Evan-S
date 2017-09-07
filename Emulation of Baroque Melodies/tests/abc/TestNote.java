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
	 * so it can handle "/"
	 */
	@Test
	public void setLength() {
		Note note = new Note();
		assertTrue(note.setLength(3));
	}
	
	@Test
	public void testToString() {
		Note note = new Note();
		note.setAccidental("^");
		note.setPitch("G");
		note.setOctave(3);
		note.setLength(3);
		assertEquals("^g''3", note.toString());
	}
	
	@Test
	public void testConstructor() {
		Note note = new Note("^g'3");
		assertEquals('G', note.getPitch());
		assertEquals(2, note.getOctave());
		assertEquals(3, note.getLength());
		assertEquals('^', note.getAccidental());
	}

}
