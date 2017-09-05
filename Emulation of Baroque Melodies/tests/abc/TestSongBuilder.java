package abc;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestSongBuilder {
	
	/**
	 * Tests simply opening an ABC File
	 */
	@Test
	public void testOpenForReading() {
		SongBuilder songBuilder = new SongBuilder();
		assertTrue(songBuilder.openReader("abc files/vivaldi-spring.abc"));
		assertFalse(songBuilder.openReader("abc files/bach-song.abc"));
	}
	
	/**
	 * Tests closing an already opened ABC file
	 */
	@Test
	public void testClose() {
		SongBuilder abcReader = new SongBuilder();
		// Can't close a file that was never opened. (NullPointerException)
		assertFalse(abcReader.closeReader());
		// Should be able to close a file that is opened.
		abcReader.openReader("abc files/vivaldi-spring.abc");
		assertTrue(abcReader.closeReader());
	}
	
	
	/**
	 * THIS IS NOT DONE.
	 */
	@Test
	public void testBuildSong() {
		SongBuilder sB = new SongBuilder();
		Song s = sB.buildSong("abc files/vivaldi-spring.abc");
		// Test header
		assertEquals("Spring", s.getTitle());
		assertEquals("Vivaldi", s.getComposer());
		assertEquals("E", s.getKey());
		assertEquals("1/8", s.getNoteLength());
		// Test body
		
	}
	
	/**
	 * Tests border case where specified path is invalid
	 */
	@Test
	public void testBuildSongInvalidPath() {
		SongBuilder songBuilder = new SongBuilder();
		Song s = songBuilder.buildSong("This isn't a valid path");
		assertEquals(null, s);
	}
}
