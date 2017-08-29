package abc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestABCReader {
	
	@Test
	public void testOpenForReading() {
		ABCReader abcReader = new ABCReader();
		assertTrue(abcReader.openForReading("abc files/vivaldi-spring.abc"));
		assertFalse(abcReader.openForReading("abc files/bach-song.abc"));
	}
	
	@Test
	public void testClose() {
		ABCReader abcReader = new ABCReader();
		// Can't close a file that was never opened. (NullPointerException)
		assertFalse(abcReader.close());
		// Should be able to close a file that is opened.
		abcReader.openForReading("abc files/vivaldi-spring.abc");
		assertTrue(abcReader.close());
	}

}
