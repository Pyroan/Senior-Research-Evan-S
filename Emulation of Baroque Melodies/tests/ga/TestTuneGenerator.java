package ga;

import static org.junit.Assert.*;

import org.junit.Ignore;
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
		Song ss = t.createTune("updated bounding");
		ABCWriter abc = new ABCWriter();
		abc.setDefaultDirectory("output tests");
		abc.writeSong(ss, false);
		abc.closeWriter();
		
		SongBuilder sb = new SongBuilder();
		Song s = sb.buildSong("output tests/unnamed-test.abc");
		assertNotNull(s);
	}
	
	// I hate this test so much already.
	// literally just prints out a string
	// of random walk ints. Since i have no way
	// to really test if they're the kind of random
	// I want them to be.
	@Test
	public void testPickNotes() {
		TuneGenerator t = new TuneGenerator();
		int[] notes = t.pickNotes(32);
		for (int i = 0; i < 32; i++) {
			System.out.print(notes[i]+" ");
		}
		System.out.println();		
	}

}
