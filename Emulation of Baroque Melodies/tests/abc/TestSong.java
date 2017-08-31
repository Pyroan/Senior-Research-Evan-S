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
		Song song = new Song("Spring", "Vivaldi", Tempo.ALLEGRO, "4/4");
		assertEquals("Spring,\nBy Vivaldi", song.getTitleAndComposer());
	}
}
