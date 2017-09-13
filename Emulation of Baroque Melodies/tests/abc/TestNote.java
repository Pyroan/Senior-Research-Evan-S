package abc;

import static org.junit.Assert.*;

import org.junit.Ignore;
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
	
	@Ignore
	@Test
	public void testToString() {
		Note note = new Note();
		note.setAccidental("^");
		note.setPitch("G");
		note.setOctave(3);
		note.setLength(3);
		assertEquals("^g''3", note.toString());
		
		Note note2 = new Note("_G,/");
		assertEquals("_G,/", note2.toString());
	}
	
	@Test
	public void testBasicNote() {
		Note note;
		// testing a note that's just a pitch.
		note = new Note("G");
		assertEquals('G', note.getPitch());
		note = new Note("f");
		assertEquals('F', note.getPitch());
		note = new Note("H");
		assertNotEquals('H', note.getPitch());
	}
	
	@Test
	public void testNoteWithAccidental() {
		Note note = new Note("^G");
		assertEquals('^', note.getAccidental());
		assertEquals('G', note.getPitch());
		note = new Note("xG");
		assertNotEquals('x', note.getAccidental());
	}
	
	@Test
	public void testNoteWithOctave() {
		Note note = new Note("G'");
		assertEquals(1, note.getOctave());
		note = new Note("f");
		assertEquals(1, note.getOctave());
		note = new Note("A");
		assertEquals(0, note.getOctave());		
		note = new Note("B,");
		assertEquals(-1, note.getOctave());
		// Slightly more complicated exmaples.
		note = new Note("c'''");
		assertEquals(4, note.getOctave());
		note = new Note("D,,,");
		assertEquals(-3, note.getOctave());
		note = new Note("E'',,"); // this should never happen but...
		assertEquals(0, note.getOctave());
		note = new Note("F,,'''");
		assertEquals(1, note.getOctave());
	}
	
	@Test
	public void testLength() {
		Note note = new Note("G3");
		assertEquals(3, note.getLength());
		note = new Note("G/");
		assertEquals(-1, note.getLength());
		note = new Note("F//");
		assertEquals(-2, note.getLength());
	}
	
	@Ignore
	@Test
	public void testCompleteNote() {
		// Testing a full note
		Note note = new Note("^g'3");
		assertEquals('G', note.getPitch());
		assertEquals(2, note.getOctave());
		assertEquals(3, note.getLength());
		assertEquals('^', note.getAccidental());
	}

}
