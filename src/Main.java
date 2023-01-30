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

        for (int i = 0; i < 3; i++) {
            System.out.println("");
            System.out.println("Please enter the players for " + leagueRoster.get(i).getName() + ".");
            for (int j = 0; j < 3; j++) {

                String playerName;
                int numGoals, numAssists;

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
                while (numGoals < 0);

                do {
                    System.out.println("Enter the amount of assists for " + playerName + ":");
                    while (!input.hasNextInt()) {
                        System.out.println("Please enter a number!");
                        input.nextLine();
                    }
                    numAssists = input.nextInt();
                    input.nextLine();
                }
                while (numAssists < 0);

                if (i == 0) teamOne.add(new Player(playerName, numGoals, numAssists));
                if (i == 1) teamTwo.add(new Player(playerName, numGoals, numAssists));
                if (i == 2) teamThree.add(new Player(playerName, numGoals, numAssists));

            }
        }
        //endregion

        //region setting up for data output section.

        int team1Goals = 0, team1Assists = 0, team2Goals = 0, team2Assists = 0, team3Goals = 0, team3Assists = 0;
        int team1Total = 0, team2Total = 0, team3Total = 0;

        for (Player player : teamOne) {
            team1Goals = team1Goals + player.getNumGoals();
            team1Assists = team1Assists + player.getNumAssists();
            team1Total = team1Goals + team1Assists;
        }

        for (Player player : teamTwo) {
            team2Goals = team2Goals + player.getNumGoals();
            team2Assists = team2Assists + player.getNumAssists();
            team2Total = team2Goals + team2Assists;
        }

        for (Player player : teamThree) {
            team3Goals = team3Goals + player.getNumGoals();
            team3Assists = team3Assists + player.getNumAssists();
            team3Total = team3Goals + team3Assists;
        }

        //endregion

        //region Data output
        System.out.println("");
        System.out.println("STAT REPORTS FOR ALL TEAMS");
        System.out.println("=====================================");

        //team1
        System.out.println(leagueRoster.get(0).getName() + ": G - " + team1Goals + "   A - " + team1Assists + "   Total - " + team1Total + "   Budget - $" + dec.format(leagueRoster.get(0).getBudget()));
        System.out.println(leagueRoster.get(0).teamRating(team1Total));
        System.out.println("");

        //team2
        System.out.println(leagueRoster.get(1).getName() + ": G - " + team2Goals + "   A - " + team2Assists + "   Total - " + team2Total + "   Budget - $" + dec.format(leagueRoster.get(1).getBudget()));
        System.out.println(leagueRoster.get(1).teamRating(team2Total));
        System.out.println("");

        //team3
        System.out.println(leagueRoster.get(2).getName() + ": G - " + team3Goals + "   A - " + team3Assists + "   Total - " + team3Total + "   Budget - $" + dec.format(leagueRoster.get(2).getBudget()));
        System.out.println(leagueRoster.get(2).teamRating(team3Total));

        System.out.println("");
        System.out.println("Stats per player:");
        System.out.println("=====================================");

        //team1
        System.out.println(leagueRoster.get(0).getName());
        for (Player currentPlayer : teamOne){
            currentPlayer.playerStats(currentPlayer);
        }
        System.out.println("");

        //team2
        System.out.println(leagueRoster.get(1).getName());
        for (Player currentPlayer : teamTwo){
            currentPlayer.playerStats(currentPlayer);
        }
        System.out.println("");

        //team3
        System.out.println(leagueRoster.get(2).getName());
        for (Player currentPlayer : teamThree){
            currentPlayer.playerStats(currentPlayer);
        }

        //endregion
    }
}