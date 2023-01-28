

public class Player{

    private String name;
    private int numGoals = 0, numAssists = 0;

    //CONSTRUCTOR
    public Player(String name, int numGoals, int numAssists) {
        this.name = name;
        this.numGoals = numGoals;
        this.numAssists = numAssists;
    }

    public String getName() {
        return name;
    }

    public int getNumGoals() {
        return numGoals;
    }

    public int getNumAssists() {
        return numAssists;
    }

}