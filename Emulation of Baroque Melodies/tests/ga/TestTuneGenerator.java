package ga;

import static org.junit.Assert.*;

import org.junit.Test;

import abc.Song;
import abc.SongBuilder;

public class TestTuneGenerator {

	// There isn't really a great way to test this,
	// Other than to just make sure a tune was actually generated.
	@Test
	public void testCreateTune() {
		TuneGenerator t = new TuneGenerator();
		t.createTune("Test");
		SongBuilder sb = new SongBuilder();
		Song s = sb.buildSong("unnamed-test.abc");
		assertNotNull(s);
	}

}
