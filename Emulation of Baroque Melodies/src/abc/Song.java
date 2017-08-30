package abc;

/**
 * Represents a Song.
 * @author Evan Schoenberger
 *
 */
public class Song {
	
	// Metadata/information fields
	private String title; // Title of the piece
	private String composer; // original composer
	private Tempo tempo; // Speed the piece should be played at.
	private String timeSignature; // 
	
	// Tune Body
//	public Note[] notes;
	
	/*********************
	 *    Constructors   *
	 *********************/

	/**
	 * Constructs a new Song with default attributes
	 */
	public Song() {
		title = "Untitled";
		composer = "Unnamed";
		tempo = Tempo.ANDANTE;
		timeSignature = "4/4";
	}
	
	/**
	 * Constructs a new song with specified attributes
	 */
	public Song(String title, String composer, Tempo tempo, String timeSignature) {
		this.title = title;
		this.composer = composer;
		this.tempo = tempo;
		this.timeSignature = timeSignature;
	}
	
	/**
	 * Constructs an existing song from the given
	 * pathname.
	 * @param path
	 */
	public Song(String path) {
		SongBuilder abcReader = new SongBuilder();
		abcReader.openReader(path);
	}
	
	public String getMetadata() {
		String s = title + ",\nBy " + composer;
		return s;
	}
}
