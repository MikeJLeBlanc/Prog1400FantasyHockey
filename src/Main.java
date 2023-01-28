import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        // global formats
        Scanner input = new Scanner(System.in);
        DecimalFormat dec = new DecimalFormat("0.00");

        // changed to 3 arrays lists. will control with nested for loop .
        ArrayList<Team> leagueRoster = new ArrayList<>();
        ArrayList<Player> teamOne = new ArrayList<>();
        ArrayList<Player> teamTwo = new ArrayList<>();
        ArrayList<Player> teamThree = new ArrayList<>();

        //region teams input into leagueRoster array
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
                if (teamName.length() < 3) {
                    System.out.println("Please enter a Team name that is more than 3 characters");
                    teamName = input.nextLine();

                }
            }
            while (teamName == null || teamName.equals("")); // input validation to get the user to actually write correct values. these can have numbers.
            leagueRoster.add(new Team(teamName));
        }
        //endregion

        //region loops through teams array to input players.
        // time for the players. name, goals and assists. they get added to the team roster
        System.out.println("PLAYER ENTRY");
        System.out.println("=====================================");

        String playerName;
        int numGoals, numAssists;

        for (Team team : leagueRoster) {
            System.out.println("Please enter the players for " + team.getName() + ".");
            for (int j = 0; j < 3; j++) {
                do {
                    System.out.println("Enter name for player #" + (j + 1) + ":");
                    while (!input.hasNextLine()) {
                        System.out.println("Please enter a valid name!");
                        input.next();
                    }
                    playerName = input.nextLine();
                }
                while (playerName == null || playerName.length() < 3);
                do {
                    System.out.println("Enter the amount of goals for " + playerName + ":");
                    while (!input.hasNextInt()) {
                        System.out.println("Please enter a number!");
                        input.nextLine();
                    }
                    numGoals = input.nextInt();
                }
                while (numGoals <= 0);
                do {
                    System.out.println("Enter the amount of assists for " + playerName + ":");
                    while (!input.hasNextInt()) {
                        System.out.println("Please enter a number!");
                        input.nextLine();
                    }
                    numAssists = input.nextInt();
                    input.nextLine();
                }
                while (numAssists <= 0);


                if (teamOne.size() < 3) {
                    teamOne.add(new Player(playerName, numGoals, numAssists));

                } if (teamTwo.size() == 3) {
                    teamTwo.add(new Player(playerName, numGoals, numAssists));

                } else {
                    teamThree.add(new Player(playerName, numGoals, numAssists));
                }
            }
        }
        //endregion
        for (int i = 0; i < 3; i++) {
            System.out.println(leagueRoster.get(i).getName() + " has these players:");
            for (int j = 0; j < 3; j++){
                if (j < 3) {
                    System.out.println(teamOne.get(j));

                } if (j < 3) {
                    System.out.println(teamTwo.get(j));

                } else {
                    System.out.println(teamThree.get(j));

                }
            }
        }
        // output all data here. Learn some proper formatting, noob.
    }
}