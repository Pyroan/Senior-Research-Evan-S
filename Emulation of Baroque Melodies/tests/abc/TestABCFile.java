package abc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestABCFile {
	
	@Test
	public void testOpenForReading() {
		ABCFile abcfile = new ABCFile();
		assertTrue(abcfile.openForReading("abc files/vivaldi-spring.abc"));
		assertFalse(abcfile.openForReading("abc files/bach-song.abc"));
	}
	
	@Test
	public void testClose() {
		ABCFile abcfile = new ABCFile();
		// Can't close a file that was never opened. (NullPointerException)
		assertFalse(abcfile.close());
		// Should be able to close a file that is opened.
		abcfile.openForReading("abc files/vivaldi-spring.abc");
		assertTrue(abcfile.close());
	}

}
