import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        // global formats
        Scanner input = new Scanner(System.in);
        DecimalFormat dec = new DecimalFormat("0.00");

        // arrays (assuming only 3 people are signing up for this league.)
        Team[] leagueRoster = new Team[3];
        Player[] teamLineup = new Player[3];

        // capture all user input for teams.
        System.out.println("FANTASY HOCKEY APPLICATION");
        System.out.println("TEAM ENTRY");
        System.out.println("=====================================");
        for (int i = 0; i < leagueRoster.length; ++i) {
            String name;

            do {
                System.out.println("Please enter your teams name: ");
                while (!input.hasNextLine()) {
                    System.out.println("Please enter a valid name!");
                    input.next();
                }
                name = input.nextLine();
                leagueRoster[i] = new Team(name);
            }
            while (input == null || input.equals(""));
        }

        // time for the players. name, goals and assists. Salary is randomly set when players are created.
        System.out.println("PLAYER ENTRY");
        System.out.println("=====================================");
        for (int i = 0; i < teamLineup.length; ++i) {
            String name;
            int goals;
            int assists;

            //maybe do this in a nested for loop. might be cleaner.
            System.out.println("Enter Players for " + leagueRoster[i].getName() + ".");
            do {
                System.out.println("Enter name for player #" + (i+1) +":" );
                while (!input.hasNextLine()){
                    System.out.println("Please enter a valid name!");
                    input.next();
                }
                name = input.nextLine();

                System.out.println("Enter number of goals for "+ name +":");
                while (!input.hasNextInt()) { //Check that the value is an integer
                    System.out.println("Enter a positive number.");
                    input.nextInt();
                    input.nextLine();
                }
                goals = input.nextInt();
                input.nextLine();

                System.out.println("Enter number of assists for "+ name +":");
                while (!input.hasNextInt()) { //Check that the value is an integer
                    System.out.println("Enter a positive number.");
                    input.nextInt();
                    input.nextLine();
                }
                assists = input.nextInt();
                input.nextLine();

                teamLineup[i] = new Player(name, goals, assists);
            }
            while (input == null || input.equals("") || goals < 0 || assists < 0);
        }

        // output all data here. Learn some proper formatting, noob.
    }
}