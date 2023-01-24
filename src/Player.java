

public class Player {

    private String name;
    private int numGoals = 0, numAssists = 0;
    private float salary = 0;

    //CONSTRUCTOR
    public Player(String name, int numGoals, int numAssists) {
        this.name = name;
        this.numGoals = numGoals;
        this.numAssists = numAssists;
        salary = randBudget();
    }

    private float randBudget(){
        int min = 0;
        int max = 100000;
        float budget = (float)Math.floor(Math.random() * (max - min + 1) + min);

        return budget;
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

    public float getSalary() {
        return salary;
    }

}