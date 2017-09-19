import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import abc.*;
import ga.*;
import ui.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestABCSuite.class,
	TestGASuite.class,
	TestUISuite.class
})
public class AllTests {
}
