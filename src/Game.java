import java.util.Scanner;

public class Game {
    //create fields
    //to store the user's pick
    String userPick;
    //to store the computer's pick
    String computerPick;
    //to store either "win", "lose". "draw"
    String result;
    //to store the score
    int userWins;
    int computerWins;
    int draws;

    // Constructor to initialize scores
    public Game() {
        userWins = 0;
        computerWins = 0;
        draws = 0;
    }

    //get computer's pick
    String getComputerPick(){
        String computerPick;
        int randomNumber = (int) (Math.random() * 3) + 1;

        if (randomNumber == 1) {
            computerPick = "rock";
        }
        else if(randomNumber == 2) {
            computerPick = "paper";

        }
        else {
            computerPick = "scissors";
        }

        return computerPick;

    }

    //get user's pick
    String getUserPick(){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter rock, paper or scissors: ");

        //get input until user enters "rock. "paper", "scissors"
        while (true) {
            userPick = input.nextLine();

            if (userPick.equals("rock") || userPick.equals("paper") || userPick.equals("scissors")){
                break;
            } else {
                System.out.println("Invalid input. Enter rock, paper, or scissors.");
            }
        }

        return userPick;
    }

    //get result
    String getResult(String userPick, String computerPick){
        //condition for user to draw
        if (userPick.equals(computerPick)){
            draws++;
            return "draw";
        }
        else if(userPick.equals("paper") && computerPick.equals("rock")){
            userWins++;
            return "win";
        }
        else if(userPick.equals("rock") && computerPick.equals("scissors")){
            userWins++;
            return "win";
        }
        else if(userPick.equals("scissors") && computerPick.equals("paper")){
            userWins++;
            return "win";
        }
        else {
            computerWins++;
            return "lose";
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        boolean playAgain = true;

        while (playAgain) {
            String userPick = game.getUserPick();
            String computerPick = game.getComputerPick();
            String result = game.getResult(userPick, computerPick);

            System.out.println("User Pick: " + userPick);
            System.out.println("Computer Pick: " + computerPick);
            System.out.println("You " + result);

            System.out.println("Do you want to play again? (y/n): ");
            String playAgainInput = input.nextLine();

            if (!playAgainInput.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }

        // After the loop ends (when playAgain is false), display the final score
        System.out.println("Game over!");
        System.out.println("User Wins: " + game.userWins);
        System.out.println("Computer Wins: " + game.computerWins);
        System.out.println("Draws: " + game.draws);
    }
}
