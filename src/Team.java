public class Team {
    private String name;
    private int budget = 0;

    protected Team(String name) {
        this.name = name;
    }

    protected void setBudget(int budget) {
        this.budget = budget;
    }

    protected int getBudget() {
        return this.budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}