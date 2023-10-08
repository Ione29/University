import java.util.*;

public class Game
{
    public static int[] timeOrder(int[] games)
    {
        int aux = 0;

        for(int i = 0; i < games.length; i++)
            for(int j = 1; j < (games.length - i); j++)
            {
                if(games[j - 1] > games[j])
                {
                    aux = games[j - 1];
                    games[j - 1] = games[j];
                    games[j] = aux;
                }

            }
        return games;
    }

    public static int decideWinner(int[] winningTimes)
    {
        int winner, minTime;
        winner = 0;
        minTime = winningTimes[0];

        for(int i = 1; i < winningTimes.length; i++)
            if(minTime > winningTimes[i])
            {
                winner = i;
                minTime = winningTimes[i];
            }

        return winner;
    }

    public static double averageNumberOfSubmissionsPerDay(int[][] submissions)
    {
        double averagePerDay = 0;

        for(int i = 0; i < submissions.length; i++)
            for(int j = 0; j < submissions[0].length; j++)
                averagePerDay += submissions[i][j];

        averagePerDay /= submissions.length;

        return averagePerDay;
    }

    public static int mostPopularHour(int[][] submissions)
    {
        int mostPopularHour = 0;
        int[] submissionsPerHour = new int[24];
        Arrays.fill(submissionsPerHour, 0);

        for(int j = 0; j < submissions[0].length; j++)
            for(int i = 0; i < submissions.length; i++)
                submissionsPerHour[j] += submissions[i][j];

        int max = submissionsPerHour[0];

        for(int i = 1; i < submissionsPerHour.length; i++)
            if(submissionsPerHour[i] > max)
            {
                mostPopularHour = i;
                max = submissionsPerHour[i];
            }

        return mostPopularHour;
    }

    public static void main(String args[])
    {
        //Exercitiul 1
        Sudoku game1 = new Sudoku(5, 2);
        Sudoku game2 = new Sudoku(9, 4);
        Sudoku game3 = new Sudoku(7, 3);
        Sudoku game4 = new Sudoku(12, 5);

        int[] games = {game1.getTimeToSolve(), game2.getTimeToSolve(), game3.getTimeToSolve(), game4.getTimeToSolve()};
        int[] ordered = timeOrder(games);

        for(int i = 0; i < ordered.length; i++)
            System.out.println("Game " + (i + 1) + " | Time to solve: " + ordered[i]);

        //Exercitiul 2
        int[] winningTimesOfTheDay = {15, 23, 74, 12, 53, 37};
        int winner = decideWinner(winningTimesOfTheDay) + 1;
        System.out.println("The winner of the day is player #" + winner + ", with a time of " + (winningTimesOfTheDay[winner - 1]) + " minutes.");

        //Exercitiul 3
        int[][] submissionNumbers;
        submissionNumbers = new int[7][24];
        Random rnd = new Random();

        //create an array with the submissions per hour on columns, per days on rows
        for(int i = 0; i < submissionNumbers.length; i++)
            for(int j = 0; j < submissionNumbers[0].length; j++)
                submissionNumbers[i][j] = rnd.nextInt(351);

        //print the average of submissions per day
        System.out.println("The average number of submissions per day is " + averageNumberOfSubmissionsPerDay(submissionNumbers) + ".");

        //print the hour with most submissions
        System.out.println("The hour in which the most solutions were submitted is " + mostPopularHour(submissionNumbers) + ".");

    }
}
