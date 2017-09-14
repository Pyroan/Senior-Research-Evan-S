package abc;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TestABCWriter {

	@Test
	public void testWriteSong() {
		SongBuilder b = new SongBuilder();
		Song s = b.buildSong("abc files/vivaldi-spring.abc");
		assertNotNull(s); // Double check that worked.
		// So I've decided to test this by writing out the song,
		// Then trying to open that new version as a new Song.
		// This seems like a terrible, horrible, no good, very bad idea.
		ABCWriter writer = new ABCWriter();
		writer.setWriter(new File("output tests/vivaldi-spring.abc"));
		writer.writeSong(s, true);
		writer.closeWriter();

		Song s2 = b.buildSong("output tests/vivaldi-spring.abc");
		assertNotNull(s2);
		// Can't compare by reference so...
		assertEquals(s.notes.length, s2.notes.length);
		for (int i = 0; i < s.notes.length; i++) {
			assertEquals(s.notes[i].toString(), s2.notes[i].toString());
		}
	}
	
	@Test
	public void testWriteSongNoFile() {
		SongBuilder b = new SongBuilder();
		Song s = b.buildSong("abc files/vivaldi-spring.abc");
		ABCWriter writer = new ABCWriter();
		writer.setDefaultDirectory("output tests");
		writer.writeSong(s, false);
		writer.closeWriter();
		File f = new File("output tests/vivaldi-spring-1.abc");
		assertTrue(f.exists());
		assertTrue(f.delete());
	}

	@Test
	public void testSetWriterWithPrintStream() {
		ABCWriter writer = new ABCWriter();
		assertTrue(writer.setWriter(System.out));
		writer.closeWriter();
	}

	@Test
	public void testSetWriterWithFile() {
		ABCWriter writer = new ABCWriter();
		assertTrue(writer.setWriter(new File("output tests/temp.abc")));
		writer.closeWriter();
	}

	@Test
	public void testSetWriterNoFile() {
		ABCWriter writer = new ABCWriter();
		assertTrue(writer.setWriter((File)null));
		File f = new File("This is just a test");
		assertTrue(writer.setWriter(f));
		assertTrue(writer.setWriter((File)null));
		f.delete();
	}
	
	@Test
	public void testBuildFileName() {
		// Assure junk files from other tests don't exist.
		File f = new File("output tests/vivaldi-spring-1.abc");
		if (f.exists())
			f.delete();
		
		SongBuilder b = new SongBuilder();
		Song s = b.buildSong("abc files/vivaldi-spring.abc");
		ABCWriter writer =new ABCWriter();
		String dd = "output tests";
		writer.setDefaultDirectory(dd);
		assertEquals("output tests/vivaldi-spring.abc", writer.buildFileName(s, true));
		assertEquals("output tests/vivaldi-spring-1.abc", writer.buildFileName(s, false));
	}

}
