
import java.io.*;

/**
 * Created by tomercoh on 16/04/2016.
 */
public class Eve {
	
	//Add Fields if needed

    public Eve(){}

    public Pair<String, Integer> findKey(String index, Puzzle[] puzzles){
		int counter=0;
		boolean isFound=false;
		int i;
		for (i=0;i<puzzles.length&&!isFound;i++){
    		counter=counter+1;
    		if(solvePuzzle(puzzles[i]).getValue().equals(index))
    			isFound=true;
    		
		}
		

    	return new Pair(solvePuzzle(puzzles[i-1]).getKey(),counter);
    }

    public Pair<String, String> solvePuzzle(Puzzle puz){
        String key=General.solveKeyPuzzle(puz);
        String riddle=General.solveRiddlePuzzle(puz);
        return new Pair(key,riddle);
    }
}
