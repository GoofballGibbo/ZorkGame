package game.Puzzle;

import game.Items.MemoryBlock;

public class Puzzle {

    private final String puzzle;
    private final String solution;
    private final MemoryBlock rewardMemory;
    private boolean solved;


    public Puzzle(String puzzle, String solution, MemoryBlock rewardMemory) {
        this.puzzle = puzzle;
        this.solution = solution;
        this.rewardMemory = rewardMemory;
        this.solved = false;
    }


    public String getRiddle() {
        return puzzle;
    }

    public MemoryBlock getMemory() {
        return rewardMemory;
    }

    public boolean isSolved() {
        return solved;
    }
    public void setSolved(boolean solved) {
        this.solved = solved;
    }



    public String getSolution() {
        return solution;
    }

    /*
    public boolean check(String attempt) {
        if (attempt == null) {
            return false;
        }
        boolean correct = attempt.equalsIgnoreCase(solution);
        if(correct) {
            solved = true;
        }

        return correct;
    }*/
}
