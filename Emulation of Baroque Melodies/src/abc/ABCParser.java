package abc;

public class ABCParser {

	// an ABC File to be read
	ABCReader abcFile;
	
	// BAD. this should open the file.
	public ABCParser(ABCReader abcf) {
		abcFile = abcf;
	}
	
	public void getMetadata() {
		
	}
	
	public String getTitle() {
		return null;
	}
	
}
