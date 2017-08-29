package abc;

public enum Tempo {
	GRAVE("Grave", 25, 45),
	LARGO("Largo", 45, 60),
	LARGHETTO("Larghetto", 60, 66),
	ADAGIO("Adagio", 66, 76),
	ANDANTE("Andante", 76, 108),
	MODERATO("Moderato", 108, 120),
	ALLEGRO("Allegro", 120, 168),
	VIVACE("Vivace", 168, 176),
	PRESTO("Presto", 176, 200);
	
	private final String name;
	private final int min;
	private final int max;
	Tempo(String name, int min, int max) {
		this.name = name;
		this.min = min;
		this.max = max;
	}
}
