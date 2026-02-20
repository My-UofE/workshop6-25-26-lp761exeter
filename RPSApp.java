import java.util.Scanner;
import java.util.Random;

enum HandSign 
{
    ROCK, 
    PAPER,
    SCISSORS
}

public class RPSApp 
{
    /**
     * The main method
     */
    public static void main(String[] args) 
    {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove;// player’s sign from keyboard
        HandSign computerMove;// computer’s random sign

        int checkwin;
        boolean gameOver = false;
        while (!gameOver)
        {

            //Step1: Get the player move from the keyboard input
            playerMove = getPlayerMove();
            String playerMoveString = signAsString(playerMove);

            //Step2: Get the computer’s move (randomly generated)
            computerMove = getComputerMove();
            String computerMoveString = signAsString(computerMove);

            //Step3: Check who wins
            int winner = whoWins(playerMove, computerMove);

            //Step4: Output who played what and who won the round
            System.out.println("Player hand: "+playerMoveString);
            System.out.println("Computer hand: "+computerMoveString);
            switch (winner)
            {
                case -1:
                    System.out.println("Computer wins");
                    computerScore++;
                    break;
                case 0:
                    System.out.println("Tie");
                    break;
                case 1:
                    System.out.println("Player wins");
                    playerScore++;
                    break;
                case -2:
                    System.out.println("exit");
                    gameOver = true;
                    break;
            }  
            System.out.println("Player score: "+playerScore);
            System.out.println("Computer score: "+computerScore);
        }
    }

    public static String signAsString(HandSign h)
    {
        String result = "error";
        switch (h)
        {
            case HandSign.ROCK:
                result = "rock";
                break;
            case HandSign.PAPER:
                result = "paper";
                break;
            case HandSign.SCISSORS:
                result = "scissors";
                break;
        }
        return result;
    }
    /**
     * Get the computer’s move (randomly generated)
     */
    public static HandSign getComputerMove()
    {
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        switch (n)
        {
            case 0:
                computerMove = HandSign.SCISSORS;
                break;
            case 1:
                computerMove = HandSign.PAPER;
                break;
            case 2:
                computerMove = HandSign.ROCK;
                break;
        }

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove()
    {
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);
        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
        boolean validInput = false;
        HandSign playerHandSign = null;
        while(!validInput) // repeat until valid  input
        {
            System.out.println("Please input your hand sign (s,p,r, or q to exit)");

            // convert the input string into a char type
            char inChar = in.next().toLowerCase().charAt(0);

            switch (inChar)
            {
                case 's':
                    System.out.println("You chose scissors");
                    playerHandSign = HandSign.SCISSORS;
                    validInput = true;
                    break;
                case 'p':
                    System.out.println("You chose paper");
                    playerHandSign = HandSign.PAPER;
                    validInput = true;
                    break;
                case 'r':
                    System.out.println("You chose rock");
                    playerHandSign = HandSign.ROCK;
                    validInput = true;
                    break;
                case 'q':
                    System.out.println("You chose to exit");
                    validInput = true;
                    break;
                default:
                    System.out.println("You entered and invalid input");

            }


        }
        
        return playerHandSign;

      }

    /**
     * Check who wins
     *
     * @param h1 the first hand sign
     * @param h2 the second hand sign
     * @return 0 if two signs equal, 
     *        -1 if the second sign wins, 
     *         1 if the first sign wins
     *
     */
    public static int whoWins(HandSign h1, HandSign h2)
    {
        int result = -2;
        if (h1 == h2)
        {
            result = 0;
        }
        else if (h1==HandSign.SCISSORS && h2 == HandSign.PAPER)
        {
            result = 1;
        }
        else if (h1==HandSign.SCISSORS && h2 == HandSign.ROCK)
        {
            result = -1;
        }
        else if (h1==HandSign.PAPER && h2 == HandSign.ROCK)
        {
            result = 1;
        }
        else if (h1==HandSign.PAPER && h2 == HandSign.SCISSORS)
        {
            result = -1;
        }
        else if (h1==HandSign.ROCK && h2 == HandSign.SCISSORS)
        {
            result = 1;
        }
        else if (h1==HandSign.ROCK && h2 == HandSign.PAPER)
        {
            result = -1;
        }
        return result;
    }
}