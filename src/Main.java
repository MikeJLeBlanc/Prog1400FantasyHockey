import java.util.Objects;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        // global formats
        Scanner input = new Scanner(System.in);
        DecimalFormat dec = new DecimalFormat("0.00");

        // changed to 2 single arrays. will control with nested for loop at end.
        Team[] leagueRoster = new Team[3];
        Player[] teamRoster = new Player[9];



        // capture all user input for teams.
        System.out.println("FANTASY HOCKEY APPLICATION");
        System.out.println("TEAM ENTRY");
        System.out.println("=====================================");
        for (int i = 0; i < 3; ++i) {
            String teamName;

            do {
                System.out.println("Please enter your teams name: ");
                while (!input.hasNextLine()) {
                    System.out.println("Please enter a valid name!");
                    input.next();
                }
                teamName = input.nextLine();
                leagueRoster[i] = new Team(teamName);
            }
            while (input == null || input.equals(""));
        }

        // time for the players. name, goals and assists. they get added to the team roster
        System.out.println("PLAYER ENTRY");
        System.out.println("=====================================");

        String playerName;
        int numGoals, numAssists;

        for (int teamNum = 0; teamNum < leagueRoster.length; teamNum++) {
            System.out.println("Please enter the players for " + leagueRoster[teamNum].getName() + ".");
            for (int playerNum = 0; playerNum < teamRoster.length; playerNum++) {

                do {
                    System.out.println("Enter name for player #" + (playerNum+1) + ":");
                    while (!input.hasNextLine()) {
                        System.out.println("Please enter a valid name!");
                        input.next();
                    }
                    playerName = input.nextLine();
                }
                while (input == null || input.equals(""));
                do {
                    System.out.println("Enter the amount of goals for " + playerName + ":");
                    intValidation();
                    numGoals = input.nextInt();
                    input.next();
                }
                while (input == null || input.equals(""));
                do {
                    System.out.println("Enter the amount of assists for " + playerName + ":");
                    intValidation();
                    numAssists = input.nextInt();
                    input.next();
                }
                while (input == null || input.equals(""));

                teamRoster[playerNum] = new Player(playerName, numGoals, numAssists);
            }
        }
        // output all data here. Learn some proper formatting, noob.
    }

    static void intValidation() {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("Please enter a number!");
            input.next();
            if (input.nextInt() < 0)
                System.out.println("Please enter a valid number (greater than or equal to 0)");
            input.next();
        }
    }
}