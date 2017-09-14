package abc;

import static org.junit.Assert.*;

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
	 * Test that the header of the song is
	 * Corectly processed.
	 */
	@Test
	public void testBuildHeader() {
		SongBuilder sB = new SongBuilder();
		Song s = sB.buildSong("abc files/vivaldi-spring.abc");
		// Test header
		assertEquals("Spring", s.getTitle());
		assertEquals("Vivaldi", s.getComposer());
		assertEquals("E", s.getKey());
		assertEquals("1/8", s.getNoteLength());
		
	}
	
	/**
	 * Tests that all the notes from the .abc
	 * file are successfully turned into notes in the Song.
	 */
	@Test
	public void testBuildBody() {
		SongBuilder sb = new SongBuilder();
		Song s = sb.buildSong("abc files/vivaldi-spring.abc");;
		// Test that the body
		// contains the correct notes.
		assertEquals(75, s.notes.length);
		assertEquals("e", s.notes[0].toString());
		assertEquals("g", s.notes[1].toString());
		assertEquals("e6", s.notes[s.notes.length-2].toString());
		assertEquals("z", s.notes[s.notes.length-1].toString());
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
	
	@Test
	public void testBuildSongWrongFormat() {
		SongBuilder songBuilder = new SongBuilder();
		Song s = songBuilder.buildSong("abc files/wrong-format.abc");
		assertNull(s);
	}
}
