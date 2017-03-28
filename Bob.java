
import java.io.*;

public class Bob {
    //Add Fields if needed

    public Bob(){
        //Complete Your Code Here
    }

    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){
		return solvePuzzle(puzzles[(int)(Math.random()*puzzles.length)]);
    }

    public Pair<String, String> solvePuzzle(Puzzle puz){
    	
    	String key=General.solveKeyPuzzle(puz);
        String riddle=General.solveRiddlePuzzle(puz);
   
        return new Pair(riddle,key);
	
    }
  
}
