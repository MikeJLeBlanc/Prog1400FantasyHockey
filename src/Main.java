import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        // global formats
        Scanner input = new Scanner(System.in);
        DecimalFormat dec = new DecimalFormat("0.00");

        // 2d array (assuming only 3 people are signing up for this league and 3 players per team.)
        Team[][] leagueRoster = new Team[3][4];


        // capture all user input for teams.
        System.out.println("FANTASY HOCKEY APPLICATION");
        System.out.println("TEAM ENTRY");
        System.out.println("=====================================");
        for (int i = 0; i < leagueRoster.length; ++i) {
            String teamName;

            do {
                System.out.println("Please enter your teams name: ");
                while (!input.hasNextLine()) {
                    System.out.println("Please enter a valid name!");
                    input.next();
                }
                teamName = input.nextLine();
                leagueRoster[i][0] = new Team(teamName);
            }
            while (input == null || input.equals("") || teamName.length() > 3);
        }

        // time for the players. name, goals and assists. Salary is randomly set when players are created.
        System.out.println("PLAYER ENTRY");
        System.out.println("=====================================");

        String playerName;

        for (int row = 0; row < leagueRoster.length; row++) {
            System.out.println("Please enter the players for " + leagueRoster[row][0] + ".");
            for (int col = 1; col < leagueRoster[0].length; col++) {
                if (col == 0) {
                    col++;
                }
                do {
                    System.out.println("Enter name for player #" + (col) + ":");
                    while (!input.hasNextLine()) {
                        System.out.println("Please enter a valid name!");
                        input.next();
                    }
                    playerName = input.nextLine();
                }
                while (input == null || input.equals("") || goals < 0 || assists < 0 || playerName.length > 3);
            }
        }
        // output all data here. Learn some proper formatting, noob.
    }
}