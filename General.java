
public abstract  class General {// class of static function
	public static int[] strToArr(String s){//split the numeric chars from string and put in array's cells
		int[] numbers = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
		   numbers[i] = s.charAt(i) - '0';
		}
		return numbers;
	}
	public static String ArrToStr(int[] numbers){//unite all the chars in array to a string
		String s ="";
		for (int i = 0; i < numbers.length; i++) {
		   s = s+ numbers[i];
		}
		return s;
	}
	
	public static String solveKeyPuzzleWithoutSort(Puzzle puz) {// take the puzzle and solve only the key
		String ansKey = "";
		int[] key = puz.getPrivateKey();
		for (int i = 0; i < key.length; i++) {
			ansKey = ansKey + xor(decToBin(key[i]));
		}

		return ansKey;
	}
	
	public static String solveKeyPuzzle(Puzzle puz) {// take the puzzle and solve only the key
		String ansKey = "";
		int[] key = puz.getPrivateKey();
		key = bucketSort(key);
		for (int i = 0; i < key.length; i++) {
			ansKey = ansKey + xor(decToBin(key[i]));
		}

		return ansKey;
	}

	public static String solveRiddlePuzzleWithoutSort(Puzzle puz) {
		String ansRiddle = "";
		int[] riddle = puz.getRiddle();
		for (int i = 0; i < riddle.length; i++) {
			ansRiddle = ansRiddle + xor(decToBin(riddle[i]));
		}
		return ansRiddle;
	}
	
	public static String solveRiddlePuzzle(Puzzle puz) {// take the puzzle and solve only the riddle
		String ansRiddle = "";
		int[] riddle = puz.getRiddle();
		riddle = bucketSort(riddle);
		for (int i = 0; i < riddle.length; i++) {
			ansRiddle = ansRiddle + xor(decToBin(riddle[i]));
		}
		return ansRiddle;
	}

	public static void randomShuffle(int[] a) {
		int temp;
		for (int i = 0; i < a.length - 1; i++) {
			int indexToSwap = (int) (Math.random() * (a.length - i) + i);
			temp = a[i];
			a[i] = a[indexToSwap];
			a[indexToSwap] = temp;
		}
	}

	public static String decToBin(int n) {//conversion of decimal number to binary string
		String s = "";
		s = s + (n % 2);
		while (n / 2 != 0) {
			n = n / 2;
			s = (n % 2) + s;
		}
		return s;
	}

	    public static int xor(String bin){//returns 1 if the numbers of 1's are even else return 0
	    	int counter=0;
	    	for(int i=0;i<bin.length();i++){
	    		if(bin.charAt(i)=='1')
	    			counter++;
	    	}
	    	return counter%2;
	    }

	public static int[] bucketSort(int[] arr){//sorting an array
	    int[] ans = new int[arr.length];
	    int domain=(int)(Math.pow(arr.length, 3));
	    for (int i=0;i<arr.length;i++){
	    	int index=arr[i]/domain;
	    	ans[index]=arr[i];
	    }
	    return ans;
	}
		

}
