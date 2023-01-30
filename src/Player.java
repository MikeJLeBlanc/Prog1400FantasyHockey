

public class Player{

    private String name;
    private int numGoals, numAssists;

    //CONSTRUCTOR
    protected Player(String name, int numGoals, int numAssists) {
        this.name = name;
        this.numGoals = numGoals;
        this.numAssists = numAssists;
    }

    protected void playerStats(Player player) {
        System.out.println(name + ": G - " + numGoals + "   A - " + numAssists + "   Total - " + (numGoals+numAssists));
    }

    protected int getNumGoals() {
        return numGoals;
    }

    protected int getNumAssists() {
        return numAssists;
    }

}