public class Sudoku
{
    private int rows, columns;
    private int time;
    private int difficulty;
    int[][] matrix;

    public Sudoku(int time, int difficulty)
    {
        this.time = time;
        this.difficulty = difficulty;
    }

    public int getTimeToSolve()
    {
        return this.time;
    }


}
