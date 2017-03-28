
public class Improved implements Comparable {

	private String imRiddle;
	private String imKey;

	public Improved(Puzzle puz) {
		this.imKey = General.solveKeyPuzzleWithoutSort(puz);
		this.imRiddle = General.solveRiddlePuzzleWithoutSort(puz);
	}

	public String getImRiddle() {
		return imRiddle;
	}

	public String getImKey() {
		return imKey;
	}

	public int compareTo(Object str) {
		if (str instanceof String) {
			if ((this.imRiddle).compareTo((String) str) > 0) // using compareTo of
															// String
				return 1;
			else if ((this.imRiddle).compareTo((String) str) < 0)
				return -1;
			else
				return 0;
		} else
			throw new RuntimeException("got a non String Object");
	}

}
