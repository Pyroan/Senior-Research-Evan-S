package abc;

public class ABCParser {

	// an ABC File to be read
	ABCFile abcFile;
	
	// BAD. this should open the file.
	public ABCParser(ABCFile abcf) {
		abcFile = abcf;
	}
	
	public void getMetadata() {
		
	}
	
	public String getTitle() {
		return null;
	}
	
}
