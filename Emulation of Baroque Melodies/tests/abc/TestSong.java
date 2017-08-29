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
		assertNotEquals("Spring, By Vivaldi", song.getMetadata());
		assertEquals("Untitled,\nBy Unnamed", song.getMetadata());
	}
	
	/**
	 * See if we can get a new song with specific
	 */
	@Test
	public void testSpecifiedConsructor() {
		Song song = new Song("Spring", "Vivaldi", Tempo.ALLEGRO, "4/4");
		assertEquals("Spring,\nBy Vivaldi", song.getMetadata());
	}
	
	/**
	 * See if we can output the metadata for the song.
	 */
	@Test
	public void testGetMetadata() {
		Song spring = new Song("abc files/vivaldi-spring.abc");
	}

}
