package abc;

/**
 * Represents a single note in a tune.
 * @author Evan S.
 *
 */
public class Note {

	/**
	 * Can be ^ (sharp), = (natural), or _ (flat)
	 */
	char accidental;

	char pitch;

	/**
	 * An octave of 0 means the octave
	 * beginning at Middle-C
	 * An octave of n is n octaves above
	 * or below octave 0.
	 */
	int octave;

	/**
	 * The length of a note, where units
	 * are the default note length of the tune.
	 * A length of -n is equal to 1/(2n)
	 */
	int length;


	/**
	 * @return true if S is a valid accidental,
	 * false otherwise.
	 */
	public boolean setAccidental(String s) {
		if (s == "^" || s == "=" || s == "_") {
			accidental = s.charAt(0);
			return true;
		} else {
			return false;
		}
	}

	public boolean setPitch(String s) {
		if (s.matches("[A-Ga-g]|z")) {
			pitch = s.charAt(0);
			return true;
		}	
		else {
			return false;
		}
	}
	public boolean setOctave(int n) {
		octave = n;
		return true;
	}

	public boolean setLength(int n) {
		length = n;
		return true;
	}
}
