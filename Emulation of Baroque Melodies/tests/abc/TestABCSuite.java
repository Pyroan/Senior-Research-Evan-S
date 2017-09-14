package abc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestSongBuilder.class,
	TestSong.class,
	TestNote.class
})

public class TestABCSuite {
}
