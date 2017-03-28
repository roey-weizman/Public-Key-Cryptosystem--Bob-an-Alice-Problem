
import java.lang.Math;

public class Alice {

	private Puzzle[] puzzlesArray;
	private AVLTree keyTree;
	private Improved[] solutions;

	public Alice() {
		puzzlesArray = null;
		keyTree = null;
		solutions = null;

	}

	public Puzzle[] getPuzzlesCopy() {
		Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
		for (int i = 0; i < puzzlesArray.length; i++) {
			puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
		}
		return puzzlesCopy;
	}

	public void createPuzzles(int n, int k) {
		Puzzle[] temp = new Puzzle[k];
		this.solutions = new Improved[k];
		int domain = (int) Math.pow(n, 3);
		for (int i = 0; i < temp.length; i++) {
			int p = 0;
			Puzzle puz = CreateOnePuz(n, domain);
			while (solutions[p] != null) {
				if ( (solutions[p].getImRiddle().equals(General.solveRiddlePuzzleWithoutSort(puz)))) {
					puz = CreateOnePuz(n, domain);
					p = 0;
				}
				p = p + 1;
			}
			temp[i] = puz;
			solutions[i] = new Improved(temp[i]); // storing the sorted puzzle into the improved object
		}
				
		for (int i = 0; i < temp.length; i++) {// rumbling the array
			General.randomShuffle(temp[i].getPrivateKey());
			General.randomShuffle(temp[i].getRiddle());
		}
		puzzlesArray = temp;
		createTree();

	}

	private Puzzle CreateOnePuz(int n, int domain) {
		int[] key = new int[n];
		int[] riddle = new int[n]; 
		for (int j = 0; j < key.length; j++) {
			key[j] = (int) (Math.random() * domain + j * domain);
			riddle[j] = (int) (
					Math.random() * domain + j * domain);
		}
		return new Puzzle(key, riddle);
	}

	public Pair<String, Integer> findKey(String sIndex) {
		return new Pair(General.ArrToStr((keyTree.getPrivateKey(sIndex)).getKey()),
				((keyTree.getPrivateKey(sIndex)).getValue()));
	}

	private void createTree() {// AVLTree to save the keys and the riddles
		this.keyTree = new AVLTree();
		if (solutions != null && solutions.length > 0) {
			for (int i = 0; i < solutions.length; i++) {
				keyTree.insert(solutions[i]);
			}
		}
	}

}
