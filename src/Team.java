public class Team { // parent class
    private String name;
    private float budget = 0;

    protected Team(String name) {
        this.name = name;
        this.budget = randBudget();
    }

    private float randBudget(){
        int min = 0;
        int max = 100000;

        return (float)Math.floor(Math.random() * (max - min + 1) + min);
    }

    protected float getBudget() {
        return this.budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}