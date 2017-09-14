package abc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSong {

	/**
	 * See if we can get a default song constructed.
	 */
	@Test
	public void testDefaultConstructor() {
		Song song = new Song();
		assertNotEquals("Spring, By Vivaldi", song.getTitleAndComposer());
		assertEquals("Untitled,\nBy Unnamed", song.getTitleAndComposer());
	}
	
	/**
	 * See if we can get a new song with specific
	 */
	@Test
	public void testSpecifiedConsructor() {
		Song song = new Song("Spring", "Vivaldi", "4/4");
		assertEquals("Spring,\nBy Vivaldi", song.getTitleAndComposer());
	}
	
	/**
	 * Additional tests for note length and meter.
	 */
	@Test
	public void testMoreSetters() {
		Song song = new Song();
		song.setNoteLength("4");
		assertEquals("1/4", song.getNoteLength());
		song.setNoteLength(8);
		assertEquals("1/8", song.getNoteLength());
		song.setNoteLength("1/2");
		assertEquals("1/2", song.getNoteLength());
		
		song.setMeter("6/8");
		assertEquals(6, song.getMeter()[0]);
		assertEquals(8, song.getMeter()[1]);
		assertEquals("6/8", song.getMeterString());
		song.setMeter("C");
		assertEquals("4/4", song.getMeterString());
	}
	
	/**
	 * Additional tests for all the getters.
	 */
	@Test
	public void testGettersAndSetters() {
		Song song = new Song();
		song.setTitle("Hi Buddy");
		assertEquals("Hi Buddy", song.getTitle());
		song.setComposer("Buddo");
		assertEquals("Buddo", song.getComposer());
		song.setKey("Cm");
		assertEquals("Cm", song.getKey());
	}
}
