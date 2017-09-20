package ga;

import static org.junit.Assert.*;

import org.junit.Test;

import abc.ABCWriter;
import abc.Song;
import abc.SongBuilder;

public class TestTuneGenerator {

	// There isn't really a great way to test this,
	// Other than to just make sure a tune was actually generated.
	@Test
	public void testCreateTune() {
		TuneGenerator t = new TuneGenerator();
		Song ss = t.createTune("Test");
		ABCWriter abc = new ABCWriter();
		abc.setDefaultDirectory("output tests");
		abc.writeSong(ss, true);
		abc.closeWriter();
		
		SongBuilder sb = new SongBuilder();
		Song s = sb.buildSong("output tests/unnamed-test.abc");
		assertNotNull(s);
	}

}
