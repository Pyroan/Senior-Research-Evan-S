package abc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestABCParser {

	@Test
	public void testGetMetadata() {
		ABCReader abcfile = new ABCReader();
		abcfile.openForReading("abc files/vivaldi-spring.abc");
		ABCParser abcParser = new ABCParser(abcfile);
		
	}

}
