package abc;

/**
 * Represents a Song.
 * @author Evan S
 *
 */
public class Song {

	// Metadata/information fields
	private String title; // Title of the piece
	private String composer; // original composer
	private String key;

	// The following two will be used when creating pieces
	// to evaluate how many beats/notes should be in each measure.
	private int[] meter = new int[2];
	private int noteLength;

	// Tune Body
	public Note[] notes;

	
	/*********************
	 *    Constructors   *
	 *********************/

	/**
	 * Constructs a new Song with default attributes
	 */
	public Song() {
		title = "Untitled";
		composer = "Unnamed";
		key = "C";
		meter[0]=4; 
		meter[1]=4;
		noteLength = 8;
	}

	/**
	 * Constructs a new song with specified attributes
	 * FIXME this may not be necessary. 
	 * Depends on whether the bot needs it to create new songs.
	 */
	public Song(String title, String composer, String timeSignature) {
		this.title = title;
		this.composer = composer;
		setMeter(timeSignature);
	}

	/****************************
	 *    Getters and Setters   *
	 ****************************/

	/**
	 * Returns just the title and composer in the form
	 * "<Title>, by <Composer>"
	 */
	public String getTitleAndComposer() {
		String s = title + ",\nBy " + composer;
		return s;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String comp) {
		composer = comp;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getNoteLength() {
		return "1/"+noteLength;
	}
	
	public int getNoteLengthInt() {
		return noteLength;
	}

	/**
	 * Sets the note length based on a string instead
	 * of an int, converting it.
	 * This assumes note length is always in the form
	 * "1" or "1/X"
	 * @param noteLength
	 */
	public void setNoteLength(String noteLength) {
		if (noteLength.length() == 1) {
			setNoteLength(Integer.parseInt(noteLength));
		} else {
			this.noteLength = Integer.parseInt(noteLength.substring(2));
		}
	}

	public void setNoteLength(int noteLength) {
		this.noteLength = noteLength;
	}

//	public void setTimeSignature(String ts) {
//		// reminder meter isn't a string anymore;
//		//meter = ts;
//	}

	/**
	 * Sets the meter. Assumes the string being passed to it
	 * is of the form "X/Y" or "C" for common time.
	 * @param meter
	 */
	public void setMeter(String meter) {
		if (meter.equals("C")) {
			this.meter[0] = 4;
			this.meter[1] = 4;
		} else {
			String[] m = meter.split("/");
			this.meter[0] = Integer.parseInt(m[0]);
			this.meter[1] = Integer.parseInt(m[1]);
		}
	}
	
	public int[] getMeter() {
		return meter;
	}
	
	public String getMeterString() {
		return meter[0]+"/"+meter[1];
	}
	
}
