public class Puzzle  {

	private int[] privateKey;
	private int[] riddle;

	public Puzzle(int[] privateKey, int[] riddle) {
		this.privateKey = privateKey;
		this.riddle = riddle;
	}

	public Puzzle(Puzzle o) {
		int[] oRiddle = o.getRiddle();
		int[] oPrivateKey = o.getPrivateKey();
		privateKey = new int[oPrivateKey.length];
		riddle = new int[oRiddle.length];
		for (int i = 0; i < oPrivateKey.length; i++) {
			privateKey[i] = oPrivateKey[i];
		}
		for (int i = 0; i < oRiddle.length; i++) {
			riddle[i] = oRiddle[i];
		}
	}

	public int[] getPrivateKey() {
		return privateKey;
	}

	public int[] getRiddle() {
		return riddle;
	}

	
}
